package br.com.schumaker.bs;

import br.com.schumaker.model.Usuario;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 19/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface UsuarioBs {
    Usuario obter(Integer id);
    Usuario obter(String email);
    List<Usuario> listar();
    List<Usuario> like(String nome);
    boolean verificarEmail(String email);
    void validar(Usuario usuario);
    void cadastrar(Usuario usuario);
    void atualizar(Usuario usuario);
    void deletar(Usuario usuario);
}
