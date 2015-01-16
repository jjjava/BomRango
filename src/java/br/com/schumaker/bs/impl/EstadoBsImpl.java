package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.EstadoBs;
import br.com.schumaker.dao.impl.EstadoDaoImpl;
import br.com.schumaker.model.Cidade;
import br.com.schumaker.model.Estado;
import java.util.List;
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 16/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class EstadoBsImpl implements EstadoBs {

    @Override
    public Estado obter(Integer id) {
        return new EstadoDaoImpl().obter(id);
    }

    @Override
    public List<Estado> listar() {
        return new EstadoDaoImpl().listar();
    }

    @Override
    public List<Estado> like(String s) {
        return new EstadoDaoImpl().like(s);
    }

    @Override
    public boolean verificarNome(String nome) {
        return new EstadoDaoImpl().verificarNome(nome);
    }

    @Override
    public boolean verificarCidadeNoEstado(Cidade cidade) {
        return new EstadoDaoImpl().verificarCidadeNoEstado(cidade);
    }

    @Override
    public void cadastar(Estado estado) {
        if (verificarNome(estado.getNome())) {
            mostrarMensagem(FacesMessage.SEVERITY_WARN, "Cadastro - Estado", "Já existe um estado com esse nome.");
        } else {
            if (new EstadoDaoImpl().cadastar(estado)) {
                mostrarMensagem(FacesMessage.SEVERITY_INFO, "Cadastro - Estado", "Estado cadastrado com sucesso.");
            } else {
                mostrarMensagem(FacesMessage.SEVERITY_ERROR, "Cadastro - Estado", "Erro ao cadastrar o estado.");
            }
        }
    }

    @Override
    public void atualizar(Estado estado) {
        if (new EstadoDaoImpl().verificarNome(estado.getNome())) {
            mostrarMensagem(FacesMessage.SEVERITY_WARN, "Cadastro - Estado", "Já existe um estado com esse nome.");
        } else if (new EstadoDaoImpl().verificarUf(estado.getUf())) {
            mostrarMensagem(FacesMessage.SEVERITY_WARN, "Cadastro - Estado", "Já existe um estado com essa UF.");
        } else {
            if (new EstadoDaoImpl().atualizar(estado)) {
                mostrarMensagem(FacesMessage.SEVERITY_WARN, "Cadastro - Estado", "Estado atualizado com sucesso.");
            } else {
                mostrarMensagem(FacesMessage.SEVERITY_WARN, "Cadastro - Estado", "Erro ao atualizar estado.");
            }
        }
    }

    @Override
    public void deletar(Estado estado) {
        throw new UnsupportedOperationException("não suportado.");
    }

    private void mostrarMensagem(FacesMessage.Severity sev, String titulo, String mensagem) {
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(sev, titulo, mensagem));
    }
}
