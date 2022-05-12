package tn.brainstormers.gui;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
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
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import tn.brainstormers.services.CommentService;
import tn.brainstormers.utils.Datasource;

/**
 * FXML Controller class
 *
 * @author sami
 */
public class CommentsBackController implements Initializable {

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
        Connection con;
        Statement statement;
        //Statement statement1;
        String request = "SELECT * FROM `comments`";
        //String requestFromUser = "SELECT firstname FROM `user` WHERE id=1";
        String stringComment;
        int idUser;
        int starsNum;
        con = Datasource.getInstance().getCnx();

        try {
            statement = con.createStatement();
            ResultSet results = statement.executeQuery(request);
            while (results.next()) {
                stringComment = results.getString("comment");
                idUser = results.getInt("id_user");
                starsNum = results.getInt("stars");
                commentsList.getItems().add(idUser + " : " + stringComment + "          " + starsNum + " Stars");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    static String searx;

    @FXML
    private void dynamicsearch(KeyEvent event) {
        searx = dysearch.getText().trim();
        Connection con;
        Statement statement;
        //Statement statement1;
        String request = "SELECT * FROM comments WHERE comment LIKE '%" + searx + "%'";
        //String requestFromUser = "SELECT firstname FROM `user` WHERE id=1";
        String stringComment;
        int idUser;
        int starsNum;
        con = Datasource.getInstance().getCnx();
        try {
            commentsList.getItems().clear();
            statement = con.createStatement();
            ResultSet results = statement.executeQuery(request);
            while (results.next()) {
                stringComment = results.getString("comment");
                idUser = results.getInt("id");
                starsNum = results.getInt("stars");
                commentsList.getItems().add(idUser + " :    " + stringComment + "          " + starsNum + " Stars");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void listselect() {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        String toSpeak = commentsList.getSelectionModel().getSelectedItem();
        String toSpeak1 = toSpeak.substring(2);
        Voice voice = VoiceManager.getInstance().getVoice("kevin16");
        voice.allocate();
        voice.setVolume(vol);
        voice.speak(toSpeak1);
    }

    @FXML
    public void turnoff() {
        vol = 0;
        Voice voice = VoiceManager.getInstance().getVoice("kevin16");
        voice.setVolume(vol);
        turnofftts.setVisible(false);
        turnontts.setVisible(true);
    }

    @FXML
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
        String todel = commentsList.getSelectionModel().getSelectedItem().substring(0, 2).trim();
        cs.Delete(Integer.valueOf(todel));
        Connection con;
        commentsList.getItems().clear();
        Statement statement;
        String request = "SELECT * FROM `comments`";
        String stringComment;
        int idUser;
        int starsNum;
        con = Datasource.getInstance().getCnx();

        try {
            statement = con.createStatement();
            ResultSet results = statement.executeQuery(request);
            while (results.next()) {
                stringComment = results.getString("comment");
                idUser = results.getInt("id");
                starsNum = results.getInt("stars");
                commentsList.getItems().add(idUser + " : " + stringComment + "          " + starsNum + " Stars");
            }
            // sendSMS sm = new sendSMS();
            //sm.sendSMS();

        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }

        aff();

    }

    public void aff() {
        commentsList.getItems().clear();
        CommentService cs = new CommentService();
        Connection con;
        Statement statement;
        //Statement statement1;
        String request = "SELECT * FROM `comments`";
        //String requestFromUser = "SELECT firstname FROM `user` WHERE id=1";
        String stringComment;
        int idUser;
        int starsNum;
        con = Datasource.getInstance().getCnx();

        try {
            statement = con.createStatement();
            ResultSet results = statement.executeQuery(request);
            while (results.next()) {
                stringComment = results.getString("comment");
                idUser = results.getInt("id_user");
                starsNum = results.getInt("stars");
                commentsList.getItems().add(idUser + " : " + stringComment + "          " + starsNum + " Stars");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
