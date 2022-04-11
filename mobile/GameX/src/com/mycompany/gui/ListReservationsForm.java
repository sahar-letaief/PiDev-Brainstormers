/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
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
import com.codename1.ui.util.Resources;
import com.mycompany.services.EvenementService;
import com.mycompany.services.ReservationService;
import com.mycompany.entities.Evenement;
import com.mycompany.entities.Reservation;
import com.mycompany.entities.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author WIKI
 */
public class ListReservationsForm extends Form{
    
    ArrayList<Reservation> data = new ArrayList<>();
    Form current;
      Resources res;

    public ListReservationsForm(Form previous) {
    setTitle("List of reservations");

        data=ReservationService.getInstance().ShowReservationsBack();
        Container y = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    
        for (int i=0;i<data.size();i++){
          Container x = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container xx = new Container(new BoxLayout(BoxLayout.X_AXIS));
         Container xxx = new Container(new BoxLayout(BoxLayout.X_AXIS));
         Container xxxx = new Container(new BoxLayout(BoxLayout.X_AXIS));
          Container last = new Container(new BoxLayout(BoxLayout.X_AXIS));
           Container first = new Container(new BoxLayout(BoxLayout.X_AXIS));
          Container deb = new Container(new BoxLayout(BoxLayout.X_AXIS));
           Container fin = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Reservation r= new Reservation();
        Evenement e=new Evenement(data.get(i).getEvenement().getNameEvent(),data.get(i).getEvenement().getPlaceEvent(),data.get(i).getEvenement().getPriceEvent(),
        data.get(i).getEvenement().getNbParticipants(),data.get(i).getEvenement().getDateDebut(),data.get(i).getEvenement().getDateFin());
        User u=new User(data.get(i).getUser().getFirstname(),data.get(i).getUser().getLastname());
        r.setId(data.get(i).getId());
        r.setDateReservation(data.get(i).getDateReservation());
        r.setEvenement (e);
        r.setUser(u);
   
       
                   
         Label separation = new Label("----------------------------");
         Label IdReservation=new Label(""+data.get(i).getId());
         System.out.println(data.get(i).getId());
         Label DateReservation=new Label("Reservation date : "+data.get(i).getDateReservation().substring(0,10));
         Label NameEvent=new Label("Name event: "+data.get(i).getEvenement().getNameEvent());
         Label PlaceEvent = new Label("Place event: "+ data.get(i).getEvenement().getPlaceEvent());
         Label DateDebut = new Label("Begins at: "+ data.get(i).getEvenement().getDateDebut().substring(0,10));
         Label DateFin = new Label("Ends at: "+ data.get(i).getEvenement().getDateFin().substring(0,10));
         
         Label firstname=new Label("Player first name: "+data.get(i).getUser().getFirstname());
         Label lastname=new Label("Player last name: "+data.get(i).getUser().getLastname());
         
        
         x.addAll(IdReservation,DateReservation);
         xxx.addAll(NameEvent);
         xxxx.addAll(PlaceEvent);
         deb.addAll(DateDebut);
         fin.addAll(DateFin);
         first.addAll(firstname);
         last.addAll(lastname);
         //xx.addAll(DeleteReservation);
          y.addAll(separation,x,xxx,first,last,xxxx,deb,fin,xx);
         
        }
         addAll(y);
        
       getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ADD_TO_HOME_SCREEN, e->new  ProfileForm(res).show());
    }
}
