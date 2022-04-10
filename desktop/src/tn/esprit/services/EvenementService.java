/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tn.esprit.entities.Evenement;
import tn.esprit.utils.Datasource;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import tn.esprit.entities.Reservation;
import tn.esprit.entities.User;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;



/**
 *
 * @author WIKI
 */
public class EvenementService  {
     public Connection cnx;
    public Statement ste;
    public  PreparedStatement pst;

    public EvenementService() {
        cnx = (Connection) Datasource.getInstance().getCnx();
    }
  
     public void AddEvent(Evenement e) {
        String requete = "INSERT INTO `evenement` (`name_event`,`place_event`,`nb_participants`,`price_event`,`date_debut`,`date_fin`) "
                + "VALUES (?,?,?,?,?,?);";
        
        try {
            pst = (PreparedStatement) cnx.prepareStatement(requete);
            pst.setString(1, e.getNameEvent());
            pst.setString(2, e.getPlaceEvent());
            pst.setInt(3, e.getNbParticipants());
            pst.setFloat(4, e.getPriceEvent());
            pst.setString(5, e.getDateDebut());
            pst.setString(6, e.getDateFin());
            pst.executeUpdate();
            System.out.println("event"+e.getNameEvent()+" added successfully");
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Evenement> FetchEvents(){
        List<Evenement> events = new ArrayList<>();
        String requete = "SELECT * FROM `evenement`";
        
        try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs =  ste.executeQuery(requete);
            
            while(rs.next()){           
                events.add(new Evenement(rs.getInt("id"), rs.getString("name_event"), rs.getString("place_event"),
                      rs.getInt("nb_participants"),rs.getFloat("price_event"),rs.getString("date_debut"),rs.getString("date_fin")));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return events;
    }
    public Evenement FetchOneEvent(int id){
        Evenement event = new Evenement();
        String requete = "SELECT * FROM `evenement` where id="+id;
        
        try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs =  ste.executeQuery(requete);
            
            while(rs.next()){           
                 
                event = new Evenement(rs.getInt("id"), rs.getString("name_event"), rs.getString("place_event"),rs.getInt("nb_participants"),rs.getFloat("price_event"),rs.getString("date_debut"),rs.getString("date_fin"));

            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return event;
    }
    public void updatePar(Evenement e){
              String requete = "update `evenement` set name_event=?,place_event=?,nb_participants=?,price_event=?,date_debut=?,date_fin=? where id=?" ;
        try {
            
            pst = (PreparedStatement) cnx.prepareStatement(requete);
            
            pst.setString(1, e.getNameEvent());
            pst.setString(2, e.getPlaceEvent());
            pst.setInt(3, e.getNbParticipants());
            pst.setFloat(4, e.getPriceEvent());
            pst.setString(5, e.getDateDebut());
            pst.setString(6, e.getDateFin());
            pst.setInt(7, e.getId());
            pst.executeUpdate();    
            System.out.println("participants number of event "+e.getNameEvent()+" is updated successfully");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public User FetchOneUser(int id){
        User user=new User();
        String requete = "SELECT * FROM `user` where id="+id;
        
        try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs =  ste.executeQuery(requete);
            
            while(rs.next()){           
                 
                user = new User(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"),rs.getString("email"),rs.getInt("phone_number"));

            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    
       public void DeleteEvent(int id) {
        String requete = "delete from `evenement` where id=?";
        try {
           pst = (PreparedStatement) cnx.prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("event with id="+id+" is deleted successfully");
        } catch (SQLException ex) {
            System.out.println("error in delete event " + ex.getMessage());
        }
    }
      
        public void EditEvent(Evenement e) {
        System.out.println(e);
        String requete = "update `evenement` set name_event=?,place_event=?,nb_participants=?,price_event=?,date_debut=?,date_fin=? where id=?" ;
        try {
            
            pst = (PreparedStatement) cnx.prepareStatement(requete);
//            java.sql.PreparedStatement pst = cnx.prepareStatement(requete);
            
            pst.setString(1, e.getNameEvent());
            pst.setString(2, e.getPlaceEvent());
            pst.setInt(3, e.getNbParticipants());
            pst.setFloat(4, e.getPriceEvent());
            pst.setString(5, e.getDateDebut());
            pst.setString(6, e.getDateFin());
            pst.setInt(7, e.getId());
            pst.executeUpdate();    
            System.out.println("event "+e.getNameEvent()+" is updated successfully");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

      public List<Evenement> SortEventByPrice(){
        List<Evenement> events = new ArrayList<>();
        String requete = "SELECT * FROM `evenement` ORDER BY price_event";
        
        try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs =  ste.executeQuery(requete);
            
            while(rs.next()){           
                events.add(new Evenement(rs.getInt("id"), rs.getString("name_event"), rs.getString("place_event"),
                      rs.getInt("nb_participants"),rs.getFloat("price_event"),rs.getString("date_debut"),rs.getString("date_fin")));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return events;
    }
        public List<Evenement> SortEventByPart(){
        List<Evenement> events = new ArrayList<>();
        String requete = "SELECT * FROM `evenement` ORDER BY nb_participants";
        
        try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs =  ste.executeQuery(requete);
            
            while(rs.next()){           
                events.add(new Evenement(rs.getInt("id"), rs.getString("name_event"), rs.getString("place_event"),
                      rs.getInt("nb_participants"),rs.getFloat("price_event"),rs.getString("date_debut"),rs.getString("date_fin")));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return events;
    }
         public List<Evenement> FindEventByName(String name){
        List<Evenement> events = new ArrayList<>();
        String requete = "SELECT * FROM `evenement` WHERE name_event LIKE %"+name+"%";
        
        try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs =  ste.executeQuery(requete);
            
            while(rs.next()){           
                events.add(new Evenement(rs.getInt("id"), rs.getString("name_event"), rs.getString("place_event"),
                      rs.getInt("nb_participants"),rs.getFloat("price_event"),rs.getString("date_debut"),rs.getString("date_fin")));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return events;
    }
          public void GenerateQrEvent(Evenement event) throws FileNotFoundException, IOException{
        
              String eventName=event.getNameEvent()+"\n"+event.getPlaceEvent()+"\n"+event.getPriceEvent()+"\n";
              ByteArrayOutputStream out= QRCode.from(eventName).to(ImageType.JPG).stream();
              String filename=eventName+".jpg";
              File f=new File("C:\\Users\\WIKI\\Desktop\\PI\\desktop\\"+filename);
               FileOutputStream fos=new FileOutputStream(f);
               fos.write(out.toByteArray());
               fos.flush();
    }
      
   
}
