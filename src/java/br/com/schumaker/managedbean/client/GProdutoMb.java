package br.com.schumaker.managedbean.client;

import br.com.schumaker.bs.impl.SetorBsImpl;
import br.com.schumaker.model.Produto;
import br.com.schumaker.model.Setor;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 24/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
@ManagedBean
@ViewScoped
public class GProdutoMb implements Serializable {
    
    private Produto produto;
    private Setor setor;
    private List<Setor> setores;
    
    public GProdutoMb(){
        produto = new Produto();
        setores = new SetorBsImpl().listar();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public List<Setor> getSetores() {
        return setores;
    }

    public void setSetores(List<Setor> setores) {
        this.setores = setores;
    }
}
