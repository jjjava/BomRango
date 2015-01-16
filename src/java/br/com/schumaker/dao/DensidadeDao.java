package br.com.schumaker.dao;

import br.com.schumaker.model.Densidade;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 11/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface DensidadeDao {
    Densidade obter(Integer id);
    List<Densidade> listar();
    List<Densidade> like(String s);
    boolean verificarNome(String nome);
    boolean cadastrar(Densidade densidade);
    boolean atualizar(Densidade densiadade);
    boolean deletar(Densidade densidade);
}
