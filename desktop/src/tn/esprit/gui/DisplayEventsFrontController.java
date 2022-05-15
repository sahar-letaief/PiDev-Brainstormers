/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tn.esprit.gui;

import controller.ListOfProductController;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tn.esprit.entities.Evenement;
import tn.esprit.entities.Reservation;
import tn.esprit.services.EvenementService;
import tn.esprit.services.ReservationService;

/**
 * FXML Controller class
 *
 * @author sami
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

    EvenementService es = new EvenementService();
    ReservationService rs = new ReservationService();

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
    @FXML
    private Button moreDetails;
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
    private HBox SignOutBack;
    @FXML
    private HBox clicReclamation;
    @FXML
    private HBox clicCommunication;

    /**
     * Initializes the controller class.
     */
    public List<Evenement> getData() {
        List<Evenement> data = new ArrayList<>();
        data = es.FetchEventsFront();
        System.out.println("hedhi" + data);
        Evenement e = new Evenement();
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
        dataSort = es.SortEventByPrice();
        System.out.println("hedhi sorted" + dataSort);
        Evenement e = new Evenement();
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
        dataSearch = es.FindEventByNameFront(this.searchlabel.getText());
        System.out.println("hedhi by name" + dataSearch);
        Evenement e = new Evenement();
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
        Evenement EventPie = new Evenement();
        int nbPie = 0;
        EventNameLablel.setText(e.getNameEvent());
        EventPriceLabel.setText(e.getPriceEvent() + "DT");
        EventPlaceLabel.setText(e.getPlaceEvent());
        NbParticipants.setText(e.getNbParticipants() + "");
        DateDebutLabel.setText(e.getDateDebut());
        DateFinLabel.setText(e.getDateFin());
        idLabel.setText(e.getId() + "");
        if (NbParticipants.getText().equals("0")) {
            addRes.setVisible(false);
        } else {
            addRes.setVisible(true);
        }
        try {

            String filename = es.GenerateQrEvent(e);
            System.out.println("filename lenaaa " + filename);
            Image image = new Image(getClass().getResourceAsStream("/tn/esprit/utils/img/" + filename));
            QrCode.setImage(image);

        } catch (Exception ex) {
            System.out.println("mafamesh qr");
        }

        chosenEventCard.setStyle("-fx-background-color: #DEEFBD" + ";\n"
                + "    -fx-background-radius: 30;");
        scroll.setStyle("-fx-background-color: #DEEFBD");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idLabel.setVisible(false);
        events2.clear();
        grid.getChildren().clear();
        System.out.println("clear events sorted 2" + events2);
        events.addAll(getData());
        System.out.println("init" + events);
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
            for (int i = 0; i < events.size() - 1; i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("EventItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                EventItemController EIC = fxmlLoader.getController();
                EIC.setData(events.get(i), myListener);

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

                GridPane.setMargin(anchorPane, new javafx.geometry.Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void AddReservation(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        List<Evenement> ev = new ArrayList<Evenement>();
        ev = es.FetchEventsFront();
        Reservation r = new Reservation(Integer.valueOf(this.idLabel.getText()), 1);
        System.out.println("reservationnnn: " + r.getEvenement_id() + " " + r.getUser_id());
        System.out.println("ev " + ev);
        Evenement e = new Evenement(Integer.valueOf(this.idLabel.getText()), this.EventNameLablel.getText(), this.EventPlaceLabel.getText(), Integer.parseInt(this.NbParticipants.getText()), Float.parseFloat(this.EventPriceLabel.getText().substring(0, 4)), this.DateDebutLabel.getText(), this.DateFinLabel.getText());
        System.out.println("idddd " + e.getId());
        if (rs.ReservationTest(e.getId(), 1)) {
            System.out.println("reservation mawjouda");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information ");
            alert.setHeaderText("Reservation error");
            alert.setContentText("Reservation already done,check the list of reservations!");
            alert.showAndWait();
        } else {

            System.out.println("reservation moush mawjouda");

            rs.AddReservation(r);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information ");
            alert.setHeaderText("Reservation add");
            alert.setContentText("Reservation added successfully!");
            alert.showAndWait();
            int par = Integer.parseInt(this.NbParticipants.getText());
            par = par - 1;
            this.NbParticipants.setText(String.valueOf(par));
            events.addAll(getData());
            if (NbParticipants.getText().equals("0")) {
                addRes.setVisible(false);
            } else {
                addRes.setVisible(true);
            }

        }

    }

    @FXML
    private void DisplayReservationsFront(ActionEvent event) {

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
    private void SearchEvent(ActionEvent event) {
        idLabel.setVisible(false);
        events.clear();
        events2.clear();
        events3.clear();
        grid.getChildren().clear();
        //System.out.println("clear events "+events);
        events3.addAll(getDataSearch());
        System.out.println("search" + events3);
        if (this.searchlabel.getText() == " ") {
            events.addAll(getData());
        } else {
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
                for (int i = 0; i < events3.size() - 1; i++) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/tn/esprit/gui/EventItem.fxml"));
                    AnchorPane anchorPane = fxmlLoader.load();

                    EventItemController EIC = fxmlLoader.getController();
                    EIC.setData(events3.get(i), myListener);

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

                    GridPane.setMargin(anchorPane, new javafx.geometry.Insets(10));
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
        System.out.println("clear events " + events);
        events.addAll(getDataSort());
        System.out.println("init" + events);
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
            for (int i = 0; i < events.size() - 1; i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/tn/esprit/gui/EventItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                EventItemController EIC = fxmlLoader.getController();
                EIC.setData(events.get(i), myListener);

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

                GridPane.setMargin(anchorPane, new javafx.geometry.Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showEventsFront(ActionEvent event) {
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
   public static int idToComment;
    Evenement e = new Evenement();

    @FXML
    private void moreDetails(ActionEvent event) {
        e = es.FetchOneEvent(Integer.valueOf(idLabel.getText()));
        idToComment = e.getId();
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("Comments.fxml"));

        try {
            Parent root = Loader.load();
            CommentsController C = Loader.getController();

            Scene productDetailScene = new Scene(root);
            Stage cineStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            cineStage.setScene(productDetailScene);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
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
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AllProductFront.fxml"));
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
}
