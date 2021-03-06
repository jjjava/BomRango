package br.com.schumaker.managedbean;

import br.com.schumaker.bs.impl.ProdutoBsImpl;
import br.com.schumaker.model.Produto;
import br.com.schumaker.util.HsCommons;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 07/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
@ManagedBean
@ViewScoped
public class ProdutoMb implements Serializable {

    private final ProdutoBsImpl produtoBs;
    private List<Produto> produtos;
    private Produto selectedProduto;
    private String query;

    public ProdutoMb() {
        produtoBs = new ProdutoBsImpl();
        produtos = new ArrayList<Produto>();
        this.checkParameter();
    }

    private void checkParameter() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        String tag = (String) session.getAttribute("CloudTag");
        if (tag != null) {
            query = tag;
            onNameChange();
        }
        session.removeAttribute("CloudTag");
    }

    public void onNameChange() {
        if (query == null || query.equalsIgnoreCase("")) {
            produtos = produtoBs.listar(HsCommons.DAOPRODES);
        } else {
            produtos = produtoBs.listarELike(query);
        }
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String nome) {
        this.query = nome;
    }

    public Produto getSelectedProduto() {
        return selectedProduto;
    }

    public void setSelectedProduto(Produto selectedProduto) {
        this.selectedProduto = selectedProduto;
    }
}
