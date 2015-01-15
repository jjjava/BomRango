package br.com.schumaker.dao.impl;

import br.com.schumaker.connection.HsConnection;
import br.com.schumaker.dao.FabricanteDao;
import br.com.schumaker.model.Fabricante;
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
public class FabricanteDaoImpl implements FabricanteDao {

    @Override
    public Fabricante obter(Integer id) {
        String sql = "select * from compras.fabricante where fabricante.id = " + id;
        Connection conn = HsConnection.getConnection();
        Fabricante fabricante = new Fabricante();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                fabricante.setId(rs.getInt("id"));
                fabricante.setNome(rs.getString("nome"));
                fabricante.setSite(rs.getString("site"));
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
        return fabricante;
    }

    @Override
    public List<Fabricante> listar() {
        List<Fabricante> fabricantes = new ArrayList<Fabricante>();
        String sql = "select * from compras.fabricante";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Fabricante fabricante = new Fabricante();
                fabricante.setId(rs.getInt("id"));
                fabricante.setNome(rs.getString("nome"));
                fabricante.setSite(rs.getString("site"));
                //---add na lista
                fabricantes.add(fabricante);
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
        return fabricantes;
    }

    @Override
    public List<Fabricante> like(String s) {
        List<Fabricante> fabricantes = new ArrayList<Fabricante>();
        String sql = "select * from compras.fabricante where fabricante.nome like '%" + s + "%'";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Fabricante fabricante = new Fabricante();
                fabricante.setId(rs.getInt("id"));
                fabricante.setNome(rs.getString("nome"));
                fabricante.setSite(rs.getString("site"));
                //---add na lista
                fabricantes.add(fabricante);
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
        return fabricantes;
    }

    public boolean verifyName(String nome) {
        boolean validado = false;
        String sql = "select * from compras.fabricante where fabricante.nome = '" + nome + "'";
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
}
