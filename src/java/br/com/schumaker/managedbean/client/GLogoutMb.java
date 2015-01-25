package br.com.schumaker.managedbean.client;

import br.com.schumaker.bs.impl.ClienteBsImpl;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 25/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
@ManagedBean
@ViewScoped
public class GLogoutMb implements Serializable{
    
    public GLogoutMb(){ 
    }
    
    public String doLogout(){
        new ClienteBsImpl().invalidarSessao();
        return "";
    }
}
