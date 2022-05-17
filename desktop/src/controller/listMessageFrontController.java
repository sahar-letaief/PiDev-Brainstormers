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
import tn.esprit.entities.Communication;
import tn.esprit.gui.DisplayEventsFrontController;
import tn.esprit.gui.DisplayReservationFrontController;
import tn.esprit.gui.SignUpController;
import tn.esprit.services.CommunicationService;

/**
 * FXML Controller class
 *
 * @author oasis
 */
public class listMessageFrontController implements Initializable {

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
    private Button refresh;
    private TableView<Communication> tb_rec1;
    @FXML
    private TableView<Communication> tbl_communication;
    @FXML
    private TableColumn<Communication, String> mail;
    @FXML
    private TableColumn<Communication, String> titr;
    @FXML
    private TableColumn<Communication, String> message;
    @FXML
    private Button deletec;
    public static String tftitre;
    public static String tfmessage;
    public static String tfaddress;
    public static String tfid;
    @FXML
    private Button ccc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       CommunicationService evcrud = new CommunicationService();
        ArrayList<Communication> ev = (ArrayList<Communication>) evcrud.afficher();
        ObservableList<Communication> obs = FXCollections.observableArrayList(ev);
        //table.setItems(obs);
        titr.setCellValueFactory(new PropertyValueFactory<Communication, String>("title"));
        message.setCellValueFactory(new PropertyValueFactory<Communication, String>("message"));
       // tfCommand.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("ref_cmde"));
       // message.setCellValueFactory(new PropertyValueFactory<Communication, String>("sender_id"));
        FilteredList<Communication> filteredData = new FilteredList<>(FXCollections.observableArrayList(ev), b -> true);
 	SortedList<Communication> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tbl_communication.comparatorProperty());

        tbl_communication.setItems(sortedData);
    
    
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
    private void deleteMessage(ActionEvent event) {
         Communication ev = tbl_communication.getSelectionModel().getSelectedItem();
        CommunicationService udao = CommunicationService.getInstance();
        udao.supprimer(ev.getTitle());
        System.out.println("Delete success");

        tbl_communication.refresh();
    }

    @FXML
    private void ModifyMessage(ActionEvent event) {
        Communication ev = tbl_communication.getSelectionModel().getSelectedItem();
        listMessageFrontController.tftitre=ev.getTitle();
        listMessageFrontController.tfmessage=ev.getMessage();
      //  AffichageBackController.refrecup=ev.getCmde().getRef_cmde();
       

        System.out.println(ev.getId());
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/EditMessage.fxml"));
        
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(listMessageFrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void refreshList(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/listMessageFront.fxml"));
        
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(listMessageFrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
