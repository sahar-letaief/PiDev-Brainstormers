/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import tn.esprit.entities.User;
import tn.esprit.entities.UserStaticSession;
import tn.esprit.utils.Datasource;
/**
 *
 * @author Yassine
 */
public class UserServices implements IService<User> {

    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;

    public UserServices() {
        //Récupération de la connection à la base de données
        cnx = Datasource.getInstance().getCnx();
    }

    @Override
    public void ajouter(User p) {
        String requete = "INSERT INTO `USER` (`email`,`password`,`roles`,`firstname`,`lastname`,`phone_number`,`usertag`,`last_login_date`,`is_verified`) "
                + "VALUES ('" + p.getEmail() + "','" + p.getPassword() + "','" + "ROLE_USER" + "','" + p.getFirstname() + "','" + p.getLastname() + "'"
                + ",'" + p.getPhonenumber() + "','" + p.getUsername() + "','" + "2022-03-27 18:59:24" + "','" + 1 + "');";
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
            System.out.println("personne ajoutée");

        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String SignIn(User p) {

        String getrequete = "SELECT * FROM `user` where email=" + "'" + p.getEmail() + "'" + " and password=" + "'" + p.getPassword() + "'";

        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(getrequete);

            while (rs.next()) {
                if (rs.getString("email").equals(p.getEmail()) && rs.getString("password").equals(p.getPassword())) {
                    UserStaticSession user = new UserStaticSession(rs.getInt("id"),
                            rs.getString("email"),
                            rs.getString("usertag"),
                            rs.getString("firstname"),
                            rs.getString("lastname"),
                            rs.getInt("phone_number"),
                            rs.getString("password"),
                            rs.getString("roles").substring(7, rs.getString("roles").length() - 2));

                    return "success";
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);

        }
        return "error";
    }

    public String SignUp(User p) {

        String getrequete = "SELECT * FROM `user` where email=" + "'" + p.getEmail() + "'";

        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(getrequete);

            while (rs.next()) {
                if (rs.getString("email").equals(p.getEmail())) {
                    return "user exists";
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
            return "error";
        }

        String requete = "INSERT INTO `USER` (`email`,`password`,`roles`,`firstname`,`lastname`,`phone_number`,`usertag`,`last_login_date`,`is_verified`) "
                + "VALUES (?,?,?,?,?,?,?,?,?);";

        String value = "[\"" + "ROLE_" + p.getRoles() + "\"]";

        try {
            pst = cnx.prepareStatement(requete);
            pst.setString(1, p.getEmail());
            pst.setString(2, p.getPassword());
            pst.setString(3, value);
            pst.setString(4, p.getFirstname());
            pst.setString(5, p.getLastname());
            pst.setInt(6, p.getPhonenumber());
            pst.setString(7, p.getUsername());
            pst.setString(8, "2022-03-27 18:59:24");
            pst.setInt(9, 1);

            pst.executeUpdate();
            return "user Signed up";
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
            return "Error";
        }
    }

    public ObservableList<User> displayUsers(ObservableList<User> UsersList) {
        List<User> users = new ArrayList<>();
        String requete = "SELECT * FROM `user`";

        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(requete);

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("usertag"));
                user.setPhonenumber(rs.getInt("phone_number"));
                user.setFirstname(rs.getString("firstname") + " " + rs.getString("lastname"));
                user.setLastname(rs.getString("lastname"));
                user.setPassword("Crypted");
                user.setRoles(rs.getString("roles").substring(7, rs.getString("roles").length() - 2));
                user.setLastlogindate(rs.getString("last_login_date"));
                UsersList.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return UsersList;
    }

    public void UpdateUser(User p) {

        String requete = "UPDATE `USER` set email=? , password=? , roles=? , firstname=? ,"
                + " lastname=? , phone_number=?, usertag=? where id=?;";
        String value = "[\"" + "ROLE_" + p.getRoles() + "\"]";

        p.setRoles(value);
        try {
            pst = cnx.prepareStatement(requete);
            pst.setString(1, p.getEmail());
            pst.setString(2, p.getPassword());
            pst.setString(3, p.getRoles());
            pst.setString(4, p.getFirstname());
            pst.setString(5, p.getLastname());
            pst.setInt(6, p.getPhonenumber());
            pst.setString(7, p.getUsername());
            pst.setInt(8, p.getId());

            pst.executeUpdate();
            System.out.println("personne mise a jour");
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UpdateUserBack(User p) {

        String requete = "UPDATE `USER` set email=? , roles=? , firstname=? ,"
                + " lastname=? , phone_number=?, usertag=? where id=?;";

        String value = "[\"" + "ROLE_" + p.getRoles() + "\"]";

        p.setRoles(value);
        try {
            pst = cnx.prepareStatement(requete);
            pst.setString(1, p.getEmail());
            pst.setString(2, p.getRoles());
            pst.setString(3, p.getFirstname());
            pst.setString(4, p.getLastname());
            pst.setInt(5, p.getPhonenumber());
            pst.setString(6, p.getUsername());
            pst.setInt(7, p.getId());

            pst.executeUpdate();
            System.out.println("personne mise a jour");
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean deleteUser(int id) {
        String requete = "delete from `user` where id=?";
        try {
            pst = (PreparedStatement) cnx.prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("user with id=" + id + " is deleted successfully");
            return true;
        } catch (SQLException ex) {
            System.out.println("error in delete user " + ex.getMessage());
        }
        return false;
    }

    public List<User> test(String SearchValue, String SearchKey , String SortKey) {
        List<User> users = new ArrayList<>();
        String requete = "";
        
        if ( SearchValue.isEmpty() ){
            
            if ( SortKey.isEmpty()){
                requete = "SELECT * FROM `user`";
            }else if ( SortKey.equals("Email")) {
                requete = "SELECT * FROM `user` ORDER BY email ASC";
            }else if ( SortKey.equals("Full Name")) {
                requete = "SELECT * FROM `user` ORDER BY firstname ASC ";
            }else if ( SortKey.equals("Username")) {
                requete = "SELECT * FROM `user` ORDER BY usertag ASC";
            }
            
        }else if ( SearchKey.equals("Email") ) {
            requete = "SELECT * FROM `user` WHERE email LIKE"  + "'%" + SearchValue + "%'";
        }else if ( SearchKey.equals("Full Name") ){
            requete = "SELECT * FROM `user` WHERE firstname LIKE"  + "'%" + SearchValue + "%'";
        }else if ( SearchKey.equals("Username") ){
            requete = "SELECT * FROM `user` WHERE usertag LIKE"  + "'%" + SearchValue + "%'";
        }

        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(requete);

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("usertag"));
                user.setPhonenumber(rs.getInt("phone_number"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setPassword("Crypted");
                user.setRoles(rs.getString("roles").substring(7, rs.getString("roles").length() - 2));
                user.setLastlogindate(rs.getString("last_login_date"));
                users.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users;
    }

    public User getOneUser(int id) {
        String requete = "SELECT * FROM `user` where id=" + id;

        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(requete);

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("usertag"));
                user.setPhonenumber(rs.getInt("phone_number"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setPassword("Crypted");
                user.setRoles(rs.getString("roles").substring(7, rs.getString("roles").length() - 2));
                user.setLastlogindate(rs.getString("last_login_date"));
                return user;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
