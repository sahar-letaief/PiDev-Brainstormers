/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.codename1.db.Cursor;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.MyApplication;
import com.mycompany.entities.Evenement;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.util.Date;
import java.util.Map;


/**
 *
 * @author WIKI
 */
public class EvenementService {
    public static EvenementService instance = null;
    private ConnectionRequest req;
    public ArrayList<Evenement> evenement;
     public static boolean resultOK;
    ArrayList<Evenement> eventlist = new ArrayList<>();
     ArrayList<Evenement> eventlist2 = new ArrayList<>();
    
    public static EvenementService getInstance(){
        if(instance==null)
            instance = new EvenementService();
         return instance;
        
    }
    public EvenementService(){
        req = new ConnectionRequest();
    }
    
    
    public ArrayList<Evenement> getList(String json){
       // List<Evenement> temp = new ArrayList<>();

            try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> events = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println(events);
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("root");
            

            for (Map<String, Object> obj : list) {
                        Evenement event = new Evenement();
                        
                        float id= Float.parseFloat(obj.get("id").toString());
                        String NameEvent=obj.get("NameEvent").toString();
                        System.out.println(NameEvent);
                        String PlaceEvent=obj.get("PlaceEvent").toString();
                        double NbParticipants=Double.parseDouble(obj.get("NbParticipants").toString());
                        double PriceEvent=Double.parseDouble(obj.get("PriceEvent").toString());
                        
                       
                        event.setId((int)id);
                        event.setNameEvent(NameEvent);
                        event.setPlaceEvent(PlaceEvent);
                        event.setNbParticipants((int)NbParticipants);
                        event.setPriceEvent((float)PriceEvent);
                        event.setDateDebut(obj.get("DateDebut").toString());
                        event.setDateFin(obj.get("DateFin").toString());
                        
                        eventlist.add(event);

            }

        } catch (IOException ex) {
        }
       
        return eventlist;
        
    }
  /* public ArrayList<Evenement> getList2(String json){
         JSONParser j = new JSONParser();
         Evenement event = new Evenement();
            try {
                  Map<String, Object> events = j.parseJSON(new CharArrayReader(json.toCharArray()));
                   System.out.println(events);
           
            Map<String, Object> list = (Map<String, Object>) events.get("root");
             int id= Integer.parseInt(list.get("id").toString());
                        
                event.setId((int)id);
                event.setNameEvent((String)list.get("NameEvent").toString());
                event.setPlaceEvent(list.get("PlaceEvent").toString());
                event.setPriceEvent(Integer.parseInt(list.get("PriceEvent").toString()));
                event.setNbParticipants(Integer.parseInt(list.get("NbParticipants").toString()));
                event.setDateDebut(list.get("DateDebut").toString());
                event.setDateFin(list.get("DateFin").toString());
                 
                
            }catch(IOException ex) {
                System.out.println("error related to sql :( "+ex.getMessage());
            }
            
           eventlist.add(event);
            return eventlist;
           
    }*/
    
         public void AddEvent(Evenement event){
         ConnectionRequest req = new ConnectionRequest();
        String url ="http://127.0.0.1:8000/evenement/newApi?NameEvent="+event.getNameEvent()+"&PlaceEvent="+event.getPlaceEvent()+"&PriceEvent="+event.getPriceEvent()+"&NbParticipants="+event.getNbParticipants()+"&DateDebut="+event.getDateDebut()+"&DateFin="+event.getDateFin();
        req.setUrl(url);
        req.addResponseListener(a->{
            String str = new String(req.getResponseData());
            System.err.println("data=="+str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
         
    
   
    public ArrayList<Evenement> ShowEvents(){
        String url="http://127.0.0.1:8000/evenement/apiDisplay";
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                EvenementService ser = new EvenementService();
                eventlist = ser.getList(new String(req.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return eventlist;
            }
    
    
    
     public  Evenement ShowOneEvent(Evenement event){
         ConnectionRequest req = new ConnectionRequest();
         String url="http://127.0.0.1:8000/evenement/showApi/"+event.getId();
            req.setUrl(url);
          Evenement e=new Evenement();
          String str  = new String(req.getResponseData());
        req.addResponseListener(((evt) -> {
        
            JSONParser jsonp = new JSONParser();
            try {
                
                Map<String,Object>list = jsonp.parseJSON(new CharArrayReader(new String(str).toCharArray()));
                 
                 event.setId((int)Integer.parseInt(list.get("id").toString()));
                event.setNameEvent((String)list.get("NameEvent").toString());
                event.setPlaceEvent(list.get("PlaceEvent").toString());
                event.setPriceEvent(Integer.parseInt(list.get("PriceEvent").toString()));
                event.setNbParticipants(Integer.parseInt(list.get("NbParticipants").toString()));
                event.setDateDebut(list.get("DateDebut").toString());
                event.setDateFin(list.get("DateFin").toString());
                
                
            }catch(IOException ex) {
                System.out.println("error related to sql :( "+ex.getMessage());
            }
            
            
            System.out.println("data === "+str);
            
            
            
        }));
        
              NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

              return e;
        
        
              
     }
    
    ArrayList<Evenement> sort1 = new ArrayList<>();
    public ArrayList<Evenement> SortByPrice(){
           ConnectionRequest req = new ConnectionRequest();
        String url="http://127.0.0.1:8000/evenement/apiSortPrice";
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                EvenementService ser = new EvenementService();
                sort1 = ser.getList(new String(req.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return sort1;
          
            }
    
       ArrayList<Evenement> sort2 = new ArrayList<>();
    public ArrayList<Evenement> SortByPart(){
           ConnectionRequest req = new ConnectionRequest();
        String url="http://127.0.0.1:8000/evenement/apiSortPart";
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                EvenementService ser = new EvenementService();
                sort2 = ser.getList(new String(req.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return sort2;
          
            }
    
     ArrayList<Evenement> sort3 = new ArrayList<>();
    public ArrayList<Evenement> SortByName(){
           ConnectionRequest req = new ConnectionRequest();
        String url="http://127.0.0.1:8000/evenement/apiSortName";
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                EvenementService ser = new EvenementService();
                sort3 = ser.getList(new String(req.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return sort3;
          
            }
    
        
          
      
    
    public boolean DeleteEvent(int id){
         ConnectionRequest req = new ConnectionRequest();
         String url="http://127.0.0.1:8000/evenement/deleteApi/"+id;
          req.setUrl(url);
         req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               req.removeResponseCodeListener(this);
            }
        });
         NetworkManager.getInstance().addToQueueAndWait(req);
         return resultOK;
    }
    
    public boolean EditEvent(Evenement event){
         ConnectionRequest req = new ConnectionRequest();
        String url = "http://127.0.0.1:8000/evenement/editApi/"+event.getId()+"?NameEvent="+event.getNameEvent()+"&PlaceEvent="+event.getPlaceEvent()+"&PriceEvent="+event.getPriceEvent()+"&NbParticipants="+event.getNbParticipants()+"&DateDebut="+event.getDateDebut()+"&DateFin="+event.getDateFin();
         req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
              resultOK=req.getResponseCode() == 200;
              req.removeResponseListener(this);
            }
        });
         NetworkManager.getInstance().addToQueueAndWait(req);
         return resultOK;
    }

    }
   
    

