/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

/**
 *
 * @author HP
 */
public class Product {
    private int id;
    private String ProductName;
    private String Description;
    private String Reference;
    private String image;
    private int Stock;
    private int Price;
    int Category_id;

    public int getCategory_id() {
        return Category_id;
    }

    public void setCategory_id(int Category_id) {
        this.Category_id = Category_id;
    }
    

    public Product() {
    }

    public Product(String ProductName, String Description, String Reference, String image, int Stock, int Price) {
        this.ProductName = ProductName;
        this.Description = Description;
        this.Reference = Reference;
        this.image = image;
        this.Stock = Stock;
        this.Price = Price;
    }

    

    public Product(String text) {
    }
     public Product(int id) {
         this.id = id;
    }

    public Product(String Reference, String ProductName, String Description, int Stock, int Price,int Category_id) {
        this.Reference = Reference;
        this.ProductName = ProductName;
        this.Description = Description;
        this.Stock = Stock;
        this.Price = Price;
         this.Category_id = Category_id;
    }


   

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getReference() {
        return Reference;
    }

    public void setReference(String Reference) {
        this.Reference = Reference;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id=" + id + ", ProductName=" + ProductName + ", Description=" + Description + ", Reference=" + Reference + ", image=" + image + ", Stock=" + Stock + ", Price=" + Price + '}';
    }

 
    

     
}
