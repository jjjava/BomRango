package br.com.schumaker.dao;

import br.com.schumaker.model.Unidade;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 07/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface UnidadeDao {
    Unidade obter(Integer id);
    List<Unidade> listar();
    List<Unidade> like(String s);
}
