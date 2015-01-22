package br.com.schumaker.bs;

import br.com.schumaker.model.Cliente;
import br.com.schumaker.model.Mercado;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 05/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface MercadoBs {
    Mercado obter(Integer id);
    List<Mercado> listar();
    List<Mercado> like(String s);
    Cliente getClienteSessao();
    Mercado getMercadoSessao();
    void mostrarPerfil(String action);
    void gerenciarSessao();
    boolean verificarNome(String nome);
    void cadastrar(Mercado mercado);
    void atualizar(Mercado mercado);
    void deletar(Mercado mercado); 
}
