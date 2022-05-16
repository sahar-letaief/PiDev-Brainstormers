/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.gui;

import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author oasis
 */
public class Home extends Form {
    Form current;
      private Resources theme;
    public Home() {
        Button b =new Button("Profile");

       
        b.addActionListener(e-> new ProfileForm(theme).show());
        add(b);
        current=this;
        setTitle("Home");
        
        this.setLayout(new FlowLayout(CENTER, CENTER));
        
        Label lb = new Label("Welcome client");
        this.getToolbar().addCommandToSideMenu("Home", null, ev -> {
            
        });
        
        this.getToolbar().addCommandToSideMenu("Add Rclamation", null, ev -> {
            new Add(current).show();
        });
        
        this.getToolbar().addCommandToSideMenu("List Reclamations ", null, ev -> {
            
            new ListeReclamation(current).show();
            
       });
         this.getToolbar().addCommandToSideMenu("Map ", null, ev -> {
            
            new MapForm1(theme,current);
            
       });
       
   
        
    

   
}}
