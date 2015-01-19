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
    Usuario obter(String email);
    List<Usuario> listar();
    List<Usuario> like(String nome);
    boolean verificarEmail(String email);
    boolean validar(String nome, String password);
    boolean cadastrar(Usuario usuario);
    boolean atualizar(Usuario usuario);
    boolean deletar(Usuario usuario);
}
