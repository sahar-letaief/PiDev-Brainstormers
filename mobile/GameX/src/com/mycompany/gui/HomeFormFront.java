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
 * @author WIKI
 */
public class HomeFormFront extends Form{
    Form current;
     public HomeFormFront(){
        current = this;
        setTitle("GameX");
        setLayout(BoxLayout.y());

        add(new Label("Select option"));
        
        Button btnEventDisplayFront = new Button("Show events ");
        
        Button bntReservationDisplayFront=new Button("Show reservations");
   
        
        
     
        btnEventDisplayFront.addActionListener(e -> new ListEventsFormFront(current).show());
        bntReservationDisplayFront.addActionListener(e -> new ListReservationsFormFront(current).show());
     
       addAll(btnEventDisplayFront,bntReservationDisplayFront);
     
       
    }
}
