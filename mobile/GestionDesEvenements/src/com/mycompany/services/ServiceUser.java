/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.User;
import com.mycompany.gui.PhoneCodeForm;
import com.mycompany.gui.ProfileForm;
import com.mycompany.gui.SessionManager;
import com.mycompany.gui.SignInForm;
import com.mycompany.utils.Statics;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Yassine
 */
public class ServiceUser {
    
    
    public static ServiceUser instance = null ;
    public static boolean resultOk = true;
    String json;

    //initilisation connection request 
    private ConnectionRequest req;
    
    public static ServiceUser getInstance() {
        if(instance == null )
            instance = new ServiceUser();
        return instance ;
    }
    
    public ServiceUser() {
        req = new ConnectionRequest();
    }
    
    //SignIn
    
    public void signin(TextField username,TextField password, Resources rs ) {
        
        
        String url = Statics.BASE_URL+"/login/mobile?username="+username.getText().toString()+"&password="+password.getText().toString();
        req = new ConnectionRequest(url, false); //false ya3ni url mazlt matba3thtich lel server
        req.setUrl(url);
        req.setPost(true);
        req.addResponseListener((e) ->{
        JSONParser j = new JSONParser();
        String json = new String(req.getResponseData()) + "";
        boolean error = false;
        try {
            Map<String,Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));
            for (Map.Entry mapentry : user.entrySet()) {
                //system.out.println("clé: "+mapentry.getKey() + " | valeur: " + mapentry.getValue());
                if ( mapentry.getKey().equals("error")){
                    error = true;
                }
            }
        if( error ) {
            Dialog.show("Echec d'authentification","Username ou mot de passe éronné","OK",null);
        }
        else {
            //Session
            float id = Float.parseFloat(user.get("id").toString());
            SessionManager.setId((int)id);//jibt id ta3 user ly3ml login w sajltha fi session ta3i
            SessionManager.setUserName(user.get("usertag").toString());
            SessionManager.setEmail(user.get("email").toString());
            SessionManager.setfirstname(user.get("firstname").toString());
            SessionManager.setlastname(user.get("lastname").toString());
            SessionManager.setPassword(user.get("password").toString());
            //
            float phonenumber = Float.parseFloat(user.get("phone_number").toString());
            SessionManager.setphonenumber((int)phonenumber);

            String str = user.get("roles").toString();
            SessionManager.setrole(str.substring(1 , str.length() - 1));
            
            if ( user.get("verificationCode") == null){
                new ProfileForm(rs).show();
            }else{
                new PhoneCodeForm(rs).show();
            }
                
                }
        }catch(Exception ex) {
            ex.printStackTrace();
        }


        });
    
         //ba3d execution ta3 requete ely heya url nestanaw response ta3 server.
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
    
    public void signup(TextField username,TextField firstname,TextField lastname,TextField phonenumber,TextField email ,TextField password,ComboBox<String> roles , Resources res ) {
        
        String url = Statics.BASE_URL+"/signup/mobile?username="+username.getText().toString()+"&email="+email.getText().toString()+
                "&password="+password.getText().toString()+"&roles="+roles.getSelectedItem().toString()+"&firstname="+firstname.getText().toString()+
                "&lastname="+lastname.getText().toString()+"&phonenumber="+phonenumber.getText().toString();
        
        req.setUrl(url);
       
        //Control saisi
        if(username.getText().equals(" ") && password.getText().equals(" ") && email.getText().equals(" ")) {
            
            Dialog.show("Erreur","Veuillez remplir les champs","OK",null);
            
        }
        
        //hethi wa9t tsir execution ta3 url 
        req.addResponseListener((e)-> {
         
            //njib data ly7atithom fi form 
            byte[]data = (byte[]) e.getMetaData();//lazm awl 7aja n7athrhom ke meta data ya3ni na5o id ta3 kol textField 
            String responseData = new String(data);//ba3dika na5o content 
                        System.out.println("data ===>"+responseData.toString());

            JSONParser j = new JSONParser();
            String json = new String(req.getResponseData()) + "";
            boolean error = true;
            try {
            Map<String,Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));
            for (Map.Entry mapentry : user.entrySet()) {
                System.out.println("clé: "+mapentry.getKey() + " | valeur: " + mapentry.getValue());
                if ( mapentry.getKey().equals("success")){
                    error = false;
                }
            }
            
            if( error ) {
            Dialog.show("Echec","Please try again","OK",null);
            }else{
                Dialog.show("SUCCESS","Sign Up succcessflly","OK",null);
                new SignInForm(res).show();
            }
            }catch(Exception ex) {
            ex.printStackTrace();
            }
            
        }
        );
        //ba3d execution ta3 requete ely heya url nestanaw response ta3 server.
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
    
    public void ConfirmPhoneNumberCode(TextField Code,Resources res, int id){
        
        String url = Statics.BASE_URL+"/PhoneNumberCode/mobile?code="+Code.getText().toString()+"&UserId="+id;
        req = new ConnectionRequest(url, false); //false ya3ni url mazlt matba3thtich lel server
        req.setUrl(url);
        req.setPost(true);
        req.addResponseListener((e) ->{
        JSONParser j = new JSONParser();
        String json = new String(req.getResponseData()) + "";
        boolean success = false;
        boolean error = false;
        String text = "";
        try {
            Map<String,Object> data = j.parseJSON(new CharArrayReader(json.toCharArray()));
            for (Map.Entry mapentry : data.entrySet()) {
                System.out.println("clé: "+mapentry.getKey() + " | valeur: " + mapentry.getValue());
                if ( mapentry.getKey().equals("success")){
                    success = true;
                    text = mapentry.getValue().toString();
                }else if ( mapentry.getKey().equals("error") ){
                    error = true;
                    text = mapentry.getValue().toString();
                }
            }
        if( success ) {
           Dialog.show("Success",text,"OK",null);
           new ProfileForm(res).show();
        }
        else if( error ) {
           Dialog.show("Error",text,"OK",null);
        }
        else { Dialog.show("ERROR","Invalid Code","OK",null);}
        
        }catch(Exception ex) {
            ex.printStackTrace();
        }

        });
    
         //ba3d execution ta3 requete ely heya url nestanaw response ta3 server.
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
    
    public void editprofile(User user, Resources res){
        
        String url = Statics.BASE_URL+"/editProfile/mobile?username="+user.getUsername()+"&email="+user.getEmail()+
                "&password="+user.getPassword()+"&roles="+user.getRole()+"&firstname="+user.getNom()+
                "&lastname="+user.getPrenom()+"&phonenumber="+user.gettelephone()+"&id="+user.getId();
        
        req = new ConnectionRequest(url, false); //false ya3ni url mazlt matba3thtich lel server
        req.setUrl(url);
        req.setPost(true);
        req.addResponseListener((e) ->{
        JSONParser j = new JSONParser();
        String json = new String(req.getResponseData()) + "";
        boolean success = false;
        boolean error = false;
        String text = "";
        try {
            Map<String,Object> data = j.parseJSON(new CharArrayReader(json.toCharArray()));
            for (Map.Entry mapentry : data.entrySet()) {
                System.out.println("clé: "+mapentry.getKey() + " | valeur: " + mapentry.getValue());
                if ( mapentry.getKey().equals("success")){
                    success = true;
                    text = mapentry.getValue().toString();
                }else if ( mapentry.getKey().equals("error") ){
                    error = true;
                    text = mapentry.getValue().toString();
                }
            }
        if( success ) {
            
            SessionManager.setId((int)user.getId());//jibt id ta3 user ly3ml login w sajltha fi session ta3i
            SessionManager.setUserName(user.getUsername());
            SessionManager.setEmail(user.getEmail());
            SessionManager.setfirstname(user.getNom());
            SessionManager.setlastname(user.getPrenom());
            SessionManager.setphonenumber(user.gettelephone());

            String str = "ROLE_" + user.getRole();
            SessionManager.setrole(str);
            System.out.println(user);
           Dialog.show("Success",text,"OK",null);
           new ProfileForm(res).show();
        }
        else if( error ) {
           Dialog.show("Error",text,"OK",null);
        }
        else { Dialog.show("ERROR","please try again","OK",null);}
        
        }catch(Exception ex) {
            ex.printStackTrace();
        }

        });
    
         //ba3d execution ta3 requete ely heya url nestanaw response ta3 server.
        NetworkManager.getInstance().addToQueueAndWait(req);
        
    }

}
