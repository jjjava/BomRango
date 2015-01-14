package br.com.schumaker.managedbean;

import br.com.schumaker.dao.impl.ClienteDaoImpl;
import br.com.schumaker.model.Cliente;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
