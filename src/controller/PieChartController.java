/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import tn.esprit.entities.Category;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tn.esprit.services.ServiceCategory;


/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class PieChartController implements Initializable {

    @FXML
    private PieChart pieChart;
    ObservableList<PieChart.Data> list=FXCollections.
            observableArrayList();
    @FXML
    private Button back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ServiceCategory pdao=ServiceCategory.getInstance();
        List<Category> pers=pdao.afficher();
        for(Category p:pers) {
            list.addAll(
                new PieChart.Data(p.getName(), 12.0)             
        );
        }
        pieChart.setAnimated(true);
        pieChart.setData(list);
        // TODO
    }    

    @FXML
    private void back(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/ListOfProduct.fxml"));
            Stage stage = (Stage) back.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


   
}    
    

