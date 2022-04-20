/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import static java.lang.String.format;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import tn.esprit.entities.Evenement;
import tn.esprit.services.EvenementService;

/**
 * FXML Controller class
 *
 * @author WIKI
 */
public class DisplayEventsController implements Initializable {

    @FXML
    private TextField NameEventtf;
    @FXML
    private TextField PlaceEventtf;
    @FXML
    private TextField PriceEventtf;
    @FXML
    private TextField Participantstf;
    @FXML
    private DatePicker BeginsAtdate;
    @FXML
    private DatePicker EndsAtdate;
    @FXML
    private TextField SearchEvent;
    @FXML
    private TableView<Evenement> tableviewEvents;
    
      EvenementService es=new EvenementService();
     Evenement e = new Evenement();
    @FXML
    private TableColumn<Evenement, String> NameEvent;
    @FXML
    private TableColumn<Evenement, String> PlaceEvent;
    @FXML
    private TableColumn<Evenement, Float> PriceEvent;
    @FXML
    private TableColumn <Evenement ,Integer> Participants;
    @FXML
    private TableColumn<Evenement, String> Begins ;
    @FXML
    private TableColumn<Evenement, String> Ends;
    public TableColumn edit;
    public TableColumn Delete;
      ObservableList<Evenement> events ;
    @FXML
    private Button deletebtn;
    @FXML
    private Label nameError;
    @FXML
    private Label placeError;
    @FXML
    private Label priceError;
    @FXML
    private Label partError;
    @FXML
    private Label beginsError;
    @FXML
    private Label endError;
    @FXML
    private Label idLabel;
    @FXML
    private Button clear;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableviewEvents.setFocusTraversable(false);
        getEvents();
        idLabel.setVisible(false);
       // BeginsAtdate.setValue(LocalDate.now());
    }    
    public void getEvents(){
         nameError.setVisible(false);
         partError.setVisible(false);
         placeError.setVisible(false);
          priceError.setVisible(false);
          beginsError.setVisible(false);
          endError.setVisible(false);
         
          
         NameEvent.setCellValueFactory(new PropertyValueFactory<Evenement,String>("NameEvent"));
        PlaceEvent.setCellValueFactory(new PropertyValueFactory<Evenement,String>("PlaceEvent"));
         PriceEvent.setCellValueFactory(new PropertyValueFactory<Evenement,Float>("PriceEvent"));
          Participants.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("NbParticipants"));
           Begins.setCellValueFactory(new PropertyValueFactory<Evenement,String>("DateDebut"));
            Ends.setCellValueFactory(new PropertyValueFactory<Evenement,String>("DateFin"));
       EvenementService es=new EvenementService();
       events= es.FetchEvents();
        System.out.println(events);
        tableviewEvents.setItems(events); 
    
                  
                  }//get events                

    @FXML
    private void DeleteEvent(ActionEvent event) {
 
    Evenement e=tableviewEvents.getItems().get(tableviewEvents.getSelectionModel().getSelectedIndex());
        es.DeleteEvent(e.getId());
         Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information ");
            alert.setHeaderText("Event delete");
            alert.setContentText("Event deleted successfully!");
            alert.showAndWait();
         getEvents();

    }
        private boolean NoDate(){
     boolean  test=true;
      System.out.println(ChronoUnit.DAYS.between(this.BeginsAtdate.getValue(), this.EndsAtdate.getValue()));  
      
         int a=(int) ChronoUnit.DAYS.between(this.BeginsAtdate.getValue(), this.EndsAtdate.getValue());
         int b=(int) ChronoUnit.DAYS.between(LocalDate.now(), this.BeginsAtdate.getValue());
        System.out.println("aaaaaaaaaa"+b);
    if (a<b) //begin akber
    {
  
        test=false;
        
    }
    return test;
    }

    @FXML
    private void AddEvent(ActionEvent event) {
        int part;
        float price;
        String name,place;
        //BeginsAtdate.setValue(LocalDate.now());
         if ((NameEventtf.getText().length()==0)||(PlaceEventtf.getText().length()==0)||(PriceEventtf.getText().length()==0)||(Participantstf.getText().length()==0))
                { Alert alert = new Alert(AlertType.ERROR);
                   alert.setTitle("Error ");
                    alert.setHeaderText("Error!");
                    alert.setContentText("Fields cannot be empty");
                    alert.showAndWait();}
         
         else if (NoDate()== false){
                   Alert alert = new Alert(AlertType.ERROR);
                   alert.setTitle("Error ");
                    alert.setHeaderText("Error!");
                    alert.setContentText("End date should be greater than begin date");
                    alert.showAndWait();
         }
         else{
             
           
            
         try{
            part = Integer.parseInt(Participantstf.getText());
            partError.setVisible(false);
        }catch(Exception exc){
            System.out.println("Number of participants int");
            partError.setVisible(true);
            return;
        }   
          try{
            price = Float.parseFloat(PriceEventtf.getText());
            priceError.setVisible(false);
        }catch(NumberFormatException exc){
            System.out.println("price float");
            priceError.setVisible(true);
            return;
        }   
           try{
            name = String.valueOf(NameEventtf.getText());
            nameError.setVisible(false);
        }catch(Exception exc){
            System.out.println("name exception");
            nameError.setVisible(true);
            return;
        }  
           try{
            place = String.valueOf(PlaceEventtf.getText());
            placeError.setVisible(false);
        }catch(Exception exc){
            System.out.println("name exception");
            placeError.setVisible(true);
            return;
        } 
            Evenement ev=new Evenement(NameEventtf.getText(),PlaceEventtf.getText(),Integer.valueOf(Participantstf.getText()),Float.valueOf(PriceEventtf.getText()),String.valueOf(BeginsAtdate.getValue()),String.valueOf(EndsAtdate.getValue()));
         es.AddEvent(ev);
         getEvents();
          //FXMLLoader loader = new FXMLLoader(getClass().getResource("DisplayEvents.fxml"));
          Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information ");
            alert.setHeaderText("Event add");
            alert.setContentText("Event added successfully!");
            alert.showAndWait();
         }
        
    }

    @FXML
    private void ShowOneEvent(ActionEvent event) {
      
        ObservableList<Evenement> ev=tableviewEvents.getSelectionModel().getSelectedItems();
        e= es.FetchOneEvent(ev.get(0).getId());
            System.out.println("hedha howa " +ev);
        try{
        
        this.idLabel.setText(String.valueOf(e.getId()));
        this.NameEventtf.setText(String.valueOf(e.getNameEvent()));
        System.out.println("haya"+e.getNameEvent());
       this.PlaceEventtf.setText(String.valueOf(e.getPlaceEvent()));
        System.out.println("haya"+e.getPlaceEvent());
       this.Participantstf.setText(String.valueOf(e.getNbParticipants())+"");
        System.out.println("haya"+e.getNbParticipants());
       this.PriceEventtf.setText(String.valueOf(e.getPriceEvent())+"");
        System.out.println("haya"+e.getPriceEvent());
       this.BeginsAtdate.setValue(LocalDate.parse(e.getDateDebut()));
        System.out.println("haya"+LocalDate.parse(e.getDateDebut()));
         this.EndsAtdate.setValue(LocalDate.parse(e.getDateFin()));
         System.out.println("haya"+LocalDate.parse(e.getDateFin()));
        } catch(Exception ex){
            System.out.println("fama ghalta");
        }
       
    }

    @FXML
    private void UpdateEvent(ActionEvent event) {
      //  Evenement upe=new Evenement();
        try{
         //upe.setNameEvent(NameEventtf.getText());
     // upe.setPlaceEvent(PlaceEventtf.getText());
     // upe.setNbParticipants(Integer.valueOf(Participantstf.getText()));
      // upe.setPriceEvent(Float.valueOf(PriceEventtf.getText()));
  
          Date DateDebut = Date.valueOf(this.BeginsAtdate.getValue());
   Date DateFin = Date.valueOf(this.EndsAtdate.getValue());
 // upe.setDateDebut(String.valueOf(DateDebut));
  //upe.setDateFin(String.valueOf(DateFin));
  Evenement up=new Evenement(Integer.valueOf(this.idLabel.getText()),this.NameEventtf.getText(),this.PlaceEventtf.getText(),Integer.valueOf(this.Participantstf.getText()),Float.valueOf(this.PriceEventtf.getText()),String.valueOf(DateDebut),String.valueOf(DateFin));
  es.EditEvent(up);
   Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information ");
            alert.setHeaderText("Event update");
            alert.setContentText("Event updated successfully!");
            alert.showAndWait();
            getEvents();
        } catch(Exception ex){
            System.out.println("fama ghalta2");
        }
       NameEventtf.clear();
       PlaceEventtf.clear();
       Participantstf.clear();
       PriceEventtf.clear();
       BeginsAtdate.setValue(null);
       EndsAtdate.setValue(null);
       
    }

    @FXML
    private void ShowResevationsBack(ActionEvent event) {
         FXMLLoader Loader = new FXMLLoader(getClass().getResource("DisplayReservations.fxml"));

        try {
            Parent root = Loader.load();
            DisplayReservationsController C = Loader.getController();
           C.getRes();
            Scene productDetailScene = new Scene(root);
            Stage cineStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            cineStage.setScene(productDetailScene);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void clearLabels(ActionEvent event) {
         NameEventtf.clear();
       PlaceEventtf.clear();
       Participantstf.clear();
       PriceEventtf.clear();
       BeginsAtdate.setValue(null);
       EndsAtdate.setValue(null);
    }

    @FXML
    private void searchEvent(ActionEvent event) {
        ObservableList<Evenement> ob=es.FindEventByName(this.SearchEvent.getText());
        
        System.out.println(ob);
        tableviewEvents.setItems(ob); 
    }
        
        
    
} //class