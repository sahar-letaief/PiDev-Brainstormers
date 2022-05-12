/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.brainstormers.entities;

/**
 *
 * @author sami
 */
public class User {

    private int id;
    private String username;
    private String email;
    private int phone_number;
    public String firstname;
    public String lastname;
    private String nom;
    private String prenom;
    private String motdepasse;
    private String role;

    public User(int id, String username, String email, int phone_number, String firstname, String lastname, String nom, String prenom, String motdepasse, String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone_number = phone_number;
        this.firstname = firstname;
        this.lastname = lastname;
        this.nom = nom;
        this.prenom = prenom;
        this.motdepasse = motdepasse;
        this.role = role;
    }

    public User(String firstname) {
        this.firstname = firstname;
    }

    ///constrcuteur mtaa reservation
    public User(int id, String firstname, String lastname, String email, int phone_number) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone_number = phone_number;

    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getTelephone() {
        return phone_number;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public String getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(int phone_number) {
        this.phone_number = phone_number;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "FIRST NAME : " + firstname + ", LAST NAME: " + lastname;
    }

}
