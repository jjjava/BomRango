package br.com.schumaker.dao.impl;

import br.com.schumaker.connection.HsConnection;
import br.com.schumaker.dao.CategoriaDao;
import br.com.schumaker.model.Categoria;
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
public class CategoriaDaoImpl implements CategoriaDao {

    @Override
    public Categoria obter(Integer id) {
        String sql = "select * from compras.categoria where id = " + id;
        Connection conn = HsConnection.getConnection();
        Categoria categoria = new Categoria();
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
                System.err.println(e);//throw new RuntimeException(e);
            }
        }
        return categoria;
    }

    @Override
    public List<Categoria> listar() {
        List<Categoria> categorias = new ArrayList<Categoria>();
        String sql = "select * from compras.categoria order by categoria.nome";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));
                //---add na lista
                categorias.add(categoria);
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
        return categorias;
    }

    @Override
    public List<Categoria> like(String s) {
        List<Categoria> categorias = new ArrayList<Categoria>();
        String sql = "select * from compras.categoria where categoria.nome like '%" + s + "%' order by categoria.nome";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria();
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
}
