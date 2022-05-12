/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Cart.ShoppingCart;
import tn.esprit.entities.Product;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tn.esprit.services.ServiceProduct;

/**
 * FXML Controller class
 *
 * @author maryem
 */
public class FrontController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private Label idf;
    @FXML
    private Label fxprix;
    @FXML
    private GridPane gird;
    @FXML
    private ImageView backB;
    public static Product carPassed;
    @FXML
    private ImageView imgShow;
    @FXML
    private Label desc;
    @FXML
    private Label ref;
    @FXML
    private Label stock;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ref.setText(ListOfProductController.ref_recup);

        label.setText(ListOfProductController.productnamerecup);
        desc.setText(ListOfProductController.decriptionrecup);

        fxprix.setText(String.valueOf(ListOfProductController.pricerecup));
        stock.setText(String.valueOf(ListOfProductController.stockrecup));

        ServiceProduct se =new ServiceProduct();
        Product k = new Product();
        System.out.println(ListOfProductController.img_recup);

        ImageView img = new ImageView();
           imgShow.setImage(new Image("http://localhost:7882/PiDev-Brainstormers-main/public/uploads/"+ListOfProductController.img_recup,200,200,true,true));
            //imgShow.setImage(new Image("C://xampp/htdocs/PiDev-Brainstormers-main/public/uploads\"+ListOfProductController.img_recup,200,200,true,true));
            
            

        
        
       /* try {
            ServiceProduct carServiceImp = ServiceProduct.getInstance();
            String path = carServiceImp.getCarById(carPassed.getProductName()).getImage();
            if (path != null) {
                InputStream stream = new FileInputStream(path);
                javafx.scene.image.Image image = new javafx.scene.image.Image(stream);
                dd.setImage(image);
            } else {
                System.out.println("no image");
            }
        } catch (FileNotFoundException e) {
            System.out.println("no changes ");
        }*/

        
    }    
    

    @FXML
    private void handleButtonAction(ActionEvent event) {
        
          //add product to shopping cart
                Node sourceComponent = (Node)event.getSource();
                String productName =(String)sourceComponent.getUserData();
                ShoppingCart shoppingCart= ShoppingCart.getInstance();
                shoppingCart.addProduct(productName);
        
        
        
    }

    @FXML
    private void backToBack(MouseEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/ListOfProduct.fxml"));
            Stage stage = (Stage) backB.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
