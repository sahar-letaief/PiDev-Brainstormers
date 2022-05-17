/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import controller.ListOfProductController;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import tn.esprit.entities.Reclamation;
import tn.esprit.entities.UserStaticSession;

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
    @FXML
    private HBox UsersBack;
    @FXML
    private VBox pnItems;

    public ItemController itemController;
    @FXML
    private VBox ListUsers;

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
    private ComboBox<String> roles;
    ObservableList<String> ROLES = FXCollections.observableArrayList();


    public static boolean test = false;
    public static boolean notProfile = false;
    public static int idUser;
    public static Boolean testUserUpdate = true;
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
    private TextField SearchField;
    public static String SearchValue = "";
    @FXML
    private ComboBox<String> SearchComboBox;
    ObservableList<String> SearchOptions = FXCollections.observableArrayList();
    public static String SearchKey = "";
    @FXML
    private RadioButton SortFullName;
    @FXML
    private RadioButton SortEmail;
    @FXML
    private RadioButton SortUsername;
    public static String SortKey = "";
    @FXML
    private Label btnProducts;
    @FXML
    private Label goCat;
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
    private HBox ReclamBack;
    @FXML
    private HBox backCom;
    @FXML
    private HBox SignOutBack1;
    @FXML
    private HBox reservationBack1;
    @FXML
    private Button UpdateButton;
    @FXML
    private Button BackButton;
    @FXML
    private Button SaveEditProfile;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // LoadUsers();
        SearchOptions.add("Full Name");
        SearchOptions.add("Email");
        SearchOptions.add("Username");
        SearchComboBox.setItems(SearchOptions);
        
        SortFullName.setUserData("Full Name");
        SortEmail.setUserData("Email");
        SortUsername.setUserData("Username");
        
        final ToggleGroup group = new ToggleGroup();
        SortFullName.setToggleGroup(group);
        SortEmail.setToggleGroup(group);
        SortUsername.setToggleGroup(group);
        
        group.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
            if (group.getSelectedToggle() != null) {
                 SortKey = group.getSelectedToggle().getUserData().toString();
            }
        });
        this.ProfileInterface.setVisible(false);
        UserServices us = new UserServices();
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.5), e -> {
                    if (!notProfile) {
                        if (test) {
                            if (testUserUpdate) {
                                ROLES.add("USER");
                                ROLES.add("PLAYER");
                                ROLES.add("ADMIN");
                                roles.setItems(ROLES);
                                User user = us.getOneUser(idUser);
                                this.FirstNameText.setText(user.getFirstname());
                                this.LastNameText.setText(user.getLastname());
                                this.UserNameText.setText(user.getUsername());
                                this.Emailtext.setText(user.getEmail());
                                this.PhoneNumberText.setText(String.valueOf(user.getPhonenumber()));
                                ListUsers.setVisible(false);
                                EditUserbox.setVisible(true);
                                testUserUpdate = false;
                            }

                        } else if (!test) {
                            LoadUsers2();
                            ListUsers.setVisible(true);
                            EditUserbox.setVisible(false);
                        }
                    }

                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }

    private void LoadUsers2() {
        pnItems.getChildren().clear();
        this.pnItems.setVisible(true);

        UserServices us = new UserServices();
        List<User> users = new ArrayList<>();
        users = us.test(SearchValue , SearchKey , SortKey);
        Node[] nodes = new Node[users.size()];

        for (int i = 0; i < users.size(); i++) {
            try {
                ItemController.fullname = users.get(i).getFirstname() + " " + users.get(i).getLastname();
                ItemController.email = users.get(i).getEmail();
                ItemController.username = users.get(i).getUsername();
                ItemController.id = String.valueOf(users.get(i).getId());
 
                nodes[i] = (Node) FXMLLoader.load(getClass().getResource("item.fxml"));

                pnItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void LoadUsers() {

        /*UsersList.clear();
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
                            if (deletedUser) {
                                LoadUsers();
                            } else {
                                LoadUsers();
                            }

                        });
                        editIcon.setOnMouseClicked((event) -> {

                            User user = UsersTable.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader();
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
        UsersTable.setItems(UsersList);*/

    }

    @FXML
    private void onUsersBack(javafx.scene.input.MouseEvent event) {
        // LoadUsers();
        // UsersTable.setVisible(true);
        notProfile = false;
        test = false;
        testUserUpdate = true;
        ListUsers.setVisible(true);
        EditUserbox.setVisible(false);
        this.ProfileInterface.setVisible(false);
        LoadUsers2();
    }
    /*private void onUsersBack(ActionEvent event) {}*/

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

        test = false;
        testUserUpdate = true;
    }

    @FXML
    private void onCloseEdit(ActionEvent event) {
        test = false;
        testUserUpdate = true;
    }

    private void onProfileVisit(ActionEvent event) {
        notProfile = true;
        test = false;
        testUserUpdate = true;
        ListUsers.setVisible(false);
        EditUserbox.setVisible(false);
        this.ProfileInterface.setVisible(true);
        
        ROLES.add("USER");
        ROLES.add("PLAYER");
        Roleprofile.setItems(ROLES);
        
        FirstNameProfile.setText(UserStaticSession.getFirstname());
        LastNameProfile.setText(UserStaticSession.getLastname());
        EmailProfile.setText(UserStaticSession.getEmail());
        UserNameProfile.setText(UserStaticSession.getUsername());
        PhoneNumberProfile.setText(String.valueOf(UserStaticSession.getPhonenumber()));
        PasswordProfile.setText(UserStaticSession.getPassword());
        
        
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

        // Roleprofile;
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
        }
    }

    @FXML
    private void onEditProfileAction(ActionEvent event) {

        if (EditProfileRadioButton.isSelected()) {

            User user = new User(UserStaticSession.getId() ,EmailProfile.getText() , UserNameProfile.getText(),FirstNameProfile.getText() ,LastNameProfile.getText() , Integer.parseInt(PhoneNumberProfile.getText()),PasswordProfile.getText() ,Roleprofile.getSelectionModel().selectedItemProperty().getValue()  );
            UserServices us = new UserServices();
            us.UpdateUser(user);
            UserStaticSession usr = new UserStaticSession(UserStaticSession.getId() ,EmailProfile.getText() , UserNameProfile.getText(),FirstNameProfile.getText() ,LastNameProfile.getText() , Integer.parseInt(PhoneNumberProfile.getText()),PasswordProfile.getText() ,Roleprofile.getSelectionModel().selectedItemProperty().getValue()  );
            EditProfileRadioButton.setSelected(false);
        }
    }

    private void onSignOut(ActionEvent event) {
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
    private void onSearchTyped(KeyEvent event) {
        
        SearchValue = SearchField.getText();
        SearchKey = SearchComboBox.getSelectionModel().selectedItemProperty().getValue();
        if ( SearchValue.isEmpty()){
            SearchValue = "";
        }else{
            System.out.println(SearchValue + " " + SearchKey);

        }
    }

  

    @FXML
    private void goTOList(javafx.scene.input.MouseEvent event) {
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
    private void onorder(javafx.scene.input.MouseEvent event) {
        
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
    private void oncomments(javafx.scene.input.MouseEvent event) {
        
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
    private void ontags(javafx.scene.input.MouseEvent event) {
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
    private void goListCat(javafx.scene.input.MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/ListOfCategory.fxml"));
        
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
    private void onSignOut(javafx.scene.input.MouseEvent event) {
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
    private void OnReclamation(javafx.scene.input.MouseEvent event) {
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
    private void OnCommunication(javafx.scene.input.MouseEvent event) {
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
    }
    
   

   

    

    


