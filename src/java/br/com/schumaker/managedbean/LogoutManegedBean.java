package br.com.schumaker.managedbean;

import br.com.schumaker.model.Cliente;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 15/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
@ManagedBean
@ViewScoped
public class LogoutManegedBean implements Serializable {
    
    public LogoutManegedBean() {
    }
    
    @PostConstruct
    public void load() {
    }
    
    public void doLogout() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        Cliente cliente = (Cliente) session.getAttribute("Cliente");
        if (cliente != null) {
            session.removeAttribute("Cliente");
        }
    }
}
