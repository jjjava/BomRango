package br.com.schumaker.dao.impl;

import br.com.schumaker.connection.HsConnection;
import br.com.schumaker.dao.UnidadeDao;
import br.com.schumaker.model.Unidade;
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
public class UnidadeDaoImpl implements UnidadeDao {

    @Override
    public Unidade obter(Integer id) {
        String sql = "select * from compras.unidade where unidade.id = " + id;
        Connection conn = HsConnection.getConnection();
        Unidade unidade = new Unidade();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                unidade.setId(rs.getInt("id"));
                unidade.setNome(rs.getString("nome"));
                unidade.setDescricao(rs.getString("descricao"));
            }
        } catch (SQLException e) {
            System.err.println(e);//throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);//throw new RuntimeException(e);
            }
        }
        return unidade;
    }

    @Override
    public List<Unidade> listar() {
        List<Unidade> unidades = new ArrayList<Unidade>();
        String sql = "select * from compras.unidade";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Unidade unidade = new Unidade();
                unidade.setId(rs.getInt("id"));
                unidade.setNome(rs.getString("nome"));
                unidade.setDescricao(rs.getString("descricao"));
                //---add na lista
                unidades.add(unidade);
            }
        } catch (SQLException e) {
            System.err.println(e);//throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);//throw new RuntimeException(e);
            }
        }
        return unidades;
    }

    @Override
    public List<Unidade> like(String s) {
        List<Unidade> unidades = new ArrayList<Unidade>();
        String sql = "select * from compras.unidade where unidade.nome like '%" + s + "%'";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Unidade unidade = new Unidade();
                unidade.setId(rs.getInt("id"));
                unidade.setNome(rs.getString("nome"));
                unidade.setDescricao(rs.getString("descricao"));
                //---add na lista
                unidades.add(unidade);
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
        return unidades;
    }

    @Override
    public boolean cadastrar(Unidade unidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean atulizar(Unidade unidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar(Unidade unidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
