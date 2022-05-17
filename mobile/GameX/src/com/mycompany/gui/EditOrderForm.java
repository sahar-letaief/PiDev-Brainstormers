package com.mycompany.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.l10n.ParseException;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Order;
import com.mycompany.services.OrderService;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class EditOrderForm extends Form{
    OrderService os = new OrderService();

    public EditOrderForm(Form previous, Order spectacle){


        System.out.println(spectacle.getId()+"");
        setTitle("Edit The Order : " +spectacle.getId()+"");
        setLayout(BoxLayout.y());

        this.getToolbar().addCommandToLeftBar("Back", null, (evt) -> {
            new ListOrderForm(previous).showBack();
        });
        TextField refTextField= new TextField(spectacle.getRef_cmde(), "ref");
        TextField telTextField= new TextField(Integer.toString(spectacle.getTel()),"8");
        TextField codeTextField = new TextField(Integer.toString(spectacle.getCode_postal()), "4" );
        TextField etatTextField= new TextField(spectacle.getEtat_cmde(), "etat");
        TextField paysTextField = new TextField(spectacle.getPays(),"pays");
        TextField regionTextField= new TextField(spectacle.getRegion(), "region");
        Button editButton = new Button("Edit The Order");
        editButton.addActionListener(l->{
            if((refTextField.getText().length()==0)||(paysTextField.getText().length()==0)||(regionTextField.getText().length()==0)){
                Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
            }
            else {
                int tel = Integer.parseInt(telTextField.getText());
                int code = Integer.parseInt(codeTextField.getText());
                spectacle.setRef_cmde(refTextField.getText());
                spectacle.setTel(tel);
                spectacle.setCode_postal(code);
                spectacle.setPays(paysTextField.getText());
                spectacle.setRegion(regionTextField.getText());
                spectacle.setEtat_cmde(etatTextField.getText());
                OrderService sp = new OrderService();
                sp.editOrder(spectacle);
                InfiniteProgress ip = new InfiniteProgress();
                final Dialog iDialog = ip.showInfiniteBlocking();
                if(OrderService.getInstance().editOrder(spectacle)){
                    iDialog.dispose();
                    Dialog.show("Success","commande modifié",new Command("OK"));
                    //previous.showBack();
                    }
                else{
                    iDialog.dispose();
                    Dialog.show("ERROR", "Erreur", new Command("OK"));
                }

        }

    });
        addAll(refTextField ,telTextField,codeTextField,etatTextField,paysTextField,regionTextField, editButton);
//Back Button
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

    }

}
