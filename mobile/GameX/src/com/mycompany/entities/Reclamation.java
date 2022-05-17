/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.entities;

/**
 *
 * @author oasis
 */
public class Reclamation {
   
    private int id;
    private String Title;
    private String Description;
 
    
     public Reclamation() {
    }

    public Reclamation(String Title, String Description) {
        this.Title = Title;
        this.Description = Description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

   
    

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", Title=" + Title + ", Description=" + Description + '}';
    }

}
