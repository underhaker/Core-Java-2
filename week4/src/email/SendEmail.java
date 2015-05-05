package email;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {
    public static void sendEmail(String emailTo,String nameTo,String emailFrom,String emailPassword, String nameFrom) throws MalformedURLException, EmailException{
//        HtmlEmail email=new ImageHtmlEmail();
//        URL urlImage= new URL("http://d3dsacqprgcsqh.cloudfront.net/photo/azbW3zq_460sa_v1.gif");
         EmailAttachment attachment = new EmailAttachment();
         URL url=new URL("http://d3dsacqprgcsqh.cloudfront.net/photo/azbW3zq_460sa_v1.gif");
         attachment.setURL(url);
         attachment.setDisposition(EmailAttachment.ATTACHMENT);
         attachment.setDescription("Gif of Suarez accident.");
         attachment.setName("Suarez.gif");
         MultiPartEmail email = new MultiPartEmail();
         email.setHostName("smtp.gmail.com");
         email.setDebug(true);
         email.setSmtpPort(587);
//         email.setSS
         email.setStartTLSEnabled(true);
         email.setAuthenticator(new DefaultAuthenticator(emailFrom,emailPassword)); 
         email.addTo(emailTo, nameTo);
         email.setFrom(emailFrom, nameFrom);
         email.setSubject("Email test");
         String message="This is an e-mail test using java.\nSending a picture of the Suarez incident.";
         email.setMsg(message);
         email.attach(attachment);
         email.send();
    }
    public static void main(String[] args) {
        try {
            sendEmail("chris_jericho@abv.bg","Pesho","yoan.stoyanov11@gmail.com","goranman11","Penko");
//            sendEmail("yoan.stoyanov11@gmail.com","Jonny","chris_jericho@abv.bg","Pesho");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (EmailException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
