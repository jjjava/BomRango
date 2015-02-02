package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.FabricanteBs;
import br.com.schumaker.dao.impl.FabricanteDaoImpl;
import br.com.schumaker.model.Fabricante;
import java.util.List;
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 17/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class FabricanteBsImpl implements FabricanteBs {

    @Override
    public Fabricante obter(Integer id) {
        return new FabricanteDaoImpl().obter(id);
    }
    
    @Override
    public Fabricante obter(String nome) {
        return new FabricanteDaoImpl().obter(nome);
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
       if(verificarNome(fabricante.getNome())){
           mostrarMensagem(FacesMessage.SEVERITY_WARN, "Cadastro - Fabricante", "Fabricante já cadastrado.");
       }else{
           if(new FabricanteDaoImpl().cadastrar(fabricante)){
               mostrarMensagem(FacesMessage.SEVERITY_INFO, "Cadastro - Fabricante", "Fabricante cadastrado com sucesso.");
           }else{
               mostrarMensagem(FacesMessage.SEVERITY_ERROR, "Cadastro - Fabricante", "Erro ao cadastrar fabricante.");
           }
       }
    }

    @Override
    public void atualizar(Fabricante fabricante) {
        mostrarMensagem(FacesMessage.SEVERITY_WARN, "Fabricante", "Ação não suportada.");
    }

    @Override
    public void deletar(Fabricante fabricante) {
        mostrarMensagem(FacesMessage.SEVERITY_WARN, "Fabricante", "Ação não suportada.");
    }
    
    private void mostrarMensagem(FacesMessage.Severity sev, String titulo, String mensagem) {
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(sev, titulo, mensagem));
    }
}
