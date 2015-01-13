package br.com.schumaker.dao;

import br.com.schumaker.model.Setor;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 07/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface SetorDao {
    Setor obter(Integer id);
    List<Setor> listar();
    List<Setor> like(String s);
}