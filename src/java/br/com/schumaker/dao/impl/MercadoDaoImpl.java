package br.com.schumaker.dao.impl;

import br.com.schumaker.connection.HsConnection;
import br.com.schumaker.dao.MercadoDao;
import br.com.schumaker.model.Cidade;
import br.com.schumaker.model.Estado;
import br.com.schumaker.model.Mercado;
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
public class MercadoDaoImpl implements MercadoDao {

    @Override
    public Mercado obter(Integer id) {
        String sql = "select * from compras.mercado where mercado.id = " + id;
        Connection conn = HsConnection.getConnection();
        Mercado mercado = new Mercado();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                mercado.setId(rs.getInt("id"));
                mercado.setIdDensidade(rs.getInt("iddensidade"));
                mercado.setNome(rs.getString("nome"));
                mercado.setEndereco(rs.getString("endereco"));
                mercado.setTelefone(rs.getString("telefone"));
                mercado.setSite(rs.getString("site"));
                mercado.setCartoes(rs.getString("cartoes"));
                mercado.setCnpj(rs.getString("cnpj"));
                mercado.setHorarioFunc(rs.getString("horariofunc"));
                mercado.setFundacao(rs.getString("fundacao"));
                mercado.setSobre(rs.getString("sobre"));
                mercado.setEstacionamento(rs.getInt("estacionamento"));
                //ojbetos
                mercado.setCidade(getMyCidade(rs.getInt("idcidade")));
                mercado.setEstado(getMyEstado(rs.getInt("idestado")));
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
        return mercado;
    }

    @Override
    public List<Mercado> listar() {
        List<Mercado> mercados = new ArrayList<Mercado>();
        String sql = "select * from compras.mercado";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Mercado mercado = new Mercado();
                mercado.setId(rs.getInt("id"));
                mercado.setIdDensidade(rs.getInt("iddensidade"));
                mercado.setNome(rs.getString("nome"));
                mercado.setEndereco(rs.getString("endereco"));
                mercado.setTelefone(rs.getString("telefone"));
                mercado.setSite(rs.getString("site"));
                mercado.setCartoes(rs.getString("cartoes"));
                mercado.setCnpj(rs.getString("cnpj"));
                mercado.setHorarioFunc(rs.getString("horariofunc"));
                mercado.setFundacao(rs.getString("fundacao"));
                mercado.setSobre(rs.getString("sobre"));
                mercado.setEstacionamento(rs.getInt("estacionamento"));
                //ojbetos
                mercado.setCidade(getMyCidade(rs.getInt("idcidade")));
                mercado.setEstado(getMyEstado(rs.getInt("idestado")));
                //---add na lista
                mercados.add(mercado);
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
        return mercados;
    }

    @Override
    public List<Mercado> like(String s) {
        List<Mercado> mercados = new ArrayList<Mercado>();
        String sql = "select * from compras.mercado where mercado.nome like '%" + s + "%'";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Mercado mercado = new Mercado();
               mercado.setId(rs.getInt("id"));
                mercado.setIdDensidade(rs.getInt("iddensidade"));
                mercado.setNome(rs.getString("nome"));
                mercado.setEndereco(rs.getString("endereco"));
                mercado.setTelefone(rs.getString("telefone"));
                mercado.setSite(rs.getString("site"));
                mercado.setCartoes(rs.getString("cartoes"));
                mercado.setCnpj(rs.getString("cnpj"));
                mercado.setHorarioFunc(rs.getString("horariofunc"));
                mercado.setFundacao(rs.getString("fundacao"));
                mercado.setSobre(rs.getString("sobre"));
                mercado.setEstacionamento(rs.getInt("estacionamento"));
                //ojbetos
                mercado.setCidade(getMyCidade(rs.getInt("idcidade")));
                mercado.setEstado(getMyEstado(rs.getInt("idestado")));
                //---add na lista
                mercados.add(mercado);
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
        return mercados;
    }

    public List<Mercado> listarByDensidade(int idDensidade) {
        List<Mercado> mercados = new ArrayList<Mercado>();
        String sql = "select * from compras.mercado where mercado.iddensidade =" + idDensidade + " order by mercado.nome";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Mercado mercado = new Mercado();
               mercado.setId(rs.getInt("id"));
                mercado.setIdDensidade(rs.getInt("iddensidade"));
                mercado.setNome(rs.getString("nome"));
                mercado.setEndereco(rs.getString("endereco"));
                mercado.setTelefone(rs.getString("telefone"));
                mercado.setSite(rs.getString("site"));
                mercado.setCartoes(rs.getString("cartoes"));
                mercado.setCnpj(rs.getString("cnpj"));
                mercado.setHorarioFunc(rs.getString("horariofunc"));
                mercado.setFundacao(rs.getString("fundacao"));
                mercado.setSobre(rs.getString("sobre"));
                mercado.setEstacionamento(rs.getInt("estacionamento"));
                //ojbetos
                mercado.setCidade(getMyCidade(rs.getInt("idcidade")));
                mercado.setEstado(getMyEstado(rs.getInt("idestado")));
                //---add na lista
                mercados.add(mercado);
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
        return mercados;
    }

    private Estado getMyEstado(Integer id) {
        return new EstadoDaoImpl().obter(id);
    }

    private Cidade getMyCidade(Integer id) {
        return new CidadeDaoImpl().obter(id);
    }
}
