/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import tn.esprit.entities.Evenement;

/**
 * FXML Controller class
 *
 * @author WIKI
 */
public class EventItemController implements Initializable {

    @FXML
    private Label nameLabel;
    @FXML
    private Label priceLable;
    @FXML
    private ImageView img;

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
        nameLabel.setText(e.getNameEvent());
        priceLable.setText(MainEventsFront.CURRENCY + e.getPriceEvent());
       
    }
}
