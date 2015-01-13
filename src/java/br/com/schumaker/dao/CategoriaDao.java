package br.com.schumaker.dao;

import br.com.schumaker.model.Categoria;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 07/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CategoriaDao {
    Categoria obter(Integer id);
    List<Categoria> listar();
    List<Categoria> like(String s);
}
