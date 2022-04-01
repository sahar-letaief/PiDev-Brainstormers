/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.User;
import com.mycompany.services.ServiceUser;
import java.util.Vector;

/**
 *
 * @author Yassine
 */
public class ModifierProfileForm extends Form{
    
    
    public ModifierProfileForm(Resources res, Form previous) {
        
        
        setTitle("Se Connecter");
        setLayout(BoxLayout.yCenter());
        TextField email = new TextField(SessionManager.getEmail(), "Email", 20, TextField.ANY);
        TextField username = new TextField(SessionManager.getUserName(), "username", 20, TextField.ANY);
        TextField firstname = new TextField(SessionManager.getfirstname(), "firstname", 20, TextField.ANY);
        TextField lastname = new TextField(SessionManager.getlastname(), "lastname", 20, TextField.ANY);
        TextField phonenumber = new TextField(String.valueOf(SessionManager.getphonenumber()), "phonenumber", 9, TextField.ANY);
        
        Vector<String> vectorRole;
        vectorRole = new Vector();
        vectorRole.add("USER");
        vectorRole.add("PLAYER");
        ComboBox<String>roles = new ComboBox<>(vectorRole);
        Button confirm = new Button("confirm");
        Button back = new Button("back");

        back.addActionListener(ev -> {previous.showBack();});
        
        addAll(username,firstname, lastname,phonenumber, email ,roles,confirm , back); 
        confirm.requestFocus();
        
        confirm.addActionListener(e -> 
        {
            /* Reclamation r = new Reclamation(String.valueOf(objet.getText()
                                  ).toString(),
                                  String.valueOf(description.getText()).toString(),
                                  format.format(new Date()),
                                  0,SessionManager.getId()); */
            User user = new User( SessionManager.getId(),
                    String.valueOf(username.getText()).toString(), 
                    String.valueOf(email.getText()).toString() , 
                    Integer.parseInt(phonenumber.getText())   ,
                    String.valueOf(firstname.getText()).toString() , 
                    String.valueOf(lastname.getText()).toString() , 
                    "",
                    String.valueOf(roles.getSelectedItem().toString()).toString() );
            
            ServiceUser.getInstance().editprofile(user,res);
        });
        
        
    }
}
