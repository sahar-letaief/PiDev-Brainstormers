package tn.esprit.entities;

/**
 *
 * @author sami
 */
public class Comment {

    private int id;
    private int id_user;
    private int id_event;
    private String comment;
    private int stars;

    //Constructors
    public Comment() {
    }

    public Comment(int stars) {
        this.stars = stars;
    }

    public Comment(int id_user, int id_event, String comment, int stars) {
        this.id_user = id_user;
        this.id_event = id_event;
        this.comment = comment;
        this.stars = stars;
    }

    public Comment(int id, int id_user, int id_event, String comment, int stars) {
        this.id_user = id_user;
        this.id_event = id_event;
        this.comment = comment;
        this.stars = stars;
    }

    //Getters
    public int getId() {
        return id;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_event() {
        return id_event;
    }

    public String getComment() {
        return comment;
    }

    public int getStars() {
        return stars;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", id_user=" + id_user + ", id_event=" + id_event + ",comment=" + comment + ",stars= " + stars + '}';
    }

}
