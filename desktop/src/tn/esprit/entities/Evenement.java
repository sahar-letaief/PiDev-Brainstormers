/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.entities;

/**
 *
 * @author sami
 */
public class Evenement {

    public int id;
    public String NameEvent;
    public String PlaceEvent;
    public int NbParticipants;
    public float PriceEvent;
    public String DateDebut;
    public String DateFin;

    public Evenement() {

    }

    public Evenement(String NameEvent) {
        this.NameEvent = NameEvent;
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

    @Override
    public String toString() {
        return NameEvent;
    }
}
