/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.time.ZoneId;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.esprit.entities.Communication;
import tn.esprit.gui.SignInController;
import tn.esprit.gui.SignUpController;
import tn.esprit.services.CommunicationService;
import tn.esprit.utils.Datasource;

/**
 * FXML Controller class
 *
 * @author oasis
 */
public class AjouterMessageBackController implements Initializable {

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
    private HBox rr;
    @FXML
    private HBox cc;
    @FXML
    private HBox SignOutBack1;
   
    @FXML
    private Button SaveEditProfile;
    @FXML
    private HBox reservationBack1;
    @FXML
    private Text ftTitle;
    @FXML
    private Text ftDescription;
    @FXML
    private Button add;
    @FXML
    private Button list;
    @FXML
    private TextField titre_message;
    @FXML
    private TextArea message;
     Connection cnx = Datasource.getInstance().getCnx();
     CommunicationService rs = CommunicationService.getInstance();
    @FXML
    private VBox ProfileInterface;
    @FXML
    private RadioButton EditProfileRadioButton;
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
    private TableView<?> UsersTable;
    @FXML
    private TableColumn<?, ?> fullNameCol;
    @FXML
    private TableColumn<?, ?> emailCol;
    @FXML
    private TableColumn<?, ?> passwordCol;
    @FXML
    private TableColumn<?, ?> roleCol;
    @FXML
    private TableColumn<?, ?> dateCol;
    @FXML
    private TableColumn<?, ?> phoneNumberCol;
    @FXML
    private TableColumn<?, ?> usernameCol;
    @FXML
    private TableColumn<?, ?> editCol;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
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
    private void oncomments(MouseEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("CommentsBack.fxml"));
        
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
    private void ontags(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TagsBack.fxml"));
        
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
    private void onreservation(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DisplayReservations.fxml"));
        
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
    private void OnReclamation(MouseEvent event) {
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
    private void OnCommunication(MouseEvent event) {
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

    @FXML
    private void onSignOut(MouseEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("SignIn.fxml"));
        
        try {
            Parent root = loader.load();
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
    private void Add_Message(ActionEvent event) {
        if (titre_message.getText().isEmpty() || message.getText().isEmpty()) {
             titre_message.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
             message.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
               System.out.println("Fields Are Empty");
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Fill your fields !");
                alert.show(); 
                  }
             /* else
                 if (!DataValidationUtils.ValidAddress(address.getText().replaceAll("\\s", ""))) {
                address.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                System.out.println("phone is invalid");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("ivalid phone !");
                alert.show();    
             }*/
               
    else{
            String tr = titre_message.getText();
            String me = message.getText();
          //  String ad = address.getText();

            ZoneId defaultZoneId = ZoneId.systemDefault();
            Communication ev = new Communication(tr,me);
            rs.ajouterC(ev);
            System.err.println("Added Seccessfully");
           
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Reclamation added successfuly!");
                alert.show();
                titre_message.setText("");
                message.setText("");
             //   address.setText("");

    }
    }

    @FXML
    private void ListOfMessage(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/ListMessage.fxml"));
        
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AjouterMessageBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
