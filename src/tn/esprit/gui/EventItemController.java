/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tn.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import tn.esprit.entities.Evenement;

/**
 * FXML Controller class
 *
 * @author sami
 */
public class EventItemController implements Initializable {

    @FXML
    private Label nameLabel;

    @FXML
    private Label PlaceLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(e);
    }

    private Evenement e;
    private MyListener myListener;

    public void setData(Evenement e, MyListener myListener) {
        this.e = e;
        this.myListener = myListener;
        this.nameLabel.setText(e.getNameEvent());
        this.PlaceLabel.setText(e.getPlaceEvent());

    }
}
