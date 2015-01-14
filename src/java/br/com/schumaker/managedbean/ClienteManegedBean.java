package br.com.schumaker.managedbean;

import br.com.schumaker.dao.impl.ClienteDaoImpl;
import br.com.schumaker.model.Cliente;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

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
    }

    public void doLogin() {
        ClienteDaoImpl clienteDaoImpl = new ClienteDaoImpl();
        if (clienteDaoImpl.validar(cliente.getEmail(), cliente.getEmail())) {
            try {
                cliente = clienteDaoImpl.obter(cliente.getEmail());
                FacesContext fc = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
                session.setAttribute("Cliente", cliente);
                FacesContext.getCurrentInstance().getExternalContext().redirect("faces/gerenciar/gerenciarmercado.xhtml");
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        System.err.println(cliente.getEmail());
        System.err.println(cliente.getSenha());

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
