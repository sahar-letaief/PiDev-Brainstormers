/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;


import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SignatureComponent;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.BOTTOM;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 *
 * @author bhk
 */
public class HomeForm extends Form{
Form current;
private Resources theme;
    public HomeForm() {
        Button trie =new Button("Back");

       
        trie.addActionListener(e-> new ProfileForm(theme).show());
        add(trie);
        
        Resources res=UIManager.initFirstTheme("/theme");
        current=this; //Back 
        setTitle("Home");
        setLayout(BoxLayout.y());
         Image  img = res.getImage("logo9.png");
          
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        Label facebook = new Label("786 followers", res.getImage("facebook-logo.png"), "BottomPad");
        Label twitter = new Label("486 followers", res.getImage("twitter-logo.png"), "BottomPad");
        facebook.setTextPosition(BOTTOM);
        twitter.setTextPosition(BOTTOM);
        
        add(LayeredLayout.encloseIn(
                sl

        ));
        
        add(new Label("Choose an option"));
        Button btnListProducts = new Button("List Of Products");
        Button btnStat = new Button("Statistics");
        Button btnAdd = new Button("Add product");
        Button map=new Button("map");  
        Button btnListCategories = new Button("List Of Categories");
        Button btnAddCat = new Button("Add Category");
          
       
        map.addActionListener(e-> new MapForm_1(theme,current));  




        btnListProducts.addActionListener(e-> new ListProdForm(current).show());
        btnStat.addActionListener(e-> new statForm(current).show());
        btnAdd.addActionListener(e-> new AddProductForm(current).show());
        
        btnListCategories.addActionListener(e-> new ListCatForm(current).show());
        btnAddCat.addActionListener(e-> new AddCategoryForm(current).show());





        addAll(btnListProducts, btnStat, btnAdd,map,btnListCategories,btnAddCat);
        Dialog.show("Visit", " Our Products", "Go", null);

       
        

        
        
    }
  
    
    
}
