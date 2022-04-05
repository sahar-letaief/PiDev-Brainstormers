/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondesevenements;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import tn.esprit.entities.Evenement;
import tn.esprit.services.EvenementService;
import java.util.Date;
import tn.esprit.entities.Reservation;
import tn.esprit.entities.User;
import tn.esprit.services.ReservationService;

/**
 *
 * @author WIKI
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EvenementService es=new EvenementService();
        ReservationService rs=new ReservationService();
        
        /**********affichage des evenements**********/
       // System.out.println("la liste des evenements:"+es.FetchEvents());
        
        /*********ajout d'un evenement***************/
       // Evenement e = new Evenement("sahar test","kairouan",5,12,"2022-04-04","2002-04-05");
        //es.AddEvent(e);
       
        //suppression evenement
        //es.DeleteEvent(37);
        
        /****** affichage reservations****/
       // System.out.println("la liste des reservations"+rs.FetchReservations());
       
       /*****modification evenement*******/
        Evenement e = new Evenement(40,"sahar test","esprit kairouan",5,12,"2022-04-04","2002-04-05");
        es.EditEvent(e);
       
       
       
       /******** ajout reservation*****/
     
     /* String date_reservation = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(LocalDateTime.now());
      System.out.println(date_reservation);
      Reservation r=new Reservation(25,1,date_reservation);
        rs.AddReservation(r);*/
        
        /***** suppression reservation *****/
       // rs.DeleteReservation(57);
       
       
      
        
    }
    
}
