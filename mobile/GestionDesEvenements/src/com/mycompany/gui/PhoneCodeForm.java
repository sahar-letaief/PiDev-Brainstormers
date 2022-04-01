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
import com.mycompany.services.ServiceUser;

/**
 *
 * @author Yassine
 */
public class PhoneCodeForm extends Form{
    
    public PhoneCodeForm(Resources res) {
    
        setTitle("Se Connecter");
        setLayout(BoxLayout.yCenter());
        Label PNCode = new Label("Please enter code sent on your phone");
        TextField code = new TextField("", "Phone Number Code", 20, TextField.ANY);
        Button confirm = new Button("confirm");
        Button logout = new Button("logout");

        addAll(code, confirm, logout); 
        confirm.requestFocus();
        
        confirm.addActionListener(e -> 
        {
               ServiceUser.getInstance().ConfirmPhoneNumberCode(code,res,SessionManager.getId());
        });
    }
}
