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
public class ShowUserForm extends Form {

    public ShowUserForm(User user,Resources rs,Form previous) {
        setTitle("Show user");

        Container y = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container yy = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        TextField id = new TextField(String.valueOf(user.getId()), "");
        TextField username = new TextField(String.valueOf(user.getUsername()), "username", 20, TextField.ANY);
        TextField email = new TextField(String.valueOf(user.getEmail()), "Email", 20, TextField.ANY);
        TextField role = new TextField(String.valueOf(user.getRole()),"Role  ", 20, TextField.ANY);
        TextField firstname = new TextField(String.valueOf(user.getNom()), "firstname", 20, TextField.ANY);
        TextField lastname = new TextField(String.valueOf(user.getPrenom()), "lastname", 20, TextField.ANY);
        TextField phonenumber = new TextField(String.valueOf(user.gettelephone()), "phonenumber", 9, TextField.ANY);
        Label firstnameLabel = new Label("First Name : ");
        Label lastnameLabel = new Label("Last Name : ");
        Label emailLabel = new Label("Email : ");
        Label usernameLabel = new Label("User Name : ");
        Label phonenumberLabel = new Label("Phone Number : ");
        Label roleLabel = new Label("Role : ");
        Label idLabel = new Label("Id : ");

        ////set to read only
        id.setEditable(false);
        username.setEditable(false);
        email.setEditable(false);
        role.setEditable(false);
        firstname.setEditable(false);
        lastname.setEditable(false);
        phonenumber.setEditable(false);

        Container x = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container xx = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container xxx = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container xxxx = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container xxxxx = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container debut = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container fin = new Container(new BoxLayout(BoxLayout.X_AXIS));

        x.addAll(idLabel,id);
        xxxx.addAll(emailLabel,email);
        xx.addAll(firstnameLabel,firstname);
        xxxxx.addAll(lastnameLabel,lastname);
        debut.addAll(phonenumberLabel,phonenumber);
        fin.addAll(usernameLabel,username);
        xxx.addAll(roleLabel,role);

        y.addAll(x, xxxx, xx,xxxxx, debut, fin, xxx);
        addAll(y);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack() );

    }
}
