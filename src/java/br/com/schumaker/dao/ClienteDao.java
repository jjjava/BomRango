package br.com.schumaker.dao;

import br.com.schumaker.model.Cliente;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 13/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ClienteDao {
    Cliente obter(Integer id);
    List<Cliente> listar();
    List<Cliente> like(String nome);
    boolean validar(String email, String password);
}
