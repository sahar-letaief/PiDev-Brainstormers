/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.services.EvenementService;
import com.mycompany.entities.Evenement;

/**
 *
 * @author WIKI
 */
public class EditEvent extends Form{
    Form current,previous;
    public EditEvent(Evenement event){
         setTitle("Edit Event");
             
              TextField tfid=new TextField(String.valueOf(event.getId()),"");
              TextField tfNameEvent = new TextField(String.valueOf(event.getNameEvent()),"Name Event");
              TextField tfPlaceEvent = new TextField(String.valueOf(event.getPlaceEvent()),"Place Event");
              TextField tfPriceEvent = new TextField(String.valueOf(event.getPriceEvent()),"Price Event");
              TextField tfNbParticipants = new TextField(String.valueOf(event.getNbParticipants()),"Participants number");
              TextField tfDateDebut = new TextField(event.getDateDebut().substring(0,10),"Begins at");
              TextField tfDateFin = new TextField(event.getDateFin().substring(0,10),"Ends at");
        
       
        tfid.setSingleLineTextArea(false);      
        tfNameEvent.setSingleLineTextArea(true);
        tfPlaceEvent.setSingleLineTextArea(true);
        tfPriceEvent.setSingleLineTextArea(true);
        tfNbParticipants.setSingleLineTextArea(true);
        tfDateDebut.setSingleLineTextArea(true);
        tfDateFin.setSingleLineTextArea(true);
        Button btnU = new Button("Update");
        btnU.setUIID("Button");
        
        btnU.setMaterialIcon(FontImage.MATERIAL_UPDATE);
         btnU.addActionListener(l->{
         event.setId((int)Integer.parseInt(tfid.getText().toString()));
         event.setNameEvent(tfNameEvent.getText().toString());
         event.setPlaceEvent(tfPlaceEvent.getText().toString());
         event.setPriceEvent((float)Float.parseFloat(tfPriceEvent.getText().toString()));
         event.setNbParticipants((int)Integer.parseInt(tfNbParticipants.getText().toString()));
         event.setDateDebut(tfDateDebut.getText().toString());
         event.setDateFin(tfDateFin.getText().toString());

     
    
         if( EvenementService.getInstance().EditEvent(event)){
         Dialog.show("Succes", "Event modified", new Command("OK"));
        new ListEventsForm(previous).show();
         }
       });
         
         Button btnAnnuler = new Button("Discard");
       btnAnnuler.addActionListener(e -> {
           new ListEventsForm(previous).show();
       });
       
       setLayout(BoxLayout.y());
       add(tfNameEvent).add(tfPlaceEvent).add(tfPriceEvent).add(tfNbParticipants).add(tfDateDebut).add(tfDateFin).add(btnU).add(btnAnnuler);
       
       
        
        
             getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->new ListEventsForm(previous).show());

         //add(content);
        show();
       
        
       
       
    }
}
