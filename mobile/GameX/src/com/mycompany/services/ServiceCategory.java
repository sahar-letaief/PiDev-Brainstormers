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
import com.mycompany.entities.Category;
import com.mycompany.utils.Statics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author maryem
 */
public class ServiceCategory {
    
    public ArrayList<Category> Categories;
    public ArrayList<Category> listeCategoryForm;
    
    public static ServiceCategory instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceCategory() {
         req = new ConnectionRequest();
    }

    public static ServiceCategory getInstance() {
        if (instance == null) {
            instance = new ServiceCategory();
        }
        return instance;
    }

   

    public ArrayList<Category> parseCategories(String jsonText){
        try {
            Categories=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> CategoriesListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)CategoriesListJson.get("root");
            for(Map<String,Object> obj : list){
                Category t = new Category();  
              float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                t.setName((obj.get("Name").toString()));
                t.setDescription((obj.get("description").toString()));
               
                     
             Categories.add(t);
            }
            /*
            
             Students=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> StudentsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)StudentsListJson.get("root");
            for(Map<String,Object> obj : list){
                Student t = new Student();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                t.setEmail((obj.get("email").toString()));
                    t.setNsc(obj.get("nsc").toString());
                Students.add(t);
            }
            */
            
        } catch (IOException ex) {
            
        }
        return Categories;
    }
   
    
    public ArrayList<Category> getAllCategories(){
        //String url = Statics.BASE_URL+"/Products/";
        String url = Statics.BASE_URL +"/category/Json";
        req.setUrl(url);
        req.setPost(false);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Categories = parseCategories(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Categories;
    }
    public boolean addCategory(Category F){
        //String url = Statics.BASE_URL+"/Formation/"+F.getId()+"/"+F.getNom()+"/"+F.getDescription()+"/"+F.getImage()+"/"+F.getPrix()+"/"+F.getDatede()+"/"+F.getDatefin();
        String url = Statics.BASE_URL+"/category/newJson?id="+F.getId()+"&Name="+F.getName()+"&description="+F.getDescription();
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
    
    
    
    public boolean delCategory(Category t) {
        String url = Statics.BASE_URL + "/category/"+t.getId()+"/deleteJson";
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
    
    public boolean editCategory(Category t) {
        String url = Statics.BASE_URL + "/category/"+t.getId()+"/editJson"+"?&Name="+t.getName()+"&description="+t.getDescription()+"";
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
    //**+
    
    
    
    ///**
   

   
     /**public void addProduct(Product F) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = Statics.BASE_URL+"product/new/new?id="+F.getId()+"&Reference="+F.getReference()+"&ProductName="+F.getProductName()+"&Description="+F.getDescription()+"&Price="+F.getPrice()+"&Stock="+F.getStock();
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
//            if (str.trim().equalsIgnoreCase("OK")) {
//                f2.setTitle(tlogin.getText());
//             f2.show();
//            }
//            else{
//            Dialog.show("error", "login ou pwd invalid", "ok", null);
//            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        Dialog.show("Succés", " ajouté", "ok", null);
    }*/
   /* public ArrayList<Product> Recherche(String item){        
        ConnectionRequest con = new ConnectionRequest();
        String url = Statics.BASE_URL +"product/FrontProduct";
        con.setUrl(url);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceProduct ser = new ServiceProduct();
                listProductForm = ser.parseProducts(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listProductForm;
    }*/


    
    
}
