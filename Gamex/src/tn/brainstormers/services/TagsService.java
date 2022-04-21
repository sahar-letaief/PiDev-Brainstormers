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
import tn.brainstormers.entities.Tags;
import tn.brainstormers.utils.Datasource;
/**
 *
 * @author sami
 */
public class TagsService implements IService<Tags>{
    
    private Connection con;
    private Statement statement;
    private PreparedStatement prepstatement;
    public TagsService() {
        //Récupération de la connection à la base de données
        con = Datasource.getInstance().getCnx();
    }
     @Override
    public void create(Tags t) {
        String request = "INSERT INTO `tags` (`tag1`,`tag2`,`tag3`,`id_comment`) VALUES ('" + t.getTag1() + "','" + t.getTag2() + "','" + t.getTag3() + "','" + t.getId_comment()+ "');";
        try {
            statement = con.createStatement();
            statement.executeUpdate(request);
            System.out.println("Tags added");

        } catch (SQLException ex) {
            Logger.getLogger(CommentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        @Override
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
}
