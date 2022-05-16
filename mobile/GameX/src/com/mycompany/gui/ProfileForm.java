/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.User;
import com.mycompany.services.ServiceUser;

/**
 *
 * @author Yassine
 */
public class ProfileForm extends Form{
    
    public ProfileForm(Resources res) {
        Container y = new Container(new BoxLayout(BoxLayout.Y_AXIS));
      Container x = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Form previous = null;
        setTitle("Se Connecter");
        setLayout(BoxLayout.yCenter());
        Label firstname = new Label("First Name : " + SessionManager.getfirstname() );
        Label lastname = new Label("Last Name : " + SessionManager.getlastname() );
        Label email = new Label("Email : " + SessionManager.getEmail() );
        Label username = new Label("Username : " + SessionManager.getUserName() );
        Label phonenumber = new Label("Phone Number : " + SessionManager.getphonenumber() );
        Label role = new Label("");
        String s = SessionManager.getrole();
        if ( s.equals("ROLE_PLAYER") ){
            role = new Label("role : PLAYER");
              Button front = new Button("Visit us");
            //addAll(front);
             getToolbar().addCommandToSideMenu("Show events" , null ,ev -> {new ListEventsFormFront(previous).show();} );
                getToolbar().addCommandToSideMenu("Show my reservations" , null ,ev -> {new ListReservationsFormFront(previous).show();} );
                            getToolbar().addCommandToSideMenu("Products" , null ,ev -> {new HomeForm().show();} );
                            getToolbar().addCommandToSideMenu("products of cart" , null ,ev -> {new HomeForm_1().show();} );
                            getToolbar().addCommandToSideMenu("Reclamations" , null ,ev -> {new Home().show();} );

              front.addActionListener(e -> 
        {   
            new HomeFormFront().show();
        });
              
              
              
        }else if ( s.equals("ROLE_ADMIN") ){
            role = new Label("role : ADMIN");
             Button front = new Button("Visit us");
             Button back = new Button("Visit dashboard");
           // addAll(front,back);
           getToolbar().addCommandToSideMenu("Show all users" , null ,ev -> {new DisplayUsersBackForm(0, res).show();} );
            getToolbar().addCommandToSideMenu("Show events" , null ,ev -> {new ListEventsForm(previous).show();} );
            getToolbar().addCommandToSideMenu("Show reservations" , null ,ev -> {new ListReservationsForm(previous).show();} );
            getToolbar().addCommandToSideMenu("List Of Products" , null ,ev -> {new HomeForm().show();} );
               /*getToolbar().addCommandToSideMenu("Add Product" , null ,ev -> {new AddProductForm(previous).show();} );
               getToolbar().addCommandToSideMenu("List Of Categories" , null ,ev -> {new ListCatForm(previous).show();} );
               getToolbar().addCommandToSideMenu("Add Category" , null ,ev -> {new AddCategoryForm(previous).show();} );
               getToolbar().addCommandToSideMenu("Statistics" , null ,ev -> {new statForm(previous).show();} );*/
            
              front.addActionListener(e -> 
        {   
            new HomeFormFront().show();
        });
                back.addActionListener(e -> 
        {   
            new HomeFormBack().show();
        });
        }
        else{
            role = new Label("role : CLIENT");
             Button front = new Button("Visit us");
              //addAll(front);
               getToolbar().addCommandToSideMenu("Show events" , null ,ev -> {new ListEventsFormFront(previous).show();} );
               getToolbar().addCommandToSideMenu("Show my reservations" , null ,ev -> {new ListReservationsFormFront(previous).show();} );
               getToolbar().addCommandToSideMenu("List Of Products" , null ,ev -> {new HomeForm().show();} );
               getToolbar().addCommandToSideMenu("products of cart" , null ,ev -> {new HomeForm_1().show();} );
               getToolbar().addCommandToSideMenu("Reclamations" , null ,ev -> {new Home().show();} );
               




              front.addActionListener(e -> 
        {   
            new HomeFormFront().show();
        });
        }

        //mp oublié
        Button modifier = new Button("Edit Profile");
        Button UpdatePassword = new Button("Update Password");
        Button logout=new Button("logout");
        
        
        addAll(email,firstname, lastname, username,phonenumber,role, modifier,UpdatePassword,logout);
        modifier.requestFocus();
        
        
        modifier.addActionListener(e -> 
        {   
            new ModifierProfileForm(res,this).show();
        });
         logout.addActionListener(e -> 
        {   
            new SignInForm(res).show();
        });
         UpdatePassword.addActionListener(e -> 
        {   
            new UpdatePasswordForm(res,SessionManager.getEmail()).show();
        });
        
    }
    
}
