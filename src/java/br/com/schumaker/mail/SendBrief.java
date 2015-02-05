package br.com.schumaker.mail;

import br.com.schumaker.bs.impl.LogBsImpl;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Hudson Schumaker 
 */
public class SendBrief {

    private String from;
    private String to;
    private String subject;
    private String message;
    private String pass;

    public SendBrief() {
        from = "schumakerteam@schumaker.com.br";
        pass = "P@ssw0rd";
    }

    public Boolean sendMessage() {
        boolean res = false;
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.schumaker.com.br");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.starttls.enable", "true");
            Session s = Session.getDefaultInstance(props, new Autenticar(getFrom(), getPass()));
            MimeMessage email = new MimeMessage(s);
            InternetAddress de = new InternetAddress(getFrom());
            email.setFrom(de);
            InternetAddress para = new InternetAddress(getTo());
            email.addRecipient(Message.RecipientType.TO, para);
            email.setSubject(getSubject());
            email.setText(getMessage());
            Transport.send(email);
            res = true;
        } catch (AddressException ex) {
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            res = false;
        } catch (MessagingException ex) {
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            res = false;
        }
        return res;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
