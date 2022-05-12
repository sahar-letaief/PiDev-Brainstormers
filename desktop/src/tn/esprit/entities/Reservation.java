/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.entities;

/**
 *
 * @author sami
 */
public class Reservation extends Evenement {

    public int id;
    public Evenement evenement;
    public User user;
    public String date_reservation;
    public int evenement_id;
    public int user_id;

    public Reservation() {
    }

    public Reservation(int id, Evenement evenement, User user, String date_reservation) {
        this.id = id;
        this.evenement = evenement;
        this.user = user;
        this.date_reservation = date_reservation;

    }

    public Reservation(int id, String date_reservation, int evenement_id, int user_id) {
        this.id = id;
        this.date_reservation = date_reservation;
        this.evenement_id = evenement_id;
        this.user_id = user_id;
    }

    public Reservation(int evenement_id, int user_id) {
        // this.date_reservation = date_reservation;
        this.evenement_id = evenement_id;
        this.user_id = user_id;
    }

    public Reservation(int id, Evenement evenement) {
        this.id = id;
        this.evenement = evenement;
    }

    public Reservation(int id, int evenement_id, int user_id, String date_reservation) {
        this.id = id;
        this.date_reservation = date_reservation;
        this.evenement_id = evenement_id;
        this.user_id = user_id;
    }

    public Reservation(int id, Evenement evenement, String date_reservation, int evenement_id, int user_id) {
        this.id = id;
        this.evenement = evenement;
        this.date_reservation = date_reservation;
        this.evenement_id = evenement_id;
        this.user_id = user_id;
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

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(int id) {
        this.id = id;
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

    //@Override
    public String toString() {
        return "Reservation{" + "id=" + id + "," + evenement.toString() + " , " + user.toString() + ", date_reservation=" + date_reservation + '}' + "\n";
    }
}
