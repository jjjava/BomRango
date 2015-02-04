package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.ProdutoBs;
import br.com.schumaker.dao.impl.FabricanteDaoImpl;
import br.com.schumaker.dao.impl.ProdutoDaoImpl;
import br.com.schumaker.model.Fabricante;
import br.com.schumaker.model.Produto;
import br.com.schumaker.model.Setor;
import br.com.schumaker.model.Unidade;
import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 16/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class ProdutoBsImpl implements ProdutoBs {

    @Override
    public Produto obter(Integer id) {
        return new ProdutoDaoImpl().obter(id);
    }

    @Override
    public List<Produto> listar() {
        return new ProdutoDaoImpl().listar();
    }

    @Override
    public List<Produto> listar(int limite) {
        return new ProdutoDaoImpl().listar(limite);
    }

    @Override
    public List<Produto> listar(String nome) {
        return new ProdutoDaoImpl().listar(nome);
    }

    @Override
    public List<Produto> listar(String nome, int limite) {
        return new ProdutoDaoImpl().listar(nome, limite);
    }

    @Override
    public List<Produto> listarELike(String nome) {
        List<Produto> listaNome = new ProdutoDaoImpl().listar(nome);
        List<Produto> listaLike = new ProdutoDaoImpl().like(nome);
        for (Produto p : listaLike) {
            listaNome.add(p);
        }
        return listaNome;
    }

    @Override
    public List<Produto> listarELike(String nome, int limite) {
        List<Produto> listaNome = new ProdutoDaoImpl().listar(nome, limite);
        List<Produto> listaLike = new ProdutoDaoImpl().like(nome, limite);
        for (Produto p : listaLike) {
            listaNome.add(p);
        }
        return listaNome;
    }

    @Override
    public List<Produto> like(String s) {
        return new ProdutoDaoImpl().like(s);
    }

    @Override
    public List<Produto> like(String s, int limite) {
        return new ProdutoDaoImpl().like(s, limite);
    }

    @Override
    public boolean verificarNome(String nome) {
        return new ProdutoDaoImpl().verificarNome(nome);
    }

    @Override
    public boolean verificarFabricante(String nome) {
        return new ProdutoDaoImpl().verificarFabricante(nome);
    }

    @Override
    public void cadastrar(Produto produto) {
        Fabricante fabricante = new FabricanteDaoImpl().obter(produto.getIdFabricante());
        if (verificarNome(produto.getNome()) && verificarFabricante(fabricante.getNome())) {
            mostrarMensagem(FacesMessage.SEVERITY_WARN, "Cadastro - Produto", "Produto já existente.");
        } else {
            if (new ProdutoDaoImpl().cadastrar(produto)) {
                mostrarMensagem(FacesMessage.SEVERITY_INFO, "Cadastro - Produto", "Produto cadastrado com sucesso.");
            } else {
                mostrarMensagem(FacesMessage.SEVERITY_ERROR, "Cadastro - Produto", "Erro ao cadastrar produto.");
            }
        }
    }

    @Override
    public void atualizar(Produto produto) {
        mostrarMensagem(FacesMessage.SEVERITY_WARN, "Produto", "Não suportado ainda");
    }

    @Override
    public void deletar(Produto produto) {
        mostrarMensagem(FacesMessage.SEVERITY_WARN, "Produto", "Não suportado ainda");
    }

    public void primeiraEtapaCadastro(Produto p, Setor s, Fabricante f, Unidade u) {
        p.setIdcategoria(new SetorBsImpl().obter(s.getNome()));
        p.setIdfabricante(new FabricanteBsImpl().obter(f.getNome()));
        p.setUnidade(new UnidadeBsImpl().obter(u.getNome()));
        p.setIdmercado(new MercadoBsImpl().getMercadoSessao());
        p.setAtivo(1);//validacao com inteiro

        setCadProdutoSessao(p);
    }

    public void segundaEtapaCadastro() {
        Produto p = getCadProdutoSessao();
    }

    private void setCadProdutoSessao(Produto produto) {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.setAttribute("CadProduto", produto);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("carregafotoproduto.xhtml");
        } catch (IOException ex) {
            System.out.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        }
    }

    public Produto getCadProdutoSessao() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        return (Produto) session.getAttribute("CadProduto");
    }

    private void mostrarMensagem(FacesMessage.Severity sev, String titulo, String mensagem) {
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(sev, titulo, mensagem));
    }
}
