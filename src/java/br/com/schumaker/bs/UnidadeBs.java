package br.com.schumaker.bs;

import br.com.schumaker.model.Unidade;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 24/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface UnidadeBs {
    Unidade obter(Integer id);
    Unidade obter(String nome);
    List<Unidade> listar();
    List<Unidade> like(String s);
    boolean verificarNome(String nome); 
    void cadastrar(Unidade cidade);
    void atualizar(Unidade cidade);
    void deletar(Unidade cidade);
}
