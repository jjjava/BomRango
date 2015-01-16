package br.com.schumaker.bs;

import br.com.schumaker.model.Fabricante;
import java.util.List;

/**
 *
 * @author hudson.sales
 * @verison 1.0.0
 */
public interface FabricanteBs {
    Fabricante obter(Integer id);
    List<Fabricante> listar();
    List<Fabricante> like(String s);
    void verificarNome(String nome);
    void cadastrar(Fabricante fabricante);
    void atualizar(Fabricante fabricante);
    void deletar(Fabricante fabricante); 
}