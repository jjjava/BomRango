package br.com.schumaker.dao.impl;

import br.com.schumaker.connection.HsConnection;
import br.com.schumaker.dao.SetorDao;
import br.com.schumaker.model.Setor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 07/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class SetorDaoImpl implements SetorDao {

    public SetorDaoImpl() {
    }

    @Override
    public Setor obter(Integer id) {
        String sql = "select * from compras.categoria where categoria.id = " + id;
        Connection conn = HsConnection.getConnection();
        Setor categoria = new Setor();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));
            }
        } catch (SQLException e) {
            System.err.println(e);//throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return categoria;
    }

    @Override
    public List<Setor> listar() {
        List<Setor> categorias = new ArrayList<Setor>();
        String sql = "select * from compras.categoria order by categoria.nome";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Setor categoria = new Setor();
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));
                //---add na lista
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return categorias;
    }

    @Override
    public List<Setor> like(String s) {
        List<Setor> categorias = new ArrayList<Setor>();
        String sql = "select * from compras.categoria where categoria.nome like '%" + s + "%' order by categoria.nome";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Setor categoria = new Setor();
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));
                //adiciona a lista
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return categorias;
    }

    @Override
    public boolean verificarNome(String nome) {
        boolean validado = false;
        String sql = "select * from compras.categoria where categoria.nome = '" + nome + "'";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                validado = true;
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return validado;
    }

    @Override
    public boolean cadastrar(Setor setor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean atualizar(Setor setor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar(Setor setor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
