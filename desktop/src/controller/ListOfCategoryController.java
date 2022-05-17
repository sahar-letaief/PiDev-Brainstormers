/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import tn.esprit.entities.Category;
import tn.esprit.entities.Product;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import tn.esprit.gui.DisplayEventsController;
import tn.esprit.gui.DisplayReservationsController;
import tn.esprit.gui.SignUpController;
import tn.esprit.services.ServiceCategory;
import tn.esprit.services.ServiceProduct;

/**
 * FXML Controller class
 *
 * @author maryem
 */
public class ListOfCategoryController implements Initializable {

    @FXML
    private AnchorPane show;
    @FXML
    private AnchorPane slider;
    @FXML
    private Button supp;
    @FXML
    private Button mod;
    @FXML
    private TextField filterFieldCat;
    private Button addProd;
    @FXML
    private TableColumn<Category, String> nameCat;
    @FXML
    private TableColumn<Category, String> descCat;
    @FXML
    private TableView<Category> tableCat;
    public static String name_recup;
    public static String decription_recup;
    public static int id_rec;
    @FXML
    private Button addCat;
    private Label goProd;
    @FXML
    private Label goCat;
    private ImageView iconProd;
    private ImageView iconCat;
    private Button reload;
    @FXML
    private TextField nbrProd;
    private Label stat;
    private ImageView iconStat;
    @FXML
    private Label btnProducts;
    @FXML
    private HBox UsersBack;
    @FXML
    private HBox order;
    @FXML
    private HBox commentsback;
    @FXML
    private HBox tagsback;
    @FXML
    private HBox eventsback;
    @FXML
    private HBox reservationBack;
    @FXML
    private HBox SignOutBack;
    @FXML
    private HBox ReclamBack;
    @FXML
    private HBox backCom;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        ServiceCategory evcrud = new ServiceCategory();
        ArrayList<Category> ev = (ArrayList<Category>) evcrud.afficher();
        ObservableList<Category> obs = FXCollections.observableArrayList(ev);
        //table.setItems(obs);
        nameCat.setCellValueFactory(new PropertyValueFactory<Category,String>("name"));
        descCat.setCellValueFactory(new PropertyValueFactory<Category,String>("description"));
        
        
        
        
        
        
        FilteredList<Category> filteredData = new FilteredList<>(FXCollections.observableArrayList(ev), b -> true);
 	// 2. Set the filter Predicate whenever the filter changes.
		filterFieldCat.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(events -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (events.getName().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (events.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Category> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tableCat.comparatorProperty());

        tableCat.setItems(sortedData);
        ServiceCategory ec = new ServiceCategory();
        String s = ec.countCategory();
        nbrProd.setText(s);


        
    
        
    }    


    @FXML
    private void supprimer(ActionEvent Category) {
        Category ev = tableCat.getSelectionModel().getSelectedItem();
        ServiceCategory udao = ServiceCategory.getInstance();
        udao.supprimer(ev.getName());
        System.out.println("delete successfully");

        tableCat.refresh();

    }

    @FXML
    private void modifier(ActionEvent Category) {
        Category ev = tableCat.getSelectionModel().getSelectedItem();
        ListOfCategoryController.name_recup=ev.getName();
        ListOfCategoryController.decription_recup=ev.getDescription();

        

        ListOfCategoryController.id_rec=ev.getId();

        System.out.println(ev.getId());
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/EditCategory.fxml"));
            Stage stage = (Stage) mod.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfCategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    @FXML
    private void btnAddCat(ActionEvent Category) {
       try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/AddCategory.fxml"));
            Stage stage = (Stage) addCat.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfCategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void goListProd(MouseEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/ListOfProduct.fxml"));
            Stage stage = (Stage) goProd.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void iconGoProd(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/ListOfProduct.fxml"));
            Stage stage = (Stage) iconProd.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void iconGoCat(MouseEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/ListOfCategory.fxml"));
            Stage stage = (Stage) iconCat.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnReload(ActionEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/ListOfCategory.fxml"));
            Stage stage = (Stage) reload.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /*private void btnSum(ActionEvent event) {
        ServiceCategory ec = new ServiceCategory();
        String s = ec.countCategory();
        nbrProd.setText(s);
    }*/

    private void btnStat(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/Stat.fxml"));
            Stage stage = (Stage) stat.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void iconBtnStat(MouseEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/Stat.fxml"));
            Stage stage = (Stage) iconStat.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
    @FXML
    private void goToList2(MouseEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/ListOfProduct.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
           
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void goListCat(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/ListOfCategory.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
           
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onUsersBack(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/DisplayUsersBack.fxml"));
        
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void goTOList(javafx.scene.input.MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/ListOfProduct.fxml"));
        
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onorder(javafx.scene.input.MouseEvent event) {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/orderAffiche.fxml"));
        
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void oncomments(javafx.scene.input.MouseEvent event) {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/CommentsBack.fxml"));
        
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void ontags(javafx.scene.input.MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/TagsBack.fxml"));
        
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
     private void onevents(MouseEvent event) {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("tn/esprit/gui/DisplayEvents.fxml"));

        try {
            Parent root = Loader.load();
            DisplayEventsController C = Loader.getController();
            C.getEvents();
            Scene productDetailScene = new Scene(root);
            Stage cineStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            cineStage.setScene(productDetailScene);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
     
    @FXML
    private void onreservation(MouseEvent event) {
       FXMLLoader Loader = new FXMLLoader(getClass().getResource("tn/esprit/gui/DisplayReservations.fxml"));

        try {
            Parent root = Loader.load();
            DisplayReservationsController C = Loader.getController();
            C.getRes();
            Scene productDetailScene = new Scene(root);
            Stage cineStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            cineStage.setScene(productDetailScene);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    @FXML
    private void onSignOut(javafx.scene.input.MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/SignIn.fxml"));
        
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     @FXML
    private void OnReclamation(javafx.scene.input.MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/AffichageBack.fxml"));
        
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void OnCommunication(javafx.scene.input.MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/ListMessage.fxml"));
        
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
