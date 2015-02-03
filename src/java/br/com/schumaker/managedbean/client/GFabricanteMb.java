package br.com.schumaker.managedbean.client;

import br.com.schumaker.bs.impl.FabricanteBsImpl;
import br.com.schumaker.model.Fabricante;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 03/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
@ManagedBean
@ViewScoped
public class GFabricanteMb implements Serializable{
    private Fabricante fabtricante;
    
    public GFabricanteMb(){
        fabtricante = new Fabricante();
    }
    
    public void processarCadastro(){
        new FabricanteBsImpl().cadastrar(fabtricante);
    }

    public Fabricante getFabtricante() {
        return fabtricante;
    }

    public void setFabtricante(Fabricante fabtricante) {
        this.fabtricante = fabtricante;
    }
}
