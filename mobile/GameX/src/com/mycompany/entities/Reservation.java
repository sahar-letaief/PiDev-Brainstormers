/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.util.List;

/**
 *
 * @author WIKI
 */
public class Reservation  {
    public int id;
    public User user;
    public Evenement evenement;
  
    public String DateReservation;
  

    public Reservation() {
    }

    public Reservation(int id, Evenement evenement,User user,String DateReservation) {
        this.id = id;
        this.evenement = evenement;
        this.user=user;
        this.DateReservation = DateReservation;
    }

   
   

   
   

    public int getId() {
        return id;
    }

    public Evenement getEvenement() {
        return evenement;
    }

      
    public String getDateReservation() {
        return DateReservation;
    }

    public User getUser() {
        return user;
    }

  

  

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    } 

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

   

    public void setDateReservation(String DateReservation) {
        this.DateReservation = DateReservation;
    }



    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", evenement=" + evenement + ", DateReservation=" + DateReservation + '}';
    }
    
  

}
