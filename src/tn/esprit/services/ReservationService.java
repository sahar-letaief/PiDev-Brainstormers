/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.esprit.entities.Evenement;
import tn.esprit.entities.Reservation;
import tn.esprit.entities.User;
import tn.esprit.utils.Datasource;

/**
 *
 * @author sami
 */
public class ReservationService {

    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;

    public ReservationService() {
        cnx = (Connection) Datasource.getInstance().getCnx();
    }

    public void AddReservation(Reservation r) {
        EvenementService es = new EvenementService();
        Evenement e = new Evenement();
        String date_reservation = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(LocalDateTime.now());
        String requete = "INSERT INTO `reservation` (`date_reservation`,`evenement_id` ,`user_id`) VALUES(? ,?,?) ;";

        try {

            Evenement tempEvent = es.FetchOneEvent(r.getEvenement_id());
            System.out.println("before" + tempEvent);
            tempEvent.setNbParticipants(tempEvent.getNbParticipants() - 1);
            es.updatePar(tempEvent);
            int new_id = tempEvent.getId();
            r.setEvenement(tempEvent);
            System.out.println("after" + tempEvent);

            pst = (PreparedStatement) cnx.prepareStatement(requete);
            pst.setString(1, date_reservation);
            pst.setInt(2, r.getEvenement_id());
            pst.setInt(3, r.getUser_id());

            pst.executeUpdate();

            System.out.println("reservation with id event = " + r.getEvenement_id() + " is added successfully");
        } catch (SQLException ex) {
            System.out.println("error in adding reservation");
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObservableList<Reservation> FetchReservations() {
        ObservableList<Reservation> reservations = FXCollections.observableArrayList();
        Evenement event = new Evenement();
        User user = new User();
        EvenementService es = new EvenementService();
        String requete = "SELECT reservation.id,reservation.date_reservation,reservation.user_id as u_id, evenement.id as event_id FROM `reservation`,`evenement` WHERE reservation.evenement_id=evenement.id";
        try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs = ste.executeQuery(requete);

            while (rs.next()) {
                Evenement tempEvent = es.FetchOneEvent(rs.getInt("event_id"));
                User tempUser = es.FetchOneUser(rs.getInt("u_id"));
                reservations.add(new Reservation(rs.getInt("id"), tempEvent, tempUser,
                        rs.getString("date_reservation")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reservations;
    }

    public ObservableList<Reservation> FetchReservationsFront(int id) {
        ObservableList<Reservation> reservations = FXCollections.observableArrayList();
        Evenement event = new Evenement();
        User user = new User();
        EvenementService es = new EvenementService();
        String requete = "SELECT reservation.id,reservation.date_reservation,reservation.user_id as u_id, evenement.id as event_id FROM `reservation`,`evenement` WHERE reservation.evenement_id=evenement.id and reservation.user_id=" + id;
        try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs = ste.executeQuery(requete);

            while (rs.next()) {
                Evenement tempEvent = es.FetchOneEvent(rs.getInt("event_id"));
                User tempUser = es.FetchOneUser(rs.getInt("u_id"));
                reservations.add(new Reservation(rs.getInt("id"), tempEvent, tempUser,
                        rs.getString("date_reservation")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reservations;
    }

    public boolean ReservationTest(int evenement_id, int user_id) {
        EvenementService es = new EvenementService();
        Evenement tempEvent = new Evenement();
        //Reservation r=new Reservation();
        String requete = "SELECT evenement_id , user_id FROM `reservation` WHERE evenement_id=" + evenement_id + " AND user_id=" + user_id;
        try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs = ste.executeQuery(requete);

            while (rs.next()) {

//                e = new Evenement(rs.getInt("event_id"), rs.getString("name_event"), rs.getString("place_event"),rs.getInt("nb_participants"),rs.getFloat("price_event"),rs.getString("date_debut"),rs.getString("date_fin"));
                Reservation r = new Reservation(rs.getInt("evenement_id"), rs.getInt("user_id"));
                return true;
            }

        } catch (SQLException ex) {
            return false;

        }
        return false;

    }

    public Reservation FetchOneRes(int id) {
        Reservation r = new Reservation();
        String requete = "SELECT * FROM `reservation` where id=" + id;

        try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs = ste.executeQuery(requete);

            while (rs.next()) {

                r = new Reservation(rs.getInt("id"), rs.getString("date_reservation"), rs.getInt("evenement_id"), rs.getInt("user_id"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public int ResPie(int id) {
        Reservation r = new Reservation();
        EvenementService es = new EvenementService();
        Evenement ev = new Evenement();
        //  Map<Evenement,Reservation> map = new Map<Evenement,Reservation>();
        String requete = "SELECT * FROM `reservation` where evenement_id=" + id;
        int nb = 0;
        try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs = ste.executeQuery(requete);

            while (rs.next()) {

                r = new Reservation(rs.getInt("id"), rs.getString("date_reservation"), rs.getInt("evenement_id"), rs.getInt("user_id"));
                ev = es.FetchOneEvent(id);
                nb++;

            }

        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nb;
    }

    public int idss() {
        Reservation r = new Reservation();
        String requete = "SELECT evenement_id FROM `reservation`";
        int nb = 0;
        try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs = ste.executeQuery(requete);

            while (rs.next()) {

                r = new Reservation(rs.getInt("id"), rs.getString("date_reservation"), rs.getInt("evenement_id"), rs.getInt("user_id"));
                nb++;

            }

        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nb;
    }

    public void DeleteReservation(int id) {
        EvenementService es = new EvenementService();
        ReservationService rs = new ReservationService();

        Reservation r = rs.FetchOneRes(id);

        String requete = "delete from reservation where id=" + id;
        try {
            Evenement tempEvent = es.FetchOneEvent(r.getEvenement_id());
            System.out.println("before" + tempEvent);
            tempEvent.setNbParticipants(tempEvent.getNbParticipants() + 1);
            es.updatePar(tempEvent);

            System.out.println("after" + tempEvent);
            pst = (PreparedStatement) cnx.prepareStatement(requete);
            //pst.setInt(1, id);

            pst.executeUpdate();
            System.out.println("reservation with id=" + id + " is deleted successfully");
        } catch (SQLException ex) {
            System.out.println("error in delete reservation " + ex.getMessage());
        }
    }

}
