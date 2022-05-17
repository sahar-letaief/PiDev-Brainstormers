/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.codename1.io.*;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.mycompany.entities.Order;
import com.mycompany.gui.ListOrderForm;
import com.mycompany.utils.Statics;
import com.codename1.ui.events.ActionListener;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class OrderService {
    Form current;
    public ArrayList<Order> orders;
    public  static OrderService instance;
    private ConnectionRequest req;
    private ConnectionRequest connectionRequest;
    ConnectionRequest con = new ConnectionRequest();
    public OrderService() {
        req = new ConnectionRequest();
    }

    public static OrderService getInstance(){
        if(instance == null){
            instance = new OrderService();
        }
        return instance;
    }
    public boolean resultOK;


    public boolean addOrder(Order F){
        //String url = Statics.BASE_URL+"/Formation/"+F.getId()+"/"+F.getNom()+"/"+F.getDescription()+"/"+F.getImage()+"/"+F.getPrix()+"/"+F.getDatede()+"/"+F.getDatefin();
        String url = Statics.BASE_URL+"/commande/AddCommande/new?id="+F.getId()+"&ref_cmde="+F.getRef_cmde()+"&etat_cmde="+F.getEtat_cmde()+"&Pays="+F.getPays()+"&Region="+F.getRegion()+"&code_postal="+F.getCode_postal()+"&tel="+F.getTel();
        req .setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode()==200;
                req.removeResponseCodeListener(this);
            }
        } );
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK ;
    }




    public boolean editOrder(Order spectacle) {
        String Url = Statics.BASE_URL+"/commande/editcmde/"+spectacle.getId()+
                "?&ref_cmde="+spectacle.getRef_cmde()+"&etat_cmde="+spectacle.getEtat_cmde()+"&Pays="+spectacle.getPays()+
                "&Region="+spectacle.getRegion()+"&code_postal="+spectacle.getCode_postal()+"&tel="+spectacle.getTel();
        req.setUrl(Url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }





    public ArrayList<Order> parseTest(String jsonText){
        try {
            orders=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> OrdersListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)OrdersListJson.get("root");
            for(Map<String,Object> obj : list){
                Order t = new Order();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                t.setRef_cmde((obj.get("ref_cmde").toString()));
                t.setPays((obj.get("Pays").toString()));
                t.setRegion((obj.get("Region").toString()));
                float code_postal = Float.parseFloat(obj.get("code_postal").toString());
                t.setCode_postal((int)code_postal);
                float tel = Float.parseFloat(obj.get("tel").toString());
                t.setTel((int)tel);
                //boolean etat_cmde ;
                //t.setEtat_cmde((obj.get("etat_cmde").toString()));


                orders.add(t);
            }

        } catch (IOException ex) {

        }
        return orders;
    }


    public ArrayList<Order> getAllOrders() {
        String url = Statics.BASE_URL + "/commande/AllComandes";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println(new String(req.getResponseData()));
                orders = parseTest(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return orders;
    }

    public ArrayList<Order> getAllOrdersTri() {
        String url = Statics.BASE_URL + "/commande/AllComandes";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println(new String(req.getResponseData()));
                orders = parseTest(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return orders;
    }

}
