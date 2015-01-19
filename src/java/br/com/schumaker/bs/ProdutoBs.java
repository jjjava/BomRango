package br.com.schumaker.bs;

import br.com.schumaker.model.Produto;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 16/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ProdutoBs {
    Produto obter(Integer id);
    List<Produto> listar();
    List<Produto> listar(int limite);
    List<Produto> listar(String nome);
    List<Produto> listar(String nome, int limite);
    List<Produto> listarELike(String nome);
    List<Produto> listarELike(String nome, int limite);
    List<Produto> like(String s);
    List<Produto> like(String s, int limite);
    boolean verificarNome(String nome);
    boolean verificarFabricante(String nome);
    void cadastrar(Produto produto);
    void atualizar(Produto produto);
    void deletar(Produto produto);
}
