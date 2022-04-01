/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.mycompany.services.EvenementService;
import com.mycompany.services.ReservationService;
import com.mycompany.entities.Evenement;
import java.util.ArrayList;

/**
 *
 * @author WIKI
 */
public class SortEventByPrice extends Form{
    ArrayList<Evenement> data = new ArrayList<>();
    Form current;

    public SortEventByPrice(Form previous) {
    setTitle("Sort by price");
     Picker datePicker = new Picker();

    data=EvenementService.getInstance().SortByPrice();
     Container y = new Container(new BoxLayout(BoxLayout.Y_AXIS));
      Container yy = new Container(new BoxLayout(BoxLayout.Y_AXIS));
       Container map = new Container(new BoxLayout(BoxLayout.X_AXIS));
       // Button Back = new Button("B");
       // Button EventPrice = new Button("Sort by price");
        for (int i=0;i<data.size();i++){
           
       
         
         Container x = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container xx = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container xxx = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container xxxx = new Container(new BoxLayout(BoxLayout.X_AXIS));
      
        Container debut = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container fin = new Container(new BoxLayout(BoxLayout.X_AXIS));
   

        Evenement e=new Evenement();
        //Reservation r= new Reservation();
       // User u=new User();
        
        e.setId(data.get(i).getId());
        e.setNameEvent(data.get(i).getNameEvent());
        e.setPlaceEvent(data.get(i).getPlaceEvent());
        e.setPriceEvent((float)data.get(i).getPriceEvent());
        e.setNbParticipants(data.get(i).getNbParticipants());
        e.setDateDebut(data.get(i).getDateDebut());
        e.setDateFin(data.get(i).getDateFin());
        
        Button DetailEvent = new Button("Detail");
        Button AddReservation = new Button("Add Reservation");
      
        
         Label separation = new Label("----------------------------");
         Label IdEvent=new Label(""+data.get(i).getId());
         Label NameEvent = new Label("Name Event "+ data.get(i).getNameEvent());
         Label PlaceEvent = new Label("Place event "+ data.get(i).getPlaceEvent());
         Label Pricevent = new Label("Price event "+ data.get(i).getPriceEvent()+"DT");
         Label NbParticipants = new Label("Participants "+ data.get(i).getNbParticipants());
         Label DateDebut = new Label("Begins at "+ data.get(i).getDateDebut().substring(0,10));
         Label DateFin = new Label("Ends at "+ data.get(i).getDateFin().substring(0,10));
        
         
        
     
     
        
       
        x.addAll(NameEvent);
        xxxx.addAll(PlaceEvent);
        xx.addAll(Pricevent,NbParticipants);
        debut.addAll(DateDebut);
        fin.addAll(DateFin);
        xxx.addAll(AddReservation);
       // map.addAll(EventMap);
        y.addAll(separation,x,xxxx,xx,debut,fin,xxx);
        
        }
  
          // map.addAll(EventMap,EventPrice);
           yy.addAll(map);
           addAll(yy);
            addAll(y);
          
          

        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->new ListEventsFormFront(previous).show());
    }
    
}
