/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.entities;

/**
 *
 * @author WIKI
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

    public User(int id, String username, String email, int telephone, String firstname, String lastname, String nom, String prenom, String motdepasse, String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.telephone = telephone;
        this.firstname = firstname;
        this.lastname = lastname;
        this.nom = nom;
        this.prenom = prenom;
        this.motdepasse = motdepasse;
        this.role = role;
    }

    
    ///constrcuteur mtaa reservation
    public User( String firstname, String lastname,String email,int telephone) {
        
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.telephone = telephone;
        
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
        return telephone;
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

    public void setTelephone(int telephone) {
        this.telephone = telephone;
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
        return "User{" + "id=" + id + ", username=" + username + ", email=" + email + ", telephone=" + telephone + ", firstname=" + firstname + ", lastname=" + lastname + ", nom=" + nom + ", prenom=" + prenom + ", motdepasse=" + motdepasse + ", role=" + role + '}';
    }
    
    
    
    
}