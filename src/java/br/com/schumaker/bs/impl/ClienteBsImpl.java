package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.ClienteBs;
import br.com.schumaker.dao.impl.ClienteDaoImpl;
import br.com.schumaker.model.Cliente;
import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 16/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class ClienteBsImpl implements ClienteBs {

    @Override
    public Cliente obter(Integer id) {
        return new ClienteDaoImpl().obter(id);
    }

    @Override
    public Cliente obter(String email) {
        return new ClienteDaoImpl().obter(email);
    }

    @Override
    public List<Cliente> listar() {
        return new ClienteDaoImpl().listar();
    }

    @Override
    public List<Cliente> like(String s) {
        return new ClienteDaoImpl().like(s);
    }

    @Override
    public boolean verificarEmail(String email) {
        return new ClienteDaoImpl().verificarEmail(email);
    }

    @Override
    public void validar(Cliente cliente) {
        ClienteDaoImpl clienteDaoImpl = new ClienteDaoImpl();
        //
        //criptografar aqui
        //
        if (clienteDaoImpl.validar(cliente.getEmail(), cliente.getSenha())) {//usar senha criptografada
            try {
                cliente = clienteDaoImpl.obter(cliente.getEmail());
                FacesContext fc = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
                session.setAttribute("Cliente", cliente);
                FacesContext.getCurrentInstance().getExternalContext().redirect("gerenciador/gerenciarmercado.xhtml");
            } catch (IOException ex) {
                System.out.println(ex);
            }
        } else {
            mostrarMensagem(FacesMessage.SEVERITY_INFO, "Login", "Email ou Senha incorretos.");
        }
    }

    @Override
    public boolean verificarNome(String nome) {
        return new ClienteDaoImpl().verificarNome(nome);
    }

    @Override
    public void cadastrar(Cliente cliente) {
        if (new ClienteDaoImpl().cadastrar(cliente)) {
            mostrarMensagem(FacesMessage.SEVERITY_INFO, "Cadastrar - Cliente", "Cliente cadastrado com sucesso.");
        } else {
            mostrarMensagem(FacesMessage.SEVERITY_ERROR, "Cadastrar - Cliente", "Erro ao cadastrar cliente.");
        }
    }

    @Override
    public void atualizar(Cliente cliente) {
        if (new ClienteDaoImpl().atualizar(cliente)) {
            mostrarMensagem(FacesMessage.SEVERITY_INFO, "Atualizar - Cliente", "Cliente Atualizado com sucesso.");
        } else {
            mostrarMensagem(FacesMessage.SEVERITY_ERROR, "Atualizar - Cliente", "Erro ao atualizar cliente.");
        }
    }

    @Override
    public void deletar(Cliente cliente) {
        if (new ClienteDaoImpl().deletar(cliente)) {
            mostrarMensagem(FacesMessage.SEVERITY_INFO, "Deletar - Cliente", "Cliente deletado com sucesso.");
        } else {
            mostrarMensagem(FacesMessage.SEVERITY_ERROR, "Deletar - Cliente", "Erro ao deletar cliente.");
        }
    }

    private void mostrarMensagem(FacesMessage.Severity sev, String titulo, String mensagem) {
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(sev, titulo, mensagem));
    }
}
