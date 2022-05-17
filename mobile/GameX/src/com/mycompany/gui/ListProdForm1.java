package com.mycompany.gui;







import com.codename1.components.ImageViewer;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.codename1.ui.Form;
import com.mycompany.myapp.MyApplication;
import com.mycompany.entities.Order;
import com.mycompany.entities.Product;
import com.mycompany.services.ServiceProduct;


public class ListProdForm1 extends Form{
    Form current;

    public  ListProdForm1(Form previous) {
        current = this;
        ServiceProduct sp = new ServiceProduct();
        add(new InfiniteProgress());
        Display.getInstance().scheduleBackgroundTask(()-> {

            Display.getInstance().callSerially(() -> {
                removeAll();
                setLayout(BoxLayout.y());
                Button trie =new Button("Actualiser");
                trie.addActionListener(e-> new ListProdForm1(current).show());
                add(trie);

                this.getToolbar().addCommandToSideMenu("YOUR CART",
                        null, (evt) -> {
                            new FormListeBD(this).show();
                        });

                List<Product> listerec = sp.getAllProducts();
                for(Product p : listerec)
                {
                    MultiButton m = new MultiButton();
                    m.setTextLine1("Nom: "+p.getProductName());
                    m.setTextLine2("description: "+p.getDescription());
                    m.setTextLine3("Prix: "+p.getPrice());


                    add(m);

                    m.addPointerReleasedListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            if (Dialog.show("Product : "+p.getProductName(), "Add to cart ?", "YES", "NO")) {
                                try {
                                    //INSERT INTO DATABASE
                                    MyApplication.myDataBase.execute("INSERT INTO Product (ProductName, Description, Price) VALUES ('"+p.getProductName()+"','"+p.getDescription()+"','"+p.getPrice()+"')");
                                    Dialog.show("Add Product "+p.getProductName(), "Insert done !", "OK", null);
                                    System.out.println("yyy");
                                } catch (IOException ex) {
                                    System.out.println(ex.getMessage());
                                }
                            }
                        }
                    });

                }






                revalidate() ;
            });


        });




        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());


    }



}