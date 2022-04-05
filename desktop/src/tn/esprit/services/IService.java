/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services;

import java.util.List;
import tn.esprit.entities.Evenement;

/**
 *
 * @author WIKI
 */
public interface IService<Evenement> {
     public void AddEvent(Evenement e);
     public List<Evenement> FetchEvents();
     public void DeleteEvent(int id);
     public void EditEvent(Evenement e) ;
}
