package br.com.schumaker.dao.impl;

import br.com.schumaker.connection.HsConnection;
import br.com.schumaker.dao.ClienteDao;
import br.com.schumaker.model.Cliente;
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
public class ClienteDaoImpl implements ClienteDao {

    @Override
    public Cliente obter(Integer id) {
        String sql = "select * from compras.cliente where cliente.id = " + id;
        Connection conn = HsConnection.getConnection();
        Cliente cliente = new Cliente();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cliente.setId(rs.getInt("id"));
                cliente.setIdMercado(rs.getInt("idmercado"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));//duvida se carregar ou nao 
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
        return cliente;
    }

    public Cliente obter(String email) {
        String sql = "select * from compras.cliente where cliente.email = '" + email + "'";
        Connection conn = HsConnection.getConnection();
        Cliente cliente = new Cliente();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cliente.setId(rs.getInt("id"));
                cliente.setIdMercado(rs.getInt("idmercado"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));//duvida se carregar ou nao 
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
        return cliente;
    }

    @Override
    public List<Cliente> listar() {
        String sql = "select * from compras.cliente order by cliente.nome";
        Connection conn = HsConnection.getConnection();
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setIdMercado(rs.getInt("idmercado"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));//duvida se carregar ou nao 
                //adiciona a lista
                clientes.add(cliente);
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
        return clientes;
    }

    @Override
    public List<Cliente> like(String nome) {
        String sql = "select * from compras.cliente where cliente.nome like '%" + nome + "%' order by cliente.nome";
        Connection conn = HsConnection.getConnection();
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setIdMercado(rs.getInt("idmercado"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));//duvida se carregar ou nao 
                //adiciona a lista
                clientes.add(cliente);
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
        return clientes;
    }

    @Override
    public boolean validar(String email, String password) {
        boolean validado = false;
        String cryptEmail = HsEncryption.encrypt(email);
        String cryptPassword = HsEncryption.encrypt(password);
        String sql = "select * from compras.cliente where cliente.email = '" + cryptEmail + "' and cliente.senha = '" + cryptPassword + "'";
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

    public void inseri(Cliente cliente) {
        String sql = "insert into compras.cliente (idmercado, nome, email, senha) "
                + " values (?,?,?,?)";
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, cliente.getIdMercado());
            pst.setString(2, cliente.getNome());
            pst.setString(3, cliente.getEmail());
            pst.setString(4, cliente.getSenha());
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
