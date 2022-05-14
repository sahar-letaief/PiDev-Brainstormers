/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cart;

import tn.esprit.entities.Product;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tn.esprit.services.ServiceProduct;

/**
 *
 * @author MSI
 */
public class ShoppingCart {

    //singletons should have single method for initializing and accessing it
    //This way the instance will never be null when you need it.
    private static ShoppingCart INSTANCE;

    public static ShoppingCart getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ShoppingCart();
        }
        return INSTANCE;
    }

    private Map<String, CartEntry> entries;

    public ShoppingCart() {
        this.entries = new HashMap<>();
    }

    public void addProduct(String ProductName) {
        ServiceProduct Sp = new ServiceProduct();
                System.out.println(ProductName + " çbal l moshkla");

        Product product = Sp.getCarById(ProductName);
        CartEntry productEntry = entries.get(ProductName.toUpperCase());

        if (productEntry != null) {
            productEntry.increase_qte();
        } else {

            CartEntry entry = new CartEntry(product, 1);
            entries.put(ProductName.toUpperCase(), entry);
        }

    }

    public void removeProduct(String productName) {
        CartEntry productEntry = entries.get(productName.toUpperCase());
        if (productEntry != null) {
            productEntry.decrease_qte();
        }
    }

    public int getguantity(String productName) {
        CartEntry entry = entries.get(productName.toUpperCase());
        if (entry != null) {
            return entry.getQuantity();
        }
        return 0;
    }

    public float calcultotal() {
        float total = 0;
        for (CartEntry entry : entries.values()) {
            float entryCost = entry.getProduct().getPrice() * entry.getQuantity();
            total = total + entryCost;
        }
        return total;
    }

    public List<CartEntry> getEntries() {
        return new ArrayList<>(entries.values());
    }

}
