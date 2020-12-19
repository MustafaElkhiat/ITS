package utilites;


import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtil {
    public static void sendMail(String recipient, String subject, String text) throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        String accountEmail = "ticket.system1111@gmail.com";
        String password = "ticket1111";
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(accountEmail, password);
            }
        });
        Message message = prepareMessage(session, accountEmail, recipient, subject, text);
        Transport.send(message);
    }

    private static Message prepareMessage(Session session, String accountEmail, String recipient, String subject, String text) throws AddressException {
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(accountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);
            //message.setText(text);
            message.setContent(text, "text/html");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return message;
    }

}
