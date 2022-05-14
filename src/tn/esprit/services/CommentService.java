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
import tn.esprit.entities.Comment;
import tn.esprit.utils.Datasource;

/**
 *
 * @author sami
 */
public class CommentService {

    private Connection con;
    private Statement statement;
    private PreparedStatement prepstatement;

    public CommentService() {
        //Récupération de la connection à la base de données
        con = Datasource.getInstance().getCnx();
    }

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

    public void update(Comment c) {
        String request = "UPDATE `comments` SET `comment` =?,`stars` =? WHERE `comments`.`id` =?; ";

        try {
            prepstatement = con.prepareStatement(request);
            prepstatement.setInt(2, c.getStars());
            prepstatement.setString(1, c.getComment());
            prepstatement.setInt(3, c.getId());
            prepstatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int searchById(int id_user, int id_event) {

        String request = "SELECT COUNT(*) id FROM comments WHERE id_user=? AND id_event=?;";
        int i;
        i = 0;
        try {
            prepstatement = con.prepareStatement(request);
            prepstatement.setInt(1, id_user);
            prepstatement.setInt(2, id_event);
            ResultSet r = prepstatement.executeQuery();
            while (r.next()) {
                i = Integer.valueOf(r.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public Comment fetchById(int id_user, int id_event) {

        String request = "SELECT * FROM comments WHERE id_user=? AND id_event=?;";
        Comment com = new Comment();
        try {
            prepstatement = con.prepareStatement(request);
            prepstatement.setInt(1, id_user);
            prepstatement.setInt(2, id_event);
            ResultSet r = prepstatement.executeQuery();
            while (r.next()) {
                com.setId(Integer.valueOf(r.getString(1)));
                com.setId_user(Integer.valueOf(r.getString(2)));
                com.setId_event(Integer.valueOf(r.getString(3)));
                com.setComment(r.getString(4));
                com.setStars(Integer.valueOf(r.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(com.getId() + " " + com.getId_user() + " " + com.getId_event() + " " + com.getComment() + " " + com.getStars());
        return com;
    }

    public void Delete(int id) {

        String request = "DELETE FROM comments WHERE id=?;";
        try {
            prepstatement = con.prepareStatement(request);
            prepstatement.setInt(1, id);
            prepstatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int Stars(int stars) {
        String request = "SELECT COUNT(*) FROM comments WHERE stars=?;";
        int s = 0;
        try {
            prepstatement = con.prepareStatement(request);
            prepstatement.setInt(1, stars);
            ResultSet r = prepstatement.executeQuery();
            while (r.next()) {
                s = Integer.valueOf(r.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

}
