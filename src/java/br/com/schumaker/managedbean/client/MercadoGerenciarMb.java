package br.com.schumaker.managedbean.client;

import br.com.schumaker.bs.impl.LogBsImpl;
import br.com.schumaker.bs.impl.MercadoBsImpl;
import br.com.schumaker.dao.impl.MercadoDaoImpl;
import br.com.schumaker.model.Cliente;
import br.com.schumaker.model.Mercado;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * @author hudson schumaker HStudio - @BomRango 14/01/2015
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@ManagedBean
@ViewScoped
public class MercadoGerenciarMb implements Serializable {

    private Mercado mercado;
    private Cliente clienteSessao;

    public MercadoGerenciarMb() {
        MercadoBsImpl mercadoBsImpl = new MercadoBsImpl();        
        Cliente cliente = mercadoBsImpl.getClienteSessao();
        if (cliente == null) {
            try {
                clienteSessao = null;
                System.out.println("sessão vazia redirecionando...");
                FacesContext.getCurrentInstance().getExternalContext().redirect("../gerenciar.xhtml");
            } catch (IOException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        } else {
            clienteSessao = cliente;
            MercadoDaoImpl mercadoDaoImpl = new MercadoDaoImpl();
            mercado = mercadoDaoImpl.obter(cliente.getIdMercado());
        }
    }

    public Mercado getMercado() {
        return mercado;
    }

    public void setMercado(Mercado mercado) {
        this.mercado = mercado;
    }

    public Cliente getCliente() {
        if(clienteSessao == null){
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("../gerenciar.xhtml");
            } catch (IOException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return clienteSessao;
    }

    public void setCliente(Cliente cliente) {
        this.clienteSessao = cliente;
    }
}
