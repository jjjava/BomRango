package br.com.schumaker.managedbean;

import br.com.schumaker.mail.SendBrief;
import br.com.schumaker.model.MensagemContato;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 * @author hudson schumaker HStudio - @BomRango 10/01/2015
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@ManagedBean
@ViewScoped
public class MensagemContatoManegedBean implements Serializable {

    private MensagemContato mContato;
    private String mRetorno;

    public MensagemContatoManegedBean() {
        mContato = new MensagemContato();
        mRetorno = "";
    }

    public void onSend() {
        SendBrief send = new SendBrief();
        send.setTo("hudson@schumaker.com.br");
        send.setSubject(mContato.getAssunto());
        send.setMessage("De: " + mContato.getNome() + "\n"
                + "Email: " + mContato.getEmail() + "\n"
                + "Mensagen: \n" + mContato.getMessage() + "\nFim.");
        if (send.sendMessage()) {
            mRetorno = "Mensagem enviado com sucesso.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Envio:", mRetorno);
            RequestContext.getCurrentInstance().showMessageInDialog(message);
            try {
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);//nao esta funcionando
                FacesContext.getCurrentInstance().getExternalContext().redirect("faces/index.xhtml");
            } catch (IOException ex) {
                System.err.println(ex);
            }
        } else {
            mRetorno = "Erro ao enviar a mensagem.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Envio:", mRetorno);
            RequestContext.getCurrentInstance().showMessageInDialog(message);
        }
    }

    public MensagemContato getmContato() {
        return mContato;
    }

    public void setmContato(MensagemContato mContato) {
        this.mContato = mContato;
    }

    public String getmRetorno() {
        return mRetorno;
    }
}
