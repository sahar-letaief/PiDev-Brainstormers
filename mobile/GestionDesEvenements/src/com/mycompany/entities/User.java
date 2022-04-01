/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author Yassine
 */
public class User {
    
    private int id;
    private String username;
    private String email;
    private int telephone;
    public String firstname;
    public String lastname;
    private String nom;
    private String prenom;
    private String motdepasse;
    private String role;

    public User(int id , String username, String email, int telephone, String nom, String prenom, String motdepasse,String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.telephone = telephone;
        this.nom = nom;
        this.prenom = prenom;
        this.motdepasse = motdepasse;
        this.role = role;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getPassword() {
        return motdepasse;
    }

    public void setPassword(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int gettelephone() {
        return telephone;
    }

    public void settelephone(int telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", adresse=" + email + ", telephone=" + telephone + ", role =" + role + ", fullname=" + nom + " " +prenom  + '}';
    }

    public User(int id, String username, String email, int telephone, String nom, String prenom) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.telephone = telephone;
        this.nom = nom;
        this.prenom = prenom;
    }

    public User(String username, String email, int telephone, String nom, String prenom) {
        this.username = username;
        this.email = email;
        this.telephone = telephone;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    /////pur la reservation 

    public User(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    
    
    
    
}
