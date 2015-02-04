package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.SetorBs;
import br.com.schumaker.dao.impl.SetorDaoImpl;
import br.com.schumaker.model.Setor;
import java.util.List;
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 19/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class SetorBsImpl implements SetorBs {

    @Override
    public Setor obter(Integer id) {
        return new SetorDaoImpl().obter(id);
    }
    
    @Override
    public Setor obter(String nome) {
        return new SetorDaoImpl().obter(nome);
    }

    @Override
    public List<Setor> listar() {
        return new SetorDaoImpl().listar();
    }

    @Override
    public List<Setor> like(String s) {
        return new SetorDaoImpl().like(s);
    }

    @Override
    public boolean verificarNome(String nome) {
        return new SetorDaoImpl().verificarNome(nome);
    }

    @Override
    public void cadastrar(Setor setor) {
        if (verificarNome(setor.getNome())) {
            mostrarMensagem(FacesMessage.SEVERITY_WARN, "Cadastro - Setor", "Já existe um setor com esse nome.");
        } else {
            if (new SetorDaoImpl().cadastrar(setor)) {
                mostrarMensagem(FacesMessage.SEVERITY_INFO, "Cadastro - Setor", "Setor cadastrado com sucesso.");
            } else {
                mostrarMensagem(FacesMessage.SEVERITY_ERROR, "Cadastro - Setor", "Erro ao cadastrar o setor.");
            }
        }
    }

    @Override
    public void atualizar(Setor setor) {
        mostrarMensagem(FacesMessage.SEVERITY_WARN, "Setor", "Não suportado ainda");
    }

    @Override
    public void deletar(Setor setor) {
        mostrarMensagem(FacesMessage.SEVERITY_WARN, "Setor", "Não suportado ainda");
    }

    private void mostrarMensagem(FacesMessage.Severity sev, String titulo, String mensagem) {
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(sev, titulo, mensagem));
    }
}
