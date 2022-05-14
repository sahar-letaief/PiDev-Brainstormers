/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Cart.ShoppingCart;
import tn.esprit.entities.Product;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import static controller.AllProductFrontController.article;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;

/**
 * FXML Controller class
 *
 * @author maryem
 */
public class DetailsController implements Initializable {

    @FXML
    private Pane pnItem;
    @FXML
    private ImageView imNft;
    @FXML
    private Label lblTitle;
    @FXML
    private Label lblCreationDate;
    @FXML
    private Label lblOwner;
    @FXML
    private Label lblCategory;
    private Label aimg;
    
    
    
    private String id;  
    public static Product r ;
    public static Product thisArticle;
     public static Product Posta;
    public static String ayja;
    private Button show;
    @FXML
    private Button cart;

    /**
     * Initializes the controller class.
     */
   @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblTitle.setText(article.getReference());
        lblCategory.setText(article.getProductName());
        //aimg.setText(article.getImage());
        //ida.setText(String.valueOf(article.getId()));
        id=String.valueOf(article.getId());
        lblOwner.setText(String.valueOf(article.getPrice()));
        lblCreationDate.setText(String.valueOf(article.getStock()));

        ayja=article.getImage();
        thisArticle = article;
        Posta=article;
        System.out.println(ayja);
        //Integer.valueOf(id)
        thisArticle.setId(Integer.valueOf(id));
        //Posta.setId(Integer.valueOf(id));
        
                cart.setUserData(article.getProductName());
                cart.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        //add product to shopping cart
                        Node sourceComponent = (Node) actionEvent.getSource();
                        String ProductName = (String) sourceComponent.getUserData();
                        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa " + ProductName + "aaaaaaaaaaaaaaaaaa");
                        ShoppingCart shoppingCart = ShoppingCart.getInstance();
                        System.out.println("1111111111111111111111111\n");
                        shoppingCart.addProduct(ProductName);
                        System.out.println("22222222222222222222222222");

                    }
                });
        
        try {
            FileInputStream inputstream = new FileInputStream("C:\\xampp\\htdocs\\PiDev-Brainstormers-main\\public\\uploads\\"+ayja);
            Image image = new Image(inputstream);
            imNft.setImage(image);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void addtocarttttt(ActionEvent event) {
        
        
        
    }

   
  

    
}
