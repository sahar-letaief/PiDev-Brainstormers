package com.mycompany.gui;

import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.entities.Order;
import com.mycompany.services.OrderService;

import java.util.ArrayList;

public class ordersearch extends Form {
    Form current;
    ordersearch(Form previous,Order rec){
        current=this;


        setTitle("List Orders");
        setLayout(BoxLayout.y());
        this.getToolbar().addCommandToLeftBar("Back", null, (evt) -> {
            new ListOrderForm(previous).showBack();
        });
        SpanLabel sp = new SpanLabel();
        ArrayList<Order> list;
        list= new ArrayList<>();
        list = OrderService.getInstance().getAllOrders();
       // for ( Order ev : list) {
            //SpanLabel spl = new SpanLabel("ref_cmde: " + "  " + ev.getRef_cmde()+" etat_cmde:"+" "+ev.getEtat_cmde()+" Pays:"+" "+ev.getPays()+" Region:"+" "+ev.getRegion()+" code_postal:"+" "+ev.getCode_postal()+" tel:"+" "+ev.getTel());
            //addAll(spl);

            MultiButton multiButton = new MultiButton(rec.getRef_cmde() + "");
            multiButton.setTextLine1("ref: "+rec.getRef_cmde());
            multiButton.setTextLine2("region: "+rec.getRegion() + "  " +"Pays: "+rec.getPays() + "  " +"Etat: "+rec.getEtat_cmde()  );
            multiButton.setTextLine4("code postale: "+rec.getCode_postal() +"  " +"NumTel: "+rec.getTel());
            multiButton.addActionListener(l -> new EditOrderForm(current, rec).show());
            add(multiButton);


        //}
    }


}
