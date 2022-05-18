package tn.esprit.gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.esprit.entities.Comment;
import tn.esprit.entities.Evenement;
import tn.esprit.entities.Tags;
import tn.esprit.entities.UserStaticSession;
import static tn.esprit.gui.DisplayEventsFrontController.idToComment;
import tn.esprit.services.CommentService;
import tn.esprit.services.EvenementService;
import tn.esprit.services.TagsService;
import tn.esprit.utils.Datasource;

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
    @FXML
    public AnchorPane Anchorpane;
    @FXML
    public ImageView imgview;
    @FXML
    public Label banlabel;
    @FXML
    public Label nameEventComment;
    @FXML
    public Label PrEv;
    @FXML
    public Label evPlace;
    TagsService ts = new TagsService();
    CommentService cs = new CommentService();

    public int testExistance() {
        int val;
        val = cs.searchById(UserStaticSession.getId(), idToComment);
        return val;
    }
    static int stars = 0;
    int val = testExistance();
    static Comment c;
    static Tags t;
    static int profCounter = 0;
    static int secondsPassed = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EvenementService es = new EvenementService();
        Evenement e = new Evenement();
        e = es.FetchOneEvent(idToComment);
        try {

            String filename = es.GenerateQrEvent(e);
            System.out.println("filename lenaaa " + filename);
            Image image = new Image(getClass().getResourceAsStream("/tn/esprit/utils/img/" + filename));
            imgview.setImage(image);

        } catch (Exception ex) {
            System.out.println("mafamesh qr");
        }
        idToComment = e.getId();
        nameEventComment.setText(e.getNameEvent());
        PrEv.setText(String.valueOf(e.getPriceEvent()));
        evPlace.setText(e.getPlaceEvent());

        aff();
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
            Submit.setVisible(false);
            commentsub.setVisible(true);
            Delete.setVisible(true);
            Modify.setVisible(true);

        } else {
            commentsub.setVisible(false);
            Delete.setVisible(false);
            Modify.setVisible(false);
        }
    }

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

    @FXML
    public void handleSubmit(ActionEvent event) {

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
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                public void run() {
                    secondsPassed++;
                    System.out.println(secondsPassed);
                }

            };
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

        } else if (profCounter < 3) {

        }
        c = new Comment(UserStaticSession.getId(), idToComment, CommentInput.getText().trim(), stars);

        if (err == 0 && err1 == 0 && err2 == 0 && err3 == 0) {

            cs.createPst(c);
            Comment com1 = cs.fetchById(UserStaticSession.getId(), idToComment);
            int het = com1.getId();
            t = new Tags(tag1.getText().trim(), tag2.getText().trim(), tag3.getText().trim(), het);
            ts.createPst(t);

            aff();
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
            commentsub.setVisible(false);
            Submit.setVisible(false);
            Delete.setVisible(false);

            magic *= -1;
        } else {
            Comment c1 = new Comment();
            c1 = cs.fetchById(UserStaticSession.getId(), idToComment);
            c1.setComment(CommentInput.getText().trim());
            System.out.println(c1.getComment());
            c1.setStars(stars);
            cs.update(c1);
            aff();
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
            secondsPassed = 0;
            profCounter = 0;
        }
    }

    @FXML
    private void handleDelete(MouseEvent event) {
        Comment com;
        com = cs.fetchById(UserStaticSession.getId(), idToComment);
        cs.Delete(com.getId());
        aff();

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
        commentsub.setVisible(false);
        Submit.setVisible(true);
        Delete.setVisible(false);
    }

    @FXML
    public void listeselect() {
        new Thread(() -> {
            System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
            String toSpeak = commentsList.getSelectionModel().getSelectedItem();
            String toSpeak1 = toSpeak.substring(2);
            Voice voice = VoiceManager.getInstance().getVoice("kevin16");
            voice.allocate();
            voice.setVolume(100);
            voice.speak(toSpeak1);
        }).start();
    }

    public void aff() {
        commentsList.getItems().clear();
        Connection con;
        Statement statement;
        //Statement statement1;
        String request = "SELECT * FROM `comments` WHERE id_event=" + idToComment;
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
                commentsList.getItems().add(stringComment + "          " + starsNum + " Stars");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void returnEv(ActionEvent event) {

        FXMLLoader Loader = new FXMLLoader(getClass().getResource("DisplayEventsFront.fxml"));

        try {
            Parent root = Loader.load();
            DisplayEventsFrontController C = Loader.getController();
            List<Evenement> data = new ArrayList<>();
            data = C.getData();

            Scene productDetailScene = new Scene(root);
            Stage cineStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            cineStage.setScene(productDetailScene);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
