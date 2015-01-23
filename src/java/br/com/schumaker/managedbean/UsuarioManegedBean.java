package br.com.schumaker.managedbean;

import br.com.schumaker.bs.impl.UsuarioBsImpl;
import br.com.schumaker.model.Usuario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 12/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
@ManagedBean
@ViewScoped

public class UsuarioManegedBean implements Serializable {

    private Usuario usuario;
    public UsuarioManegedBean() {
    }

    public void doLogin() {
        new UsuarioBsImpl().validar(usuario);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
