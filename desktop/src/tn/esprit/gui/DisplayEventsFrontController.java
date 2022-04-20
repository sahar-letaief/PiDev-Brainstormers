/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import tn.esprit.entities.Evenement;
import tn.esprit.gui.MainEventsFront;
import tn.esprit.services.EvenementService;

/**
 * FXML Controller class
 *
 * @author WIKI
 */
public class DisplayEventsFrontController implements Initializable {

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
    
    private MyListener myListener;
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
        e.setPriceEvent(data.get(i).getPriceEvent());
        e.setNbParticipants(data.get(i).getNbParticipants());
        e.setDateDebut(data.get(i).getDateDebut());
        e.setDateFin(data.get(i).getDateFin());
            System.out.println("data lena"+e);
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
    public void initialize(URL location, ResourceBundle resources) {
        events.addAll(getData());
        if (events.size() > 0) {
            setChosenEvent(events.get(0));
            myListener = new MyListener() {
               
                @Override
                public void onClickListener(Evenement e) {
                  setChosenEvent(e);
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < events.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("EventItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                EventItemController EIC = fxmlLoader.getController();
                 EIC.setData(events.get(i),myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void AddReservation(ActionEvent event) {
    }
    
}
