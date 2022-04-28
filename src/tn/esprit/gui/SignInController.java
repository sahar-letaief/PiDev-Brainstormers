/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import tn.esprit.entities.User;
import tn.esprit.entities.UserStaticSession;
import tn.esprit.services.UserServices;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class SignInController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private Label EmailError;
    @FXML
    private Label forgetPassword;
    @FXML
    private VBox SignInBox;
    @FXML
    private VBox ForgottenPasswordBox;
    @FXML
    private TextField emailForgotPassword;
    @FXML
    private Button BackForgotPasswordToSignIn;
    @FXML
    private Button SendEmailForgotPassword;
    @FXML
    private Label errorLabelForgotPassword;
    @FXML
    private HBox CodeHbox;
    @FXML
    private HBox NewPasswordHbox;
    @FXML
    private TextField CodeForgotPassword1;
    public static String idResetUserPassword = "";
    @FXML
    private TextField NewPasswordUser;
    @FXML
    private Label errorLabelForgotPassword1;
    @FXML
    private TextField PhoneCode;
    @FXML
    private HBox CodeHbox1;
    @FXML
    private TextField CodeForgotPassword11;
    @FXML
    private HBox NewPasswordHbox1;
    @FXML
    private TextField NewPasswordUser1;
    @FXML
    private Button SignOutCode;
    @FXML
    private Button SubmitverificationCode;
    @FXML
    private VBox VerificationCodeHbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void onLogin(ActionEvent event) {

        User user = new User(email.getText(), password.getText());
        UserServices Us = new UserServices();

        String res = Us.SignIn(user);
        System.out.println(res);
        if (res.equals("error")) {
            EmailError.setVisible(true);
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("DisplayUsersBack.fxml"));

        try {
            if (res.equals("empty")) {
                Parent root = loader.load();
                Scene scene = new Scene(root);
                DisplayUsersBackController displayUsersBackController = loader.getController();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();

            } else {
                SignInBox.setVisible(false);
                ForgottenPasswordBox.setVisible(false);
                VerificationCodeHbox.setVisible(true);
            }
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onSignUp(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));

        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onforgotpasswordclicked(MouseEvent event) {
        SignInBox.setVisible(false);
        ForgottenPasswordBox.setVisible(true);
        VerificationCodeHbox.setVisible(false);

    }

    @FXML
    private void onBackFromForgotPasswordToSignIn(ActionEvent event) {
        SignInBox.setVisible(true);
        ForgottenPasswordBox.setVisible(false);
        VerificationCodeHbox.setVisible(false);

    }

    @FXML
    private void onSendEmailForgotPassword(ActionEvent event) {
        UserServices us = new UserServices();
        if (SendEmailForgotPassword.getText().equals("Send Email")) {

            String res = us.ForgetPassword(emailForgotPassword.getText());
            if (res.equals("error")) {
                System.out.print(res + "\n");
                errorLabelForgotPassword.setVisible(true);
            } else {
                errorLabelForgotPassword.setVisible(false);
                CodeHbox.setVisible(true);

                Properties props = System.getProperties();
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.port", "587");
                Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("stagesymfony@gmail.com", "Salwaghozzi10");
                    }
                }
                );

                try {

                    MimeMessage m = new MimeMessage(session);
                    m.setFrom(new InternetAddress("no-reply@gmail.com"));
                    m.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(emailForgotPassword.getText()));
                    m.setSubject("Reset Password Token");
                    m.setText("Token : " + res);

                    Transport.send(m);
                    System.err.println("message sent");
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        } else if (SendEmailForgotPassword.getText().equals("Submit")) {

            us.SetNewPasswordReset(NewPasswordUser.getText(), idResetUserPassword);
            SignInBox.setVisible(true);
            ForgottenPasswordBox.setVisible(false);
            VerificationCodeHbox.setVisible(false);

        }

    }

    @FXML
    private void onCodeInertedChanged(KeyEvent event) {

        UserServices us = new UserServices();
        String res = us.resetPasswordToken(CodeForgotPassword1.getText());
        if (res.equals("error")) {
            System.err.println(res + "waaaaaaaaa");
        } else {
            idResetUserPassword = res;
            NewPasswordHbox.setVisible(true);
            SendEmailForgotPassword.setText("Submit");
        }

    }

    @FXML
    private void onSignOutFromCode(ActionEvent event) {
        SignInBox.setVisible(true);
        ForgottenPasswordBox.setVisible(false);
        VerificationCodeHbox.setVisible(false);
    }

    @FXML
    private void onSubmitVerificationCode(ActionEvent event) {
        String code = PhoneCode.getText();
        UserServices us = new UserServices();
        String res = us.VerificationCode(code, UserStaticSession.getEmail());
        if (res.equals("error")) {
            System.err.println(res + "codeeee");
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DisplayUsersBack.fxml"));

            try {
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    DisplayUsersBackController displayUsersBackController = loader.getController();
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.centerOnScreen();
                    stage.show();
            } catch (IOException ex) {
                Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
