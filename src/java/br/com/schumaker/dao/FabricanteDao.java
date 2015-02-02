package br.com.schumaker.dao;

import br.com.schumaker.model.Fabricante;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 07/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface FabricanteDao {
    Fabricante obter(Integer id);
    Fabricante obter(String nome);
    List<Fabricante> listar();
    List<Fabricante> like(String s);
    boolean verificarNome(String nome);
    boolean cadastrar(Fabricante fabricante);
    boolean atualizar(Fabricante fabricante);
    boolean deletar(Fabricante fabricante);
}
