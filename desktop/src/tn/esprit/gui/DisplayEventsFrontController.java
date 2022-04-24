/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tn.esprit.entities.Evenement;
import tn.esprit.entities.Reservation;
import tn.esprit.gui.MainEventsFront;
import tn.esprit.services.EvenementService;
import tn.esprit.services.ReservationService;

/**
 * FXML Controller class
 *
 * @author WIKI
 */
public class DisplayEventsFrontController implements Initializable {

    @FXML
    private VBox chosenEventCard;
    @FXML
    private Label EventNameLablel;
    @FXML
    private Label EventPriceLabel;
    @FXML
    private Label EventPlaceLabel;
    @FXML
    private Label NbParticipants;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    
    private List<Evenement> events = new ArrayList<>();
    private List<Evenement> events2 = new ArrayList<>();
    private List<Evenement> events3 = new ArrayList<>();
    
    
    EvenementService es=new EvenementService();
    ReservationService rs=new ReservationService();
    
   
    private MyListener myListener;
    @FXML
    private Label DateDebutLabel;
    @FXML
    private Label DateFinLabel;
    @FXML
    private Button MyReservations;
    @FXML
    private Label idLabel;
    @FXML
    private ImageView QrCode;
    @FXML
    private Button Search;
    @FXML
    private Button sort;
    @FXML
    private TextField searchlabel;
    @FXML
    private Button addRes;
    
   
    
    
    /**
     * Initializes the controller class.
     */
    
    public List<Evenement> getData() {
        List<Evenement> data = new ArrayList<>();
        data=es.FetchEventsFront();
        System.out.println("hedhi"+data);
        Evenement e=new Evenement();
        e.setId(e.getId());
        e.setNameEvent(e.getNameEvent());
        e.setPriceEvent(e.getPriceEvent());
        e.setPlaceEvent(e.getPlaceEvent());
        e.setDateDebut(e.getDateDebut());
        e.setDateFin(e.getDateFin());
        data.add(e);
        return data;
    }
    
