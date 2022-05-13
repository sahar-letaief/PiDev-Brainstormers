/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.io.FileSystemStorage;
import com.codename1.io.MultipartRequest;
import com.codename1.l10n.ParseException;
import com.codename1.ui.Button;
import com.codename1.ui.Calendar;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Category;
import com.mycompany.entities.Product;
import com.mycompany.services.ServiceCategory;
import com.mycompany.services.ServiceProduct;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;


/**
 *
 * @author maryem
 */
public class AddProductForm extends Form{
    
      
public AddProductForm(Form previous){

    
        setTitle("add a new product");
        setLayout(BoxLayout.y());
        ComboBox<Category> cb= new ComboBox();
        ServiceCategory AGG = new ServiceCategory();
        ArrayList<Category> list = AGG.getAllCategories();
           //try {
                                //Image ban = Image.createImage("file://C:\\Users\\21628\\Desktop\\Mobile\\Final\\src\\Attraction\\Images\\banner.jpg").scaledHeight(1000);
                               // add(ban);
                            ////} catch (IOException ex) {

                            //}
        for(int i = 0 ; i < list.size(); i++){
            cb.addItem(list.get(i));
        }
        
        TextField Ffreference= new TextField("","Reference");
        TextField Ffproductname= new TextField("","ProductName");
        TextField Ffdescription= new TextField("","Description");
        TextField Ffprice= new TextField("","Price");
        TextField FfStock= new TextField("","Stock");
        Button btnValider=new Button("Add Product");
        btnValider.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                if ((Ffreference.getText().length()==0)||(Ffproductname.getText().length()==0)||(Ffdescription.getText().length()==0)||(Ffprice.getText().length()==0)||(FfStock.getText().length()==0) )
                    Dialog.show("alert", "please fill all the fields", new Command("Ok"));
                else
                {
                    try{
                        Product F =new Product (Ffreference.getText(),Ffproductname.getText(),Ffdescription.getText(), Integer.parseInt(Ffprice.getText()),Integer.parseInt(FfStock.getText()),(cb.getSelectedItem().getId()));
                        if (new ServiceProduct().addProduct(F))
                            Dialog.show("Success", "Connection accepted", new Command("OK"));
                        else
                            Dialog.show("ERRor", "Server error", new Command("OK"));

                    }catch(NumberFormatException e){
                        Dialog.show("ERROR", " id must be a number", new Command("OK"));
                    }
                }
            }
        });
        addAll(Ffreference,Ffproductname,Ffdescription,Ffprice,FfStock,cb,btnValider);
        getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());
    }
}

