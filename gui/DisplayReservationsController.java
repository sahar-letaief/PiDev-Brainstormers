/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tn.brainstormers.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tn.brainstormers.entities.Evenement;
import tn.brainstormers.entities.Reservation;
import tn.brainstormers.entities.User;
import tn.brainstormers.services.ReservationService;

/**
 * FXML Controller class
 *
 * @author sami
 */
public class DisplayReservationsController implements Initializable {

    ObservableList<Reservation> res;

    @FXML
    private TableColumn<Reservation, String> reservationdate;
    @FXML
    private TableView<Reservation> tableviewRes;
    @FXML
    private TableColumn<Reservation, Evenement> NameEvent;
    @FXML
    private TableColumn<Reservation, User> firstname;
    //private TableColumn<Reservation, User> lastname;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableviewRes.setFocusTraversable(false);
        getRes();
    }

    public void getRes() {

        NameEvent.setCellValueFactory(new PropertyValueFactory<Reservation, Evenement>("evenement"));

        firstname.setCellValueFactory(new PropertyValueFactory<Reservation, User>("user"));
//         lastname.setCellValueFactory(new PropertyValueFactory<Reservation,User>("lastname"));

        reservationdate.setCellValueFactory(new PropertyValueFactory<Reservation, String>("date_reservation"));

        ReservationService rs = new ReservationService();
        res = rs.FetchReservations();
        System.out.println(res);
        tableviewRes.setItems(res);

    }

    @FXML
    private void EventsBack(ActionEvent event) {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("DisplayEvents.fxml"));

        try {
            Parent root = Loader.load();
            DisplayEventsController C = Loader.getController();
            C.getEvents();
            Scene productDetailScene = new Scene(root);
            Stage cineStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            cineStage.setScene(productDetailScene);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
