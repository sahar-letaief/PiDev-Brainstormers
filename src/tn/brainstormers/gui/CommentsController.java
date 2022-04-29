/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tn.brainstormers.gui;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import tn.brainstormers.entities.Comment;
import tn.brainstormers.entities.Tags;
import static tn.brainstormers.gui.CommentsBackController.vol;
import tn.brainstormers.services.CommentService;
import tn.brainstormers.services.TagsService;
import tn.brainstormers.utils.Datasource;

/**
 * FXML Controller class
 *
 * @author sami
 */
public class CommentsController implements Initializable {

    @FXML
    public Button Submit;
    @FXML
    public TextArea CommentInput;
    @FXML
    public Label CommentErr;
    @FXML
    public Label CommentErr1;
    @FXML
    public Label CommentErr2;
    @FXML
    public Label CommentErr3;
    @FXML
    public Label Star1;
    @FXML
    public Label Star2;
    @FXML
    public Label Star3;
    @FXML
    public Label Star4;
    @FXML
    public Label Star5;
    public ListView<String> commentsList;
    //ommentService cs = new CommentService();
    @FXML
    public Button Delete;
    @FXML
    public Button Modify;
    @FXML
    public TextField tag1;
    @FXML
    public TextField tag2;
    @FXML
    public TextField tag3;
    @FXML
    public Label commentlabel;
    @FXML
    public Label commentsub;
    @FXML
    public Label starslabel;
//cs.searchById(1,18);
    @FXML
    public AnchorPane Anchorpane;
    @FXML
    public Label Star11;
    @FXML
    public Label Star21;
    @FXML
    public Label Star41;
    @FXML
    public Label Star31;
    @FXML
    public Label Star51;
    @FXML
    public ImageView imgview;
    @FXML
    public Label banlabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image image = new Image(getClass().getResourceAsStream("/images/valo.jpg"));
        imgview.setImage(image);
        CommentService cs = new CommentService();
        TagsService ts = new TagsService();
        Star11.setVisible(false);
        Star21.setVisible(false);
        Star31.setVisible(false);
        Star41.setVisible(false);
        Star51.setVisible(false);
        Connection con;
        Statement statement;
        //Statement statement1;
        String request = "SELECT * FROM `comments`";
        //String requestFromUser = "SELECT firstname FROM `user` WHERE id=1";
        String stringComment;
        String stringUser;
        int starsNum;
        con = Datasource.getInstance().getCnx();
        try {
            statement = con.createStatement();
            ResultSet results = statement.executeQuery(request);
            //statement1 = con.createStatement();
            //ResultSet resultsUser = statement1.(requestFromUser);
            while (results.next()) {
                stringComment = results.getString("comment");
                stringUser = "Sami";
                starsNum = results.getInt("stars");
                //comments.add(new Comment(results.getInt("id"), results.getInt("id_event"), results.getString("comment"), results.getInt("stars")));
                commentsList.getItems().add(stringUser + " : \n" + stringComment + "\n" + "Stars: " + starsNum);
                //TAGS commentsList.getItems().add(strcomm);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (val != 0) {
            tag1.setVisible(false);
            tag2.setVisible(false);
            tag3.setVisible(false);
            CommentInput.setVisible(false);
            commentlabel.setVisible(false);
            starslabel.setVisible(false);
            Star1.setVisible(false);
            Star2.setVisible(false);
            Star3.setVisible(false);
            Star4.setVisible(false);
            Star5.setVisible(false);
            Star11.setVisible(false);
            Star21.setVisible(false);
            Star31.setVisible(false);
            Star41.setVisible(false);
            Star51.setVisible(false);
            Submit.setVisible(false);
            commentsub.setVisible(true);
            Delete.setVisible(true);
            Modify.setVisible(true);

        } else {
            commentsub.setVisible(false);
            Delete.setVisible(false);
            Modify.setVisible(false);
        }
        //Modify.setTranslateX(0);
        //Modify.setTranslateY(0);
    }

    public int test() {
        CommentService cs = new CommentService();
        int t;
        t = cs.searchById(1, 18);
        return t;
    }
    static int stars = 0;
    static int stars1 = 0;
    int val = test();

    @FXML
    public void handlestar5() {
        Star5.setOpacity(1);
        Star4.setOpacity(1);
        Star3.setOpacity(1);
        Star2.setOpacity(1);
        Star1.setOpacity(1);
        stars = 5;
    }

    @FXML
    public void handlestar4() {
        Star5.setOpacity(0.4);
        Star4.setOpacity(1);
        Star3.setOpacity(1);
        Star2.setOpacity(1);
        Star1.setOpacity(1);
        stars = 4;
    }

