package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.ProdutoBs;
import br.com.schumaker.dao.impl.ProdutoDaoImpl;
import br.com.schumaker.model.Produto;
import java.util.List;
import javax.faces.application.FacesMessage;
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Produto> listarELike(String nome, int limite) {
        throw new UnsupportedOperationException("Not supported yet.");
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
        Fabricante fabricante = new Fa
        if (verificarNome(produto.getNome())&& verificarMarca(produto.)) {
            mostrarMensagem(FacesMessage.SEVERITY_WARN, "Cadastro - Produto", "Produto.");
        } else {
            
        }
    }

    @Override
    public void atualizar(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deletar(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void mostrarMensagem(FacesMessage.Severity sev, String titulo, String mensagem) {
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(sev, titulo, mensagem));
    }
}
