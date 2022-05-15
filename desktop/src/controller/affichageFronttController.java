/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import tn.esprit.entities.Reclamation;
import tn.esprit.gui.DisplayEventsFrontController;
import tn.esprit.gui.DisplayReservationFrontController;
import tn.esprit.gui.SignUpController;
import tn.esprit1.services.ReclamationService;

/**
 * FXML Controller class
 *
 * @author oasis
 */
public class affichageFronttController implements Initializable {

    @FXML
    private HBox UsersBack;
    @FXML
    private Label btnProducts;
    @FXML
    private HBox order;
    @FXML
    private HBox eventsback;
    @FXML
    private HBox reservationBack;
    @FXML
    private HBox clicReclamation;
    @FXML
    private HBox clicCommunication;
    @FXML
    private HBox SignOutBack2;
    @FXML
    private Button supp;
    @FXML
    private Button mod;
    @FXML
    private Button refresh;
    @FXML
    private TableView<Reclamation> tb_rec1;
    @FXML
    private TableColumn<Reclamation, String> titrefr;
    @FXML
    private TableColumn<Reclamation, String> descriptionfr;
    @FXML
    private TableColumn<Reclamation, String> statusfr;
 public static String nom_recup;
    public static String descriptionrecup;
    public static String statusrecup;
    public static String refrecup;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ReclamationService evcrud = new ReclamationService();
        ArrayList<Reclamation> ev = (ArrayList<Reclamation>) evcrud.afficher();
        ObservableList<Reclamation> obs = FXCollections.observableArrayList(ev);
        //table.setItems(obs);
        //tfClients.setCellValueFactory(new PropertyValueFactory<Reclamation, String>(""));
      //  referencefr.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("ref_cmde"));
       
        
        
         //tfClients.setCellValueFactory(new PropertyValueFactory<Reclamation, String>(""));
     //   tfClients.setCellValueFactory(new PropertyValueFactory<Reclamation, String>(""));
       // tfCommand.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("ref_cmde"));
        descriptionfr.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("description"));
          titrefr.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("title"));
        statusfr.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("status"));

      //  statusfr.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("status"));
        
        
        
         
     
 FilteredList<Reclamation> filteredData = new FilteredList<>(FXCollections.observableArrayList(ev), b -> true);
 	
		SortedList<Reclamation> sortedData = new SortedList<>(filteredData);
		
		
		sortedData.comparatorProperty().bind(tb_rec1.comparatorProperty());

        tb_rec1.setItems(sortedData);
        
    }

            

   @FXML
    private void onUsersBack(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Profile.fxml"));

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
    private void goTOList(MouseEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("AllProductFront.fxml"));
        
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
    private void goToList2(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AllProductFront.fxml"));
        
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
    private void onorder(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("orderAfficheFront.fxml"));
        
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
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/DisplayEventsFront.fxml"));

        try {
            Parent root = Loader.load();
            DisplayEventsFrontController C = Loader.getController();
            C.getData();
            Scene productDetailScene = new Scene(root);
            Stage cineStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            cineStage.setScene(productDetailScene);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
  @FXML
    private void onreservation(MouseEvent event) {
       FXMLLoader Loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/DisplayReservationFront.fxml"));

        try {
            Parent root = Loader.load();
            DisplayReservationFrontController C = Loader.getController();
            C.getRes();
            Scene productDetailScene = new Scene(root);
            Stage cineStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            cineStage.setScene(productDetailScene);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void onReclamtionFront(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/ajouter_reclamation.fxml"));
        
        try {
            javafx.scene.Parent root = loader.load();
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
    private void onCommunication(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/ajouter_message.fxml"));
        
        try {
            javafx.scene.Parent root = loader.load();
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
    private void onSignOut(MouseEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("SignIn.fxml"));
        
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
    private void supprimer(ActionEvent event) {
        Reclamation ev = tb_rec1.getSelectionModel().getSelectedItem();
        ReclamationService udao = ReclamationService.getInstance();
        udao.supprimer(ev.getTitle());
        System.out.println("Delete success");

        tb_rec1.refresh();
        
    
    }
    
    @FXML
    private void modifier(ActionEvent event) {
        Reclamation ev = tb_rec1.getSelectionModel().getSelectedItem();
        affichageFronttController.nom_recup=ev.getTitle();
        affichageFronttController.descriptionrecup=ev.getDescription();
      //  AffichageBackController.refrecup=ev.getCmde().getRef_cmde();
       

        System.out.println(ev.getId());
          FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/EditReclamation.fxml"));
        
        try {
            javafx.scene.Parent root = loader.load();
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
    private void Refresh(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/affichageFrontt.fxml"));
        
        try {
            javafx.scene.Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(affichageFronttController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
