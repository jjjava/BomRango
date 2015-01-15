package br.com.schumaker.dao.impl;

import br.com.schumaker.connection.HsConnection;
import br.com.schumaker.dao.DensidadeDao;
import br.com.schumaker.model.Densidade;
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
public class DensidadeDaoImpl implements DensidadeDao {

    @Override
    public Densidade obter(Integer id) {
        String sql = "select * from compras.densidade where densidade.id = " + id;
        Connection conn = HsConnection.getConnection();
        Densidade densidade = new Densidade();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                densidade.setId(rs.getInt("id"));
                densidade.setNome(rs.getString("nome"));
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
        return densidade;
    }

    @Override
    public List<Densidade> listar() {
        List<Densidade> densidades = new ArrayList<Densidade>();
        String sql = "select * from compras.densidade order by densidade.id";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Densidade densidade = new Densidade();
                densidade.setId(rs.getInt("id"));
                densidade.setNome(rs.getString("nome"));
                //---add na lista
                densidades.add(densidade);
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
        return densidades;
    }

    @Override
    public List<Densidade> like(String s) {
        List<Densidade> densidades = new ArrayList<Densidade>();
        String sql = "select * from compras.densidade where densidade.nome like '%" + s + "%'";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Densidade densidade = new Densidade();
                densidade.setId(rs.getInt("id"));
                densidade.setNome(rs.getString("nome"));
                //---add na lista
                densidades.add(densidade);
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
        return densidades;
    }

    public boolean verificarNomeDensidade(String nome) {
        String sql = "select * from compras.densidade where densidade.nome = '" + nome + "'";
        Connection conn = HsConnection.getConnection();
        boolean validado = false;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

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
        return validado;
    }
}