    @FXML
    public void handlestar3() {
        Star5.setOpacity(0.4);
        Star4.setOpacity(0.4);
        Star3.setOpacity(1);
        Star2.setOpacity(1);
        Star1.setOpacity(1);
        stars = 3;
    }

    @FXML
    public void handlestar2() {
        Star5.setOpacity(0.4);
        Star4.setOpacity(0.4);
        Star3.setOpacity(0.4);
        Star2.setOpacity(1);
        Star1.setOpacity(1);
        stars = 2;
    }

    @FXML
    public void handlestar1() {
        Star5.setOpacity(0.4);
        Star4.setOpacity(0.4);
        Star3.setOpacity(0.4);
        Star2.setOpacity(0.4);
        Star1.setOpacity(1);
        stars = 1;
    }

    public void showComments() {

    }

    public boolean profanityFinder(String comment) {
        //int index;
        String commenttoUpperCase = comment.toUpperCase();

        if (commenttoUpperCase.indexOf("FUCK") != -1) {
            return true;
        } else if (commenttoUpperCase.indexOf("SHIT") != -1) {
            return true;
        } else if (commenttoUpperCase.indexOf("BITCH") != -1) {
            return true;
        } else if (commenttoUpperCase.indexOf("ASSHOLE") != -1) {
            return true;
        } else {
            return false;
        }
    }
    static Comment c;
    static int profCounter = 0;
    static int secondsPassed = 0;

