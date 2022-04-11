/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.mycompany.services.EvenementService;
import com.mycompany.entities.Evenement;
import java.util.Date;

/**
 *
 * @author WIKI
 */
public class AddEvent extends Form{
            public AddEvent(Form previous){
              setTitle("Add event");
               Container y = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                 Container x = new Container(new BoxLayout(BoxLayout.X_AXIS));
                     Container xx = new Container(new BoxLayout(BoxLayout.X_AXIS));
              SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
              Picker datepicker1=new Picker();
              Picker datepicker2=new Picker();
              datepicker1.setType(Display.PICKER_TYPE_DATE);
              datepicker2.setType(Display.PICKER_TYPE_DATE);
              
              TextField tfNameEvent = new TextField("","Name Event");
              TextField tfPlaceEvent = new TextField("","Place Event");
              TextField tfPriceEvent = new TextField("","Price Event");
              TextField tfNbParticipants = new TextField("","Participants number");
              //TextField tfDateDebut = new TextField("","Begins at");
              //TextField tfDateFin = new TextField("","Ends at");
              Button btnValider = new Button("Add");
              btnValider.setMaterialIcon(FontImage.MATERIAL_ADD_TASK);
               btnValider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                
                if ((tfNameEvent.getText().length()==0)||(tfPlaceEvent.getText().length()==0)||(tfPriceEvent.getText().length()==0)||(tfNbParticipants.getText().length()==0))
                { Dialog.show("Alert", "Please fill all the fields", new Command("OK"));}
                else{
            InfiniteProgress ip = new InfiniteProgress();
            final Dialog idialog = ip.showInfiniteBlocking();
            Evenement e = new Evenement(
                    String.valueOf(tfNameEvent.getText()),
                    String.valueOf(tfPlaceEvent.getText()),
                    Integer.valueOf(tfNbParticipants.getText()),
                    Integer.valueOf(tfPriceEvent.getText()),
                    format.format(datepicker1.getDate()),
                    format.format(datepicker2.getDate())
                    );
                    System.err.println("data event=="+e);
                    EvenementService.getInstance().AddEvent(e);
                    idialog.dispose();
                    Dialog.show("Succes", "Event Added", new Command("OK"));
                    new ListEventsForm( previous).show();
            }
        }
        });
        addAll(tfNameEvent,tfPlaceEvent,tfNbParticipants,tfPriceEvent,datepicker1,datepicker2,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->new ListEventsForm(previous).show());






            }
    
}
