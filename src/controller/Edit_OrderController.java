/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.SQLException;
import java.util.Locale;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static javax.swing.JOptionPane.showMessageDialog;
import tn.esprit.entities.Order;
import tn.esprit.services.OrderService;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class Edit_OrderController implements Initializable {


    @FXML
    private TextField codepostal;

    @FXML
    private Text etat;

    @FXML
    private Text etat1;

    private TextField etatt;

    @FXML
    private ImageView flesh2;

    @FXML
    private Button flesh_id;

    @FXML
    private TextField numero;

    @FXML
    private Text pays;

    private TextField payss;

    @FXML
    private Text reff;

    @FXML
    private TextField reffe;

    @FXML
    private TextField regio;

    @FXML
    private Text region;

    @FXML
    private AnchorPane show;


    @FXML
    private AnchorPane slider11;

    @FXML
    private Text tel;

    @FXML
    private Button update;
    @FXML
    private ComboBox<String> comboxL;
    @FXML
    private ComboBox<String> comboxS;
    @FXML
    private Label admin;
    @FXML
    private ImageView homeMarket;
    @FXML
    private Label home1;
    @FXML
    private ImageView cmde31;

    @FXML
    void abon(MouseEvent event) {

    }

    @FXML
    void cmde3(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/orderAfficheFront.fxml"));
            Stage stage = (Stage) flesh_id.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherOrderBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void fleshbutton(ActionEvent event) {
 try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/orderAfficheFront.fxml"));
            Stage stage = (Stage) flesh_id.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherOrderBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void form(MouseEvent event) {

    }

    @FXML
    void stat(MouseEvent event) {

    }

    @FXML
    void update_order2(ActionEvent event) throws SQLException {
        Boolean Etat;

        Order prom = new Order();
        prom.setRef_cmde(reffe.getText());
        prom.setTel(parseInt(numero.getText()));
        prom.setRegion(regio.getText());
        prom.setPays(comboxL.getValue());
        prom.setStatus(comboxS.getValue());
        prom.setCode_postal(parseInt(codepostal.getText()));

        System.out.println("hahahah");
        OrderService pr=OrderService.getInstance();
        pr.modifierPST(prom); 
        showMessageDialog(null, "update with succese");
        
              
                try {
                    Parent parent = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/orderAfficheFront.fxml"));
                    Scene scene = new Scene(parent);
                    Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                   
                } catch (IOException e) {
                    e.printStackTrace();
                }

            
    }
    /**
     * Initializes the controller class.
     */
    
     public void getLocation() {
        String[] countries = Locale.getISOCountries();

        // Loop each country 
        for (int i = 0; i < countries.length; i++) {

            String country = countries[i];
            Locale locale = new Locale("en", country);

            // Get the country name by calling getDisplayCountry()
            String countryName = locale.getDisplayCountry();
            // Printing the country name on the console
            System.out.println(i + 1 + " : " + countryName);
            comboxL.getItems().addAll(countryName);

        }

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        getLocation();
        comboxS.getItems().addAll(
            "Cancled",
            "in progress"
        );
        
        reffe.setText(AfficherOrderController.ref_order);
        numero.setText(String.valueOf(AfficherOrderController.num_order));
        regio.setText(AfficherOrderController.region_order);
        comboxL.setValue(AfficherOrderController.pays_order);
        comboxS.setValue(String.valueOf(AfficherOrderController.status_order));
        codepostal.setText(String.valueOf(AfficherOrderController.code_order));


    }    

    @FXML
    private void deco(MouseEvent event) {
    }

    @FXML
    private void homeMarket(MouseEvent event) {
    }

    
}