    @FXML
    public void handleSubmit(ActionEvent event) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                secondsPassed++;
                System.out.println(secondsPassed);
            }
        };
        int err;
        int err1;
        int err2;
        int err3;

        if (CommentInput.getText()
                .trim().isEmpty()) {
            CommentErr.setVisible(true);
            err = 1;
        } else {
            CommentErr.setVisible(false);
            err = 0;
        }

        if (CommentInput.getText()
                .trim().length() > 255) {
            CommentErr1.setVisible(true);
            err1 = 1;
        } else {
            CommentErr1.setVisible(false);
            err1 = 0;
        }
        if (stars
                == 0) {
            CommentErr2.setVisible(true);
            err2 = 1;
        } else {
            CommentErr2.setVisible(false);
            err2 = 0;
        }

        if (profanityFinder(CommentInput.getText()) == true) {
            err3 = 1;
            profCounter++;
            CommentErr3.setVisible(true);
        } else {
            CommentErr3.setVisible(false);
            err3 = 0;
        }
        /*COUNTER

        COUNTER
         */
        if (profCounter >= 3) {
            timer.scheduleAtFixedRate(task, 1000, 1000);
            banlabel.setVisible(true);
            tag1.setVisible(
                    false);
            tag2.setVisible(
                    false);
            tag3.setVisible(
                    false);
            CommentInput.setVisible(
                    false);
            commentlabel.setVisible(
                    false);
            starslabel.setVisible(
                    false);
            Star1.setVisible(
                    false);
            Star2.setVisible(
                    false);
            Star3.setVisible(
                    false);
            Star4.setVisible(
                    false);
            Star5.setVisible(
                    false);
            Submit.setVisible(
                    false);
            commentsub.setVisible(
                    false);
            Delete.setVisible(
                    false);
            Modify.setVisible(
                    false);
            CommentErr.setVisible(false);
            CommentErr1.setVisible(false);
            CommentErr2.setVisible(false);
            CommentErr3.setVisible(false);
            commentsList.setVisible(false);

        }
        c = new Comment(1, 18, CommentInput.getText().trim(), stars);

        CommentService cs = new CommentService();
        TagsService ts = new TagsService();

        if (err == 0 && err1 == 0 && err2 == 0 && err3 == 0) {

            cs.create(c);
            Comment com1 = cs.searchById1(1, 18);
            int het = com1.getId();
            Tags t;
            t = new Tags(tag1.getText().trim(), tag2.getText().trim(), tag3.getText().trim(), het);
            ts.createPst(t);
            Connection con;
            Statement statement;
            //Statement statement1;
            String request = "SELECT * FROM `comments` UNION ALL SELECT * FROM `tags`";
            //String requestFromUser = "SELECT firstname FROM `user` WHERE id=1";
            String stringComment;
            String stringUser;
            //String stringTag1;
            //String stringTag2;
            //String stringTag3;
            int starsNum;
            con = Datasource.getInstance().getCnx();
            try {
                statement = con.createStatement();
                ResultSet results = statement.executeQuery(request);
                //statement1 = con.createStatement();
                //ResultSet resultsUser = statement1.(requestFromUser);
                while (results.next()) {
                    stringComment = results.getString("comment");
                    stringUser = "Sami";
                    //stringTag1 = results.getString("tag1");
                    //stringTag2 = results.getString("tag2");
                    //stringTag3 = results.getString("tag3");
                    commentsList.getItems().clear();
                    starsNum = results.getInt("stars");
                    //comments.add(new Comment(results.getInt("id"), results.getInt("id_event"), results.getString("comment"), results.getInt("stars")));
                    commentsList.getItems().add(stringUser + " : \n" + stringComment + "\n" + "Stars: " + starsNum + "\n");
                    //TAGS commentsList.getItems().add(strcomm);
                }

            } catch (SQLException ex) {
                Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
            }
            tag1.setVisible(
                    false);
            tag2.setVisible(
                    false);
            tag3.setVisible(
                    false);
            CommentInput.setVisible(
                    false);
            commentlabel.setVisible(
                    false);
            starslabel.setVisible(
                    false);
            Star1.setVisible(
                    false);
            Star2.setVisible(
                    false);
            Star3.setVisible(
                    false);
            Star4.setVisible(
                    false);
            Star5.setVisible(
                    false);
            Submit.setVisible(
                    false);
            commentsub.setVisible(
                    true);
            Delete.setVisible(
                    true);
            Modify.setVisible(
                    true);
        }

    }

    static int magic = 1;

    @FXML
    public void handleModify(ActionEvent event) {
        if (magic == 1) {
            Modify.setVisible(true);
            Modify.setTranslateX(90);
            Modify.setTranslateY(95);

            tag1.setVisible(true);
            tag2.setVisible(true);
            tag3.setVisible(true);
            CommentInput.setVisible(true);
            commentlabel.setVisible(true);
            starslabel.setVisible(true);
            Star1.setVisible(true);
            Star2.setVisible(true);
            Star3.setVisible(true);
            Star4.setVisible(true);
            Star5.setVisible(true);
            //Submit.setVisible(true);
            commentsub.setVisible(false);
            Submit.setVisible(false);
            Delete.setVisible(false);

            //CommentInput.setText(c1.getComment());
            /*switch (c1.getStars()) {
            case 1:
                handlestar1();
                break;
            case 2:
                handlestar2();
                break;
            case 3:
                handlestar3();
                break;
            case 4:
                handlestar4();
                break;
            case 5:
                handlestar5();
                break;
        }
        Star1.setVisible(false);
        Star2.setVisible(false);
        Star3.setVisible(true);
        Star4.setVisible(true);
        Star5.setVisible(true);*/
            Star11.setVisible(true);
            Star21.setVisible(true);
            Star31.setVisible(true);
            Star41.setVisible(true);
            Star51.setVisible(true);

            magic *= -1;
        } else {
            Comment c1 = new Comment();
            CommentService cs = new CommentService();
            c1 = cs.searchById1(1, 18);
            c1.setComment(CommentInput.getText().trim());
            System.out.println(c1.getComment());
            c1.setStars(stars1);
            cs.update(c1);
            Connection con;
            Statement statement;
            //Statement statement1;
            String request = "SELECT * FROM `comments`";
            //String requestFromUser = "SELECT firstname FROM `user` WHERE id=1";
            String stringComment;
            String stringUser;
            int starsNum;
            con = Datasource.getInstance().getCnx();
            try {
                commentsList.getItems().clear();
                statement = con.createStatement();
                ResultSet results = statement.executeQuery(request);
                //statement1 = con.createStatement();
                //ResultSet resultsUser = statement1.(requestFromUser);
                while (results.next()) {
                    stringComment = results.getString("comment");
                    stringUser = "Sami";
                    starsNum = results.getInt("stars");
                    //comments.add(new Comment(results.getInt("id"), results.getInt("id_event"), results.getString("comment"), results.getInt("stars")));
                    commentsList.getItems().add(stringUser + " : \n" + stringComment + "\n" + "Stars: " + starsNum);
                    //TAGS commentsList.getItems().add(strcomm);

                }

            } catch (SQLException ex) {
                Logger.getLogger(CommentService.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            tag1.setVisible(false);
            tag2.setVisible(false);
            tag3.setVisible(false);
            CommentInput.setVisible(false);
            commentlabel.setVisible(false);
            starslabel.setVisible(false);
            Star1.setVisible(false);
            Star2.setVisible(false);
            Star3.setVisible(false);
            Star4.setVisible(false);
            Star5.setVisible(false);
            Star11.setVisible(false);
            Star21.setVisible(false);
            Star31.setVisible(false);
            Star41.setVisible(false);
            Star51.setVisible(false);
            Submit.setVisible(false);
            commentsub.setVisible(true);
            Delete.setVisible(true);
            Modify.setTranslateX(0);
            Modify.setTranslateY(0);
            magic *= -1;
        }
    }

    @FXML
    public void handleinit(MouseEvent event) {
        if (secondsPassed > 10) {
            banlabel.setVisible(false);

            tag1.setVisible(
                    true);
            tag2.setVisible(
                    true);
            tag3.setVisible(
                    true);
            CommentInput.setVisible(
                    true);
            commentlabel.setVisible(
                    true);
            starslabel.setVisible(
                    true);
            Star1.setVisible(
                    true);
            Star2.setVisible(
                    true);
            Star3.setVisible(
                    true);
            Star4.setVisible(
                    true);
            Star5.setVisible(
                    true);
            Submit.setVisible(
                    true);
            commentsub.setVisible(
                    false);
            Delete.setVisible(
                    false);
            Modify.setVisible(
                    false);
            commentsList.setVisible(true);
        }
    }

    @FXML
    public void handlestar51() {
        Star51.setOpacity(1);
        Star41.setOpacity(1);
        Star31.setOpacity(1);
        Star21.setOpacity(1);
        Star11.setOpacity(1);
        stars1 = 5;
    }

    @FXML
    public void handlestar41() {
        Star51.setOpacity(0.4);
        Star41.setOpacity(1);
        Star31.setOpacity(1);
        Star21.setOpacity(1);
        Star11.setOpacity(1);
        stars1 = 4;
    }

    @FXML
    public void handlestar31() {
        Star51.setOpacity(0.4);
        Star41.setOpacity(0.4);
        Star31.setOpacity(1);
        Star21.setOpacity(1);
        Star11.setOpacity(1);
        stars1 = 3;
    }

    @FXML
    public void handlestar21() {
        Star51.setOpacity(0.4);
        Star41.setOpacity(0.4);
        Star31.setOpacity(0.4);
        Star21.setOpacity(1);
        Star11.setOpacity(1);
        stars1 = 2;
    }

    @FXML
    public void handlestar11() {
        Star51.setOpacity(0.4);
        Star41.setOpacity(0.4);
        Star31.setOpacity(0.4);
        Star21.setOpacity(0.4);
        Star11.setOpacity(1);
        stars1 = 1;
    }

    @FXML
    private void handleDelete(MouseEvent event) {
        CommentService cs = new CommentService();
        Comment com;
        com = cs.searchById1(1, 18);
        cs.Delete(com.getId());
        Connection con;
        Statement statement;
        //Statement statement1;
        String request = "SELECT * FROM `comments`";
        //String requestFromUser = "SELECT firstname FROM `user` WHERE id=1";
        String stringComment;
        String stringUser;
        int starsNum;
        con = Datasource.getInstance().getCnx();
        try {
            commentsList.getItems().clear();
            statement = con.createStatement();
            ResultSet results = statement.executeQuery(request);
            //statement1 = con.createStatement();
            //ResultSet resultsUser = statement1.(requestFromUser);
            while (results.next()) {
                stringComment = results.getString("comment");
                stringUser = "Sami";
                starsNum = results.getInt("stars");
                //comments.add(new Comment(results.getInt("id"), results.getInt("id_event"), results.getString("comment"), results.getInt("stars")));
                commentsList.getItems().add(stringUser + " : \n" + stringComment + "\n" + "Stars: " + starsNum);
                //TAGS commentsList.getItems().add(strcomm);

            }

        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        Modify.setVisible(false);
        tag1.setVisible(true);
        tag2.setVisible(true);
        tag3.setVisible(true);
        CommentInput.setVisible(true);
        commentlabel.setVisible(true);
        starslabel.setVisible(true);
        Star1.setVisible(true);
        Star2.setVisible(true);
        Star3.setVisible(true);
        Star4.setVisible(true);
        Star5.setVisible(true);
        //Submit.setVisible(true);
        commentsub.setVisible(false);
        Submit.setVisible(true);
        Delete.setVisible(false);
    }

    @FXML
    public void listeselect() {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        String toSpeak = commentsList.getSelectionModel().getSelectedItem();
        String toSpeak1 = toSpeak.substring(2);
        Voice voice = VoiceManager.getInstance().getVoice("kevin16");
        voice.allocate();
        voice.setVolume(vol);
        voice.speak(toSpeak1);
    }
}
