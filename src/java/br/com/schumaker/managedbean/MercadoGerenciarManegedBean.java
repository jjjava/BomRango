package br.com.schumaker.managedbean;

import br.com.schumaker.model.Cliente;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * @author hudson schumaker HStudio - @BomRango 14/01/2015
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@ManagedBean
@ViewScoped
public class MercadoGerenciarManegedBean implements Serializable {

    public MercadoGerenciarManegedBean() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        Cliente cliente = (Cliente) session.getAttribute("Cliente");
        if (Cliente == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("faces/gerenciar.xhtml");
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}
