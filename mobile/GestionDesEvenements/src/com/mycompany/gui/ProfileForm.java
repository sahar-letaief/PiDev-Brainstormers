/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.User;
import com.mycompany.services.ServiceUser;

/**
 *
 * @author Yassine
 */
public class ProfileForm extends Form{
    
    public ProfileForm(Resources res) {
        Form previous = null;
        setTitle("Se Connecter");
        setLayout(BoxLayout.yCenter());
        Label firstname = new Label("First Name : " + SessionManager.getfirstname() );
        Label lastname = new Label("Last Name : " + SessionManager.getlastname() );
        Label email = new Label("Email : " + SessionManager.getEmail() );
        Label username = new Label("Username : " + SessionManager.getUserName() );
        Label phonenumber = new Label("Phone Number : " + SessionManager.getphonenumber() );
        Label role = new Label("");
        String s = SessionManager.getrole();
        if ( s.equals("ROLE_PLAYER") ){
            role = new Label("role : PLAYER");
              Button front = new Button("Visit us");
            addAll(front);
              front.addActionListener(e -> 
        {   
            new HomeFormFront().show();
        });
              
              
              
        }else if ( s.equals("ROLE_ADMIN") ){
            role = new Label("role : ADMIN");
             Button front = new Button("Visit us");
             Button back = new Button("Visit dashboard");
            addAll(front,back);
            
              front.addActionListener(e -> 
        {   
            new HomeFormFront().show();
        });
                back.addActionListener(e -> 
        {   
            new HomeFormBack().show();
        });
        }
        else{
            role = new Label("role : CLIENT");
             Button front = new Button("Visit us");
              addAll(front);
              front.addActionListener(e -> 
        {   
            new HomeFormFront().show();
        });
        }

        //mp oublié
        Button modifier = new Button("Edit Profile");
        
        
        
        addAll(email,firstname, lastname, username,phonenumber,role, modifier);
        modifier.requestFocus();
        
        modifier.addActionListener(e -> 
        {   
            new ModifierProfileForm(res,this).show();
        });
        
    }
    
}
