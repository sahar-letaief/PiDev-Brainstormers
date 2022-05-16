/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.entities.Reclamation;
import com.mycompany.services.ReclamationService;
/**
 *
 * @author oasis
 */
public class Add extends Form {
    public  Add(Form previous){
        setTitle("add a new Reclamation ");
        setLayout(BoxLayout.y());
        TextField Fftt= new TextField("","title",20, TextArea.ANY);
        TextField FfDES= new TextField("","Description");
         
        Button btnValider=new Button("Add");
        btnValider.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                if ((Fftt.getText().length()==0)||(FfDES.getText().length()==0))
                    Dialog.show("alert", "please fill all the fields", new Command("Ok"));
                else
                {
                    try{
                        Reclamation R = new Reclamation(Fftt.getText(),FfDES.getText());
                        if ( ReclamationService.getInstance().addReclamation(R))
                            Dialog.show("Success", "Connection accepted", new Command("OK"));
                        else
                            Dialog.show("ERRor", "Server error", new Command("OK"));
                }catch(NumberFormatException e){
                        Dialog.show("ERROR", "tel ,code postale must be a number", new Command("OK"));
                    }
            }
            }
         });
        addAll(Fftt,FfDES,btnValider);
        getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());

        
        
    }
}

