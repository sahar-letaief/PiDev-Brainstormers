/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author maryem
 */
public class Category {
    private int id;
    private String Name;
    private String description;

    public Category(String Name, String description, int id) {
        this.id = id;
        this.Name = Name;
        this.description = description;
    }
    public Category(String Name, String description) {
        this.Name = Name;
        this.description = description;
    }
     public Category(String text) {
    }
     public Category(int id) {
         this.id = id;
    }

    public Category() {
    }
    
    

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" + "Name=" + Name + ", description=" + description + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    
    
    
    
}
