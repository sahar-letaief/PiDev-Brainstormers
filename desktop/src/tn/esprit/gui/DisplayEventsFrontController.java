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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import tn.esprit.entities.Evenement;
import tn.esprit.entities.Reservation;
import tn.esprit.gui.MainEventsFront;
import tn.esprit.services.EvenementService;
import tn.esprit.services.ReservationService;

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
    ReservationService rs=new ReservationService();
    
    private MyListener myListener;
    @FXML
    private Label DateDebutLabel;
    @FXML
    private Label DateFinLabel;
    @FXML
    private Button MyReservations;
    @FXML
    private Label idLabel;
    /**
     * Initializes the controller class.
     */
    
    private List<Evenement> getData() {
        List<Evenement> data = new ArrayList<>();
        data=es.FetchEventsFront();
        System.out.println("hedhi"+data);
        Evenement e=new Evenement();
        e.setId(e.getId());
        e.setNameEvent(e.getNameEvent());
        e.setPriceEvent(e.getPriceEvent());
        e.setPlaceEvent(e.getPlaceEvent());
        e.setDateDebut(e.getDateDebut());
        e.setDateFin(e.getDateFin());
        data.add(e);
        return data;
    }
 private void setChosenEvent(Evenement e) {
        EventNameLablel.setText(e.getNameEvent());
        EventPriceLabel.setText(e.getPriceEvent()+MainEventsFront.CURRENCY );
        NbParticipants.setText(e.getNbParticipants()+"");
        DateDebutLabel.setText(e.getDateDebut());
        DateFinLabel.setText(e.getDateFin());
        idLabel.setText(e.getId()+"");
        chosenEventCard.setStyle("-fx-background-color: #b59c9c" + ";\n" +
                "    -fx-background-radius: 30;");
    }
   @Override
    public void initialize(URL location, ResourceBundle resources) {
        idLabel.setVisible(false);
       events.addAll(getData());
       System.out.println("init"+events);
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
        FXMLLoader fxmlLoader = new FXMLLoader();
        Evenement e=new Evenement(Integer.valueOf(this.idLabel.getText()),this.EventNameLablel.getText(),this.EventPlaceLabel.getText(),Integer.parseInt(this.NbParticipants.getText()),Float.parseFloat(this.EventPriceLabel.getText().substring(0, 4)),this.DateDebutLabel.getText(),this.DateFinLabel.getText());
        System.out.println("actuelllll"+e);        
        Reservation r=new Reservation(e.getId(),1);
        rs.AddReservation(r);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information ");
            alert.setHeaderText("Reservation add");
            alert.setContentText("Reservation added successfully!");
            alert.showAndWait();
        
                }

    @FXML
    private void DisplayReservationsFront(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("DisplayReservationFront.fxml"));
    }
    
}
