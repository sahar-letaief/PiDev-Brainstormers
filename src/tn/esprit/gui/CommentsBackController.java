package tn.esprit.gui;

import API.sendSMS;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import controller.ListOfProductController;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import tn.esprit.entities.User;
import tn.esprit.services.CommentService;
import tn.esprit.services.UserServices;
import tn.esprit.utils.Datasource;

/**
 * FXML Controller class
 *
 * @author sami
 */
public class CommentsBackController implements Initializable {

    UserServices us = new UserServices();
    @FXML
    public ListView<String> commentsList;
    @FXML
    private TextField dysearch;
    @FXML
    private Button turnofftts;
    @FXML
    private Button turnontts;
    @FXML
    private PieChart piecomment;
    @FXML
    private Button seestat;
    @FXML
    private Label filtlabel;
    @FXML
    private Button back;
    @FXML
    private Pane pain;
    @FXML
    private Button delete;
    /**
     * Initializes the controller class.
     */
    static int vol = 100;
    @FXML
    private AnchorPane comanchor;
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
    private HBox SignOutBack;
    @FXML
    private HBox ReclamBack;
    @FXML
    private HBox backCom;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        piecomment.setVisible(false);
        back.setVisible(false);
        pain.setVisible(false);
        System.setProperty(
                "freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        Voice voice = VoiceManager.getInstance().getVoice("kevin16");

        voice.setVolume(vol);

        CommentService cs = new CommentService();
        aff();

    }
    static String searx;

    @FXML
    private void dynamicsearch(KeyEvent event) {
        commentsList.getItems().clear();
        searx = dysearch.getText().trim();
        Connection con;
        Statement statement;
        String request = "SELECT * FROM comments WHERE comment LIKE '%" + searx + "%'";
        String stringComment;
        int id;
        int idUser;
        int starsNum;
        User usname;
        con = Datasource.getInstance().getCnx();

        try {
            statement = con.createStatement();
            ResultSet results = statement.executeQuery(request);
            while (results.next()) {
                stringComment = results.getString("comment");
                id = results.getInt("id");
                idUser = results.getInt("id_user");
                usname = us.fetchById(idUser);
                starsNum = results.getInt("stars");
                commentsList.getItems().add("COMMENT ID:  " + id + "\n" + "EMAIL:   " + usname.getEmail() + "    NAME:    " + usname.getFirstname() + "    COMMENT:    " + stringComment + "     " + starsNum + " STARS");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void listselect() {
        new Thread(()->{ System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        String toSpeak = commentsList.getSelectionModel().getSelectedItem();
        String toSpeak1 = toSpeak.substring(2);
        Voice voice = VoiceManager.getInstance().getVoice("kevin16");
        voice.allocate();
        voice.setVolume(vol);
        voice.speak(toSpeak1);
        }).start();
       
    }

    @FXML
    public void turnoff() {
        vol = 0;
        Voice voice = VoiceManager.getInstance().getVoice("kevin16");
        voice.setVolume(vol);
        turnofftts.setVisible(false);
        turnontts.setVisible(true);
    }

    public void turnon() {
        vol = 100;
        Voice voice = VoiceManager.getInstance().getVoice("kevin16");
        voice.setVolume(vol);
        turnontts.setVisible(true);
        turnofftts.setVisible(false);

    }

    @FXML
    public void seestats() {

        piecomment.getData().clear();
        delete.setVisible(false);
        back.setVisible(true);
        pain.setVisible(true);
        piecomment.setVisible(true);
        turnontts.setVisible(false);
        turnofftts.setVisible(false);
        commentsList.setVisible(false);
        filtlabel.setVisible(false);
        seestat.setVisible(false);
        dysearch.setVisible(false);
        int star1 = 0, star2 = 0, star3 = 0, star4 = 0, star5 = 0;
        CommentService cs = new CommentService();
        star1 = cs.Stars(1);
        star2 = cs.Stars(2);
        star3 = cs.Stars(3);
        star4 = cs.Stars(4);
        star5 = cs.Stars(5);
        ObservableList<PieChart.Data> piecommentData
                = FXCollections.observableArrayList(
                        new PieChart.Data("Five Stars", star5),
                        new PieChart.Data("Four Stars", star4),
                        new PieChart.Data("Three Stars", star3),
                        new PieChart.Data("Two Stars", star2),
                        new PieChart.Data("One star", star1)
                );

        piecommentData.forEach(data
                -> data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " amount: ", data.pieValueProperty()
                        )
                )
        );

        piecomment.getData().addAll(piecommentData);

    }

    @FXML
    public void back() {
        delete.setVisible(true);
        pain.setVisible(false);
        piecomment.setVisible(false);
        turnontts.setVisible(false);
        turnofftts.setVisible(true);
        commentsList.setVisible(true);
        filtlabel.setVisible(true);
        seestat.setVisible(true);
        dysearch.setVisible(true);
        back.setVisible(false);
    }

    @FXML
    public void justdel() {

        CommentService cs = new CommentService();
        String todel = commentsList.getSelectionModel().getSelectedItem().substring(13, 16).trim();
        System.out.println(todel);
        cs.Delete(Integer.valueOf(todel));
        aff();
        sendSMS sm = new sendSMS();
        sm.sendSMS();

    }

    public void aff() {

        commentsList.getItems().clear();
        CommentService cs = new CommentService();
        Connection con;
        Statement statement;
        String request = "SELECT * FROM `comments`";
        String stringComment;
        int id;
        int idUser;
        int starsNum;
        User usname;
        con = Datasource.getInstance().getCnx();

        try {
            statement = con.createStatement();
            ResultSet results = statement.executeQuery(request);
            while (results.next()) {
                id = results.getInt("id");
                stringComment = results.getString("comment");
                idUser = results.getInt("id_user");
                usname = us.fetchById(idUser);
                starsNum = results.getInt("stars");
                commentsList.getItems().add("COMMENT ID:  " + id + "\n" + "EMAIL:   " + usname.getEmail() + "    NAME:    " + usname.getFirstname() + "    COMMENT:    " + stringComment + "     " + starsNum + " STARS");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //SIDEBAR ELEMENTS
    @FXML
    private void goToList2(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/ListOfProduct.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void goListCat(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/ListOfCategory.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    private void goTOList(javafx.scene.input.MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/ListOfProduct.fxml"));

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

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/orderAffiche.fxml"));

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

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/CommentsBack.fxml"));

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/TagsBack.fxml"));

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
    private void onreservation(javafx.scene.input.MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/DisplayReservations.fxml"));

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/SignIn.fxml"));

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
