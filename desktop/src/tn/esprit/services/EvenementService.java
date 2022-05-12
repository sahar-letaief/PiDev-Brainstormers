package tn.esprit.services;

//import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Element;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import tn.esprit.entities.Evenement;
import tn.esprit.entities.User;
import tn.esprit.utils.Datasource;

/**
 *
 * @author sami
 */
public class EvenementService {

    public Connection cnx;
    public Statement ste;
    public PreparedStatement pst;

    public EvenementService() {
        cnx = (Connection) Datasource.getInstance().getCnx();
    }

    public void AddEvent(Evenement e) {
        String requete = "INSERT INTO `evenement` (`name_event`,`place_event`,`nb_participants`,`price_event`,`date_debut`,`date_fin`) "
                + "VALUES (?,?,?,?,?,?);";

        try {
            pst = (PreparedStatement) cnx.prepareStatement(requete);
            pst.setString(1, e.getNameEvent());
            pst.setString(2, e.getPlaceEvent());
            pst.setInt(3, e.getNbParticipants());
            pst.setFloat(4, e.getPriceEvent());
            pst.setString(5, e.getDateDebut());
            pst.setString(6, e.getDateFin());
            pst.executeUpdate();
            System.out.println("event " + e.getNameEvent() + " added successfully");
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObservableList<Evenement> FetchEvents() {
        ObservableList<Evenement> events = FXCollections.observableArrayList();
        String requete = "SELECT * FROM `evenement`";

        try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs = ste.executeQuery(requete);

            while (rs.next()) {
                events.add(new Evenement(rs.getInt("id"), rs.getString("name_event"), rs.getString("place_event"),
                        rs.getInt("nb_participants"), rs.getFloat("price_event"), rs.getString("date_debut"), rs.getString("date_fin")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return events;
    }

    public List<Evenement> FetchEventsFront() {
        List<Evenement> events = new ArrayList<>();
        String requete = "SELECT * FROM `evenement`";

        try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs = ste.executeQuery(requete);

            while (rs.next()) {
                events.add(new Evenement(rs.getInt("id"), rs.getString("name_event"), rs.getString("place_event"),
                        rs.getInt("nb_participants"), rs.getFloat("price_event"), rs.getString("date_debut"), rs.getString("date_fin")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return events;
    }

    public Evenement FetchOneEvent(int id) {
        Evenement event = new Evenement();
        String requete = "SELECT * FROM `evenement` where id=" + id;

        try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs = ste.executeQuery(requete);

            while (rs.next()) {

                event = new Evenement(rs.getInt("id"), rs.getString("name_event"), rs.getString("place_event"), rs.getInt("nb_participants"), rs.getFloat("price_event"), rs.getString("date_debut"), rs.getString("date_fin"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return event;
    }

    public ObservableList<Evenement> FetchOneEventBack(int id) {
        ObservableList<Evenement> event = FXCollections.observableArrayList();
        String requete = "SELECT * FROM `evenement` where id=" + id;

        try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs = ste.executeQuery(requete);

            while (rs.next()) {

                event.add(new Evenement(rs.getInt("id"), rs.getString("name_event"), rs.getString("place_event"), rs.getInt("nb_participants"), rs.getFloat("price_event"), rs.getString("date_debut"), rs.getString("date_fin")));

            }

        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return event;
    }

    public void updatePar(Evenement e) {
        String requete = "update `evenement` set name_event=?,place_event=?,nb_participants=?,price_event=?,date_debut=?,date_fin=? where id=?";
        try {

            pst = (PreparedStatement) cnx.prepareStatement(requete);

            pst.setString(1, e.getNameEvent());
            pst.setString(2, e.getPlaceEvent());
            pst.setInt(3, e.getNbParticipants());
            pst.setFloat(4, e.getPriceEvent());
            pst.setString(5, e.getDateDebut());
            pst.setString(6, e.getDateFin());
            pst.setInt(7, e.getId());
            pst.executeUpdate();
            System.out.println("participants number of event " + e.getNameEvent() + " is updated successfully");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public User FetchOneUser(int id) {
        User user = new User();
        String requete = "SELECT * FROM `user` where id=" + id;

        try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs = ste.executeQuery(requete);

            while (rs.next()) {

                user = new User(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), rs.getInt("phone_number"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public void DeleteEvent(int id) {
        String requete = "delete from `evenement` where id=?";
        try {
            pst = (PreparedStatement) cnx.prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("event with id=" + id + " is deleted successfully");
        } catch (SQLException ex) {
            System.out.println("error in delete event " + ex.getMessage());
        }
    }

    public void EditEvent(Evenement e) {
        System.out.println("dkhal requete " + e);
        String requete = "update `evenement` set name_event=?,place_event=?,nb_participants=?,price_event=?,date_debut=?,date_fin=? where id=" + e.getId();
        try {

            pst = (PreparedStatement) cnx.prepareStatement(requete);
//            java.sql.PreparedStatement pst = cnx.prepareStatement(requete);

            pst.setString(1, e.getNameEvent());
            System.out.println("loula " + e.getNameEvent());
            pst.setString(2, e.getPlaceEvent());
            System.out.println("loula " + e.getPlaceEvent());
            pst.setInt(3, e.getNbParticipants());
            System.out.println("loula " + e.getNbParticipants());
            pst.setFloat(4, e.getPriceEvent());
            System.out.println("loula " + e.getPriceEvent());
            pst.setString(5, e.getDateDebut());
            System.out.println("loula " + e.getDateDebut());
            pst.setString(6, e.getDateFin());
            System.out.println("loula " + e.getDateFin());
            //pst.setInt(7, e.getId());
            pst.executeUpdate();
            System.out.println("event " + e.getNameEvent() + "with id=" + e.getId() + " is updated successfully");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Evenement> SortEventByPrice() {
        List<Evenement> events = new ArrayList<>();
        String requete = "SELECT * FROM `evenement` ORDER BY price_event";

        try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs = ste.executeQuery(requete);

            while (rs.next()) {
                events.add(new Evenement(rs.getInt("id"), rs.getString("name_event"), rs.getString("place_event"),
                        rs.getInt("nb_participants"), rs.getFloat("price_event"), rs.getString("date_debut"), rs.getString("date_fin")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return events;
    }

    public List<Evenement> SortEventByPart() {
        List<Evenement> events = new ArrayList<>();
        String requete = "SELECT * FROM `evenement` ORDER BY nb_participants";

        try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs = ste.executeQuery(requete);

            while (rs.next()) {
                events.add(new Evenement(rs.getInt("id"), rs.getString("name_event"), rs.getString("place_event"),
                        rs.getInt("nb_participants"), rs.getFloat("price_event"), rs.getString("date_debut"), rs.getString("date_fin")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return events;
    }

    public ObservableList<Evenement> FindEventByName(String name) {
        ObservableList<Evenement> events = FXCollections.observableArrayList();
        String requete = "SELECT * FROM `evenement` WHERE name_event LIKE '%" + name + "%'";

        try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs = ste.executeQuery(requete);

            while (rs.next()) {
                events.add(new Evenement(rs.getInt("id"), rs.getString("name_event"), rs.getString("place_event"),
                        rs.getInt("nb_participants"), rs.getFloat("price_event"), rs.getString("date_debut"), rs.getString("date_fin")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return events;
    }

    public List<Evenement> FindEventByNameFront(String name) {
        List<Evenement> events = new ArrayList<>();
        String requete = "SELECT * FROM `evenement` WHERE name_event LIKE '%" + name + "%'";

        try {
            ste = (Statement) cnx.createStatement();
            ResultSet rs = ste.executeQuery(requete);

            while (rs.next()) {
                events.add(new Evenement(rs.getInt("id"), rs.getString("name_event"), rs.getString("place_event"),
                        rs.getInt("nb_participants"), rs.getFloat("price_event"), rs.getString("date_debut"), rs.getString("date_fin")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return events;
    }

    public String GenerateQrEvent(Evenement event) throws FileNotFoundException, IOException {

        String eventName = "event name: " + event.getNameEvent() + "\n" + "event place: " + event.getPlaceEvent() + "\n" + "event price: " + event.getPriceEvent() + "\n";
        ByteArrayOutputStream out = QRCode.from(eventName).to(ImageType.JPG).stream();
        String filename = event.getNameEvent() + "_QrCode.jpg";
        File f = new File("src\\tn\\esprit\\utils\\img\\" + filename);
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(out.toByteArray());
        fos.flush();
        System.out.println("qr yemshi");
        return filename;
    }

    public void GeneratePDF() {
        EvenementService es = new EvenementService();
        Evenement e = new Evenement();
        List<Evenement> events = new ArrayList<>();
        events = es.FetchEvents();
        Font bfBold12 = new Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12, Font.BOLD, new BaseColor(168, 19, 19));

        try {
            String file_name = "C:\\Users\\WIKI\\Desktop\\PI\\desktop\\src\\EventsList.pdf";
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            document.open();
            Paragraph para = new Paragraph("List of events:");
            document.add(para);
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(90f);

            insertCell(table, "Event name", Element.ALIGN_LEFT, 1, bfBold12);
            insertCell(table, "Event place", Element.ALIGN_LEFT, 1, bfBold12);
            insertCell(table, "Begins at", Element.ALIGN_LEFT, 1, bfBold12);
            insertCell(table, "Ends at", Element.ALIGN_LEFT, 1, bfBold12);
            table.setHeaderRows(1);
            for (int i = 0; i < events.size(); i++) {
                table.addCell(events.get(i).getNameEvent());
                table.addCell(events.get(i).getPlaceEvent());
                table.addCell(events.get(i).getDateDebut());
                table.addCell(events.get(i).getDateFin());
            }

            document.add(table);
            //generate image in the pdf
            //document.add(Image.getInstance("tn/esprit/utils/img/logo.png"));

            document.close();
            System.out.println("pdf of list events is done");
        } catch (Exception ex) {
            System.err.println("pdf error" + ex);

        }

    }

    private void insertCell(PdfPTable table, String text, int align, int colspan, Font font) {

        //create a new cell with the specified Text and Font
        PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
        //set the cell alignment
        cell.setHorizontalAlignment(align);
        //set the cell column span in case you want to merge two or more cells
        cell.setColspan(colspan);
        //in case there is no text and you wan to create an empty row
        if (text.trim().equalsIgnoreCase("")) {
            cell.setMinimumHeight(10f);
        }
        //add the call to the table
        table.addCell(cell);

    }
}
