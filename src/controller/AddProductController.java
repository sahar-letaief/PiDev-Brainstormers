/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import tn.esprit.entities.Category;
import tn.esprit.entities.Product;
import static java.awt.SystemColor.text;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Integer.parseInt;  
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tn.esprit.services.ServiceProduct;
import tn.esprit.utils.Data;
import java.util.regex.Pattern;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import tn.esprit.services.MailerService;
import tn.esprit.utils.DataValidationUtils;
import tn.esprit.utils.SmsTwillio;
import tn.esprit.utils.Upload;
/**
 * FXML Controller class
 *
 * @author maryem
 */
public class AddProductController implements Initializable {

    @FXML
    private AnchorPane show;
    @FXML
    private AnchorPane slider;
    @FXML
    private Label product_name;
    @FXML
    private Label Ref;
    @FXML
    private Label Desc;
    @FXML
    private TextField txtReference;
    @FXML
    private TextField txtName;
    @FXML
    private Button btnSave;
    @FXML
    private ComboBox<String> comboCat;
    @FXML
    private Label category;
    @FXML
    private TextField txtDescription;
    @FXML
    private TextField txtPrice;
    @FXML
    private Label price;
    @FXML
    private TextField txtStock;
    @FXML
    private Label stock;
    @FXML
    private Button btnInsertImage;
    Connection cnx = Data.getInstance().getCnx();
    ServiceProduct serviceProd = ServiceProduct.getInstance();
    @FXML
    private Button back;
    
    private Connection conx = null; 
    private PreparedStatement pst = null ;
    private ResultSet rs = null ;
    
    
    
    
    @FXML
    private Label btnProducts;
    @FXML
    private Label goCat;
    private ImageView iconProd;
    private ImageView iconCat;
    @FXML
    private Button exit;
    private Button addRec;
    @FXML
    private Pane pane1;
    
