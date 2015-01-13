package br.com.schumaker.dao;

import br.com.schumaker.model.Palavrao;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 08/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface PalavraoDao {
    Palavrao obter(Integer id);
    List<Palavrao> listar();
    List<Palavrao> like(String s);
}
