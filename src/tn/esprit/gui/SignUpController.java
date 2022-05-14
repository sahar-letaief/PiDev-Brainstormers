/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.esprit.entities.User;
import tn.esprit.services.UserServices;
//import de.mkammerer.argon2.Argon2;
//import de.mkammerer.argon2.Argon2Factory;
/**
 *
 * @author Yassine
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField phonenumber;
    @FXML
    private TextField username;
    @FXML
    private ComboBox<String> roles;
    @FXML
    private Label EmailError;
    @FXML
    private Label FirstNameError;
    @FXML
    private Label LastNameError;
    @FXML
    private Label PasswordError;
    @FXML
    private Label PhoneNumberError;
    @FXML
    private Label UserNameError;
    @FXML
    private Label EmtptyError;
    @FXML
    private Button BackToSignIN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onSave(ActionEvent event) {

        String emailString = email.getText();
        String firstnameString = firstname.getText();
        String lastnameString = lastname.getText();
        String phonenumberString = phonenumber.getText();
        String usernameString = username.getText();
        String passwwordString = password.getText();

        if (emailString.isEmpty() || firstnameString.isEmpty() || lastnameString.isEmpty() || usernameString.isEmpty() || passwwordString.isEmpty()) {
            EmtptyError.setVisible(true);
            return;
        }

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (pat.matcher(emailString).matches()) {
            EmailError.setVisible(false);
        }else{
             EmailError.setVisible(true);
             return;
        }
        boolean result = phonenumberString.matches("[0-9]+");
        if (!result) {
            PhoneNumberError.setVisible(true);
            return;
        }else{
            PhoneNumberError.setVisible(false);
        }

        if (firstnameString.length() < 3) {
            FirstNameError.setVisible(true);
            return;
        }else{
            FirstNameError.setVisible(false);
        }
        if (lastnameString.length() < 3) {
            LastNameError.setVisible(true);
            return;
        }else{
            LastNameError.setVisible(false);
        }
        if (usernameString.length() < 3) {
            UserNameError.setVisible(true);
            return;
        }else{
            UserNameError.setVisible(false);
        }

        User user = new User();
        user.setFirstname(firstname.getText());
        user.setLastname(lastname.getText());
        user.setEmail(email.getText());
        user.setPassword(password.getText());
        user.setPhonenumber(Integer.parseInt(phonenumber.getText()));
        user.setUsername(username.getText());
        user.setRoles(roles.getSelectionModel().selectedItemProperty().getValue());
        UserServices Us = new UserServices();
        String res = Us.SignUp(user);
        System.out.println(res);
        if (res.equals("user exists")) {
            EmailError.setVisible(true);
            return;
        }

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
    private void onBackToSignIN(ActionEvent event) {
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
}
