package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.FabricanteBs;
import br.com.schumaker.dao.impl.FabricanteDaoImpl;
import br.com.schumaker.model.Fabricante;
import java.util.List;

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
    public void verificarNome(String nome) {
      FabricanteDaoImpl().verificarNome(nome);
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
}