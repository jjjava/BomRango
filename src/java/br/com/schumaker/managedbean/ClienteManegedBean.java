package br.com.schumaker.managedbean;

import br.com.schumaker.bs.impl.ClienteBsImpl;
import br.com.schumaker.model.Cliente;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

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
        new ClienteBsImpl().validar(cliente);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
