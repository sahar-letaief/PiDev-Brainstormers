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
         //Reservation r=new Reservation();
         //String date_reservation = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(LocalDateTime.now());
         
        //System.out.println("yyyy/MM/dd -> "+date_reservation.format(LocalDateTime.now()));
        String requete = "INSERT INTO `reservation` (`date_reservation`,`evenement_id`,`user_id`) VALUES(? ,?,?) ;";
               
        
        try {
           pst = (PreparedStatement) cnx.prepareStatement(requete);
          pst.setString(1, r.getDate_reservation());
           pst.setInt(2,r.getEvenement_id() );
           pst.setInt(3, r.getUser_id());
           pst.executeUpdate();
            System.out.println("reservation with id event ="+r.getEvenement_id()+" is added successfully");
        } catch (SQLException ex) {
            System.out.println("error in adding reservation");
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public List<Reservation> FetchReservations(){
          List<Reservation> reservations = new ArrayList<>();
        String requete = "SELECT * FROM `reservation`";
         try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs =  ste.executeQuery(requete);
            
            while(rs.next()){           
                reservations.add(new Reservation(rs.getInt("id"), rs.getInt("evenement_id"), rs.getInt("user_id"),
                      rs.getString("date_reservation")));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return reservations; 
     }
      public void DeleteReservation(int id) {
        String requete = "delete from reservation where id=?";
        try {
           pst = (PreparedStatement) cnx.prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("reservation with id="+id+" is deleted successfully");
        } catch (SQLException ex) {
            System.out.println("error in delete reservation " + ex.getMessage());
        }
    }
}
