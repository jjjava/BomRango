package br.com.schumaker.dao;

import br.com.schumaker.model.Pesquisa;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 07/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface PesquisaDao {
    Pesquisa obter(Integer id);
    Pesquisa obter(String nome);
    List<Pesquisa> listar();
    List<Pesquisa> listarTopXX(int x);
    List<Pesquisa> like(String s);
    void inserir(String p);
    void atualizar(Pesquisa p);
}
