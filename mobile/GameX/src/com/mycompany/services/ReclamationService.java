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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.mycompany.entities.Reclamation;
import com.mycompany.services.ReclamationService;
import com.mycompany.utils.Statics;

/**
 *
 * @author oasis
 */
public class ReclamationService {
      public ArrayList<Reclamation> reclamations;
    
    public static ReclamationService instance=null;
   public boolean resultOK;
    private ConnectionRequest req;

    public ReclamationService() {
         req = new ConnectionRequest();
    }

    public static ReclamationService getInstance() {
        if (instance == null) {
            instance = new ReclamationService();
        }
        return instance;
    }
    public boolean addReclamation(Reclamation R){
        //String url = Statics.BASE_URL+"/Formation/"+F.getId()+"/"+F.getNom()+"/"+F.getDescription()+"/"+F.getImage()+"/"+F.getPrix()+"/"+F.getDatede()+"/"+F.getDatefin();
        String url = Statics.BASE_URL+"/newjson?Title="+R.getTitle()+"&Description="+R.getDescription();
        req.setUrl(url);
       /* req.addArgument("id", R.getId()+"");
       req.addArgument("Title", R.getTitle()+"");
       req.addArgument("Description", R.getDescription()+"");*/
      req.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode()==200;
                req.removeResponseCodeListener(this);
            }
        } );
        NetworkManager.getInstance().addToQueueAndWait(req);//exécution de réquéte sinon n'envoie rien
        return resultOK ;
        
    }
    public ArrayList<Reclamation> parseReclamation(String jsonText){
        try {
            reclamations = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> ReclamationsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)ReclamationsListJson.get("root");
            for(Map<String,Object> obj : list){
                Reclamation t = new Reclamation();  
               float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                t.setTitle((obj.get("Title").toString()));
                t.setDescription((obj.get("Description").toString()));
                reclamations.add(t);
            }
             } catch (IOException ex) {
            
        }
        return reclamations;
    }
    
    public ArrayList<Reclamation> getAllReclamation(){
      
       String url = Statics.BASE_URL +"/frontlistjson";
       req.setUrl(url);
        req.setPost(false); //
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println(new String(req.getResponseData()));
                reclamations = parseReclamation(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return reclamations;
    }
   /* public ArrayList<Reclamation> getAllReclamationtrie(){
      
       String url = Statics.BASE_URL +"/frontlist";
       req.setUrl(url);
        req.setPost(false); //
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println(new String(req.getResponseData()));
                reclamations = parseReclamation(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return reclamations;
    }*/
    public boolean delReclamation(Reclamation t) {
        String url = Statics.BASE_URL + "/"+t.getId()+"/deletejson";
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; 
                req.removeResponseListener(this); 
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    public boolean editReclamation(Reclamation t) {
        String url = Statics.BASE_URL + "/"+t.getId()+"/editjson"+"?&Title="+t.getTitle()+"&Description="+t.getDescription();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; 
                req.removeResponseListener(this); 
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
     
     
     
     
       /*   public ArrayList<Reclamation>orderByPrix(){
         //String url = Statics.BASE_URL+"/Categories/";
        String url = Statics.BASE_URL +"/formmattion/orderByPrix";
        req.setUrl(url);
        req.setPost(false);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                reclamations = parseReclamation(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return reclamations;
    }*/
    
}
