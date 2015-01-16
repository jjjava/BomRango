package br.com.schumaker.dao;

import br.com.schumaker.model.Mercado;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 07/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface MercadoDao {
    Mercado obter(Integer id);
    List<Mercado> listar();
    List<Mercado> like(String s);
    List<Mercado> listarPorDensidade(int idDensidade);
    boolean verificarNome(String nome);
    boolean cadastrar(Mercado mercado);
    boolean atualizar(Mercado mercado);
    boolean deletar(Mercado mercado);
}
