/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services;

import java.util.List;
import tn.esprit.entities.Evenement;
import tn.esprit.entities.Reservation;

/**
 *
 * @author WIKI
 */
public interface IService<T> {
     public void AddEvent(T e);
     public List<T> FetchEvents();
     public void DeleteEvent(int id);
     public void EditEvent(T e) ;
     
      public void AddReservation(T r);
       public List<T> FetchReservations();
       public void DeleteReservation(int id);
}
