package br.com.schumaker.bs;

import br.com.schumaker.model.Setor;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 19/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface SetorBs {
    Setor obter(Integer id);
    Setor obter(String nome);
    List<Setor> listar();
    List<Setor> like(String s);
    boolean verificarNome(String nome);
    void cadastrar(Setor setor);
    void atualizar(Setor setor);
    void deletar(Setor setor);
}
