/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.db.Cursor;
import com.codename1.db.Row;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.MyApplication;
import com.mycompany.entities.Order;
import com.mycompany.entities.Product;
import com.mycompany.services.OrderService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ListOrderForm extends Form{

    Form f;

    public ListOrderForm(Form previous) {
        setTitle("List Orders");
        setLayout(BoxLayout.y());

        this.getToolbar().addCommandToLeftBar("Back", null, (evt) -> {
            new HomeForm_1().showBack();
        });
        Button rtrie =new Button("Search");

        // back = Image.createImage("/logo.png");
        //back.scaled(1000, 1000);
        add(rtrie);
        Style s = UIManager.getInstance().getComponentStyle("Title");

        Form hi = new Form("Toolbar", new BoxLayout(BoxLayout.Y_AXIS));
        rtrie.addActionListener(e-> { hi.show();});
        Button gui_Button_12 = new Button();
        gui_Button_12.setText("search");
        gui_Button_12.setUIID("Label");
        gui_Button_12.setName("Button_12");
        FontImage.setMaterialIcon(gui_Button_12, FontImage.MATERIAL_CIRCLE);
        TextField searchField = new TextField("", "Toolbar Search"); // <1>
        searchField.getHintLabel().setUIID("Title");
        searchField.setUIID("Title");
        searchField.getAllStyles().setAlignment(Component.LEFT);
        hi.getToolbar().setTitleComponent(searchField);
        FontImage searchIcon = FontImage.createMaterial(FontImage.MATERIAL_SEARCH, s);
        ArrayList<Order> list1;
        list1 = OrderService.getInstance().getAllOrders();
        //hi.add(gui_Button_12);
        searchField.addDataChangeListener((i1, i2) -> { // <2>
            String t = searchField.getText();

            if(t.length() < 1) {
                for(Component cmp : hi.getContentPane()) {
                    cmp.setHidden(false);
                    cmp.setVisible(true);
                }
            } else {
                t = t.toLowerCase();
                for(Component cmp : hi.getContentPane()) {
                    String val = null;
                    //hi.add(gui_Button_12);
                    if(cmp instanceof Label) {
                        val = ((Label)cmp).getText();
                    } else {
                        if(cmp instanceof TextArea) {
                            val = ((TextArea)cmp).getText();
                        } else {
                            val = (String)cmp.getPropertyValue("text");
                        }
                    }
                    boolean show = val != null && val.toLowerCase().indexOf(t) > -1;
                    cmp.setHidden(!show); // <3>
                    cmp.setVisible(show);
                    //hi.add(gui_Button_12);
                }
            }
            hi.getContentPane().animateLayout(250);
            //  hi.add(gui_Button_12);
        });
        hi.getToolbar().addCommandToRightBar("", searchIcon, (e) -> {
            searchField.startEditingAsync(); // <4>
            //    hi.add(gui_Button_12);
        });

        for(Order rec : list1){
            Label b = new Label(rec.getRef_cmde());
            hi.add(b);
            b.addPointerPressedListener(e -> {

                if (rec.getRef_cmde() == b.getText())
                {
                    new  ordersearch(f,rec).show();
                }
            });
        }

        Button btnAddOrder=new Button("add new Order");
        btnAddOrder.addActionListener(e-> new AddOrderForm(f).show());
        addAll(btnAddOrder);

        SpanLabel sp = new SpanLabel();
        ArrayList<Order> list;
        list= new ArrayList<>();
        list = OrderService.getInstance().getAllOrders();
        for ( Order ev : list) {

        MultiButton multiButton = new MultiButton(ev.getRef_cmde() + "");
        multiButton.setTextLine1("ref: "+ev.getRef_cmde());
        multiButton.setTextLine2("region: "+ev.getRegion() + "  " +"Pays: "+ev.getPays() + "  " +"Etat: "+ev.getEtat_cmde()  );
        multiButton.setTextLine4("code postale: "+ev.getCode_postal() +"  " +"NumTel: "+ev.getTel());

        multiButton.addActionListener(l -> new EditOrderForm(f, ev).show());
        add(multiButton);
            List<Product> Products = afficherTout();
            System.out.println(Products.toString());
            for (Product ser :Products) {
                this.add(addElement(ser));
            }
        }
        getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());



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

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}