    public List<Evenement> getDataSort() {
        List<Evenement> dataSort = new ArrayList<>();
        dataSort=es.SortEventByPrice();
        System.out.println("hedhi sorted"+dataSort);
        Evenement e=new Evenement();
        e.setId(e.getId());
        e.setNameEvent(e.getNameEvent());
        e.setPriceEvent(e.getPriceEvent());
        e.setPlaceEvent(e.getPlaceEvent());
        e.setDateDebut(e.getDateDebut());
        e.setDateFin(e.getDateFin());
        dataSort.add(e);
        return dataSort;
    }
      public List<Evenement> getDataSearch() {
        List<Evenement> dataSearch = new ArrayList<>();
        dataSearch=es.FindEventByNameFront(this.searchlabel.getText());
        System.out.println("hedhi sorted"+dataSearch);
        Evenement e=new Evenement();
        e.setId(e.getId());
        e.setNameEvent(e.getNameEvent());
        e.setPriceEvent(e.getPriceEvent());
        e.setPlaceEvent(e.getPlaceEvent());
        e.setDateDebut(e.getDateDebut());
        e.setDateFin(e.getDateFin());
        dataSearch.add(e);
        return dataSearch;
    }
 private void setChosenEvent(Evenement e) throws IOException {
        EventNameLablel.setText(e.getNameEvent());
        EventPriceLabel.setText(e.getPriceEvent()+MainEventsFront.CURRENCY );
        EventPlaceLabel.setText(e.getPlaceEvent());
        NbParticipants.setText(e.getNbParticipants()+"");
        DateDebutLabel.setText(e.getDateDebut());
        DateFinLabel.setText(e.getDateFin());
        idLabel.setText(e.getId()+"");
         if( NbParticipants.getText().equals("0")){
            addRes.setVisible(false);
        }
         else{
             addRes.setVisible(true);
         }
        try{
            
        
        String filename=es.GenerateQrEvent(e);
        System.out.println("filename lenaaa "+filename);
        Image image=new Image(getClass().getResourceAsStream("/tn/esprit/utils/img/"+filename));
        QrCode.setImage(image);
  
        } catch(Exception ex){
            System.out.println("mafamesh qr");
        }
       
        chosenEventCard.setStyle("-fx-background-color: #DEEFBD" + ";\n" +
                "    -fx-background-radius: 30;");
    }
   @Override
    public void initialize(URL location, ResourceBundle resources) {
        idLabel.setVisible(false);
        events2.clear();
         grid.getChildren().clear();
        System.out.println("clear events sorted 2"+events2);
       events.addAll(getData());
       System.out.println("init"+events);
        if (events.size() > 0) {
            try {
                setChosenEvent(events.get(0));
            } catch (IOException ex) {
                Logger.getLogger(DisplayEventsFrontController.class.getName()).log(Level.SEVERE, null, ex);
            }
            myListener = new MyListener() {
               
                @Override
                public void onClickListener(Evenement e) {
                    try {
                        setChosenEvent(e);
                    } catch (IOException ex) {
                        Logger.getLogger(DisplayEventsFrontController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < events.size()-1; i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("EventItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                EventItemController EIC = fxmlLoader.getController();
                 EIC.setData(events.get(i),myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void AddReservation(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        List<Evenement> ev=new ArrayList<Evenement>();
        ev=es.FetchEventsFront();
        System.out.println("ev "+ev);
         Evenement e=new Evenement(Integer.valueOf(this.idLabel.getText()),this.EventNameLablel.getText(),this.EventPlaceLabel.getText(),Integer.parseInt(this.NbParticipants.getText()),Float.parseFloat(this.EventPriceLabel.getText().substring(0, 4)),this.DateDebutLabel.getText(),this.DateFinLabel.getText());
       if(rs.ReservationTest(e)==null){
           System.out.println("reservation mawjouda");
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Information ");
           alert.setHeaderText("Reservation error");
           alert.setContentText("Reservation already done,check the list of reservations!");
           alert.showAndWait();
       }
       else{
           
           System.out.println("reservation moush mawjouda");
           Reservation r=new Reservation(Integer.valueOf(this.idLabel.getText()),1);
           rs.AddReservation(r);
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Information ");
           alert.setHeaderText("Reservation add");
           alert.setContentText("Reservation added successfully!");
           alert.showAndWait();
           events.addAll(getData());
           return;
       }
      // grid.getChildren().clear();
       
         /* for(int i=0;i<ev.size();i++){
            int x=0;
            while(x==0){
             if(this.EventNameLablel.getText()==rs.ReservationTest(ev.get(i)).getNameEvent()) { //reservation deja existante
            //System.out.println("event tawa "+e);
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information ");
            alert.setHeaderText("Reservation error");
            alert.setContentText("Reservation already done,check the list of reservations!");
            alert.showAndWait();
            x++;
             }
            
        
        else {
     
       System.out.println("event tawa 2 "+e);
       Reservation r=new Reservation(e.getId(),1);
        rs.AddReservation(r);
           events.addAll(getData());
           //System.out.println("apres modif"+events.get(4).getNbParticipants());
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information ");
            alert.setHeaderText("Reservation add");
            alert.setContentText("Reservation added successfully!");
            alert.showAndWait();
        x++;
                }
        }
        }
        /*System.out.println("actuelllll "+e); 
        System.out.println("eli hashti bihhhh "+rs.ReservationTest(ev));*/
           
       
    }

    @FXML
    private void DisplayReservationsFront(ActionEvent event) {
      
       FXMLLoader Loader = new FXMLLoader(getClass().getResource("DisplayReservationFront.fxml"));

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
    private void SearchEvent(ActionEvent event) {
        idLabel.setVisible(false);
         events.clear();
         events2.clear();
         events3.clear();
       grid.getChildren().clear();
         //System.out.println("clear events "+events);
       events3.addAll(getDataSearch());
         System.out.println("search"+events3);
       if(this.searchlabel.getText().equals("")){
           events.addAll(getData());
       }
       else{
        if (events3.size() > 0) {
            try {
                setChosenEvent(events3.get(0));
            } catch (IOException ex) {
                Logger.getLogger(DisplayEventsFrontController.class.getName()).log(Level.SEVERE, null, ex);
            }
            myListener = new MyListener() {
               
                @Override
                public void onClickListener(Evenement e) {
                    try {
                        setChosenEvent(e);
                    } catch (IOException ex) {
                        Logger.getLogger(DisplayEventsFrontController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < events3.size()-1; i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("EventItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                EventItemController EIC = fxmlLoader.getController();
                 EIC.setData(events3.get(i),myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       }
    }

    @FXML
    private void SortByPrice(ActionEvent event) {
         idLabel.setVisible(false);
         events.clear();
        grid.getChildren().clear();
         System.out.println("clear events "+events);
       events.addAll(getDataSort());
       System.out.println("init"+events);
        if (events.size() > 0) {
            try {
                setChosenEvent(events.get(0));
            } catch (IOException ex) {
                Logger.getLogger(DisplayEventsFrontController.class.getName()).log(Level.SEVERE, null, ex);
            }
            myListener = new MyListener() {
               
                @Override
                public void onClickListener(Evenement e) {
                    try {
                        setChosenEvent(e);
                    } catch (IOException ex) {
                        Logger.getLogger(DisplayEventsFrontController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < events.size()-1; i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("EventItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                EventItemController EIC = fxmlLoader.getController();
                 EIC.setData(events.get(i),myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}