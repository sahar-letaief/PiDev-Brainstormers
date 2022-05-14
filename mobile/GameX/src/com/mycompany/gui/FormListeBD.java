package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.db.Cursor;
import com.codename1.db.Row;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
        import com.codename1.ui.Container;
        import com.codename1.ui.Dialog;
        import com.codename1.ui.Form;
        import com.codename1.ui.Image;
        import com.codename1.ui.Label;


import com.mycompany.myapp.MyApplication;
import com.mycompany.entities.Product;
import com.mycompany.services.ServiceProduct;


public class FormListeBD extends Form {

    public FormListeBD(Form previous) {

        this.setLayout(BoxLayout.y());
        this.setTitle("Your cart");

        this.getToolbar().addCommandToLeftBar("Back", null, (evt) -> {
            previous.showBack();
        });

        this.getToolbar().addCommandToOverflowMenu("Refresh", null, (evt) -> {
            actualiserLaForm();
        });

        Button btnAddOrder=new Button("add new Order");
        btnAddOrder.addActionListener(e-> new AddOrderForm(previous).show());
        addAll(btnAddOrder);


        //SELECT FROM DATABASE
        List<Product> Products = afficherTout();
        System.out.println(Products.toString());
        for (Product ser :Products) {
            this.add(addElement(ser));
        }
        getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());


    }

    public void actualiserLaForm(){

        this.removeAll();

        List<Product> products = afficherTout();

        for (Product ser : products) {
            this.addElement(ser);
        }
    }

    public Container addElement(Product s){
        Container holder = new Container(BoxLayout.x());
        Container cnt = new Container(BoxLayout.y());

        //Image im = MyApplication.theme.getImage(s.getImage());
        //ImageViewer image = new ImageViewer(im.scaled(300, 400));

        Label lbTitre = new Label(s.getProductName());
        Label lbDescription = new Label(s.getDescription());

        cnt.addAll(lbTitre, lbDescription);

        lbTitre.addPointerReleasedListener((evt) -> {
            //DELETE FROM DATABASE
            if (Dialog.show("Product "+s.getProductName(), "delete this product?", "yes", "No")) {
                try {
                    System.out.println(s);
                    MyApplication.myDataBase.execute("DELETE FROM product WHERE ProductName like '"+s.getProductName()+"'");
                    actualiserLaForm();
                    Dialog.show("Delete Product "+s.getProductName(), "Delete done !", "OK", null);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

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
                s.setPrice(r.getInteger(2));
                //s.setImage(r.getString(3));

                temp.add(s);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return temp;
    }
}
