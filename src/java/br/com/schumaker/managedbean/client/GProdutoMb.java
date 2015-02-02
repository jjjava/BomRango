package br.com.schumaker.managedbean.client;

import br.com.schumaker.bs.impl.FabricanteBsImpl;
import br.com.schumaker.bs.impl.ProdutoBsImpl;
import br.com.schumaker.bs.impl.SetorBsImpl;
import br.com.schumaker.bs.impl.UnidadeBsImpl;
import br.com.schumaker.model.Fabricante;
import br.com.schumaker.model.Produto;
import br.com.schumaker.model.Setor;
import br.com.schumaker.model.Unidade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
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
    private Fabricante marca;
    private List<Fabricante> marcas;
    private Unidade unidade;
    private List<Unidade> unidades;

    public GProdutoMb() {

    }

    @PostConstruct
    public void load() {
        produto = new Produto();
        setor = new Setor();
        marca = new Fabricante();
        unidade = new Unidade();
        setores = new SetorBsImpl().listar();
        marcas = new FabricanteBsImpl().listar();
        unidades = new UnidadeBsImpl().listar();
    }

    public void processarCadastroParte1() {
        new ProdutoBsImpl().primeiraEtapaCadastro(produto, setor, marca, unidade);
    }

    public void processarCadastroParte2() {

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

    public Fabricante getMarca() {
        return marca;
    }

    public void setMarca(Fabricante marca) {
        this.marca = marca;
    }

    public List<Fabricante> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Fabricante> marcas) {
        this.marcas = marcas;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public List<Unidade> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unidade> unidades) {
        this.unidades = unidades;
    }
}
