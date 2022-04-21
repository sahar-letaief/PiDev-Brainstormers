package tn.brainstormers.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.brainstormers.entities.Comment;
import tn.brainstormers.utils.Datasource;

/**
 *
 * @author sami
 */
public class CommentService implements IService<Comment> {

    private Connection con;
    private Statement statement;
    private PreparedStatement prepstatement;

    public CommentService() {
        //Récupération de la connection à la base de données
        con = Datasource.getInstance().getCnx();
    }

    @Override
    public void create(Comment c) {
        String request = "INSERT INTO `comments` (`id_user`,`id_event`,`comment`,`stars`) VALUES ('" + c.getId_user() + "','" + c.getId_event() + "','" + c.getComment() + "','" + c.getStars() + "');";
        try {
            statement = con.createStatement();
            statement.executeUpdate(request);
            System.out.println("Comment added");

        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createPst(Comment c) {
        String request = "INSERT INTO `comments` (`id_user`,`id_event`,`comment`,`stars`) VALUES (?,?,?,?);";

        try {
            prepstatement = con.prepareStatement(request);
            prepstatement.setInt(1, c.getId_user());
            prepstatement.setInt(2, c.getId_event());
            prepstatement.setString(3, c.getComment());
            prepstatement.setInt(4, c.getStars());
            prepstatement.executeUpdate();
            System.out.println("Comment added");
        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Comment> read() {
        List<Comment> comments = new ArrayList<>();
        String request = "SELECT * FROM `comments`";

        try {
            statement = con.createStatement();
            ResultSet results = statement.executeQuery(request);

            while (results.next()) {
                comments.add(new Comment(results.getInt("id"), results.getInt("id_event"), results.getString("comment"), results.getInt("stars")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return comments;
    }
    public void delcom(String com){
    String request = "DELETE FROM `comments` WHERE comment=?;";
      try {
            prepstatement = con.prepareStatement(request);
            prepstatement.setString(1, com);
            prepstatement.executeUpdate();
            System.out.println("Comment deleted");
        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     //public Comment readbycomment(String com) {
        
   /*List<Comment> comments = new ArrayList<>();
        String request = "SELECT * FROM `comments` WHERE comment";

        try {
            statement = con.createStatement();
            ResultSet results = statement.executeQuery(request);
            
            while (results.next()) {
                Comment retcom= new Comment(results.getInt("stars"));
                //comments.add(new Comment(results.getInt("id"), results.getInt("id_event"), results.getString("comment"), results.getInt("stars")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retcom;
    }*/
    /*
    @Override
    public void modifier(Personne t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void supprimer(Personne t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     */
}
