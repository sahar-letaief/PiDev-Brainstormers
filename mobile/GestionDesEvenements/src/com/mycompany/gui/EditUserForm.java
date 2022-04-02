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
public class EditUserForm extends Form {

    public EditUserForm(User user, Resources rs, Form previous) {
        setTitle("Show user");

        Container y = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container yy = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        TextField id = new TextField(String.valueOf(user.getId()), "");
        TextField username = new TextField(String.valueOf(user.getUsername()), "", 20, TextField.ANY);
        TextField email = new TextField(String.valueOf(user.getEmail()), "", 20, TextField.ANY);
        TextField role = new TextField(String.valueOf(user.getRole()), "", 20, TextField.ANY);
        TextField firstname = new TextField(String.valueOf(user.getNom()), "", 20, TextField.ANY);
        TextField lastname = new TextField(String.valueOf(user.getPrenom()), "", 20, TextField.ANY);
        TextField phonenumber = new TextField(String.valueOf(user.gettelephone()), "", 9, TextField.ANY);
        Label firstnameLabel = new Label("First Name : ");
        Label lastnameLabel = new Label("Last Name : ");
        Label emailLabel = new Label("Email : ");
        Label usernameLabel = new Label("User Name : ");
        Label phonenumberLabel = new Label("Phone Number : ");
        Label roleLabel = new Label("Role : ");
        Label idLabel = new Label("Id : ");
        Vector<String> vectorRole;
        vectorRole = new Vector();
        vectorRole.add("USER");
        vectorRole.add("PLAYER");
        vectorRole.add("ADMIN");
        ComboBox<String> roles = new ComboBox<>(vectorRole);

        Container idcontainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container firstnamecontainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container rolecontainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container emailcontainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container lastnamecontainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container phonenumbercontainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container usernamecontainer = new Container(new BoxLayout(BoxLayout.X_AXIS));

        emailcontainer.addAll(emailLabel, email);
        firstnamecontainer.addAll(firstnameLabel, firstname);
        lastnamecontainer.addAll(lastnameLabel, lastname);
        phonenumbercontainer.addAll(phonenumberLabel, phonenumber);
        usernamecontainer.addAll(usernameLabel, username);
        rolecontainer.addAll(roleLabel, roles);
        // xxx.addAll(AddReservation);
        Button confirm = new Button("confirm");
        confirm.setMaterialIcon(FontImage.MATERIAL_RATE_REVIEW);

        y.addAll(emailcontainer, firstnamecontainer, lastnamecontainer, phonenumbercontainer, usernamecontainer, rolecontainer, confirm);
        addAll(y);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

        confirm.addActionListener(e
                -> {
            User userEdit = new User(user.getId(),
                    String.valueOf(username.getText()).toString(),
                    String.valueOf(email.getText()).toString(),
                    Integer.parseInt(phonenumber.getText()),
                    String.valueOf(firstname.getText()).toString(),
                    String.valueOf(lastname.getText()).toString(),
                    "",
                    String.valueOf(roles.getSelectedItem().toString()).toString());

            ServiceUser.getInstance().editUser(userEdit, rs);
        });

    }
}
