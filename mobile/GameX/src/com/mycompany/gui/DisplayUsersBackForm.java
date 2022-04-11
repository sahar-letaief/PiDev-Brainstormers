/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.util.Resources;
import com.mycompany.services.ServiceUser;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.entities.User;
import java.util.ArrayList;

/**
 *
 * @author Yassine
 */
public class DisplayUsersBackForm extends Form {

    ArrayList<User> data = new ArrayList<>();
    Form current;

    public DisplayUsersBackForm(int index, Resources rs) {

        if (index == 0) {
            data = ServiceUser.getInstance().getList();
            
        } else if (index == 1) {
            data = ServiceUser.getInstance().getListSortName();
            this.revalidate();
        } else if (index == 2) {
            data = ServiceUser.getInstance().getListSortEmail();
        }

        //getToolbar().addCommandToSideMenu("profile" , null ,ev -> {new DisplayUsersBackForm(0,r).show();} );
        Container y = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container yy = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container yyy = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container map = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container sort = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Button SortName = new Button("Sort by name");
        Button SortEmail = new Button("Sort by email");
        for (int i = 0; i < data.size(); i++) {

            Container x = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container xx = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container xxx = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container xxxx = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container xxxxx = new Container(new BoxLayout(BoxLayout.X_AXIS));

            Container debut = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container fin = new Container(new BoxLayout(BoxLayout.X_AXIS));

            User user = new User();

            user.setId(data.get(i).getId());
            user.setNom(data.get(i).getNom());
            user.setPrenom(data.get(i).getPrenom());
            user.setPassword(data.get(i).getPassword());
            user.setRole(data.get(i).getRole());
            user.setUsername(data.get(i).getUsername());
            user.setEmail(data.get(i).getEmail());
            user.settelephone(data.get(i).gettelephone());

            Button DetailUser = new Button("Detail");
            Button EditUser = new Button("Edit User");

            Label separation = new Label("----------------------------");
            Label FullName = new Label("Full Name : " + data.get(i).getNom() + " " + data.get(i).getPrenom());
            Label Email = new Label("Email : " + data.get(i).getEmail());
            Label separationVertical = new Label("|");
            Label Password = new Label("Password : Crypted");
            Label UserTag = new Label("UserName : " + data.get(i).getUsername());
            Label PhoneNumber = new Label("Phone Number : " + data.get(i).gettelephone());
            Label Role = new Label("Role : " + data.get(i).getRole());

            //////////////////////////////////////////////////////////////////////
            DetailUser.setMaterialIcon(FontImage.MATERIAL_RATE_REVIEW);
            DetailUser.addActionListener(e
                    -> {
                new ShowUserForm(user, rs, this).show();
            });

            EditUser.setMaterialIcon(FontImage.MATERIAL_ADD_TO_QUEUE);
            EditUser.addActionListener(e
                    -> {
                new EditUserForm(user, rs, this).show();
            });
            x.addAll(FullName);
            xxxx.addAll(Email);
            xx.addAll(UserTag);
            xxxxx.addAll(Password);
            debut.addAll(PhoneNumber);
            fin.addAll(Role);
            xxx.addAll(EditUser, DetailUser);
            y.addAll(separation, x, xxxx, xx, xxxxx, debut, fin, xxx);

        }
        SortName.addActionListener(e
                -> {
            new DisplayUsersBackForm(1, rs).show();
        });

        SortEmail.addActionListener(e
                -> {
            new DisplayUsersBackForm(2, rs).show();
        });

        sort.addAll(SortEmail, SortName);
        yy.addAll(map);
        yyy.addAll(sort);
        addAll(yy);
        addAll(yyy);
        addAll(y);

        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ADD_TO_HOME_SCREEN, e -> new SignInForm(rs).show());
    }

}
