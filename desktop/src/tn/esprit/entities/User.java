/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.entities;

/**
 *
 * @author Yassine
 */
public class User {
    
    private int id;
    private String email;
    private String username;
    private String firstname;
    private String lastname;
    private int phonenumber;
    private String password;
    private String roles ;
    private String lastlogindate;


    public User() {
    }
    
    public User(String email , String password) {
        this.email = email;
        this.password = password;
    }
    
    public User(int id, String firstname, String lastname, String email ,int phonenumber) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
    }
    
    
    public User(int id, String email, String username, String firstname, String lastname, int phonenumber,String password, String roles,String lastlogindate) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.password = password;
        this.roles = roles;
        this.lastlogindate = lastlogindate;
    }

    public User(int id, String email, String username, String firstname, String lastname, int phonenumber,String password, String roles) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.password = password;
        this.roles = roles;
    }
    
    public User(int id,String email, String username, String firstname, String lastname, int phonenumber,String password) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.password = password;
    }

    public User(int id, String email, String username) {
        this.id = id;
        this.email = email;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }
        
    public void setEmail(String email) {
        this.email = email;
    }
    
     public String getLastlogindate() {
        return lastlogindate;
    }
        
    public void setLastlogindate(String lastlogindate) {
        this.lastlogindate = lastlogindate;
    }
    
    public String getRoles() {
        return roles;
    }
    
    public void setRoles(String roles) {
        this.roles = roles;
    }
    

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{"+ " id=" + id   + ", firstname= " + firstname + ", lastname=" + lastname + ", email= " + email + ", username= " + username + ", phonenumber= " + phonenumber + ", password= " + password + " roles= " + roles +  "\n" + '}';
    }
}
