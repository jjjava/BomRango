package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.FabricanteBs;
import br.com.schumaker.dao.impl.FabricanteDaoImpl;
import br.com.schumaker.model.Fabricante;
import java.util.List;
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;

/**
 *
 * @author hudson.sales
 * @verison 1.0.0
 */
public class FabricanteBsImpl implements FabricanteBs {

    @Override
    public Fabricante obter(Integer id) {
        return new FabricanteDaoImpl().obter(id);
    }

    @Override
    public List<Fabricante> listar() {
        return new FabricanteDaoImpl().listar();
    }

    @Override
    public List<Fabricante> like(String s) {
        return new FabricanteDaoImpl().like(s);
    }

    @Override
    public boolean verificarNome(String nome) {
      return new FabricanteDaoImpl().verificarNome(nome);
    }

    @Override
    public void cadastrar(Fabricante fabricante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Fabricante fabricante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Fabricante fabricante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void mostrarMensagem(FacesMessage.Severity sev, String titulo, String mensagem) {
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(sev, titulo, mensagem));
    }
}
