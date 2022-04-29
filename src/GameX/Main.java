package GameX;

import tn.brainstormers.services.CommentService;

/**
 *
 * @author remo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //CommentService ps = new CommentService();
        //Comment c = new Comment(2, 18, "test2", 3);
        //ps.createPst(c);
        //System.out.println(ps.afficher());
        CommentService cs = new CommentService();

        System.out.println(cs.read());
    }

}
