package com.mycompany.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.Product;
import com.mycompany.utils.Statics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author bhk
 */
public class ServiceProduct {

    public ArrayList<Product> Products;
    public ArrayList<Product> listProductForm;
    
    public static ServiceProduct instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceProduct() {
         req = new ConnectionRequest();
    }

    public static ServiceProduct getInstance() {
        if (instance == null) {
            instance = new ServiceProduct();
        }
        return instance;
    }

   

    public ArrayList<Product> parseProducts(String jsonText){
        try {
            Products=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> ProductsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)ProductsListJson.get("root");
            for(Map<String,Object> obj : list){
                Product t = new Product();  
               float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                t.setProductName((obj.get("ProductName").toString()));
                t.setDescription((obj.get("Description").toString()));
                //t.setImage((obj.get("image").toString()));
                t.setReference((obj.get("Reference").toString()));
               float Price = Float.parseFloat(obj.get("Price").toString());
                t.setPrice((int)Price);
               float Stock = Float.parseFloat(obj.get("Stock").toString());
                t.setStock((int)Stock);
                     
                Products.add(t);
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
        return Products;
    }
    public boolean deletedVoyage(int id) {

        String url = Statics.BASE_URL + "/product/"+id+"/deleteJson";
        req.setUrl(url);
        req.setPost(true);
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
    
    
    public ArrayList<Product> getAllProducts(){
        //String url = Statics.BASE_URL+"/Products/";
        String url = Statics.BASE_URL +"/product/FrontProductJson";
        req.setUrl(url);
        req.setPost(false);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Products = parseProducts(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Products;
    }
    public boolean addProduct(Product F){
        //String url = Statics.BASE_URL+"/Formation/"+F.getId()+"/"+F.getNom()+"/"+F.getDescription()+"/"+F.getImage()+"/"+F.getPrix()+"/"+F.getDatede()+"/"+F.getDatefin();
        String url = Statics.BASE_URL+"/product/newJson?id="+F.getId()+"&Reference="+F.getReference()+"&ProductName="+F.getProductName()+"&Description="+F.getDescription()+"&Price="+F.getPrice()+"&Stock="+F.getStock()+"&Category="+F.getCategory_id();
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
    
    
    
    public boolean delProduct(Product t) {
        String url = Statics.BASE_URL + "/product/"+t.getId()+"/deleteJson";
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
    
    public boolean editProduct(Product t) {
        String url = Statics.BASE_URL + "/product/"+t.getId()+"/editJson"+"?&ProductName="+t.getProductName()+"&Description="+t.getDescription()+"&Price="+t.getPrice()+"";
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
    //**
    
    
    
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