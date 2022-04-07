/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.entities;
import tn.esprit.entities.Evenement;
/**
 *
 * @author WIKI
 */
public class Reservation {
    public int id;
   public Evenement evenement;
   public User user;
   public String date_reservation;
    public int evenement_id;
    public int user_id;
    
   

    public Reservation() {
    }

    public Reservation( int evenement_id, int user_id,String date_reservation) {
        this.date_reservation = date_reservation;
        this.evenement_id = evenement_id;
        this.user_id = user_id;
    }
 public Reservation( int id,int evenement_id, int user_id,String date_reservation) {
        this.id=id;
        this.date_reservation = date_reservation;
        this.evenement_id = evenement_id;
        this.user_id = user_id;
    }

   

    public Reservation(int id, Evenement evenement, User user, String date_reservation) {
        this.id = id;
        this.evenement = evenement;
        this.user = user;
        this.date_reservation = date_reservation;
    }

  

    
    public int getId() {
        return id;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public User getUser() {
        return user;
    }

    public String getDate_reservation() {
        return date_reservation;
    }

    public int getEvenement_id() {
        return evenement_id;
    }

    public int getUser_id() {
        return user_id;
    }

   

   
    public void setId(int id) {
        this.id = id;
    }

    public void setEvenement_id(Evenement evenement) {
        this.evenement = evenement;
    }

    public void setUser_id(User user) {
        this.user = user;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDate_reservation(String date_reservation) {
        this.date_reservation = date_reservation;
    }

    public void setEvenement_id(int evenement_id) {
        this.evenement_id = evenement_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", evenement=" + evenement_id + ", user=" + user_id + ", date_reservation=" + date_reservation + '}';
    }

   

  
   

    
   
    
}
