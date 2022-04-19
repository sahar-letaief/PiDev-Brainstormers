/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import java.awt.event.MouseEvent;
import tn.esprit.entities.User;
import tn.esprit.services.UserServices;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class DisplayUsersBackController implements Initializable {

    @FXML
    private TableView<User> UsersTable;

    @FXML
    private TableColumn<User, String> fullNameCol;
    @FXML
    private TableColumn<User, String> emailCol;
    @FXML
    private TableColumn<User, String> passwordCol;
    @FXML
    private TableColumn<User, String> roleCol;
    @FXML
    private TableColumn<User, String> dateCol;
    @FXML
    private TableColumn<User, String> phoneNumberCol;
    @FXML
    private TableColumn<User, String> editCol;

    ObservableList<User> UsersList = FXCollections.observableArrayList();
    @FXML
    private TableColumn<User, String> usernameCol;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        LoadUsers();
    }
    
    private void LoadUsers(){
    
        UsersList.clear();
        fullNameCol.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
        roleCol.setCellValueFactory(new PropertyValueFactory<>("roles"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("lastlogindate"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));

        
        
         //add cell of button edit 
         Callback<TableColumn<User, String>, TableCell<User, String>> cellFoctory = (TableColumn<User, String> param) -> {
            // make cell containing buttons
            final TableCell<User, String> cell = new TableCell<User, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {

                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);

                        deleteIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#ff1744;"
                        );
                        editIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#00E676;"
                        );
                        
                        deleteIcon.setOnMouseClicked((event) -> {    
                                User user = UsersTable.getSelectionModel().getSelectedItem();
                                UserServices us = new UserServices();
                                boolean deletedUser = us.deleteUser(user.getId());
                                if ( deletedUser ){
                                    LoadUsers();
                                }else{
                                    LoadUsers();
                                }
                       
                        });
                        editIcon.setOnMouseClicked((event) -> {
                            
                            User user = UsersTable.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("EditDisplayUser.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(DisplayUsersBackController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            EditDisplayUserController EditDisplayUsercontroller = loader.getController();
                            EditDisplayUsercontroller.setUserToEdit(user);
                            EditDisplayUsercontroller.setIdUserToEdit(user.getId());
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();
                            
                        });

                        HBox managebtn = new HBox(editIcon, deleteIcon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
                        HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));

                        setGraphic(managebtn);

                        setText(null);

                    }
                }

            };

            return cell;
        };
        editCol.setCellFactory(cellFoctory);
        UserServices us = new UserServices();
        UsersList = us.displayUsers(UsersList);
        UsersTable.setItems(UsersList);
        
    }
    
}
