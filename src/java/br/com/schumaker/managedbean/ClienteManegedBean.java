package br.com.schumaker.managedbean;

import br.com.schumaker.dao.impl.ClienteDaoImpl;
import br.com.schumaker.model.Cliente;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 13/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
@ManagedBean
@ViewScoped
public class ClienteManegedBean implements Serializable {

    private Cliente cliente;

    public ClienteManegedBean() {
        cliente = new Cliente();
        System.out.println("construtor");
    }

    public void doLogin() {
        ClienteDaoImpl clienteDaoImpl = new ClienteDaoImpl();
        if (clienteDaoImpl.validar(cliente.getEmail(), cliente.getSenha())) {
            try {
                cliente = clienteDaoImpl.obter(cliente.getEmail());
                FacesContext fc = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
                session.setAttribute("Cliente", cliente);
                System.err.println("validou");
                FacesContext.getCurrentInstance().getExternalContext().redirect("gerenciador/gerenciarmercado.xhtml");
            } catch (IOException ex) {
                System.out.println(ex);
            }
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Login", "Email ou Senha incorretos");
            RequestContext.getCurrentInstance().showMessageInDialog(message);
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
