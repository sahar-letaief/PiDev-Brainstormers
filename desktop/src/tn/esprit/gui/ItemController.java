/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import tn.esprit.entities.User;
import tn.esprit.services.UserServices;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class ItemController implements Initializable {

    @FXML
    private AnchorPane aman;
    @FXML
    private HBox testhbox;
    @FXML
    private Label fullNameField;

    public static String fullname;
    public static String email;
    public static String username;
    public static String password = "crypted";
    public static String id;
    @FXML
    private Label emailField;
    @FXML
    private Label passwordField;
    @FXML
    private Label usernameField;
    @FXML
    public Button UpdateUser;
    @FXML
    private Button DeleteUser;

    /**
     * Initializes the controller class.
     *
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.fullNameField.setText(fullname);
        this.emailField.setText(email);
        this.usernameField.setText(username);
        this.passwordField.setText(password);
        this.UpdateUser.setId(id);
        this.DeleteUser.setId(id);

        UpdateUser.setOnAction((ActionEvent event) -> {
            DisplayUsersBackController.test = true;
            DisplayUsersBackController.idUser = Integer.parseInt(UpdateUser.getId());
        });

        DeleteUser.setOnAction((ActionEvent event) -> {
            UserServices us = new UserServices();
            boolean deletedUser = us.deleteUser(Integer.parseInt(DeleteUser.getId()));
        });

    }

}
