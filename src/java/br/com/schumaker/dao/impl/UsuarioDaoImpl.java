package br.com.schumaker.dao.impl;

import br.com.schumaker.connection.HsConnection;
import br.com.schumaker.dao.UsuarioDao;
import br.com.schumaker.model.Usuario;
import br.com.schumaker.util.HsEncryption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 13/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class UsuarioDaoImpl implements UsuarioDao {

    @Override
    public Usuario obter(Integer id) {
        String sql = "select * from compras.usuario where usuario.id = " + id;
        Connection conn = HsConnection.getConnection();
        Usuario usuario = new Usuario();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));//duvida se carregar ou nao 
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
        return usuario;
    }

    @Override
    public List<Usuario> listar() {
        String sql = "select * from compras.usuario order by usuario.nome";
        Connection conn = HsConnection.getConnection();
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));//duvida se carregar ou nao 
                //adiciona a lista
                usuarios.add(usuario);
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
        return usuarios;
    }

    @Override
    public List<Usuario> like(String nome) {
        String sql = "select * from compras.usuario where usuario.nome like '%" + nome + "%' order by usuario.nome";
        Connection conn = HsConnection.getConnection();
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));//duvida se carregar ou nao 
                //adiciona a lista
                usuarios.add(usuario);
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
        return usuarios;
    }

    @Override
    public boolean validar(String email, String password) {
        boolean validado = false;
        String cryptEmail = HsEncryption.encrypt(email);
        String cryptPassword = HsEncryption.encrypt(password);
        String sql = "select * from compras.usuario where usuario.email = '" + cryptEmail + "' and usuario.senha = '" + cryptPassword + "'";
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

    public void inseri(Usuario usuario) {
        String sql = "insert into compras.usuario (nome, email, senha) "
                + " values (?,?,?,?)";
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getEmail());
            pst.setString(3, usuario.getSenha());
            pst.execute();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                pst.close();
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
