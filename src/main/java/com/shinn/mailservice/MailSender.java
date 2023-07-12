package com.shinn.mailservice;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailSender {
    // email: lampt.22it@vku.udn.vn
    // pass: bltjsgqbcbtihvrw
    private static final String from = "lampt.22it@vku.udn.vn";
    private static final String password = "bltjsgqbcbtihvrw";

    public MailSender() {

    }

    private Properties defineProp() {
        Properties props= new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        return props;
    }
    public boolean sendEmail(String to, String content) {

        Properties props = defineProp();

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };
        Session session = Session.getInstance(props, auth);
        MimeMessage msg =  new MimeMessage(session);
        try {
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.setFrom(from);
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            msg.setSubject("Lấy lại mật khẩu - BookStore");
            msg.setSentDate(new Date());
            msg.setText("Mật khẩu của bạn là: " + content + ", Vui lòng nhập lại mật khẩu.", "UTF-8");
            Transport.send(msg);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
