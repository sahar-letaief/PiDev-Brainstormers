/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.entities.Category;
import com.mycompany.services.ServiceCategory;
import java.util.List;

/**
 *
 * @author maryem
 */
public class ListCatForm extends Form{
     Form current;
    public  ListCatForm(Form previous) {
        current = this;
        
       
      ServiceCategory sp = new ServiceCategory();
      add(new InfiniteProgress());
                Display.getInstance().scheduleBackgroundTask(()-> {
                    
                    Display.getInstance().callSerially(() -> {
                           //try {
                                //Image ban = Image.createImage("file://C:\\Users\\21628\\Desktop\\Mobile\\Final\\src\\Attraction\\Images\\banner.jpg").scaledHeight(1000);
                               // add(ban);
                            //} catch (IOException ex) {

                            //}
                        removeAll();
                      setLayout(BoxLayout.y());
                      
                 // Button ttrie =new Button("trie");

       
       // ttrie.addActionListener(e-> new ListFormationFormtrie(current).show()); 
        // back = Image.createImage("/logo.png");
         //back.scaled(1000, 1000);
             //add(ttrie);
                      
                       Button trie =new Button("Actualiser");

       
        trie.addActionListener(e-> new ListCatForm(current).show());
        add(trie);

                        List<Category> listerec = sp.getAllCategories();
                        for(Category p : listerec)
                        {
                            //try {
                              //  Image imagee = Image.createImage("file://C:\\Users\\21628\\Desktop\\final web\\koko444\\pi\\public\\images\\logos\\"+p.getLogo()+"").scaledHeight(350);
                               //add(imagee);
                            //} catch (IOException ex) {

                            //}
                            MultiButton m = new MultiButton();
                            m.setTextLine1("Nom: "+p.getName());
                            m.setTextLine2("description: "+p.getDescription());
                            
                            
                            add(m);
                            
                             m.addPointerReleasedListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent evt) {
                                        if (Dialog.show("Confirmation", "Que voulez vous faire ?", "Supprimer", "Modifier")) {
                                            
                                                if( ServiceCategory.getInstance().delCategory(p)){
                                                    {
                                                       Dialog.show("Success","L'produit "+p.getName()+" a ??t?? supprim?? avec succ??es",new Command("OK"));
                                                       previous.showBack();
                                                    }
                                        }
                                    }
                                        else{ 
                                               
                                                 EditCategoryForm t = new EditCategoryForm(current,p);
                                                 t.show();
                                        }
                                    }
                                });
                        }
                        
                        
                        
                        
                        
                        
                        
                        
                        
                       /* Button pdf=new Button("             PDF             ");
 add(pdf);  
 pdf.addActionListener(new ActionListener() {
                  
                    public void actionPerformed(ActionEvent evt) {
                        String path="C:\\Users\\21628\\Desktop\\PDF soka\\";
        
        Document document = new Document();
      try
      {
         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path+"Agence.pdf"));
           document.open();
          PdfPTable tb1 = new PdfPTable(4);
          tb1.addCell("Nom");
          tb1.addCell("Adresse");
          tb1.addCell("Email");
          tb1.addCell("Tel");
          
         ServiceCours es = new ServiceCours();
        ArrayList<Cours> list = es.getAllAgences();
          for (int i = 0; i < list.size(); i++) {
            
              String Nom= String.valueOf(list.get(i).getNom());
              String Q1= String.valueOf(list.get(i).getDescription());
              
              
          tb1.addCell(Nom);
          tb1.addCell(Q1);
         
          
         
         
          }
         document.add(new Paragraph("Agence"));
         document.add(tb1);
         document.close();
         writer.close();
                           Dialog.show("Success","Le PDF a ??t?? cr??e",new Command("OK"));  

        com.codename1.io.File file=new com.codename1.io.File("test.pdf");
        //desktop.open(file);
      } catch (DocumentException e)
      {
         e.printStackTrace();
      }catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
                        //Logger.getLogger(ListFormation.class.getName()).log(Level.SEVERE, null, ex);

                     
                    }
                    
                }
                
                
                );*/
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                     revalidate() ;   
                    });
                });
       getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
       
       
       
    
                        }

    
}
