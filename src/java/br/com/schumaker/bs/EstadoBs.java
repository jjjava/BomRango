package br.com.schumaker.bs;

import br.com.schumaker.model.Cidade;
import br.com.schumaker.model.Estado;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 05/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface EstadoBs {
    Estado obter(Integer id);
    List<Estado> listar();
    List<Estado> like(String s);
    boolean verificarNome(String nome);
    boolean verificarCidadeNoEstado(Cidade cidade);
    void cadastrar(Estado estado);
    void atualizar(Estado estado);
    void deletar(Estado estado);
}
