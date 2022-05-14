/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;
import com.codename1.db.Cursor;
import com.codename1.db.Row;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.MyApplication;
import com.mycompany.entities.Order;
import com.mycompany.entities.Product;
import com.mycompany.services.OrderService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AddOrderForm extends Form {


    public AddOrderForm(Form previous){
        setTitle("add a new");
        setLayout(BoxLayout.y());
        this.getToolbar().addCommandToLeftBar("Back", null, (evt) -> {
            new ListOrderForm(previous).showBack();
        });
        TextField Ffid= new TextField("","id");
        TextField Ffcode_postal= new TextField("","code");
        TextField Fftel= new TextField("","tel");
        TextField Ffref_cmde= new TextField("","ref");
        TextField FfPays= new TextField("","pays");
        TextField FfRegion= new TextField("","region");
        TextField Ffetat_cmde= new TextField("","etat");
        List<Product> Products = afficherTout();
        System.out.println(Products.toString());
        for (Product ser :Products) {
            this.add(addElement(ser));
        }
        Button btnValider=new Button("Add Order");
        btnValider.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                if ((Ffid.getText().length()==0)||(Ffcode_postal.getText().length()==0)||(Fftel.getText().length()==0)||(Ffref_cmde.getText().length()==0)||(FfPays.getText().length()==0)||(FfRegion.getText().length()==0)||(Ffetat_cmde.getText().length()==0) )
                    Dialog.show("alert", "please fill all the fields", new Command("Ok"));
                else
                {
                    try{
                        Order F =new Order (Integer.parseInt(Ffid.getText()),Integer.parseInt(Fftel.getText()),Integer.parseInt(Ffcode_postal.getText()),Ffref_cmde.getText(),FfPays.getText(),FfRegion.getText(),Ffetat_cmde.getText());
                        if (new OrderService().addOrder(F))
                            Dialog.show("Success", "Connection accepted", new Command("OK"));
                        else
                            Dialog.show("ERRor", "Server error", new Command("OK"));

                    }catch(NumberFormatException e){
                        Dialog.show("ERROR", " id must be a number", new Command("OK"));
                    }
                }
            }
        });
        addAll(Ffid,Ffref_cmde,Ffcode_postal,Fftel,FfPays,FfRegion,Ffetat_cmde,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

    }

    public Container addElement(Product s){
        Container holder = new Container(BoxLayout.x());
        Container cnt = new Container(BoxLayout.y());

        //Image im = MyApplication.theme.getImage(s.getImage());
        //ImageViewer image = new ImageViewer(im.scaled(300, 400));

        Label lbTitre = new Label(s.getProductName());
        Label lbDescription = new Label(s.getDescription());

        cnt.addAll(lbTitre, lbDescription);

        holder.setLeadComponent(lbTitre);
        holder.addAll(cnt);

        return holder;
    }

    public List<Product> afficherTout(){
        List<Product> temp = new ArrayList<>();

        try {
            Cursor cr = MyApplication.myDataBase.executeQuery("SELECT * FROM Product");

            while (cr.next()) {
                Row r = cr.getRow();

                Product s = new Product();

                s.setId(r.getInteger(0));
                s.setProductName(r.getString(1));
                s.setDescription(r.getString(2));
                //s.setPrice(r.getString(2));
                //s.setImage(r.getString(3));

                temp.add(s);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return temp;
    }
}
