/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services;

import tn.esprit.utils.MailService;

/**
 *
 * @author Nidhal
 */
public class MailerService1 {
    public void replyMail(String mail ,String Username , String Description) {
        String from = "rihab.aljene@esprit.tn";
        String pass = "";
        String[] to = {"" + mail}; // list of recipient email addresses
        String subject = "GameX";
        String body = Description ;
        MailService serv = new MailService();
        serv.sendFromGMail(from,pass,to,subject,body);
    }
}
