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
      // System.out.println("Events list :"+es.FetchEvents());
        
        /*********ajout d'un evenement***************/
       /* Evenement e = new Evenement("test1","kairouan",5,12,"2022-04-04","2002-04-07");
        es.AddEvent(e);*/
       
        //suppression evenement
       // es.DeleteEvent(40);
        
             
       /*****modification evenement*******/
        /*Evenement e = new Evenement(41,"sahaaaar","esprit tunis",5,12,"2022-04-04","2002-04-07");
        es.EditEvent(e);*/
       
       
        /****** affichage reservations****/
      // System.out.println("la liste des reservations"+rs.FetchReservations());
       
       /******** ajout reservation*****/
     
      
      /*Reservation r=new Reservation(18,1);
        rs.AddReservation(r);*/
        
        /***** suppression reservation *****/
       // rs.DeleteReservation(102);
       //es.GeneratePDF();
      /* Evenement e=new Evenement();
     
        System.out.println(es.FetchOneEvent(19));
      es.FetchOneEvent(19);*/
        
      if(rs.ReservationTest(19, 5)){
          System.out.println("fama");
      }
      else 
            System.out.println("le");
      
    }
    
}
