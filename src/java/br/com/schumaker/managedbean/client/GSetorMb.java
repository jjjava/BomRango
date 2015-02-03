package br.com.schumaker.managedbean.client;

import br.com.schumaker.bs.impl.SetorBsImpl;
import br.com.schumaker.model.Setor;
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
public class GSetorMb implements Serializable{
    private Setor setor;

    public GSetorMb() {
        setor = new Setor();
    }
    
    public void processarCadastro(){
        new SetorBsImpl().cadastrar(setor);
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
}