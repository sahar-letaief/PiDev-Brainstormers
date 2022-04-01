/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.mycompany.services.EvenementService;
import com.mycompany.entities.Evenement;
import java.util.ArrayList;

/**
 *
 * @author WIKI
 */
public class ShowOneEvent extends Form{
     ArrayList<Evenement> data = new ArrayList<>();
    Form current;

    public ShowOneEvent(Evenement event) {
    setTitle("Show event");
     Picker datePicker = new Picker();
       
    
     Container y = new Container(new BoxLayout(BoxLayout.Y_AXIS));
      Container yy = new Container(new BoxLayout(BoxLayout.Y_AXIS));
       Container map = new Container(new BoxLayout(BoxLayout.X_AXIS));
       
     
            TextField tfid=new TextField(String.valueOf(event.getId()),"");
              TextField tfNameEvent = new TextField(String.valueOf(event.getNameEvent()),"Name Event");
              TextField tfPlaceEvent = new TextField(String.valueOf(event.getPlaceEvent()),"Place Event");
              TextField tfPriceEvent = new TextField(String.valueOf(event.getPriceEvent()),"Price Event");
              TextField tfNbParticipants = new TextField(String.valueOf(event.getNbParticipants()),"Participants number");
              TextField tfDateDebut = new TextField(event.getDateDebut().substring(0,10),"Begins at");
              TextField tfDateFin = new TextField(event.getDateFin().substring(0,10),"Ends at");
         
              ////set to read only
       tfNameEvent.setEditable(false);
       tfPlaceEvent.setEditable(false);
       tfPriceEvent.setEditable(false);
       tfNbParticipants.setEditable(false);
       tfDateDebut.setEditable(false);
       tfDateFin.setEditable(false);
        
        
         Container x = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container xx = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container xxx = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container xxxx = new Container(new BoxLayout(BoxLayout.X_AXIS));
      
        Container debut = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container fin = new Container(new BoxLayout(BoxLayout.X_AXIS));
   
       
        x.addAll(tfNameEvent);
        xxxx.addAll(tfPlaceEvent);
        xx.addAll(tfPriceEvent,tfNbParticipants);
        debut.addAll(tfDateDebut);
        fin.addAll(tfDateFin);
       // xxx.addAll(AddReservation);
     
        y.addAll(x,xxxx,xx,debut,fin,xxx);
        
        
  
          
           yy.addAll(map);
           addAll(yy);
            addAll(y);
           getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->new ListEventsFormFront(current).show());
          
      
}
}
