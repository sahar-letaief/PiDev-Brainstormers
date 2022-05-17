/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import tn.esprit.entities.Order;
import tn.esprit.gui.SignUpController;
import tn.esprit.services.OrderService;
import tn.esprit.utils.DBUtil;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class AfficherOrderBackController implements Initializable {

    @FXML
    private TableView<Order> personsTable;
    @FXML
    private Button ref;
    @FXML
    private TableColumn<Order, Integer> tel;
    private Button b;
    @FXML
    private TextField filterField;
    @FXML
    private TableColumn<Order, String> refe;
    private Button ajout;
    private Button adddd;

    
    
    public static String ref_order;
    public static int num_order;
    public static String region_order;
    public static String pays_order;
    public static String status_order;
    public static int code_order;
    private Button edit;
    private ImageView Home3;
    private ImageView cmde3;
    private ImageView homecart;
    @FXML
    private Button editt;
    @FXML
    private TableColumn<Order, String> etatcheck;
    @FXML
    private Button exportToPdf;
    
    private Connection cnx;
    @FXML
    private Label btnProducts;
    @FXML
    private Label goCat;
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
        OrderService evcrud = new OrderService();
        ArrayList<Order> ev = (ArrayList<Order>) evcrud.afficher();
        ObservableList<Order> obs = FXCollections.observableArrayList(ev);
        //table.setItems(obs);
        refe.setCellValueFactory(new PropertyValueFactory<Order,String>("ref_cmde"));
        etatcheck.setCellValueFactory(new PropertyValueFactory<Order,String>("status"));
        tel.setCellValueFactory(new PropertyValueFactory<Order,Integer>("tel"));
      FilteredList<Order> filteredData = new FilteredList<>(FXCollections.observableArrayList(ev), b -> true);
 	// 2. Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(events -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (events.getRef_cmde().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Order> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(personsTable.comparatorProperty());

        personsTable.setItems(sortedData);
        
        
        exportToPdf.setOnAction(actionEvent -> {
        cnx = DBUtil.getInstance().getCnx();
    
         PreparedStatement pst=null;
         ResultSet rs=null;
         
         String guery = " select * from commande";
            try {   
               
         pst= cnx.prepareStatement(guery);
         rs= pst.executeQuery();
         
                  String file_name = "commande.pdf";
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(file_name));
        
        doc.open();
       
       Image img = Image.getInstance("C:\\Users\\MSI\\Documents\\NetBeansProjects\\Desktop\\src\\img\\logo 9 (1).png");
       img.scaleAbsoluteWidth(400);
       img.scaleAbsoluteHeight(92);
       img.setAlignment(Image.ALIGN_CENTER);
       doc.add(img);
       
       doc.add(new Paragraph(" "));
       doc.add(new Paragraph("List of commands",FontFactory.getFont(FontFactory.TIMES_BOLD,20,BaseColor.LIGHT_GRAY)));
       doc.add(new Paragraph(" "));

       PdfPTable table = new PdfPTable(6);
       table.setWidthPercentage(100);

       PdfPCell cell;
       
       cell = new PdfPCell (new Phrase("Reference", FontFactory.getFont("Comic Sans MS",12)));
       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.GRAY);
       table.addCell(cell);
       
       cell = new PdfPCell (new Phrase("Status", FontFactory.getFont("Comic Sans MS",12)));
       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.GRAY);
       table.addCell(cell);
       
       cell = new PdfPCell (new Phrase("Country", FontFactory.getFont("Comic Sans MS",12)));
       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.GRAY);
       table.addCell(cell);
       
       cell = new PdfPCell (new Phrase("Region", FontFactory.getFont("Comic Sans MS",12)));
       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.GRAY);
       table.addCell(cell);
       
       cell = new PdfPCell (new Phrase("Phone number", FontFactory.getFont("Comic Sans MS",12)));
       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.GRAY);
       table.addCell(cell);
       
       cell = new PdfPCell (new Phrase("PostCod", FontFactory.getFont("Comic Sans MS",12)));
       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.GRAY);
       table.addCell(cell);
       
       
       
      // cell = new PdfPCell (new Phrase("Phone", FontFactory.getFont("Comic Sans MS",12)));
      // cell.setHorizontalAlignment(Element.ALIGN_CENTER);
       //cell.setBackgroundColor(BaseColor.GRAY);
       
       /////////////////////////////////////////////////////////////////////////////////
       while(rs.next()) {
           cell = new PdfPCell (new Phrase(rs.getString("ref_cmde").toString(), FontFactory.getFont("Arial",12)));
       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        
       table.addCell(cell);
       
       
        cell = new PdfPCell (new Phrase(rs.getString("status").toString(), FontFactory.getFont("Arial",12)));
       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
      
       table.addCell(cell);
       
       cell = new PdfPCell (new Phrase(rs.getString("pays").toString(), FontFactory.getFont("Arial",12)));
       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
      
       table.addCell(cell);
       
       cell = new PdfPCell (new Phrase(rs.getString("region").toString(), FontFactory.getFont("Arial",12)));
       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
       
       table.addCell(cell);
       
       cell = new PdfPCell (new Phrase(rs.getString("tel").toString(), FontFactory.getFont("Arial",12)));
       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
      
       table.addCell(cell);
       
       cell = new PdfPCell (new Phrase(rs.getString("code_postal").toString(), FontFactory.getFont("Arial",12)));
       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
      
       table.addCell(cell);

        
       }
      
       doc.add(table);
       
        System.out.println("done");
                doc.close();
                
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AfficherOrderController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(AfficherOrderController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AfficherOrderController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AfficherOrderController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Commande details exported to PDF Sheet");
            alert.show();

         });

        // TODO
    }    




    private void Add(ActionEvent Order) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/AjouterOrder.fxml"));
            Stage stage = (Stage) ajout.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherOrderBackController.class.getName()).log(Level.SEVERE, null, ex);


    }
    
}

    private void Ajouter(ActionEvent Order) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/AjouterOrderFront.fxml"));
            Stage stage = (Stage) adddd.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Ajouter_OrderController.class.getName()).log(Level.SEVERE, null, ex);


    }
    }



    @FXML
    private void dd(ActionEvent Order) {
       try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/orderAfficheFront.fxml"));
            Stage stage = (Stage) b.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherOrderBackController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    private void cmde3(MouseEvent event) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/orderAfficheFront.fxml"));
            Stage stage = (Stage) cmde3.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherOrderBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void homecart(MouseEvent event) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/Market.fxml"));
            Stage stage = (Stage) homecart.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherOrderBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 

    @FXML
    private void orderedit(ActionEvent event) {
        Order ev = personsTable.getSelectionModel().getSelectedItem();
        AfficherOrderBackController.ref_order=ev.getRef_cmde();
        AfficherOrderBackController.num_order=ev.getTel();
        AfficherOrderBackController.region_order=ev.getRegion();
        AfficherOrderBackController.pays_order=ev.getPays();
        AfficherOrderBackController.status_order=ev.getStatus();
        AfficherOrderBackController.code_order=ev.getCode_postal();
        
        //AfficherOrderController.id_rec=ev.getId();

        System.out.println(ev.getId());
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/EditOrder.fxml"));
            Stage stage = (Stage) editt.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherOrderBackController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void onreservation(javafx.scene.input.MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/DisplayReservations.fxml"));
        
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


