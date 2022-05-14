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
import tn.esprit.entities.Tags;
import tn.esprit.utils.Datasource;

/**
 *
 * @author sami
 */
public class TagsService  {

    private Connection con;
    private Statement statement;
    private PreparedStatement prepstatement;

    public TagsService() {
        //Récupération de la connection à la base de données
        con = Datasource.getInstance().getCnx();
    }

    
    public void create(Tags t) {
        String request = "INSERT INTO `tags` (`tag1`,`tag2`,`tag3`,`comment_id`) VALUES ('" + t.getTag1() + "','" + t.getTag2() + "','" + t.getTag3() + "','" + t.getId_comment() + "');";
        try {
            statement = con.createStatement();
            statement.executeUpdate(request);
            System.out.println("Tags added");

        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createPst(Tags t) {
        String request = "INSERT INTO `tags` (`comment_id`,`tag1`,`tag2`,`tag3`) VALUES (?,?,?,?);";

        try {
            prepstatement = con.prepareStatement(request);
            prepstatement.setString(2, t.getTag1());
            prepstatement.setString(3, t.getTag2());
            prepstatement.setString(4, t.getTag3());
            prepstatement.setInt(1, t.getId_comment());
            prepstatement.executeUpdate();
            System.out.println("Tags added");
        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public List<Tags> read() {
        List<Tags> tags = new ArrayList<>();
        String request = "SELECT * FROM `tags`";

        try {
            statement = con.createStatement();
            ResultSet results = statement.executeQuery(request);

            while (results.next()) {
                tags.add(new Tags(results.getString("tag1"), results.getString("tag2"), results.getInt("tag3")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tags;
    }

    public void Modify(int tagid) {
        //List<Tags> tags = new ArrayList<>();
        String request = "UPDATE FROM `tags` WHERE id=?";

        try {
            statement = con.createStatement();
            statement.executeQuery(request);

        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Delete(int tagid) {
        //List<Tags> tags = new ArrayList<>();
        String request = "DELETE FROM `tags` WHERE id=?";

        try {
            statement = con.createStatement();
            statement.executeQuery(request);

        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
