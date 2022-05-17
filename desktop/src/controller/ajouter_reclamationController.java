/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.esprit.entities.Reclamation;
import tn.esprit.gui.DisplayEventsFrontController;
import tn.esprit.gui.DisplayReservationFrontController;
import tn.esprit.gui.SignUpController;
import tn.esprit.services.MailerService;
import tn.esprit.utils.Datasource;
import tn.esprit1.services.ReclamationService;

/**
 * FXML Controller class
 *
 * @author oasis
 */
public class ajouter_reclamationController implements Initializable {

    @FXML
    private HBox UsersBack;
    @FXML
    private Label btnProducts;
    @FXML
    private HBox order;
    @FXML
    private HBox eventsback;
    @FXML
    private HBox reservationBack;
    @FXML
    private HBox clicReclamation;
    @FXML
    private HBox clicCommunication;
    @FXML
    private HBox SignOutBack2;
    @FXML
    private Pane pane1;
    @FXML
    private ImageView myImageView;
    @FXML
    private Text ftTitle;
    @FXML
    private Text ftDescription;
    @FXML
    private Text ftcmde_ref;
    @FXML
    private Button ajouter;
    @FXML
    private Button consulter;
    Connection cnx = Datasource.getInstance().getCnx();
     ReclamationService rs = ReclamationService.getInstance();
    @FXML
    private TextField nom;
    @FXML
    private TextArea des;
    @FXML
    private ComboBox<String> fgg;
    private Connection conx = null; 
    private PreparedStatement pst = null ;
    private ResultSet rss = null ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection cnx = Datasource.getInstance().getCnx();
            rss = cnx.createStatement().executeQuery("SELECT ref_cmde FROM commande ");
            // Now add the comboBox addAll statement
           while (rss.next()){
            fgg.getItems().addAll(rss.getString("ref_cmde"));
           
           }
            } catch (SQLException ex) {
            Logger.getLogger(ajouter_reclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onUsersBack(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Profile.fxml"));

        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void goTOList(MouseEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("AllProductFront.fxml"));
        
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void goToList2(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AllProductFront.fxml"));
        
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onorder(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("orderAfficheFront.fxml"));
        
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     @FXML
    private void onevents(MouseEvent event) {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/DisplayEventsFront.fxml"));

        try {
            Parent root = Loader.load();
            DisplayEventsFrontController C = Loader.getController();
            C.getData();
            Scene productDetailScene = new Scene(root);
            Stage cineStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            cineStage.setScene(productDetailScene);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
  @FXML
    private void onreservation(MouseEvent event) {
       FXMLLoader Loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/DisplayReservationFront.fxml"));

        try {
            Parent root = Loader.load();
            DisplayReservationFrontController C = Loader.getController();
            C.getRes();
            Scene productDetailScene = new Scene(root);
            Stage cineStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            cineStage.setScene(productDetailScene);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void onReclamtionFront(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/ajouter_reclamation.fxml"));
        
        try {
            javafx.scene.Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void onCommunication(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/ajouter_message.fxml"));
        
        try {
            javafx.scene.Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onSignOut(MouseEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("SignIn.fxml"));
        
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void ajouter_reclamation(ActionEvent event) throws SQLException {
          if (nom.getText().isEmpty() || des.getText().isEmpty()) {
             nom.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
             des.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
               System.out.println("Fields Are Empty");
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Fill your fields !");
                alert.show(); 
                
               
    }else{
            String ttle = nom.getText();
            String Des = des.getText();
            
            ZoneId defaultZoneId = ZoneId.systemDefault();
           // Reclamation ev = new Reclamation(ttle, Des);
           // rs.ajouterPst(ev);
            System.err.println("Added Seccessfully");
            Connection cnx = Datasource.getInstance().getCnx();
            
            ResultSet rs6=null;
        
                String v= String.valueOf(fgg.getValue());
                rs6 = cnx.createStatement().executeQuery("SELECT id FROM commande where ref_cmde='"+v+"'");  
     
                rs6.next();
               int id1 = rs6.getInt("id");
               
               
            Reclamation ev = new Reclamation(ttle, Des,id1);
            rs.ajouterPst(ev); 
            MailerService ms = new MailerService();
          ms.replyMail("rihab.aljene@esprit.tn","Malek","Bonjour Madame votre réclamation a été ajoutée");
               
               
           
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Reclamation added successfuly!");
                alert.show();
                nom.setText("");
                des.setText("");
              

            }
    }

    @FXML
    private void consulter_reclamation(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/affichageFrontt.fxml"));
        
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ajouter_reclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
