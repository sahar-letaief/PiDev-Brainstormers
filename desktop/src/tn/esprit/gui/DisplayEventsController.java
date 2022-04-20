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
    private DatePicker BeginsAtdate= new DatePicker();
    @FXML
    private DatePicker EndsAtdate= new DatePicker();
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableviewEvents.setFocusTraversable(false);
        getEvents();
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
      
        
        ObservableList<Evenement> e=tableviewEvents.getSelectionModel().getSelectedItems();
        es.FetchOneEvent(e.get(0).getId());
            System.out.println("hedha howa " +e);

      this.NameEventtf.setText(e.get(1).getNameEvent());
       this.PlaceEventtf.setText(e.get(2).getPlaceEvent());
       this.Participantstf.setText(e.get(3).getPriceEvent()+"");
       this.PriceEventtf.setText(e.get(4).getNbParticipants()+"");
       this.BeginsAtdate.setValue(LocalDate.parse(e.get(5).getDateDebut()));
         this.EndsAtdate.setValue(LocalDate.parse(e.get(6).getDateFin()));
         
       
    }

    @FXML
    private void UpdateEvent(ActionEvent event) {
         e.setNameEvent(NameEventtf.getText());
      e.setPlaceEvent(PlaceEventtf.getText());
      e.setNbParticipants(Integer.valueOf(Participantstf.getText()));
       e.setPriceEvent(Float.valueOf(PriceEventtf.getText()));
  
          Date DateDebut = Date.valueOf(this.BeginsAtdate.getValue());
   Date DateFin = Date.valueOf(this.EndsAtdate.getValue());
  e.setDateDebut(String.valueOf(DateDebut));
  e.setDateFin(String.valueOf(DateFin));
  es.EditEvent(e);
   Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information ");
            alert.setHeaderText("Event update");
            alert.setContentText("Event updated successfully!");
            alert.showAndWait();
             events= es.FetchEvents();
        System.out.println(events);
        tableviewEvents.setItems(events); 
  //getEvents();
    }
} //class