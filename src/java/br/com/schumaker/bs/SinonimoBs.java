package br.com.schumaker.bs;

import br.com.schumaker.model.Sinonimo;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 21/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface SinonimoBs {
    Sinonimo obter(Integer id);
    Sinonimo obter(String nome);
    List<Sinonimo> listar();
    List<Sinonimo> like(String s);
    boolean verificarNome(String nome); 
    void cadastrar(Sinonimo sin);
    void atualizar(Sinonimo sin);
    void deletar(Sinonimo sin);
}