    private JFrame frame;
    @FXML
    private ImageView myImageView;
    String s;
       private File file;
   private Image image1;
    String pic;
    @FXML
    private TextField fxidImg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection cnx = Data.getInstance().getCnx();
            rs = cnx.createStatement().executeQuery("SELECT name FROM category ");
            // Now add the comboBox addAll statement
           while (rs.next()){
            comboCat.getItems().addAll(rs.getString("name"));
           
           }
            } catch (SQLException ex) {
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    

    @FXML
    private void form(MouseEvent event) {
    }

    @FXML
    private void promo(MouseEvent event) {
    }

    @FXML
    private void abon(MouseEvent event) {
    }

    @FXML
    private void stat(MouseEvent event) {
    }

    @FXML
    private void saveProduct(ActionEvent Product) throws SQLException {
        
        if (txtReference.getText().isEmpty() || txtName.getText().isEmpty() || txtDescription.getText().isEmpty()|| txtPrice.getText().isEmpty()|| txtStock.getText().isEmpty()|| btnInsertImage.getText().isEmpty()) {
               System.out.println("Fields Are Empty");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Check your fields! ");
                alert.show();
                
        
            // show.setText("Enter all details");

        } 
          //  if(txtReference.getText()
             //if (!txtReference.matches("[a-z]") && !txtReference.matches("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+")) {
              //  System.out.println("aaaazzzz");

            
        else 
        if (!DataValidationUtils.isProductNameValid(txtName.getText().replaceAll("\\s", ""))) {
                txtName.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                System.out.println("Product name is invalid");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("invalid product name!");
                alert.show();
        } else 
            if(!DataValidationUtils.isDescriptionValid(txtDescription.getText().replaceAll("\\s", ""))) {
                txtDescription.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                System.out.println("PDescription is invalid");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("invalid description !");
                alert.show(); }
            else 
                if (!DataValidationUtils.isReferenceValid(txtReference.getText().replaceAll("\\s", ""))) {
                txtReference.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                System.out.println("Reference is invalid");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("invalid reference!");
                alert.show(); 
                }
            
            else {
                    if (!DataValidationUtils.price(txtPrice.getText().replaceAll("\\s", ""))) {
                txtPrice.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                System.out.println("Price is invalid");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("invalid Price!");
                alert.show(); }
                    else {
                  if (!DataValidationUtils.isStockValid(txtStock.getText().replaceAll("\\s", ""))) {
                txtStock.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                System.out.println("Stock is invalid");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("invalid Stock!");
                alert.show(); }
                    } 
                String ref = txtReference.getText();
                String name = txtName.getText();
                String desc = txtDescription.getText();
                String img = fxidImg.getText();

            int price = parseInt(txtPrice.getText());
            int stock = parseInt(txtStock.getText());
            ZoneId defaultZoneId = ZoneId.systemDefault();
            
            
                ResultSet rs6 = null;

                Connection cnx = Data.getInstance().getCnx();
        
                String v= String.valueOf(comboCat.getValue());
                rs6 = cnx.createStatement().executeQuery("SELECT id FROM category where name='"+v+"'");  
     
                rs6.next();
               int id1 = rs6.getInt("id");
            

            Product ev = new Product(ref, name, desc,price,stock,img,id1);
            serviceProd.ajouterProduct(ev);
              
         
            System.err.println("Added Seccessfully");
             
           /* Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Product added successfuly!");
                        alert.show();*/
                        txtReference.setText("");
                        txtName.setText("");
                        txtDescription.setText(" ");
                        txtPrice.setText(" ");
                        txtStock.setText("");
                        comboCat.setValue("");
                 
                        
              try {
                    Parent parent = FXMLLoader.load((getClass().getResource("/tn/esprit/gui/ListOfProduct.fxml")));
                    Scene scene = new Scene(parent);
                    Stage stage = (Stage) ((Node)Product.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                 } catch (IOException e) {
                    e.printStackTrace();
                }
              
              
              
              Notifications.create()
                      .title("Added Complete")
                      .text("Saved").darkStyle().position(Pos.TOP_RIGHT)
                      .showInformation();
              /* MailerService ms = new MailerService();
            ms.replyMail("maryem.benmohamed@esprit.tn","maryem","Bonjour Monsieur votre operation a été acceptée");*/
            

                            
        SmsTwillio.sms (txtReference.getText());
    
        }}

    @FXML
    private void backk(ActionEvent Product) {
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

    @FXML
    private void btnInsertImg(ActionEvent Product) throws IOException {
        /*FileChooser F = new FileChooser();
        F.setTitle("Choisir une image");
        F.getExtensionFilters().addAll();
        File f = F.showOpenDialog(slider.getScene().getWindow());
        if(f != null){
            btnInsertImage.setText(f.toString());
        }*/
         /*FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);

        String path = file.getAbsolutePath();
        s = path;

        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);

            myImageView.setImage(image);
        } catch (IOException ex) {
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
          FileChooser fileChooser = new FileChooser();
            file= fileChooser.showOpenDialog(null);
             FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

            
            pic=(file.toURI().toString());
         //  pic=new Upload().upload(file,"uimg");
           pic=new Upload().upload(file,"");
            System.out.println(pic);
   //   image= new Image("http://localhost/uimg/"+pic);
           fxidImg.setText(pic);

           image1= new Image("http://localhost/PiDev-Brainstormers-main/public/uploads"+pic);
           myImageView.setImage(image1);

    }

    @FXML
    private void goTOList(MouseEvent event) {
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

    @FXML
    private void goListCat(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/ListOfCategory.fxml"));
            Stage stage = (Stage) goCat.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void iconGoProd(MouseEvent event) {
          try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/ListOfProduct.fxml"));
            Stage stage = (Stage) iconProd.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void iconGoCat(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/ListOfCategory.fxml"));
            Stage stage = (Stage) iconCat.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void calculer(MouseEvent event) {
    }

    @FXML
    private void btnExit(ActionEvent event) {
        frame = new JFrame();
        if(JOptionPane.showConfirmDialog(frame, "Confir if you want to exit", "Print Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
            System.exit(0);
        }
    }

        
    
    
}

