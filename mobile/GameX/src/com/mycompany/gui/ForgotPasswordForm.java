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
public class ForgotPasswordForm extends Form {

    public ForgotPasswordForm(Resources res) {
        setTitle("forgt password");
        setLayout(BoxLayout.yCenter());
        TextField username = new TextField("", "Email", 30, TextField.ANY);
        Button submit = new Button("Submit");
        
        submit.addActionListener(e -> ServiceUser.getInstance().resetPassword(username,res));

        addAll(username, submit);

    }
}
