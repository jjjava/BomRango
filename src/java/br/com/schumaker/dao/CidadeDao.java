package br.com.schumaker.dao;

import br.com.schumaker.model.Cidade;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 11/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CidadeDao {
    Cidade obter(Integer id);
    List<Cidade> listar();
    List<Cidade> like(String s);
    boolean verificarNome(String nome);
    boolean cadastrar(Cidade cidade);
    boolean atualizar(Cidade cidade);
    boolean deletar(Cidade cidade);
}
