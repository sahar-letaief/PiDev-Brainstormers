/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Form;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.services.ServiceUser;

/**
 *
 * @author Yassine
 */
public class SignInForm extends Form {
    
    public SignInForm(Resources res) {
    
        setTitle("Please connect");
        setLayout(BoxLayout.yCenter());
        TextField username = new TextField("", "Username", 20, TextField.ANY);
        TextField password = new TextField("", "Password", 20, TextField.PASSWORD);
        username.setSingleLineTextArea(false);
        password.setSingleLineTextArea(false);
        Button signIn = new Button("Sign In");
        Button signUp = new Button("Sign Up");
        
        //mp oublié
        Button  mp = new Button("Reset Password");
        
        
        signUp.addActionListener(e -> new SignUpForm(res).show());
        mp.addActionListener(e -> new ForgotPasswordForm(res).show());
        Label doneHaveAnAccount = new Label("You don't have an account ?");
        
        addAll(username, password, signIn,signUp,mp); 
        signIn.requestFocus();
        
        signIn.addActionListener(e -> 
        {
               ServiceUser.getInstance().signin(username, password, res);
        });
        

    }
}
