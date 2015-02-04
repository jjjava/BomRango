package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.UsuarioBs;
import br.com.schumaker.dao.impl.UsuarioDaoImpl;
import br.com.schumaker.hsfiles.HsFiles;
import br.com.schumaker.model.Usuario;
import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 19/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class UsuarioBsImpl implements UsuarioBs {

    @Override
    public Usuario obter(Integer id) {
        return new UsuarioDaoImpl().obter(id);
    }

    @Override
    public Usuario obter(String email) {
        return new UsuarioDaoImpl().obter(email);
    }

    @Override
    public List<Usuario> listar() {
        return new UsuarioDaoImpl().listar();
    }

    @Override
    public List<Usuario> like(String nome) {
        return new UsuarioDaoImpl().like(nome);
    }

    @Override
    public boolean verificarEmail(String email) {
        return new UsuarioDaoImpl().verificarEmail(email);
    }

    @Override
    public void validar(Usuario usuario) {
        UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();
        //
        //criptografar aqui
        //
        if (usuarioDaoImpl.validar(usuario.getEmail(), usuario.getSenha())) {//usar senha criptografada
            try {
                usuario = obter(usuario.getEmail());
                FacesContext fc = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
                session.setAttribute("Usuario", usuario);
                fc.getExternalContext().redirect("index.xhtml");
            } catch (IOException ex) {
                System.out.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        } else {
            mostrarMensagem(FacesMessage.SEVERITY_INFO, "Login", "Email ou Senha incorretos.");
        }
    }

    @Override
    public void cadastrar(Usuario usuario) {
        if (new UsuarioDaoImpl().verificarEmail(usuario.getEmail())) {
            mostrarMensagem(FacesMessage.SEVERITY_WARN, "Cadastro - Usuário", "Já existe um ususário com esse email cadastrado.");
        } else {
            if (new UsuarioDaoImpl().cadastrar(usuario)) {
                if (new HsFiles().criarDirUsuario(usuario.getEmail())) {
                    mostrarMensagem(FacesMessage.SEVERITY_INFO, "Cadastro - Usuário", "Usuário cadastraso.");
                } else {
                    mostrarMensagem(FacesMessage.SEVERITY_ERROR, "Cadastro - Usuário", "Erro ao cadastrar a usuário.");
                }
            } else {
                mostrarMensagem(FacesMessage.SEVERITY_ERROR, "Cadastro - Usuário", "Erro ao cadastrar a usuário.");
            }
        }
    }

    @Override
    public void atualizar(Usuario usuario) {
        mostrarMensagem(FacesMessage.SEVERITY_WARN, "Setor", "Não suportado ainda");
    }

    @Override
    public void deletar(Usuario usuario) {
        mostrarMensagem(FacesMessage.SEVERITY_WARN, "Setor", "Não suportado ainda");
    }

    private void mostrarMensagem(FacesMessage.Severity sev, String titulo, String mensagem) {
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(sev, titulo, mensagem));
    }
}
