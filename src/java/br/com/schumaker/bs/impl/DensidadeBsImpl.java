package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.DensidadeBs;
import br.com.schumaker.dao.impl.DensidadeDaoImpl;
import br.com.schumaker.model.Densidade;
import java.util.List;
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 16/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class DensidadeBsImpl implements DensidadeBs {

    @Override
    public Densidade obter(Integer id) {
        return new DensidadeDaoImpl().obter(id);
    }

    @Override
    public List<Densidade> listar() {
        return new DensidadeDaoImpl().listar();
    }

    @Override
    public List<Densidade> like(String s) {
        return new DensidadeDaoImpl().like(s);
    }

    @Override
    public boolean verificarNome(String nome) {
        return new DensidadeDaoImpl().verificarNome(nome);
    }

    @Override
    public void cadastrar(Densidade densidade) {
        if (new DensidadeDaoImpl().cadastrar(densidade)) {
            mostrarMensagem(FacesMessage.SEVERITY_INFO, "Casdastrar - Densidade", "Densidade cadastrada com sucesso.");
        } else {
            mostrarMensagem(FacesMessage.SEVERITY_ERROR, "Casdastrar - Densidade", "Erro ao cadastrar a densidade.");
        }
    }

    @Override
    public void atualizar(Densidade densidade) {
        if (new DensidadeDaoImpl().atualizar(densidade)) {
            mostrarMensagem(FacesMessage.SEVERITY_INFO, "Atualizar - Densidade", "Densidade atualizada com sucesso.");
        } else {
            mostrarMensagem(FacesMessage.SEVERITY_ERROR, "Atualizar - Densidade", "Erro ao atualizar a densidade.");
        }
    }

    @Override
    public void deletar(Densidade densidade) {
        if (new DensidadeDaoImpl().deletar(densidade)) {
            mostrarMensagem(FacesMessage.SEVERITY_INFO, "Deletar - Densidade", "Densidade deletada com sucesso.");
        } else {
            mostrarMensagem(FacesMessage.SEVERITY_ERROR, "Deletar - Densidade", "Erro ao deletar a densidade.");
        }
    }

    private void mostrarMensagem(FacesMessage.Severity sev, String titulo, String mensagem) {
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(sev, titulo, mensagem));
    }
}
