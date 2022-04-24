/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.esprit.entities.Evenement;
import tn.esprit.entities.Reservation;
import tn.esprit.entities.User;
import tn.esprit.utils.Datasource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author WIKI
 */
public class ReservationService {
     private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    
    public ReservationService() {
        cnx = (Connection) Datasource.getInstance().getCnx();
    }
     public void AddReservation(Reservation r) {
         EvenementService es=new EvenementService();
         Evenement e= new Evenement();
         String date_reservation = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(LocalDateTime.now());
        String requete = "INSERT INTO `reservation` (`date_reservation`,`evenement_id` ,`user_id`) VALUES(? ,?,?) ;";
               
        try {
            
            
            Evenement tempEvent = es.FetchOneEvent(r.getEvenement_id());
            System.out.println("before"+tempEvent);
            tempEvent.setNbParticipants(tempEvent.getNbParticipants()-1);
            es.updatePar(tempEvent);
            int new_id=tempEvent.getId();
            r.setEvenement(tempEvent);
            System.out.println("after"+tempEvent);
           
            
           pst = (PreparedStatement) cnx.prepareStatement(requete);
           pst.setString(1, date_reservation);
           pst.setInt(2,r.getEvenement_id());
           pst.setInt(3, r.getUser_id());
           
           pst.executeUpdate();
           
            System.out.println("reservation with id event = "+r.getEvenement_id()+" is added successfully");
        } catch (SQLException ex) {
            System.out.println("error in adding reservation");
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public ObservableList<Reservation> FetchReservations(){
          ObservableList<Reservation> reservations = FXCollections.observableArrayList();
           Evenement event=new Evenement();
           User user=new User();
           EvenementService es=new EvenementService();
        String requete = "SELECT reservation.id,reservation.date_reservation,reservation.user_id as u_id, evenement.id as event_id FROM `reservation`,`evenement` WHERE reservation.evenement_id=evenement.id";
         try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs =  ste.executeQuery(requete);
            
            while(rs.next()){
                Evenement tempEvent = es.FetchOneEvent(rs.getInt("event_id"));
                User tempUser=es.FetchOneUser(rs.getInt("u_id"));
                reservations.add(new Reservation(rs.getInt("id"), tempEvent, tempUser,
                      rs.getString("date_reservation")));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return reservations; 
     }
     public ObservableList<Reservation> FetchReservationsFront(int id){
          ObservableList<Reservation> reservations = FXCollections.observableArrayList();
           Evenement event=new Evenement();
           User user=new User();
           EvenementService es=new EvenementService();
        String requete = "SELECT reservation.id,reservation.date_reservation,reservation.user_id as u_id, evenement.id as event_id FROM `reservation`,`evenement` WHERE reservation.evenement_id=evenement.id and reservation.user_id="+id;
         try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs =  ste.executeQuery(requete);
            
            while(rs.next()){
                Evenement tempEvent = es.FetchOneEvent(rs.getInt("event_id"));
                User tempUser=es.FetchOneUser(rs.getInt("u_id"));
                reservations.add(new Reservation(rs.getInt("id"), tempEvent, tempUser,
                      rs.getString("date_reservation")));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return reservations; 
     }
     public Evenement ReservationTest(Evenement e){
         EvenementService es=new EvenementService();
         Evenement tempEvent=new Evenement();
         //Reservation r=new Reservation();
                 String requete = "SELECT reservation.id,evenement.id as event_id FROM `reservation`,`evenement` WHERE reservation.evenement_id=evenement.id ";
            try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs =  ste.executeQuery(requete);
            
            while(rs.next()){
                 tempEvent = es.FetchOneEvent(rs.getInt("event_id"));
//                   e = new Evenement(rs.getInt("event_id"), rs.getString("name_event"), rs.getString("place_event"),rs.getInt("nb_participants"),rs.getFloat("price_event"),rs.getString("date_debut"),rs.getString("date_fin"));
                 Reservation r=new Reservation(rs.getInt("id"),e);
            }
            
                       
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return e;
       
     }
      public Reservation FetchOneRes(int id){
       Reservation r=new Reservation();
        String requete = "SELECT * FROM `reservation` where id="+id;
        
        try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs =  ste.executeQuery(requete);
            
            while(rs.next()){           
                 
                r = new Reservation(rs.getInt("id"),rs.getString("date_reservation"),rs.getInt("evenement_id"),rs.getInt("user_id"));

            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
     
      public void DeleteReservation(int id) {
         EvenementService es=new EvenementService();
         ReservationService rs=new ReservationService();
         
         Reservation r=rs.FetchOneRes(id);
         
        String requete = "delete from reservation where id="+id;
        try {
             Evenement tempEvent = es.FetchOneEvent(r.getEvenement_id());
            System.out.println("before"+tempEvent);
            tempEvent.setNbParticipants(tempEvent.getNbParticipants()+1);
            es.updatePar(tempEvent);
            
          
            System.out.println("after"+tempEvent);
           pst = (PreparedStatement) cnx.prepareStatement(requete);
           //pst.setInt(1, id);
           
            pst.executeUpdate();
            System.out.println("reservation with id="+id+" is deleted successfully");
        } catch (SQLException ex) {
            System.out.println("error in delete reservation " + ex.getMessage());
        }
    }

    
}
