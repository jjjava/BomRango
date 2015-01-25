package br.com.schumaker.managedbean;

import br.com.schumaker.bs.impl.MercadoBsImpl;
import br.com.schumaker.model.Mercado;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 * @author hudson schumaker HStudio - @BomRango 13/01/2015
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@ManagedBean
@ViewScoped
public class MercadoHomeMb implements Serializable {

    private String action;
    private Mercado mercado;
    public MercadoHomeMb() {
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
        MercadoBsImpl mercadoBsImpl = new MercadoBsImpl();
        mercado = mercadoBsImpl.obter(Integer.parseInt(action));
    }

    public Mercado getMercado() {
        return mercado;
    }

    public void setMercado(Mercado mercado) {
        this.mercado = mercado;
    }
}
