/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tn.esprit.services.UserServices;
import tn.esprit.utils.Datasource;
import tn.esprit.entities.User;

/**
 *
 * @author Yassine
 */
public class Main   {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       
        // TODO code application logic here
        UserServices Us = new UserServices();
        //User user = new User(53, "yasstass@gmail.com","FREQFREQ","yassine","bensalha", 54769189 , "Salwaghozzi10" , "ROLE_USER" );
        //Us.addUser(user);
        //System.out.println(Us.displayUsers());
       // Us.UpdateUser(user);
       //Us.deleteUser(48);
        
        //Argon2 argon2 = Argon2Factory.create();
    }

   

}
