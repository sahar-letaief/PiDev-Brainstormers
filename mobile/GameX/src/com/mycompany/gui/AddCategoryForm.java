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
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.entities.Category;
import com.mycompany.services.ServiceCategory;


/**
 *
 * @author maryem
 */
public class AddCategoryForm extends Form{
    
      
public AddCategoryForm(Form previous){

    
        setTitle("add a new product");
        setLayout(BoxLayout.y());
        TextField Ffname= new TextField("","Name");
        TextField Ffdescription= new TextField("","Description");
        Button btnValider=new Button("Add Category");
        btnValider.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                if ((Ffname.getText().length()==0)||(Ffdescription.getText().length()==0) )
                    Dialog.show("alert", "please fill all the fields", new Command("Ok"));
                else
                {
                    try{
                        Category F =new Category(Ffname.getText(),Ffdescription.getText());
                        if (new ServiceCategory().addCategory(F))
                            Dialog.show("Success", "Connection accepted", new Command("OK"));
                        else
                            Dialog.show("ERRor", "Server error", new Command("OK"));

                    }catch(NumberFormatException e){
                        Dialog.show("ERROR", " id must be a number", new Command("OK"));
                    }
                }
            }
        });
        addAll(Ffname,Ffdescription,btnValider);
        getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());
    }
}
