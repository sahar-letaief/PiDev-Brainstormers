package tn.brainstormers.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sami
 */
public class Datasource {

    private String url = "jdbc:mysql://localhost:3306/gamex";
    private String username = "root";
    private String password = "";

    private Connection con;
    private static Datasource instance;

    private Datasource() {
        try {
            this.con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established");
        } catch (SQLException ex) {
            Logger.getLogger(Datasource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getCnx() {
        return con;
    }

    public static Datasource getInstance() {
        if (instance == null) {
            instance = new Datasource();
        }
        return instance;
    }

}
