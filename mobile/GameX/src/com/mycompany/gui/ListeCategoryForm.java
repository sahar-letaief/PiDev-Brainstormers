/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.mycompany.myapp.MyApplication;
import com.mycompany.entities.Category;
import com.mycompany.services.ServiceCategory;
import java.util.ArrayList;

/**
 *
 * @author maryem
 */
public class ListeCategoryForm extends Form {
     public ListeCategoryForm(Form previous) {
       /** Image duke = null;
try {
    duke = Image.createImage("/duke.png");
} catch(IOException err) {
    Log.e(err);
}
int fiveMM = Display.getInstance().convertToPixels(5);
final Image finalDuke = duke.scaledWidth(fiveMM);*/
/**Toolbar.setGlobalToolbar(true);
Form hi = new Form("Search", BoxLayout.y());
hi.add(new InfiniteProgress());
Display.getInstance().scheduleBackgroundTask(()-> {
    // this will take a while...
            ArrayList<Product> cnts = ServiceProduct.getInstance().getAllProducts();
    Display.getInstance().callSerially(() -> {
        hi.removeAll();
        for(Product c : cnts) {
            MultiButton m = new MultiButton();
            m.setTextLine1(c.getProductName());
            m.setTextLine2(c.getDescription());
            m.setTextLine2(c.getReference());
           
            
             
            /**String pic = c.getImage();
            if(pic != null) {
                m.setIcon(fill(pic, finalDuke.getWidth(), finalDuke.getHeight()));
            } else {
                m.setIcon(finalDuke);
            }
            hi.add(m);
        }
        hi.revalidate();
    });
});

hi.getToolbar().addSearchCommand(e -> {
    String text = (String)e.getSource();
    if(text == null || text.length() == 0) {
        // clear search
        for(Component cmp : hi.getContentPane()) {
            cmp.setHidden(false);
            cmp.setVisible(true);
        }
        hi.getContentPane().animateLayout(150);
    } else {
        text = text.toLowerCase();
        for(Component cmp : hi.getContentPane()) {
            MultiButton mb = (MultiButton)cmp;
            String line1 = mb.getTextLine1();
            String line2 = mb.getTextLine2();
            boolean show = line1 != null && line1.toLowerCase().indexOf(text) > -1 ||
                    line2 != null && line2.toLowerCase().indexOf(text) > -1;
            mb.setHidden(!show);
            mb.setVisible(show);
        }
        hi.getContentPane().animateLayout(150);
    }
}, 4);

hi.show();*/

        /* Button btnrech=new Button("Chercher");
         TextField rtitre = new TextField("","Plat");
         Label lb = new Label("");
         Image back;
       
             
             
       
           //btnaff=new Button("show list");
         
         
        add(rtitre);    
        add(btnrech);
       
          // f.add(btnaff);
        btnrech.addActionListener((e)->{
        //Recherche r=new Recherche();
        //r.getR().show();
        if(rtitre.getText().equalsIgnoreCase("") ){
             Dialog.show("alert","Entrer Le non D'un Plat !!", "ok", null);
                 ;}
        else{
        ServiceProduct ser=new ServiceProduct();
        lb.setText(ser.Recherche(rtitre.getText()).toString());
        }});
       add(lb);*/
        




        
       ToastBar.showInfoMessage("Welcom");
      
        setTitle("List Products");

        SpanLabel sp = new SpanLabel();
       
        //sp.setText(ServiceUser.getInstance().getAllUsers().toString);
        
         ArrayList<Category> list;
        list = new ArrayList<>();
        list = ServiceCategory.getInstance().getAllCategories();
         for ( Category ev : list) {
             
             
             SpanLabel spl = new SpanLabel("Name: " + "  " + ev.getName()+ "  "  + "description: " + "  " + ev.getDescription());
               
                
      
          addAll(spl);
          
                
            
           

        
         
              
        
        }
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
        
    }
    
    
    
        
    
   
    
    
    
    
}
