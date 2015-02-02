package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.UnidadeBs;
import br.com.schumaker.dao.impl.UnidadeDaoImpl;
import br.com.schumaker.model.Unidade;
import java.util.List;
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 24/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class UnidadeBsImpl implements UnidadeBs{

    @Override
    public Unidade obter(Integer id) {
       return new UnidadeDaoImpl().obter(id);
    }
    
    @Override
    public Unidade obter(String nome) {
       return new UnidadeDaoImpl().obter(nome);
    }

    @Override
    public List<Unidade> listar() {
      return new UnidadeDaoImpl().listar();
    }

    @Override
    public List<Unidade> like(String s) {
        return new UnidadeDaoImpl().like(s);
    }

    @Override
    public boolean verificarNome(String nome) {
        return new UnidadeDaoImpl().verificarNome(nome);
    }

    @Override
    public void cadastrar(Unidade cidade) {
       mostrarMensagem(FacesMessage.SEVERITY_WARN, "Cadastro - Unidade", "Ação não suportada.");
    }

    @Override
    public void atualizar(Unidade cidade) {
        mostrarMensagem(FacesMessage.SEVERITY_WARN, "Atualizar - Unidade", "Ação não suportada.");
    }

    @Override
    public void deletar(Unidade cidade) {
        mostrarMensagem(FacesMessage.SEVERITY_WARN, "Atualizar - Unidade", "Ação não suportada.");
    }
    
    private void mostrarMensagem(FacesMessage.Severity sev, String titulo, String mensagem) {
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(sev, titulo, mensagem));
    }
}
