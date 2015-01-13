
package br.com.schumaker.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author Hudson Schumaker
 */
public class Autenticar extends Authenticator {
    
    private String user;
    private String pass;
    public Autenticar(){
        
    }
    public Autenticar(String user, String pass){
        this.user = user;
        this.pass = pass;
    }
    @Override
    public PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(user, pass);
    }
}