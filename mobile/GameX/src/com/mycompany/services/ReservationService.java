/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import static com.mycompany.services.EvenementService.resultOK;
import com.mycompany.entities.Evenement;
import com.mycompany.entities.Reservation;
import com.mycompany.entities.User;
import com.mycompany.gui.SessionManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author WIKI
 */
public class ReservationService {
     public static ReservationService instance = null;
    private ConnectionRequest req;
    public ArrayList<Reservation> reservation;
    
    public static ReservationService getInstance(){
        if(instance==null)
            instance = new ReservationService();
         return instance;
        
    }
    public ReservationService(){
        req = new ConnectionRequest();
    }
    
    public ArrayList<Reservation> getList(String json){

            try {
            JSONParser j = new JSONParser();
            Map<String, Object> reservations = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println("yallaaaa"+reservations);
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) reservations.get("root");
            System.out.println(list);
            for (Map<String, Object> obj : list) {
                        Reservation res = new Reservation();
                       
                       Map<String, Object> eventMap = (Map<String, Object>) obj.get("evenement");
                       float idE= Float.parseFloat(eventMap.get("id").toString());
                       System.out.println(idE);
                       String NameEvent=eventMap.get("NameEvent").toString();
                       System.out.println(NameEvent);
                       String PlaceEvent = (String)eventMap.get("PlaceEvent").toString();
                       System.out.println(PlaceEvent);
            
                        String DateDebut = (String)eventMap.get("DateDebut").toString();
                        System.out.println(DateDebut);
                        String DateFin = (String)eventMap.get("DateFin").toString();
                          System.out.println(DateFin);
                       Evenement e=new Evenement((int)idE,NameEvent,PlaceEvent,DateDebut,DateFin);
                      System.out.println("event mtaa res"+e.toString());
                      
                       Map<String, Object> userMap = (Map<String, Object>) obj.get("user");
                       
                       float idU=Float.parseFloat(userMap.get("id").toString());
                       
                       String firstname=userMap.get("firstname").toString();
                       String lastname=userMap.get("lastname").toString();
                       User u= new User((int)idU,firstname,lastname);
                        
                       
                    
                        
                        float id= Float.parseFloat(obj.get("id").toString());
                        String DateReservation=obj.get("DateReservation").toString();
                        
                       
                        res.setEvenement(e);
                        res.setUser(u);
                        res.setId((int)id);
                        res.setDateReservation(obj.get("DateReservation").toString());
                        
                       
                       
                        reservationlist.add(res);
                       System.out.println(reservationlist);
            }

        } catch (IOException ex) {
        }
       
        return reservationlist;
        
    }
    ArrayList<Reservation> reservationlist = new ArrayList<>();
    public ArrayList<Reservation> ShowReservationsFront(){
         //ConnectionRequest req = new ConnectionRequest();
         SessionManager.getId();
        String url="http://127.0.0.1:8000/reservation/apiDisplay/"+SessionManager.getId() ;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ReservationService ser = new ReservationService();
                reservationlist = ser.getList(new String(req.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return reservationlist;
         
            }
    
    ArrayList<Reservation> reservationlist2 = new ArrayList<>();
      public ArrayList<Reservation> ShowReservationsBack(){
         //ConnectionRequest req = new ConnectionRequest();
        //SessionManager.getId();
        String url="http://127.0.0.1:8000/reservation/apiDisplay" ;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ReservationService ser = new ReservationService();
                reservationlist2 = ser.getList(new String(req.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return reservationlist2;
         
            }
    
    public void AddReservation(Evenement event){
                 ConnectionRequest req = new ConnectionRequest();
          
            SessionManager.getId();
        String url ="http://127.0.0.1:8000/reservation/new/api/"+event.getId()+ "/"+SessionManager.getId();
        req.setUrl(url);
        req.addResponseListener(a->{
            String str = new String(req.getResponseData());
            System.err.println("data=="+str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
    
    public boolean DeleteReservation(int id){
         ConnectionRequest req = new ConnectionRequest();
         String url="http://127.0.0.1:8000/reservation/deleteApi/"+id;
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
}
