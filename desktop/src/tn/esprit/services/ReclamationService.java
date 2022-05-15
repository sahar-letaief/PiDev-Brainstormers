/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit1.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart.Data;
import tn.esprit.entities.Order;
import tn.esprit.entities.Reclamation;
import tn.esprit.utils.Datasource;

/**
 *
 * @author oasis
 */
public class ReclamationService {

  
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private static ReclamationService instance;


    public ReclamationService() {
        //Récupération de la connection à la base de données
        cnx = Datasource.getInstance().getCnx();
        
    }
         public void modifier(Reclamation t){
        String req="update reclamation set description =?  where title=? ";
        try {
            pst=cnx.prepareStatement(req);
            
           
           
            pst.setString(1,t.getDescription());
        
            
            pst.setString(2,t.getTitle());
          

           
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
          
        }
        
    }
    public void ajouterPst(Reclamation p) {
        String requete = "INSERT INTO `reclamation` (`Title`,`Description`,`reference_id`) VALUES (?,?,?);";
        
        try {
            pst = cnx.prepareStatement(requete);
            pst.setString(1, p.getTitle());
            pst.setString(2, p.getDescription());
           pst.setInt(3, p.getC());
          pst.executeUpdate();
            System.out.println("réclamation ajoutée");
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public List<Reclamation> afficher(){
        List<Reclamation> reclamations = new ArrayList<>();
        String req = "SELECT reclamation.*, commande.* FROM reclamation  left join commande  ON commande.id=reclamation.reference_id";
            //Reclamation c =new Reclamation();
        try {
         //   ste = cnx.createStatement();
         Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(req);
            
            while(rs.next()){   
                Order c = new Order(rs.getInt("id"), rs.getString("ref_cmde"), rs.getString("pays")); 
                reclamations.add(new Reclamation(rs.getString("Title"), rs.getString("Description"),rs.getString("status")));
            }           
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reclamations;
    }
   
    public List<Reclamation> afficherBack(){
        List<Reclamation> reclamations = new ArrayList<>();
        String req = "SELECT reclamation.*, commande.* FROM reclamation  left join commande  ON commande.id=reclamation.reference_id";
            //Reclamation c =new Reclamation()
         /* String reclamationaccept="accept";
          String reclamationrefus="refus";
          if (){
          };*/
          
        try {
         //   ste = cnx.createStatement();
         Statement s = cnx.createStatement();
            ResultSet rs =  s.executeQuery(req);
            
            while(rs.next()){   
                Order c = new Order(rs.getString("ref_cmde")); 
                reclamations.add(new Reclamation(rs.getString("Title"), rs.getString("Description"),rs.getString("Status"), rs.getTimestamp("create_date"),rs.getTimestamp("create_resolution"),c));
            }           
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reclamations;
    }

    

    public void supprimer(String t ){
            String req="delete from reclamation where title='" + t + "'";
            System.out.println("produit supprimé");
          
                try {
            pst=cnx.prepareStatement(req);
           
            pst.executeUpdate();    
                }
            catch (SQLException ex) {
                Logger.getLogger(Reclamation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
     /* public ReclamationService() {
        DataSource1 cs = DataSource1.getInstance();
        try {
            ste = cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    public void ajouterStatus(Reclamation p) {
        String requete = "INSERT INTO `reclamation` (`status`,`Title`,`Description`) VALUES (?,?,?);";
        
        try {
            pst = cnx.prepareStatement(requete);
            pst.setString(1, p.getStatus());
            pst.setString(2, p.getTitle());
            pst.setString(3, p.getDescription());
            
//            pst.setInt(3, p.getCmde().getId());
          pst.executeUpdate();
            System.out.println("status ajoutée");
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ReclamationService getInstance() {
        if(instance == null){
            instance = new ReclamationService();
        }
        return instance;
    } 
    public void modifierStatus(Reclamation t){
        String req="update reclamation set description =?,status =?  where title=? ";
        try {
            pst=cnx.prepareStatement(req);
            
            
            pst.setString(1,t.getDescription());
             pst.setString(2,t.getStatus());
            
            pst.setString(3,t.getTitle());
          

           
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
          
        }
   
    }
}

