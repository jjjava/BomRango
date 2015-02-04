package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.MensagemContatoBs;
import br.com.schumaker.mail.SendBrief;
import br.com.schumaker.model.MensagemContato;
import br.com.schumaker.util.HsCommons;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 * @author hudson schumaker HStudio - @BomRango 21/01/2015
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class MensagemContatoBsImpl implements MensagemContatoBs {

    @Override
    public void enviarMensagem(MensagemContato sms) {
        String mRetorno;
        SendBrief send = new SendBrief();
        send.setTo(HsCommons.EMAIL);
        send.setSubject(sms.getAssunto());
        send.setMessage(comporMensagem(sms));
        if (send.sendMessage()) {
            mRetorno = "Mensagem enviada com sucesso.";
            mostrarMensagem(FacesMessage.SEVERITY_INFO, "Envio:", mRetorno);
            try {
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);//nao esta funcionando
                FacesContext.getCurrentInstance().getExternalContext().redirect("faces/index.xhtml");
            } catch (IOException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        } else {
            mRetorno = "Erro ao enviar a mensagem.";
            mostrarMensagem(FacesMessage.SEVERITY_INFO, "Envio:", mRetorno);
        }
    }
    
    private String comporMensagem(MensagemContato sms){
        return "De: " + sms.getNome() + "\n" + "Email: " + sms.getEmail() + "\n" + "Mensagen: \n" + sms.getMessage() + "\nFim.";
    }

    private void mostrarMensagem(FacesMessage.Severity sev, String titulo, String mensagem) {
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(sev, titulo, mensagem));
    }
}
