/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author maryem
 */
public class ListFrontController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private Label idf;
    @FXML
    private Label fxprix;
    @FXML
    private ImageView backB;
    @FXML
    private ImageView aa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
    }

    @FXML
    private void backToBack(MouseEvent event) {
    }
    
}
