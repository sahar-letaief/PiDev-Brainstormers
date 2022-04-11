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
public class NewPasswordForm extends Form{
    
    public NewPasswordForm (Resources rs,String email){
        setTitle("Reser Password Request");
        setLayout(BoxLayout.yCenter());
        Label PNCode = new Label("Please enter new password");
        TextField password = new TextField("", "Password", 20, TextField.ANY);
        TextField confirmpassword = new TextField("", "Confirm Password", 20, TextField.ANY);
        Button confirm = new Button("confirm");

        addAll(password,confirmpassword, confirm); 
        confirm.requestFocus();
        
        confirm.addActionListener(e -> 
        {
               ServiceUser.getInstance().resetUserPassword(password,confirmpassword,rs,email);
        });
    }
}
