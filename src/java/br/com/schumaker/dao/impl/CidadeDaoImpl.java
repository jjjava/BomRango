package br.com.schumaker.dao.impl;

import br.com.schumaker.connection.HsConnection;
import br.com.schumaker.dao.CidadeDao;
import br.com.schumaker.model.Cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 12/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class CidadeDaoImpl implements CidadeDao{

    @Override
    public Cidade obter(Integer id) {
        String sql = "select * from compras.cidade where cidade.id = " + id;
        Connection conn = HsConnection.getConnection();
        Cidade cidade = new Cidade();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cidade.setId(rs.getInt("id"));
                cidade.setIdEstado(rs.getInt("idestado"));
                cidade.setNome(rs.getString("nome"));
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
        return cidade;
    }

    @Override
    public List<Cidade> listar() {
        List<Cidade> cidades = new ArrayList<Cidade>();
        String sql = "select * from compras.cidade order by cidade.nome";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setId(rs.getInt("id"));
                cidade.setIdEstado(rs.getInt("idestado"));
                cidade.setNome(rs.getString("nome"));
                //---add na lista
                cidades.add(cidade);
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
        return cidades;
    }

    @Override
    public List<Cidade> like(String s) {
        List<Cidade> cidades = new ArrayList<Cidade>();
        String sql = "select * from compras.cidade where cidade.nome like '%" + s + "%'";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setId(rs.getInt("id"));
                cidade.setIdEstado(rs.getInt("idestado"));
                cidade.setNome(rs.getString("nome"));
                //---add na lista
                cidades.add(cidade);
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
        return cidades;
    }
}