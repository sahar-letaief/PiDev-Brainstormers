/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import tn.esprit.entities.Evenement;
import tn.esprit.gui.MainEventsFront;
import tn.esprit.services.EvenementService;

/**
 * FXML Controller class
 *
 * @author WIKI
 */
public class MarketController implements Initializable {

    @FXML
    private VBox chosenEventCard;
    @FXML
    private Label EventNameLablel;
    @FXML
    private Label EventPriceLabel;
    @FXML
    private Label EventPlaceLabel;
    @FXML
    private Label NbParticipants;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    private List<Evenement> events = new ArrayList<>();
    EvenementService es=new EvenementService();
    
   // private MyListener myListener;
    /**
     * Initializes the controller class.
     */
    
    private List<Evenement> getData() {
        List<Evenement> data = new ArrayList<>();
        data=es.FetchEventsFront();
        Evenement e=new Evenement();
        for (int i=0;i<data.size();i++){
             e.setId(data.get(i).getId());
        e.setNameEvent(data.get(i).getNameEvent());
        e.setPlaceEvent(data.get(i).getPlaceEvent());
        e.setPriceEvent((float)data.get(i).getPriceEvent());
        e.setNbParticipants(data.get(i).getNbParticipants());
        e.setDateDebut(data.get(i).getDateDebut());
        e.setDateFin(data.get(i).getDateFin());
        data.add(e);
    }
        return data;
    }
 private void setChosenEvent(Evenement e) {
        EventNameLablel.setText(e.getNameEvent());
        EventPriceLabel.setText(MainEventsFront.CURRENCY + e.getPriceEvent());
        NbParticipants.setText(e.getNbParticipants()+"");
        chosenEventCard.setStyle("-fx-background-color: #b59c9c" + ";\n" +
                "    -fx-background-radius: 30;");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddReservation(ActionEvent event) {
    }
    
}
