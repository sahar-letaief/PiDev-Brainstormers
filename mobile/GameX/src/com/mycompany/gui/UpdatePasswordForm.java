/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.util.Resources;
import com.mycompany.services.ServiceUser;

import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.entities.User;
import java.util.ArrayList;
import java.util.Vector;
/**
 *
 * @author Yassine
 */
public class UpdatePasswordForm extends Form{
    
    public UpdatePasswordForm(Resources res,String email) {
    
        setTitle("Update Password");
        setLayout(BoxLayout.yCenter());
        TextField password = new TextField("", "New", 20, TextField.PASSWORD);
        Button Update = new Button("Update");

        addAll(password, Update); 
        Update.requestFocus();
        
        Update.addActionListener(e -> 
        {
               ServiceUser.getInstance().updatepassword(password,email, res);
        });

    }
    
}
