/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services;

import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;
import tn.esprit.entities.Order;

/**
 *
 * @author MSI
 */
public interface IInterface {

    List<Order> afficher();
    void ajouter2(Order c);
    void modifierPST(Order f) throws SQLException;
    public ObservableList<Order> getOrderList(); 

    
}
