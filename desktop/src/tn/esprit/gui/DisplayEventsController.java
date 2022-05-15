/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tn.esprit.gui;

import controller.ListOfProductController;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import tn.esprit.entities.Evenement;
import tn.esprit.services.EvenementService;

/**
 * FXML Controller class
 *
 * @author sami
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

    EvenementService es = new EvenementService();
    Evenement e = new Evenement();
    @FXML
    private TableColumn<Evenement, String> NameEvent;
    @FXML
    private TableColumn<Evenement, String> PlaceEvent;
    @FXML
    private TableColumn<Evenement, Float> PriceEvent;
    @FXML
    private TableColumn<Evenement, Integer> Participants;
    @FXML
    private TableColumn<Evenement, String> Begins;
    @FXML
    private TableColumn<Evenement, String> Ends;

    ObservableList<Evenement> events;
    private boolean isLightMode = true;

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
    @FXML
    private Button print;
    @FXML
    private AnchorPane parent;
    @FXML
    private Label btnProducts;
    @FXML
    private Label goCat;
    @FXML
    private HBox UsersBack;
    @FXML
    private HBox order;
    @FXML
    private HBox commentsback;
    @FXML
    private HBox tagsback;
    @FXML
    private HBox eventsback;
    @FXML
    private HBox reservationBack;
    @FXML
    private HBox SignOutBack;
    @FXML
    private HBox backCom;
    @FXML
    private HBox ReclamBack;

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

    public void getEvents() {
        nameError.setVisible(false);
        partError.setVisible(false);
        placeError.setVisible(false);
        priceError.setVisible(false);
        beginsError.setVisible(false);
        endError.setVisible(false);

        NameEvent.setCellValueFactory(new PropertyValueFactory<Evenement, String>("NameEvent"));
        PlaceEvent.setCellValueFactory(new PropertyValueFactory<Evenement, String>("PlaceEvent"));
        PriceEvent.setCellValueFactory(new PropertyValueFactory<Evenement, Float>("PriceEvent"));
        Participants.setCellValueFactory(new PropertyValueFactory<Evenement, Integer>("NbParticipants"));
        Begins.setCellValueFactory(new PropertyValueFactory<Evenement, String>("DateDebut"));
        Ends.setCellValueFactory(new PropertyValueFactory<Evenement, String>("DateFin"));
        EvenementService es = new EvenementService();
        events = es.FetchEvents();
        System.out.println(events);
        tableviewEvents.setItems(events);

    }//get events

    @FXML
    private void DeleteEvent(ActionEvent event) {

        Evenement e = tableviewEvents.getItems().get(tableviewEvents.getSelectionModel().getSelectedIndex());
        es.DeleteEvent(e.getId());
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information ");
        alert.setHeaderText("Event delete");
        alert.setContentText("Event deleted successfully!");
        alert.showAndWait();
        getEvents();

    }

    private boolean NoDate() {
        boolean test = true;
        System.out.println(ChronoUnit.DAYS.between(this.BeginsAtdate.getValue(), this.EndsAtdate.getValue()));

        int a = (int) ChronoUnit.DAYS.between(this.BeginsAtdate.getValue(), this.EndsAtdate.getValue());
        int b = (int) ChronoUnit.DAYS.between(LocalDate.now(), this.BeginsAtdate.getValue());
        System.out.println("aaaaaaaaaa" + b);
        if (a < b) //begin akber
        {

            test = false;

        }
        return test;
    }

    @FXML
    private void AddEvent(ActionEvent event) {
        int part;
        float price;
        String name, place;
        //BeginsAtdate.setValue(LocalDate.now());
        if ((NameEventtf.getText().length() == 0) || (PlaceEventtf.getText().length() == 0) || (PriceEventtf.getText().length() == 0) || (Participantstf.getText().length() == 0)) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error ");
            alert.setHeaderText("Error!");
            alert.setContentText("Fields cannot be empty");
            alert.showAndWait();
        } else if (NoDate() == false) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error ");
            alert.setHeaderText("Error!");
            alert.setContentText("End date should be greater than begin date");
            alert.showAndWait();
        } else {

            try {
                part = Integer.parseInt(Participantstf.getText());
                partError.setVisible(false);
            } catch (Exception exc) {
                System.out.println("Number of participants int");
                partError.setVisible(true);
                return;
            }
            try {
                price = Float.parseFloat(PriceEventtf.getText());
                priceError.setVisible(false);
            } catch (NumberFormatException exc) {
                System.out.println("price float");
                priceError.setVisible(true);
                return;
            }
            try {
                name = String.valueOf(NameEventtf.getText());
                nameError.setVisible(false);
            } catch (Exception exc) {
                System.out.println("name exception");
                nameError.setVisible(true);
                return;
            }
            try {
                place = String.valueOf(PlaceEventtf.getText());
                placeError.setVisible(false);
            } catch (Exception exc) {
                System.out.println("name exception");
                placeError.setVisible(true);
                return;
            }
            Evenement ev = new Evenement(NameEventtf.getText(), PlaceEventtf.getText(), Integer.valueOf(Participantstf.getText()), Float.valueOf(PriceEventtf.getText()), String.valueOf(BeginsAtdate.getValue()), String.valueOf(EndsAtdate.getValue()));
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

        ObservableList<Evenement> ev = tableviewEvents.getSelectionModel().getSelectedItems();
        e = es.FetchOneEvent(ev.get(0).getId());
        System.out.println("hedha howa " + ev);
        try {

            this.idLabel.setText(String.valueOf(e.getId()));
            this.NameEventtf.setText(String.valueOf(e.getNameEvent()));
            System.out.println("haya" + e.getNameEvent());
            this.PlaceEventtf.setText(String.valueOf(e.getPlaceEvent()));
            System.out.println("haya" + e.getPlaceEvent());
            this.Participantstf.setText(String.valueOf(e.getNbParticipants()) + "");
            System.out.println("haya" + e.getNbParticipants());
            this.PriceEventtf.setText(String.valueOf(e.getPriceEvent()) + "");
            System.out.println("haya" + e.getPriceEvent());
            this.BeginsAtdate.setValue(LocalDate.parse(e.getDateDebut()));
            System.out.println("haya" + LocalDate.parse(e.getDateDebut()));
            this.EndsAtdate.setValue(LocalDate.parse(e.getDateFin()));
            System.out.println("haya" + LocalDate.parse(e.getDateFin()));
        } catch (Exception ex) {
            System.out.println("fama ghalta");
        }

    }

    @FXML
    private void UpdateEvent(ActionEvent event) {
        try {

            Date DateDebut = Date.valueOf(this.BeginsAtdate.getValue());
            Date DateFin = Date.valueOf(this.EndsAtdate.getValue());
            Evenement up = new Evenement(Integer.valueOf(this.idLabel.getText()), this.NameEventtf.getText(), this.PlaceEventtf.getText(), Integer.valueOf(this.Participantstf.getText()), Float.valueOf(this.PriceEventtf.getText()), String.valueOf(DateDebut), String.valueOf(DateFin));
            es.EditEvent(up);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information ");
            alert.setHeaderText("Event update");
            alert.setContentText("Event updated successfully!");
            alert.showAndWait();
            getEvents();
        } catch (Exception ex) {
            System.out.println("fama ghalta2");
        }
        NameEventtf.clear();
        PlaceEventtf.clear();
        Participantstf.clear();
        PriceEventtf.clear();
        BeginsAtdate.setValue(null);
        EndsAtdate.setValue(null);

    }

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
        ObservableList<Evenement> ob = es.FindEventByName(this.SearchEvent.getText());
        System.out.println(ob);
        tableviewEvents.setItems(ob);

    }

    @FXML
    private void printEvents(ActionEvent event) {
        es.GeneratePDF();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information ");
        alert.setHeaderText("Events pdf");
        alert.setContentText("Check for the pdf !!");
        alert.showAndWait();
    }

    private void showEventsBack(ActionEvent event) {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("DisplayEvents.fxml"));

        try {
            Parent root = Loader.load();
            DisplayEventsController C = Loader.getController();
            C.getEvents();
            Scene productDetailScene = new Scene(root);
            Stage cineStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            cineStage.setScene(productDetailScene);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void goToList2(MouseEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/ListOfProduct.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
           
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void goListCat(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/ListOfCategory.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
           
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onUsersBack(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/DisplayUsersBack.fxml"));
        
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
    private void goTOList(javafx.scene.input.MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/ListOfProduct.fxml"));
        
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
    private void onorder(javafx.scene.input.MouseEvent event) {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/orderAffiche.fxml"));
        
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
    private void oncomments(javafx.scene.input.MouseEvent event) {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/CommentsBack.fxml"));
        
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
    private void ontags(javafx.scene.input.MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/TagsBack.fxml"));
        
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
    private void onSignOut(javafx.scene.input.MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/SignIn.fxml"));
        
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
    private void OnReclamation(javafx.scene.input.MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/AffichageBack.fxml"));
        
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
    private void OnCommunication(javafx.scene.input.MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/ListMessage.fxml"));
        
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
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/DisplayEvents.fxml"));

        try {
            Parent root = Loader.load();
            DisplayEventsController C = Loader.getController();
            C.getEvents();
            Scene productDetailScene = new Scene(root);
            Stage cineStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            cineStage.setScene(productDetailScene);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
     
     @FXML
    private void onreservation(MouseEvent event) {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/DisplayReservations.fxml"));

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

}
