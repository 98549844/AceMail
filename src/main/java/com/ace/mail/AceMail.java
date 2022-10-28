package com.ace.mail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

import com.ace.mail.util.MailUtil;

import javax.mail.Session;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

/**
 * @Classname: AceMail
 * @Date: 2022/10/28 下午 10:18
 * @Author: kalam_au
 * @Description:
 */


public class AceMail {
    private static final Logger log = LogManager.getLogger(AceMail.class.getName());


    public static void simpleEmail() {
        System.out.println("SimpleEmail Start");
        String smtpHostServer = "smtp.example.com";
        String emailID = "email_me@example.com";
        Properties props = System.getProperties();
        props.put("mail.smtp.host", smtpHostServer);
        Session session = Session.getInstance(props, null);
        MailUtil.sendEmail(session, emailID, "SimpleEmail Testing Subject", "SimpleEmail Testing Body");
    }

    public static void TLSEmail() {
        final String fromEmail = "myemailid@gmail.com"; //requires valid gmail id
        final String password = "mypassword"; // correct password for gmail id
        final String toEmail = "myemail@yahoo.com"; // can be any email id

        System.out.println("TLSEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);
        MailUtil.sendEmail(session, toEmail, "TLSEmail Testing Subject", "TLSEmail Testing Body");
    }

    public static void SSLEmail() {
        final String fromEmail = "kinetixmpfatest2021@gmail.com"; //requires valid gmail id
        final String password = "welcome2mpfa"; // correct password for gmail id
        final String toEmail = "garlam_au@qq.com"; // can be any email id

        System.out.println("SSLEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
        props.put("mail.smtp.port", "587"); //SMTP Port

        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        Session session = Session.getDefaultInstance(props, auth);
        System.out.println("Session created");
        MailUtil.sendEmail(session, toEmail, "SSLEmail Testing Subject", "SSLEmail Testing Body");
        MailUtil.sendAttachmentEmail(session, toEmail, "SSLEmail Testing Subject with Attachment", "SSLEmail Testing Body with Attachment");
        MailUtil.sendImageEmail(session, toEmail, "SSLEmail Testing Subject with Image", "SSLEmail Testing Body with Image");
    }


    public static void main(String[] args) {
        SSLEmail();
    }
}

