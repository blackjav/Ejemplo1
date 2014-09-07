/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;


/**
 *
 * @author javs
 */


import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class Mail {
    
    
    public void enviarMail(String correoDestinatario,String asunto, String
textoCorreo) throws MessagingException{
try {
    // Propiedades de la conexión
    Properties props = new Properties();
    props.setProperty("mail.smtp.host", "smtp.gmail.com");//el segundo parametro se cambia deacuerdo a el smtp
    props.setProperty("mail.smtp.starttls.enable", "true");
    props.setProperty("mail.smtp.port", "587");
    props.setProperty("mail.smtp.user", "javierhm810@gmail.com");
    props.setProperty("mail.smtp.auth", "true");

    // Inicializar la Sesion la sesion
    Session session = Session.getDefaultInstance(props);

    // el mensaje
    MimeMessage message = new MimeMessage(session);
    message.setFrom(new InternetAddress("jav810@hotmail.com"));
    message.addRecipient(Message.RecipientType.TO,new InternetAddress(correoDestinatario));
    message.addRecipient(Message.RecipientType.BCC,new InternetAddress("jav810hotmail.com"));
    //CC A quien s ele envia una copia Oculta
    //BCC A quien s ele envia una copia Oculta

    message.setSubject(asunto);
    message.setText(textoCorreo);
    // envio MEnsaje.
    Transport trasporte = session.getTransport("smtp");
    trasporte.connect("correo","contraseña");
    trasporte.sendMessage(message, message.getAllRecipients());
    // Cierre.
    trasporte.close();
    } catch (Exception e) {
    e.printStackTrace();
    }
    
  }
}
