package br.com.schumaker.bs;

import br.com.schumaker.model.Densidade;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 16/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface DensidadeBs {
    Densidade obter(Integer id);
    List<Densidade> listar();
    List<Densidade> like(String s);
    boolean verificarNome(String nome);
    void cadastrar(Densidade densidade);
    void atualizar(Densidade densidade);
    void deletar(Densidade densidade);
}
