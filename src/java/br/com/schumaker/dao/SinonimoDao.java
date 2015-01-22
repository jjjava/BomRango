package br.com.schumaker.dao;

import br.com.schumaker.model.Sinonimo;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 21/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface SinonimoDao {
    Sinonimo obter(Integer id);
    Sinonimo obter(String nome);
    List<Sinonimo> listar();
    List<Sinonimo> like(String s);
    boolean verificarNome(String nome); 
    boolean cadastrar(Sinonimo sin);
    boolean atualizar(Sinonimo sin);
    boolean deletar(Sinonimo sin);
}
