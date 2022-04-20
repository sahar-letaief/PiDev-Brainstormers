/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tn.esprit.entities.Evenement;
import tn.esprit.entities.Reservation;
import tn.esprit.entities.User;
import tn.esprit.services.ReservationService;

/**
 * FXML Controller class
 *
 * @author WIKI
 */
public class DisplayReservationFrontController implements Initializable {
 ObservableList<Reservation> res ;
 ReservationService rs= new ReservationService();
 
    @FXML
    private TableView<Reservation> tableviewResFRONT1;
    @FXML
    private TableColumn<Reservation, Evenement> NameEvent1;
    @FXML
    private TableColumn<Reservation, String> Reservation_date1;
    @FXML
    private Button deleteReservation;
    @FXML
    private Button eventsback;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableviewResFRONT1.setFocusTraversable(false);
        getRes();
    }    
    public void getRes(){
       
          
        int id=2;
          NameEvent1.setCellValueFactory(new PropertyValueFactory<Reservation,Evenement>("evenement"));        
          Reservation_date1.setCellValueFactory(new PropertyValueFactory<Reservation,String>("date_reservation"));
          
      
       res=rs.FetchReservationsFront(id);
        System.out.println(res);
       tableviewResFRONT1.setItems(res);
    
                  
                  }//get res

    @FXML
    private void deleteReservation(ActionEvent event) {
         Reservation r=tableviewResFRONT1.getItems().get(tableviewResFRONT1.getSelectionModel().getSelectedIndex());
        rs.DeleteReservation(r.getId());
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information ");
            alert.setHeaderText("reservation delete");
            alert.setContentText("reservation deleted successfully!");
            alert.showAndWait();
         getRes();
    }

    @FXML
    private void DisplayEventsFront(ActionEvent event) {
        
                 FXMLLoader Loader = new FXMLLoader(getClass().getResource("DisplayEventsFront.fxml"));

        try {
            Parent root = Loader.load();
            DisplayEventsFrontController C = Loader.getController();
            List<Evenement> data = new ArrayList<>();
            data=C.getData();
          /********************** ne9setni haja************/
            Scene productDetailScene = new Scene(root);
            Stage cineStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            cineStage.setScene(productDetailScene);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    }

