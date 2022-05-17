/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import controller.ListOfProductController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tn.esprit.entities.User;
import tn.esprit.entities.UserStaticSession;
import tn.esprit.services.UserServices;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class ProfileController implements Initializable {

    @FXML
    private Label btnProducts;
    @FXML
    private HBox UsersBack;
    @FXML
    private HBox order;
    @FXML
    private HBox eventsback;
    @FXML
    private HBox reservationBack;
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
    private ComboBox<String> Roleprofile;
    @FXML
    private RadioButton EditProfileRadioButton;
    @FXML
    private Button SaveEditProfile;
    ObservableList<String> ROLES = FXCollections.observableArrayList();
    private static boolean visitedprofile = false;
    @FXML
    private HBox clicReclamation;
    @FXML
    private HBox clicCommunication;
    @FXML
    private HBox SignOutBack2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (visitedprofile == false) {
            ROLES.add("USER");
            ROLES.add("PLAYER");
            Roleprofile.setItems(ROLES);

            FirstNameProfile.setText(UserStaticSession.getFirstname());
            LastNameProfile.setText(UserStaticSession.getLastname());
            EmailProfile.setText(UserStaticSession.getEmail());
            UserNameProfile.setText(UserStaticSession.getUsername());
            PhoneNumberProfile.setText(String.valueOf(UserStaticSession.getPhonenumber()));
            PasswordProfile.setText("encrypted");

            FirstNameProfile.setEditable(false);
            LastNameProfile.setEditable(false);
            EmailProfile.setEditable(false);
            UserNameProfile.setEditable(false);
            PhoneNumberProfile.setEditable(false);
            PasswordProfile.setEditable(false);
            Roleprofile.setEditable(false);

            FirstNameProfile.setOpacity(0.5);
            LastNameProfile.setOpacity(0.5);
            EmailProfile.setOpacity(0.5);
            UserNameProfile.setOpacity(0.5);
            PhoneNumberProfile.setOpacity(0.5);
            PasswordProfile.setOpacity(0.5);
            Roleprofile.setOpacity(0.5);
            visitedprofile = true;
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
    private void onreservation(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DisplayReservationFront.fxml"));

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

        if (EditProfileRadioButton.isSelected()) {
            FirstNameProfile.setEditable(true);
            LastNameProfile.setEditable(true);
            EmailProfile.setEditable(true);
            UserNameProfile.setEditable(true);
            PhoneNumberProfile.setEditable(true);
            PasswordProfile.setEditable(true);

            FirstNameProfile.setOpacity(1);
            LastNameProfile.setOpacity(1);
            EmailProfile.setOpacity(1);
            UserNameProfile.setOpacity(1);
            PhoneNumberProfile.setOpacity(1);
            PasswordProfile.setOpacity(1);
            PasswordProfile.setText("");
        } else {
            FirstNameProfile.setEditable(false);
            LastNameProfile.setEditable(false);
            EmailProfile.setEditable(false);
            UserNameProfile.setEditable(false);
            PhoneNumberProfile.setEditable(false);
            PasswordProfile.setEditable(false);

            FirstNameProfile.setOpacity(0.5);
            LastNameProfile.setOpacity(0.5);
            EmailProfile.setOpacity(0.5);
            UserNameProfile.setOpacity(0.5);
            PhoneNumberProfile.setOpacity(0.5);
            PasswordProfile.setOpacity(0.5);
            PasswordProfile.setText("encrypted");
        }
    }

    @FXML
    private void onEditProfileAction(ActionEvent event) {

        if (EditProfileRadioButton.isSelected()) {

            User user = new User(UserStaticSession.getId(), EmailProfile.getText(), UserNameProfile.getText(), FirstNameProfile.getText(), LastNameProfile.getText(), Integer.parseInt(PhoneNumberProfile.getText()), PasswordProfile.getText(), Roleprofile.getSelectionModel().selectedItemProperty().getValue());
            UserServices us = new UserServices();
            us.UpdateUser(user);
            UserStaticSession usr = new UserStaticSession(UserStaticSession.getId(), EmailProfile.getText(), UserNameProfile.getText(), FirstNameProfile.getText(), LastNameProfile.getText(), Integer.parseInt(PhoneNumberProfile.getText()), PasswordProfile.getText(), Roleprofile.getSelectionModel().selectedItemProperty().getValue());
            EditProfileRadioButton.setSelected(false);
            FirstNameProfile.setEditable(false);
            LastNameProfile.setEditable(false);
            EmailProfile.setEditable(false);
            UserNameProfile.setEditable(false);
            PhoneNumberProfile.setEditable(false);
            PasswordProfile.setEditable(false);
            Roleprofile.setEditable(false);

            FirstNameProfile.setOpacity(0.5);
            LastNameProfile.setOpacity(0.5);
            EmailProfile.setOpacity(0.5);
            UserNameProfile.setOpacity(0.5);
            PhoneNumberProfile.setOpacity(0.5);
            PasswordProfile.setOpacity(0.5);
            Roleprofile.setOpacity(0.5);
        }
    }

    @FXML
    private void onevents(MouseEvent event) {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("DisplayEventsFront.fxml"));

        try {
            Parent root = Loader.load();
            DisplayEventsFrontController C = Loader.getController();

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
}
