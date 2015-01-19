package br.com.schumaker.bs;

import br.com.schumaker.model.Cidade;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 16/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CidadeBs {
    Cidade obter(Integer id);
    List<Cidade> listar();
    List<Cidade> like(String s);
    boolean verificarNome(String nome); 
    void cadastrar(Cidade cidade);
    void atualizar(Cidade cidade);
    void deletar(Cidade cidade);
}
