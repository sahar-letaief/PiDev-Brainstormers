/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.mycompany.services.EvenementService;
import com.mycompany.services.ReservationService;
import com.mycompany.entities.Evenement;
import com.mycompany.entities.Reservation;
import com.mycompany.entities.User;

/**
 *
 * @author WIKI
 */
public class AddReservation {
    public AddReservation(Form previous){
        Reservation r=new Reservation();
        Evenement e =new Evenement();
        User u=new User();
       
        InfiniteProgress ip = new InfiniteProgress();
        final Dialog idialog = ip.showInfiniteBlocking();
        System.err.println("data event=="+r);
                    ReservationService.getInstance().AddReservation(e);
                    idialog.dispose();
                    Dialog.show("Succes", "Reservation added successfully", new Command("OK"));
                    new ListEventsForm( previous).show();
            }
     //getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->new ListEventsForm(previous).show());
             
    
    
    }

   

