package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.CidadeBs;
import br.com.schumaker.dao.impl.CidadeDaoImpl;
import br.com.schumaker.model.Cidade;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 05/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class CidadeBsImpl implements CidadeBs {

    @Override
    public Cidade obter(Integer id) {
        return new CidadeDaoImpl().obter(id);
    }

    @Override
    public List<Cidade> listar() {
        return new CidadeDaoImpl().listar();
    }

    @Override
    public List<Cidade> like(String s) {
        return new CidadeDaoImpl().like(s);
    }

    @Override
    public boolean verificarNome(String nome) {
        return new CidadeDaoImpl().verificarNome(nome);
    }

    @Override
    public boolean cadastar(Cidade cidade) {
        return new CidadeDaoImpl().cadastar(cidade);
    }

    @Override
    public boolean atualizar(Cidade cidade) {
        return new CidadeDaoImpl().atualizar(cidade);
    }

    @Override
    public boolean deletar(Cidade cidade) {
        return new CidadeDaoImpl().deletar(cidade);
    }
}
