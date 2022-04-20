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
public class UserStaticSession {

    public UserStaticSession(int id ,String email ,String username ,String firstname ,String lastname , int phonenumber,String password , String roles ) {
        UserStaticSession.id = id;
        UserStaticSession.email = email;
        UserStaticSession.username = username;
        UserStaticSession.firstname = firstname;
        UserStaticSession.lastname = lastname;
        UserStaticSession.phonenumber = phonenumber;
        UserStaticSession.password = password;
        UserStaticSession.roles = roles;

    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        UserStaticSession.id = id;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        UserStaticSession.email = email;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        UserStaticSession.username = username;
    }

    public static String getFirstname() {
        return firstname;
    }

    public static void setFirstname(String firstname) {
        UserStaticSession.firstname = firstname;
    }

    public static String getLastname() {
        return lastname;
    }

    public static void setLastname(String lastname) {
        UserStaticSession.lastname = lastname;
    }

    public static int getPhonenumber() {
        return phonenumber;
    }

    public static void setPhonenumber(int phonenumber) {
        UserStaticSession.phonenumber = phonenumber;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        UserStaticSession.password = password;
    }

    public static String getRoles() {
        return roles;
    }

    public static void setRoles(String roles) {
        UserStaticSession.roles = roles;
    }


    
    private static int id;
    public static String email;
    public static String username;
    public static String firstname;
    public static String lastname;
    public static int phonenumber;
    public static String password;
    public static String roles ;
    

}
