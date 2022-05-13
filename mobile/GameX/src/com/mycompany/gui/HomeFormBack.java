/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author asus
 */
public class HomeFormBack extends Form{
    Form current;
    public HomeFormBack( ){
        current = this;
        setTitle("GameX");
        setLayout(BoxLayout.y());

        add(new Label("Select option"));
        Button btnEventDisplay = new Button("Show events ");
        Button bntReservationDisplay=new Button("Show reservations ");
        Button btnAllProd=new Button("List of products");
    
        
        
        btnEventDisplay.addActionListener(e -> new ListEventsForm(current).show());
        bntReservationDisplay.addActionListener(e-> new ListReservationsForm(current).show());
        btnAllProd.addActionListener(e -> new ListProdForm(current).show());

     
       addAll(btnEventDisplay,bntReservationDisplay,btnAllProd);
       
        
    }
    
}