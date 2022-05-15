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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tn.esprit.entities.Communication;
import tn.esprit.gui.DisplayEventsController;
import tn.esprit.gui.DisplayReservationsController;
import tn.esprit.gui.SignInController;
import tn.esprit.gui.SignUpController;
import tn.esprit.services.CommunicationService;

/**
 * FXML Controller class
 *
 * @author oasis
 */
public class ListMessageController implements Initializable {

    @FXML
    private VBox EditUserbox;
    @FXML
    private TextField FirstNameText;
    @FXML
    private TextField LastNameText;
    @FXML
    private TextField UserNameText;
    @FXML
    private TextField Emailtext;
    @FXML
    private TextField PhoneNumberText;
    @FXML
    private ComboBox<?> roles;
    @FXML
    private Button UpdateButton;
    @FXML
    private Button BackButton;
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
    private HBox SignOutBack1;
    @FXML
    private VBox ProfileInterface;
    @FXML
    private TextField FirstNameProfile;
    @FXML
    private TextField LastNameProfile;
    @FXML
    private TextField EmailProfile;
    @FXML
    private TextField UserNameProfile;
    @FXML
    private TextField PhoneNumberProfile;
    @FXML
    private TextField PasswordProfile;
    @FXML
    private ComboBox<?> Roleprofile;
    @FXML
    private RadioButton EditProfileRadioButton;
    @FXML
    private Button SaveEditProfile;
    @FXML
    private HBox reservationBack1;
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
    @FXML
    private Button modc;
    @FXML
    private Button refresh;
    public static String tftitre;
    public static String tfmessage;
    public static String tfaddress;
    public static String tfid;
    @FXML
    private HBox reback;
    @FXML
    private HBox comback;

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
    private void onEditUser(ActionEvent event) {
        
    }

    @FXML
    private void onCloseEdit(ActionEvent event) {
    }

    @FXML
    private void goTOList(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListOfProduct.fxml"));
        
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
    private void goListCat(MouseEvent event) {
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
    private void onorder(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("orderAffiche.fxml"));
        
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
    private void oncomments(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CommentsBack.fxml"));
        
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
    private void ontags(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TagsBack.fxml"));
        
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
     private void onevents(MouseEvent event) {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/DisplayEvents.fxml"));

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
       FXMLLoader Loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/DisplayReservations.fxml"));

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
    private void OnReclamation(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/AffichageBack.fxml"));
        
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
    private void OnCommunication(MouseEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/ListMessage.fxml"));
        
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
            javafx.scene.Parent root = loader.load();
            Scene scene = new Scene(root);
            SignInController SignIncontroller = loader.getController();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onSelectRadioButton(ActionEvent event) {
    }

    @FXML
    private void onEditProfileAction(ActionEvent event) {
    }

    @FXML
    private void deleteMessage(ActionEvent event) {
        Communication ev = tbl_communication.getSelectionModel().getSelectedItem();
        CommunicationService udao = CommunicationService.getInstance();
        udao.supprimer(ev.getTitle());
        System.out.println("Delete success");
Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Reclamation deleted successfuly!");
                alert.show();

       
        tbl_communication.refresh();
    }

   

    @FXML
    private void refreshList(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/ListMessage.fxml"));
        
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListMessageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void RespondMessage(ActionEvent event) {
        Communication ev = tbl_communication.getSelectionModel().getSelectedItem();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/AjouterMessageBack.fxml"));
        
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListMessageController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
    }
    
}
