/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Cart.CartEntry;
import Cart.ShoppingCart;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import tn.esprit.entities.Order;
import tn.esprit.gui.DisplayEventsFrontController;
import tn.esprit.gui.SignUpController;
import tn.esprit.services.OrderService;
import tn.esprit.utils.DBUtil;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class AfficherOrderController implements Initializable {

    @FXML
    private TableView<Order> personsTable;
    @FXML
    private Button ref;
    private TableColumn<Order, Boolean> etat;
    @FXML
    private TableColumn<Order, Integer> tel;
    private Button b;
    @FXML
    private Button imprimer;
    @FXML
    private TextField filterField;
    @FXML
    private TableColumn<Order, String> refe;
    private Button ajout;
    @FXML
    private Button adddd;

    
    
    public static String ref_order;
    public static int num_order;
    public static String region_order;
    public static String pays_order;
    public static String status_order;
    public static int code_order;
    @FXML
    private Button edit;
    private ImageView Home3;
    private ImageView cmde3;
    private ImageView homecart;
    private ImageView homeMarket;
    @FXML
    private TextField cal;
    
    private Connection cnx;
    @FXML
    private TableColumn<Order, String> etatcheck;
    @FXML
    private Button exportToPdf;
    @FXML
    private Button show;
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        OrderService ec = new OrderService();
        String s = ec.countOrder();
        cal.setText(s);
        
        OrderService evcrud = new OrderService();
        ArrayList<Order> ev = (ArrayList<Order>) evcrud.afficher();
        ObservableList<Order> obs = FXCollections.observableArrayList(ev);
        //table.setItems(obs);
        //extract the value from a given tableview row
        refe.setCellValueFactory(new PropertyValueFactory<Order,String>("ref_cmde"));
        tel.setCellValueFactory(new PropertyValueFactory<Order,Integer>("tel"));
        etatcheck.setCellValueFactory(new PropertyValueFactory<Order,String>("status"));
         FilteredList<Order>filteredData = new FilteredList<>(FXCollections.observableArrayList(ev), b -> true);
 	// Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(events -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare refcmde of every order with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (events.getRef_cmde().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}else  
				    	 return false; // Does not match.
			});
		});
		
		// hattt listt filtréee fi liste triée. 
		SortedList<Order> sortedData = new SortedList<>(filteredData);
		
		// Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(personsTable.comparatorProperty());

        personsTable.setItems(sortedData);

        // TODO
        
        
        
        //imprimer = new Button ('Export to excel');
        cnx = DBUtil.getInstance().getCnx();
        

        imprimer.setOnAction((actionEvent -> {
        imprimer.setFont(Font.font("Sansserif", 15));
        String query = "select * from commande";
        try {

        Statement pst= cnx.createStatement();
        ResultSet rs = pst.executeQuery(query);

 
        // class to represent excel file format
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("Order Details");
        XSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("ref");
        header.createCell(2).setCellValue("etat");
        header.createCell(3).setCellValue("pays");
        header.createCell(4).setCellValue("region");
        header.createCell(5).setCellValue("tel");
        header.createCell(6).setCellValue("code postal");
        header.createCell(6).setCellValue("status");
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);
        sheet.setColumnWidth(3, 256*25);//256-character width

        sheet.setZoom(150); //scale(150%

        int index = 1;
        while (rs.next()) {
            XSSFRow row = sheet.createRow(index);
            row.createCell(0).setCellValue(rs.getString("id"));
            row.createCell(1).setCellValue(rs.getString("ref_cmde"));
            row.createCell(2).setCellValue(rs.getString("etat_cmde"));
            row.createCell(3).setCellValue(rs.getString("pays"));
            row.createCell(4).setCellValue(rs.getString("region"));
            row.createCell(5).setCellValue(rs.getString("tel"));
            row.createCell(6).setCellValue(rs.getString("code_postal"));
            row.createCell(6).setCellValue(rs.getString("status"));
            index++;

        }
        
          String file_name = "order.xlsx";

        FileOutputStream fileOut = new FileOutputStream (file_name);
        wb.write(fileOut);
        fileOut.close();


        } catch (SQLException ex) {
            System.out.println("error");
        } catch (IOException ex) {
            System.out.println("error");
        }
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Order details exported to excel Sheet");
        alert.show();
        //pst.close();
        //rs.close();

        }));
    
        exportToPdf.setOnAction(actionEvent -> {
        cnx = DBUtil.getInstance().getCnx();
    
         PreparedStatement pst=null;
         ResultSet rs=null;
         
         String guery = " select * from commande";
            try {   
               
         pst= cnx.prepareStatement(guery);
         rs= pst.executeQuery();
         
                  String file_name = "commande.pdf";
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(file_name));
        
        doc.open();
       
       Image img = Image.getInstance("C:\\Users\\MSI\\Documents\\NetBeansProjects\\Desktop\\src\\img\\logo 9 (1).png");
       img.scaleAbsoluteWidth(600);
       img.scaleAbsoluteHeight(92);
       img.setAlignment(Image.ALIGN_CENTER);
       doc.add(img);
       
       doc.add(new Paragraph(" "));
       doc.add(new Paragraph("commande list",FontFactory.getFont(FontFactory.TIMES_BOLD,20,BaseColor.LIGHT_GRAY)));
       doc.add(new Paragraph(" "));

       PdfPTable table = new PdfPTable(3);
       table.setWidthPercentage(100);

       PdfPCell cell;
       
       cell = new PdfPCell (new Phrase("reference", FontFactory.getFont("Comic Sans MS",12)));
       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.GRAY);
       table.addCell(cell);
       
       cell = new PdfPCell (new Phrase("phone number", FontFactory.getFont("Comic Sans MS",12)));
       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.GRAY);
       table.addCell(cell);
       
       cell = new PdfPCell (new Phrase("status", FontFactory.getFont("Comic Sans MS",12)));
       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.GRAY);
       table.addCell(cell);
       
       cell = new PdfPCell (new Phrase("product", FontFactory.getFont("Comic Sans MS",12)));
       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.GRAY);
       table.addCell(cell);
       
      // cell = new PdfPCell (new Phrase("Phone", FontFactory.getFont("Comic Sans MS",12)));
      // cell.setHorizontalAlignment(Element.ALIGN_CENTER);
      //cell.setBackgroundColor(BaseColor.GRAY);
       
       /////////////////////////////////////////////////////////////////////////////////
       while(rs.next()) {
           cell = new PdfPCell (new Phrase(rs.getString("ref_cmde").toString(), FontFactory.getFont("Arial",12)));
       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        
       table.addCell(cell);
       
       cell = new PdfPCell (new Phrase(rs.getString("tel").toString(), FontFactory.getFont("Arial",12)));
       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
      
       table.addCell(cell);
       
       cell = new PdfPCell (new Phrase(rs.getString("etat_cmde").toString(), FontFactory.getFont("Arial",12)));
       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
       
       table.addCell(cell);
       
       
       
     //  cell = new PdfPCell (new Phrase(rs.getString("phone").toString(), FontFactory.getFont("Arial",12)));
       //cell.setHorizontalAlignment(Element.ALIGN_CENTER);
      
       //table.addCell(cell);
        
       }
      
       doc.add(table);
       
        System.out.println("done");
                doc.close();
                
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AfficherOrderController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(AfficherOrderController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AfficherOrderController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AfficherOrderController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Commande details exported to PDF Sheet");
            alert.show();

         });


       

    }  
    


    private void Add(ActionEvent Order) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/AjouterOrder.fxml"));
            Stage stage = (Stage) ajout.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherOrderController.class.getName()).log(Level.SEVERE, null, ex);


    }
    
}

    @FXML
    private void Ajouter(ActionEvent Order) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/AjouterOrderFront.fxml"));
            Stage stage = (Stage) adddd.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Ajouter_OrderController.class.getName()).log(Level.SEVERE, null, ex);


    }
    }

    @FXML
    private void dd(ActionEvent Order) {
       try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/orderAfficheFront.fxml"));
            Stage stage = (Stage) b.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    private void cmde3(MouseEvent event) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/orderAfficheFront.fxml"));
            Stage stage = (Stage) cmde3.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void order_editt1(ActionEvent event) {
        Order ev = personsTable.getSelectionModel().getSelectedItem();
        AfficherOrderController.ref_order=ev.getRef_cmde();
        AfficherOrderController.num_order=ev.getTel();
        AfficherOrderController.region_order=ev.getRegion();
        AfficherOrderController.pays_order=ev.getPays();
        AfficherOrderController.status_order=ev.getStatus();
        AfficherOrderController.code_order=ev.getCode_postal();
        
        
        //AfficherOrderController.id_rec=ev.getId();

        System.out.println(ev.getId());
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/EditOrderFront.fxml"));
            Stage stage = (Stage) edit.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void homeMarket(MouseEvent event) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/AllProductFront.fxml"));
            Stage stage = (Stage) homeMarket.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void calcul(ActionEvent event) {
        
        
    }

    @FXML
    private void shows(ActionEvent event) {
        
        Order ev = personsTable.getSelectionModel().getSelectedItem();
        AfficherOrderController.ref_order=ev.getRef_cmde();
        AfficherOrderController.status_order=ev.getStatus();
        AfficherOrderController.region_order=ev.getRegion();
        AfficherOrderController.pays_order=ev.getPays();
        AfficherOrderController.num_order=ev.getTel();
        AfficherOrderController.code_order=ev.getCode_postal();
         

        System.out.println(ev.getId());
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/Show.fxml"));
            Stage stage = (Stage) show.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void goTOList(MouseEvent event) {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/AllProductFront.fxml"));
        
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
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/AllProductFront.fxml"));
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/Profile.fxml"));

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
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/orderAfficheFront.fxml"));
        
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
    private void onreservation(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/DisplayReservationFront.fxml"));

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
    private void onevents(MouseEvent event) {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/DisplayEventsFront.fxml"));

        try {
            Parent root = Loader.load();
            DisplayEventsFrontController C = Loader.getController();

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
    

  
}


