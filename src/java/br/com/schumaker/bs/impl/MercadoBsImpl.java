package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.MercadoBs;
import br.com.schumaker.dao.impl.MercadoDaoImpl;
import br.com.schumaker.model.Mercado;
import java.util.List;
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 21/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class MercadoBsImpl implements MercadoBs {

    @Override
    public Mercado obter(Integer id) {
        return new MercadoDaoImpl().obter(id);
    }

    @Override
    public List<Mercado> listar() {
        return new MercadoDaoImpl().listar();
    }

    @Override
    public List<Mercado> like(String s) {
        return new MercadoDaoImpl().like(s);
    }

    @Override
    public boolean verificarNome(String nome) {
        return new MercadoDaoImpl().verificarNome(nome);
    }

    @Override
    public void cadastrar(Mercado mercado) {
        if (new MercadoDaoImpl().verificarNome(mercado.getNome())) {
            mostrarMensagem(FacesMessage.SEVERITY_WARN, "Cadastro - Mercado", "Já existe um mercado com esse nome.");
        } else {
            if (new MercadoDaoImpl().cadastrar(mercado)) {
                mostrarMensagem(FacesMessage.SEVERITY_WARN, "Cadastro - Mercado", "Mercado cadastrado do sucesso.");
            } else {
                mostrarMensagem(FacesMessage.SEVERITY_WARN, "Cadastro - Mercado", "Erro ao cadastrar mercado.");
            }
        }
    }

    @Override
    public void atualizar(Mercado mercado) {
        mostrarMensagem(FacesMessage.SEVERITY_WARN, "Mercado", "Sem suporte ainda.");
    }

    @Override
    public void deletar(Mercado mercado) {
        mostrarMensagem(FacesMessage.SEVERITY_WARN, "Mercado", "Sem suporte ainda.");
    }

    private void mostrarMensagem(FacesMessage.Severity sev, String titulo, String mensagem) {
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(sev, titulo, mensagem));
    }
}
