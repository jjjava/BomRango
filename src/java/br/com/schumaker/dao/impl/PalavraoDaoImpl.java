package br.com.schumaker.dao.impl;

import br.com.schumaker.connection.HsConnection;
import br.com.schumaker.dao.PalavraoDao;
import br.com.schumaker.model.Palavrao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 08/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class PalavraoDaoImpl implements PalavraoDao {

    @Override
    public Palavrao obter(Integer id) {
        String sql = "select * from compras.palavrao where palavrao.id = " + id;
        Connection conn = HsConnection.getConnection();
        Palavrao palavrao = new Palavrao();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                palavrao.setId(rs.getInt("id"));
                palavrao.setNome(rs.getString("nome"));
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
        return palavrao;
    }

    @Override
    public List<Palavrao> listar() {
        List<Palavrao> palavraos = new ArrayList<Palavrao>();
        String sql = "select * from compras.palavrao";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Palavrao palavrao = new Palavrao();
                palavrao.setId(rs.getInt("id"));
                palavrao.setNome(rs.getString("nome"));
                //---add na lista
                palavraos.add(palavrao);
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
        return palavraos;
    }

    @Override
    public List<Palavrao> like(String s) {
        List<Palavrao> palavroes = new ArrayList<Palavrao>();
        String sql = "select * from compras.palavrao where nome like '%" + s + "%'";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Palavrao palavrao = new Palavrao();
                palavrao.setId(rs.getInt("id"));
                palavrao.setNome(rs.getString("nome"));
                //---add na lista
                palavroes.add(palavrao);
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
        return palavroes;
    }
}
