package br.com.schumaker.bs;

import br.com.schumaker.model.MensagemContato;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 21/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface MensagemContatoBs {
    void enviarMensagem(MensagemContato sms);
}
