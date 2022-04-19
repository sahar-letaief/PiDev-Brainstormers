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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.esprit.entities.User;
import tn.esprit.services.UserServices;
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
    private Label idError;
    @FXML
    private Label EmailError;

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
        

        if ( emailString.isEmpty()){
            idError.setVisible(true);
            return;
        }
        else{
            idError.setVisible(false);
        }
    
        User user = new User();
        user.setFirstname(firstname.getText());
        user.setLastname(lastname.getText());
        user.setEmail(email.getText());
        user.setPassword(password.getText());
        user.setPhonenumber(Integer.parseInt(phonenumber.getText().toString()));
        user.setUsername(username.getText());
        user.setRoles(roles.getSelectionModel().selectedItemProperty().getValue());
        UserServices Us = new UserServices();
        
        String res = Us.SignUp(user);
        System.out.println(res);
         if ( res.equals("user exists") ){
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
}
