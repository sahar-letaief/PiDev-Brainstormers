/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.io.Preferences;

/**
 *
 * @author Lenovo
 */
public class SessionManager {
    
    public static Preferences pref ; // 3ibara memoire sghira nsajlo fiha data 
    
    
    
    // hethom données ta3 user lyt7b tsajlhom fi session  ba3d login 
    private static int id ; 
    private static String userName ; 
    private static String email;
    private static String firstname; 
    private static String lastname; 
    private static int phonenumber;
    private static String role; 
    private static String password; 
    
    
    
    public static Preferences getPref() {
        return pref;
    }

    public static void setPref(Preferences pref) {
        SessionManager.pref = pref;
    }

    public static int getId() {
        return pref.get("id",id);// kif nheb njib id user connecté apres njibha men pref 
    }

    public static void setId(int id) {
        pref.set("id",id);//nsajl id user connecté  w na3tiha identifiant "id";
    }
    
    public static int getphonenumber() {
        return pref.get("phonenumber",phonenumber);// kif nheb njib id user connecté apres njibha men pref 
    }

    public static void setphonenumber(int phonenumber) {
        pref.set("phonenumber",phonenumber);//nsajl id user connecté  w na3tiha identifiant "id";
    }

    public static String getUserName() {
        return pref.get("username",userName);
    }

    public static void setUserName(String userName) {
         pref.set("username",userName);
    }

    public static String getEmail() {
        return pref.get("email",email);
    }

    public static void setEmail(String email) {
         pref.set("email",email);
    }
    public static String getrole() {
        return pref.get("role",role);
    }

    public static void setrole(String role) {
         pref.set("role",role);
    }
    
    public static String getfirstname() {
        return pref.get("firstname",firstname);
    }

    public static void setfirstname(String firstname) {
         pref.set("firstname",firstname);
    }
    
    public static String getlastname() {
        return pref.get("lastname",lastname);
    }

    public static void setlastname(String lastname) {
         pref.set("lastname",lastname);
    }
    
    public static String getPassword() {
        return pref.get("password",password);
    }

    public static void setPassword(String password) {
         pref.set("password",password);
    }
}
