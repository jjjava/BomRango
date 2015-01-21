package br.com.schumaker.managedbean;

import br.com.schumaker.bs.impl.MensagemContatoBsImpl;
import br.com.schumaker.model.MensagemContato;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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

    public MensagemContatoManegedBean() {
        mContato = new MensagemContato();
    }

    public void onSend() {
       new MensagemContatoBsImpl().enviarMensagem(mContato);
    }

    public MensagemContato getmContato() {
        return mContato;
    }

    public void setmContato(MensagemContato mContato) {
        this.mContato = mContato;
    }
}
