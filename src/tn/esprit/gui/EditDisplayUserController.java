/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.esprit.entities.User;
import tn.esprit.services.UserServices;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class EditDisplayUserController implements Initializable {

    
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
    private ComboBox<String> roles;
    @FXML
    private Button UpdateButton;
    @FXML
    private Button BackButton;


    private int idUser;
    
    
    ObservableList<String> ROLES = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ROLES.add("USER");
        ROLES.add("PLAYER");
        ROLES.add("ADMIN");
        roles.setItems(ROLES);
    }
    public void setIdUserToEdit(int id){
         this.idUser = id;
    }
    
    public void setUserToEdit(User user){
        this.FirstNameText.setText( user.getFirstname() );
        this.LastNameText.setText( user.getLastname() );
        this.UserNameText.setText( user.getUsername() );
        this.Emailtext.setText( user.getEmail() );
        this.PhoneNumberText.setText( String.valueOf(user.getPhonenumber()) );
    }

    @FXML
    private void onEditUser(ActionEvent event) {
        
        User user = new User();
        user.setId(idUser);
        user.setFirstname(FirstNameText.getText());
        user.setLastname(LastNameText.getText());
        user.setEmail(Emailtext.getText());
        user.setPhonenumber(Integer.parseInt(PhoneNumberText.getText()));
        user.setUsername(UserNameText.getText());
        user.setRoles(roles.getSelectionModel().selectedItemProperty().getValue());
        UserServices Us = new UserServices();
        
        Us.UpdateUserBack(user);

    }

    @FXML
    private void onCloseEdit(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
}
