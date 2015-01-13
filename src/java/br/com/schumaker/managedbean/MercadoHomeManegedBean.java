package br.com.schumaker.managedbean;

import br.com.schumaker.dao.impl.MercadoDaoImpl;
import br.com.schumaker.model.Mercado;
import com.sun.jmx.snmp.BerDecoder;
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
public class MercadoHomeManegedBean implements Serializable {

    private String action;
    private Mercado mercado;
    public MercadoHomeManegedBean() {
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
        MercadoDaoImpl mercadoDaoImpl = new MercadoDaoImpl();
        mercado = mercadoDaoImpl.obter(Integer.parseInt(action));
    }

    public Mercado getMercado() {
        return mercado;
    }

    public void setMercado(Mercado mercado) {
        this.mercado = mercado;
    }
    
    
}