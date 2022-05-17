/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;
import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Order;


public class HomeForm_1  extends Form {
Form current;
    Order  ta;
    Resources themes;
    Resources res;

    public HomeForm_1() {
                Button trie =new Button("Back");

       
        trie.addActionListener(e-> new ProfileForm(themes).show());
        add(trie);



        this.getToolbar().addCommandToSideMenu("list of products",
                null, (evt) -> {
                    new ListProdForm1(this).show();
                });
        this.getToolbar().addCommandToSideMenu("list of orders",
                null, (evt) -> {
                    new ListOrderForm(this).show();
                });
        this.getToolbar().addCommandToSideMenu("Cart",
                null, (evt) -> {
                    new FormListeBD(this).show();
                });
        this.getToolbar().addCommandToSideMenu("Statics",
                null, (evt) -> {
                    new statForm_1(this).show();
                });
        Resources res= UIManager.initFirstTheme("/theme");
        current=this; //Back
        setTitle("Home");
        setLayout(BoxLayout.y());
        this.setLayout(new FlowLayout(CENTER,CENTER));
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

    }

}

