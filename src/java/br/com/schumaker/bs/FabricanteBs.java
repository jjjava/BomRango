package br.com.schumaker.bs;

import br.com.schumaker.model.Fabricante;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 17/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface FabricanteBs {
    Fabricante obter(Integer id);
    Fabricante obter(String nome);
    List<Fabricante> listar();
    List<Fabricante> like(String s);
    boolean verificarNome(String nome);
    void cadastrar(Fabricante fabricante);
    void atualizar(Fabricante fabricante);
    void deletar(Fabricante fabricante); 
}
