/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import tn.esprit.entities.User;
import tn.esprit.entities.UserStaticSession;
import tn.esprit.utils.Datasource;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

/*
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
String ACCOUNT_SID = "AC3ebf41ce9d5b46c08d59171d07abb5c9";
        String AUTH_TOKEN = "248aa2de2d5f469c2f7f2e9a63dc819e";

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+21654870189"),
                new com.twilio.type.PhoneNumber("+19378264622"),
                "Where's Wallace?")
                .create();

        System.out.println(message.getSid());
 */
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

        String getrequete = "SELECT * FROM `user` where email=" + "'" + p.getEmail() + "'";
        Argon2 argon2jvm = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id, 16, 32);

        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(getrequete);

            while (rs.next()) {
                if (rs.getString("email").equals(p.getEmail())) {

                    if (argon2jvm.verify(rs.getString("password"), p.getPassword())) {
                        UserStaticSession user = new UserStaticSession(rs.getInt("id"),
                                rs.getString("email"),
                                rs.getString("usertag"),
                                rs.getString("firstname"),
                                rs.getString("lastname"),
                                rs.getInt("phone_number"),
                                rs.getString("password"),
                                rs.getString("roles").substring(7, rs.getString("roles").length() - 2));

                        if (rs.getString("verification_code") != null) {
                            return rs.getString("verification_code");
                        } else {
                            return "empty";
                        }
                    }

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

        String requete = "INSERT INTO `USER` (`email`,`password`,`roles`,`firstname`,`lastname`,`phone_number`,`usertag`,`last_login_date`,`is_verified`, `verification_code`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?);";

        String value = "[\"" + "ROLE_" + p.getRoles() + "\"]";
        SecureRandom secureRandom = new SecureRandom(); //threadsafe
        Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe
        byte[] randomBytes = new byte[5];
        secureRandom.nextBytes(randomBytes);
        String code = base64Encoder.encodeToString(randomBytes);
        String code2 = base64Encoder.encodeToString(randomBytes);

        /*String ACCOUNT_SID = "AC3ebf41ce9d5b46c08d59171d07abb5c9";
        String AUTH_TOKEN = "248aa2de2d5f469c2f7f2e9a63dc819e";

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+21654870189"),
                new com.twilio.type.PhoneNumber("+19378264622"),
                code)
                .create();*/
        Argon2 argon2jvm = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id, 16, 32);
        String arg2pwd = argon2jvm.hash(10, 65536, 1, p.getPassword());
        try {
            pst = cnx.prepareStatement(requete);
            pst.setString(1, p.getEmail());
            pst.setString(2, arg2pwd);
            pst.setString(3, value);
            pst.setString(4, p.getFirstname());
            pst.setString(5, p.getLastname());
            pst.setInt(6, p.getPhonenumber());
            pst.setString(7, p.getUsername());
            pst.setString(8, "2022-03-27 18:59:24");
            pst.setInt(9, 1);
            pst.setString(10, code2);

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

    public List<User> test(String SearchValue, String SearchKey, String SortKey) {
        List<User> users = new ArrayList<>();
        String requete = "";

        if (SearchValue.isEmpty()) {

            if (SortKey.isEmpty()) {
                requete = "SELECT * FROM `user`";
            } else if (SortKey.equals("Email")) {
                requete = "SELECT * FROM `user` ORDER BY email ASC";
            } else if (SortKey.equals("Full Name")) {
                requete = "SELECT * FROM `user` ORDER BY firstname ASC ";
            } else if (SortKey.equals("Username")) {
                requete = "SELECT * FROM `user` ORDER BY usertag ASC";
            }

        } else if (SearchKey.equals("Email")) {
            requete = "SELECT * FROM `user` WHERE email LIKE" + "'%" + SearchValue + "%'";
        } else if (SearchKey.equals("Full Name")) {
            requete = "SELECT * FROM `user` WHERE firstname LIKE" + "'%" + SearchValue + "%'";
        } else if (SearchKey.equals("Username")) {
            requete = "SELECT * FROM `user` WHERE usertag LIKE" + "'%" + SearchValue + "%'";
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

    public String ForgetPassword(String email) {

        String getrequete = "SELECT * FROM `user` where email=" + "'" + email + "'";

        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(getrequete);

            while (rs.next()) {
                if (rs.getString("email").equals(email)) {

                    SecureRandom secureRandom = new SecureRandom(); //threadsafe
                    Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe
                    byte[] randomBytes = new byte[10];
                    secureRandom.nextBytes(randomBytes);

                    String requete2 = "UPDATE `USER` set reset_token=? where id=?;";
                    try {
                        pst = cnx.prepareStatement(requete2);
                        pst.setString(1, base64Encoder.encodeToString(randomBytes));
                        pst.setString(2, rs.getString("id"));
                        pst.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    return base64Encoder.encodeToString(randomBytes);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);

        }
        return "error";
    }

    public String resetPasswordToken(String token) {

        String getrequete = "SELECT * FROM `user` where reset_token=" + "'" + token + "'";

        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(getrequete);

            while (rs.next()) {
                if (rs.getString("reset_token").equals(token)) {

                    return rs.getString("id");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);

        }
        return "error";
    }

    public void SetNewPasswordReset(String Password, String id) {

        String requete = "UPDATE `USER` set password=? where id=?;";
        Argon2 argon2jvm = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id, 16, 32);
        String arg2pwd = argon2jvm.hash(10, 65536, 1, Password);
        try {
            pst = cnx.prepareStatement(requete);
            pst.setString(1, arg2pwd);
            pst.setString(2, id);

            pst.executeUpdate();
            System.out.println("mdp mise a jour");
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String VerificationCode(String code, String email) {

        String getrequete = "SELECT * FROM `user` where verification_code=" + "'" + code + "'" + " and email=" + "'" + email + "'";

        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(getrequete);

            while (rs.next()) {
                if (rs.getString("verification_code").equals(code)) {
                    String requete = "UPDATE `USER` set verification_code=? where email=?;";

                    try {
                        pst = cnx.prepareStatement(requete);
                        pst.setString(1, null);
                        pst.setString(2, email);

                        pst.executeUpdate();
                        System.out.println("mdp mise a jour");
                    } catch (SQLException ex) {
                        Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return "success";
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);

        }
        return "error";
    }
    
    //This is used in Comments
    public User fetchById(int id_user) {
      
       
        User us = new User();
        String request = "SELECT * FROM user WHERE id=?;";

        try {
            pst = cnx.prepareStatement(request);
            pst.setInt(1, id_user);

            ResultSet r = pst.executeQuery();
            while (r.next()) {
                us.setId(Integer.valueOf(r.getString(1)));
                us.setEmail((r.getString(2)));
                us.setFirstname(r.getString(5));
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return us;
    }
}
