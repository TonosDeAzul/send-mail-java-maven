package correo;

import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
    
    public String getRandom(){
        Random random = new Random();
        int number = random.nextInt(999999);
        return String.format("%06d", number);
    }
    
    public static void sendEmail(User user) throws AddressException{
        
        try {
            // Correo destinatario
            String to = user.getEmail();
            // Correo remitente
            String from = "dg.wrq109@gmail.com";
            
            // Mailtrap proveedor
//            final String username = "978d57af2cc5fa";
//            final String password = "d4c4a0b2f107c4";
            
            final String username = "dg.wrq109@gmail.com";
            final String password = "fjyzmsjlewlqmoza";
            
            // Host de Mailtrap
//            String host = "sandbox.smtp.mailtrap.io";
            String host = "smtp.gmail.com";
            
            // Configuración SMTP
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            
            // Creación del objeto Session
            Session session = Session.getInstance(props,
                    
                    new Authenticator(){
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication(){
                            return new PasswordAuthentication(username, password);
                        }
                    });
            
            // Creación del mensaje con el objeto MimeMessage
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            
            message.setSubject("Prueba de correo2 :D");
            message.setText("Su código de verificación: " + user.getCode());
            
            Transport.send(message);
            
            System.out.println("Correo enviado sactifactoriamente");
        } catch (MessagingException ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
