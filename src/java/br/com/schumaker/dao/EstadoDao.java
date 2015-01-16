package br.com.schumaker.dao;

import br.com.schumaker.model.Estado;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 13/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface EstadoDao {
    Estado obter(Integer id);
    List<Estado> listar();
    List<Estado> like(String s);
    boolean cadastar(Estado estado);
    boolean atualizar(Estado estado);
    boolean deletar(Estado estado);
}
