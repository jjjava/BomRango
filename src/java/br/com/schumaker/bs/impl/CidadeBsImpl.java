package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.CidadeBs;
import br.com.schumaker.dao.impl.CidadeDaoImpl;
import br.com.schumaker.dao.impl.EstadoDaoImpl;
import br.com.schumaker.model.Cidade;
import java.util.List;
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 16/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class CidadeBsImpl implements CidadeBs {

    @Override
    public Cidade obter(Integer id) {
        return new CidadeDaoImpl().obter(id);
    }

    @Override
    public List<Cidade> listar() {
        return new CidadeDaoImpl().listar();
    }

    @Override
    public List<Cidade> like(String s) {
        return new CidadeDaoImpl().like(s);
    }

    @Override
    public boolean verificarNome(String nome) {
        return new CidadeDaoImpl().verificarNome(nome);
    }

    @Override
    public void cadastar(Cidade cidade) {
        if (new EstadoDaoImpl().verificarCidadeNoEstado(cidade)) {
            mostrarMensagem(FacesMessage.SEVERITY_WARN, "Cadastro - Cidade", "Já existe uma cidade com esse nome no estado selecionado. ");
        } else {
            if (new CidadeDaoImpl().cadastar(cidade)) {
                mostrarMensagem(FacesMessage.SEVERITY_INFO, "Cadastro - Cidade", "Cidade cadastrada.");

            } else {
                mostrarMensagem(FacesMessage.SEVERITY_ERROR, "Cadastro - Cidade", "Erro ao cadastrar a cidade.");
            }
        }
    }

    @Override
    public void atualizar(Cidade cidade) {
        new CidadeDaoImpl().atualizar(cidade);
    }

    @Override
    public void deletar(Cidade cidade) {
        new CidadeDaoImpl().deletar(cidade);
    }

    private void mostrarMensagem(FacesMessage.Severity sev, String titulo, String mensagem) {
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(sev, titulo, mensagem));
    }
}
