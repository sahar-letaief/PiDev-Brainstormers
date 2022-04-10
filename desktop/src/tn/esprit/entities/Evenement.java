/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.entities;

import java.util.Date;

/**
 *
 * @author WIKI
 */
public class Evenement {
    public int id;
    public String NameEvent;
    public String PlaceEvent;
    public int NbParticipants;
    public float PriceEvent;
    public String  DateDebut;
    public String DateFin;
    public Reservation reservation;
    

     public Evenement() {
       
    }

     
    public Evenement(int id, String NameEvent, String PlaceEvent, int NbParticipants, float PriceEvent, String DateDebut, String DateFin) {
        this.id = id;
        this.NameEvent = NameEvent;
        this.PlaceEvent = PlaceEvent;
        this.NbParticipants = NbParticipants;
        this.PriceEvent = PriceEvent;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
    }

    public Evenement(String NameEvent, String PlaceEvent, int NbParticipants, float PriceEvent, String DateDebut, String DateFin) {
        this.NameEvent = NameEvent;
        this.PlaceEvent = PlaceEvent;
        this.NbParticipants = NbParticipants;
        this.PriceEvent = PriceEvent;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
    }

   
    public int getId() {
        return id;
    }

    public String getNameEvent() {
        return NameEvent;
    }

    public String getPlaceEvent() {
        return PlaceEvent;
    }

    public int getNbParticipants() {
        return NbParticipants;
    }

    public float getPriceEvent() {
        return PriceEvent;
    }

    public String getDateDebut() {
        return DateDebut;
    }

    public String getDateFin() {
        return DateFin;
    }

    public Reservation getReservation() {
        return reservation;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public void setNameEvent(String NameEvent) {
        this.NameEvent = NameEvent;
    }

    public void setPlaceEvent(String PlaceEvent) {
        this.PlaceEvent = PlaceEvent;
    }

    public void setNbParticipants(int NbParticipants) {
        this.NbParticipants = NbParticipants;
    }

    public void setPriceEvent(float PriceEvent) {
        this.PriceEvent = PriceEvent;
    }

    public void setDateDebut(String DateDebut) {
        this.DateDebut = DateDebut;
    }

    public void setDateFin(String DateFin) {
        this.DateFin = DateFin;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
    

    @Override
    public String toString() {
        return "Evenement{" + "id=" + id + ", NameEvent=" + NameEvent + ", PlaceEvent=" + PlaceEvent + ", NbParticipants=" + NbParticipants + ", PriceEvent=" + PriceEvent + ", DateDebut=" + DateDebut + ", DateFin=" + DateFin + '}';
    }
    
    
    
}
