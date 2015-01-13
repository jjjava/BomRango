package br.com.schumaker.dao;

import br.com.schumaker.model.Usuario;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 12/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface UsuarioDao {
    Usuario obter(Integer id);
    List<Usuario> listar();
    List<Usuario> like(String nome);
    boolean validar(String nome, String password);
}
