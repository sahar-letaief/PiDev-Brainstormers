/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;
import com.codename1.ui.Form;
import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
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
import java.util.Vector;
/**
 *
 * @author Yassine
 */
public class SignUpForm extends Form{
    
    public SignUpForm(Resources res) {
        
        
        setTitle("Se Connecter");
        setLayout(BoxLayout.yCenter());
        TextField email = new TextField("", "Email", 20, TextField.ANY);
        TextField username = new TextField("", "username", 20, TextField.ANY);
        TextField firstname = new TextField("", "firstname", 20, TextField.ANY);
        TextField lastname = new TextField("", "lastname", 20, TextField.ANY);
        TextField phonenumber = new TextField("", "phonenumber", 8, TextField.PHONENUMBER);
        TextField password = new TextField("", "Password", 20, TextField.PASSWORD);
        Button signIn = new Button("Sign In");
        Button signUp = new Button("Sign Up");
        
        Vector<String> vectorRole;
        vectorRole = new Vector();
        
        vectorRole.add("USER");
        vectorRole.add("PLAYER");
        
        ComboBox<String>roles = new ComboBox<>(vectorRole);
        
        
        //mp oublié
        Button  mp = new Button("Forgot password?","CenterLabel");
        
        
        signIn.addActionListener(e -> new SignInForm(res).show());
        Label doneHaveAnAccount = new Label("You don't have an account?");
        
        addAll(username,firstname, lastname,phonenumber, email,password ,roles,signUp , signIn); 
        signUp.requestFocus();
        
        signUp.addActionListener(e -> 
        {
               ServiceUser.getInstance().signup(username,firstname,lastname,phonenumber,email,password,roles ,res);
        });
        
        
    }
    
}
