package br.com.schumaker.dao;

import br.com.schumaker.model.Produto;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 07/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ProdutoDao {
    Produto obter(Integer id);
    List<Produto> listar();
    List<Produto> listar(int limite);
    List<Produto> like(String s);
    boolean cadastrar(Produto produto);
    boolean atualizar(Produto produto);
    boolean deletar(Produto produto);
}
