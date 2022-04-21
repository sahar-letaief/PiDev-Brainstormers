/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tn.brainstormers.gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import tn.brainstormers.entities.Comment;
import tn.brainstormers.services.CommentService;
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
    //ObservableList<Comment> commentList;
    //List<Comment> commentsList1;
    CommentService cs = new CommentService();
    @FXML
    public Button Delete;
    @FXML
    public Button Modify;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    int stars = 0;

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
        } else if (commenttoUpperCase.indexOf("WTF") != -1) {
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
        if (CommentInput.getText().trim().isEmpty()) {
            CommentErr.setVisible(true);
            err = 1;
        } else {
            CommentErr.setVisible(false);
            err = 0;
        }
        if (CommentInput.getText().trim().length() > 255) {
            CommentErr1.setVisible(true);
            err1 = 1;
        } else {
            CommentErr1.setVisible(false);
            err1 = 0;
        }
        if (stars == 0) {
            CommentErr2.setVisible(true);
            err2 = 1;
        } else {
            CommentErr2.setVisible(false);
            err2 = 0;
        }
        if (profanityFinder(CommentInput.getText()) == true) {
            err3 = 1;
            CommentErr3.setVisible(true);
        } else {
            CommentErr3.setVisible(false);
            err3 = 0;
        }
        if (err == 0 && err1 == 0 && err2 == 0 && err3 == 0) {
            Comment c = new Comment(1, 18, CommentInput.getText().trim(), stars);
            CommentService cs = new CommentService();
            cs.create(c);
            Connection con;
            Statement statement;
            PreparedStatement prepstatement;
            String request = "SELECT * FROM `comments`";
            String strcomm;
            con = Datasource.getInstance().getCnx();
            try {
                statement = con.createStatement();
                ResultSet results = statement.executeQuery(request);

                while (results.next()) {
                    strcomm = results.getString("comment");
                    //comments.add(new Comment(results.getInt("id"), results.getInt("id_event"), results.getString("comment"), results.getInt("stars")));
                    commentsList.getItems().add(strcomm);
                    //TAGS commentsList.getItems().add(strcomm);
                }

            } catch (SQLException ex) {
                Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    public void handleDelete(ActionEvent event) {
        String commentDel = commentsList.getSelectionModel().getSelectedItem();
           CommentService cs = new CommentService();
            cs.delcom(commentDel);
        int selectedID = commentsList.getSelectionModel().getSelectedIndex();
        commentsList.getItems().remove(selectedID);
    }
    
    @FXML
    public void handleModify(ActionEvent event) {
        String commentMod = commentsList.getSelectionModel().getSelectedItem();
        CommentInput.setText(commentMod);
    }

}
