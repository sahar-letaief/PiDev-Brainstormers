package tn.esprit.entities;

/**
 *
 * @author sami
 */
public class Tags {

    private int id;
    private String tag1;
    private String tag2;
    private String tag3;
    private int id_comment;

    public Tags() {
    }

    public Tags(String tag1, int id_comment) {
        this.tag1 = tag1;
        this.id_comment = id_comment;
    }

    public Tags(String tag1, String tag2, int id_comment) {
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.id_comment = id_comment;
    }

    public Tags(String tag1, String tag2, String tag3, int id_comment) {
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.tag3 = tag3;
        this.id_comment = id_comment;
    }

    public Tags(int id, String tag1, String tag2, String tag3, int id_comment) {
        this.id = id;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.tag3 = tag3;
        this.id_comment = id_comment;
    }

    public int getId() {
        return id;
    }

    public String getTag1() {
        return tag1;
    }

    public String getTag2() {
        return tag2;
    }

    public String getTag3() {
        return tag3;
    }

    public int getId_comment() {
        return id_comment;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }

    public void setTag3(String tag3) {
        this.tag3 = tag3;
    }

    public void setId_comment(int id_comment) {
        this.id_comment = id_comment;
    }

    @Override
    public String toString() {
        return "Tags{" + "id=" + id + ", tag1=" + tag1 + ", tag2=" + tag2 + ",tag3=" + tag3 + ",id_comment= " + id_comment + '}';
    }
}
