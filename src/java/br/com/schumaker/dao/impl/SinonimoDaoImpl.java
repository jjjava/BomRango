package br.com.schumaker.dao.impl;

import br.com.schumaker.bs.impl.LogBsImpl;
import br.com.schumaker.connection.HsConnection;
import br.com.schumaker.dao.SinonimoDao;
import br.com.schumaker.model.Sinonimo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 21/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class SinonimoDaoImpl implements SinonimoDao {

    @Override
    public Sinonimo obter(Integer id) {
        String sql = "select * from compras.sinonimo where sinonimo.id = " + id;
        Connection conn = HsConnection.getConnection();
        Sinonimo sinonimo = new Sinonimo();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                sinonimo.setId(rs.getInt("id"));
                sinonimo.setNome(rs.getString("nome"));
                sinonimo.add(rs.getString("sin1"));
                sinonimo.add(rs.getString("sin2"));
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return sinonimo;
    }

    @Override
    public Sinonimo obter(String nome) {
        String sql = "select * from compras.sinonimo where sinonimo.nome = '" + nome + "'";
        Connection conn = HsConnection.getConnection();
        Sinonimo sinonimo = new Sinonimo();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                sinonimo.setId(rs.getInt("id"));
                sinonimo.setNome(rs.getString("nome"));
                sinonimo.add(rs.getString("sin1"));
                sinonimo.add(rs.getString("sin2"));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        return sinonimo;
    }

    @Override
    public List<Sinonimo> listar() {
        String sql = "select * from compras.sinonimo";
        Connection conn = HsConnection.getConnection();
        List<Sinonimo> lista = new ArrayList<Sinonimo>();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Sinonimo sinonimo = new Sinonimo();
                sinonimo.setId(rs.getInt("id"));
                sinonimo.setNome(rs.getString("nome"));
                sinonimo.add(rs.getString("sin1"));
                sinonimo.add(rs.getString("sin2"));
                //add na lsita
                lista.add(sinonimo);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return lista;
    }

    @Override
    public List<Sinonimo> like(String s) {
        String sql = "select * from compras.sinonimo where sinonimo.none like '%" + s + "%'";
        Connection conn = HsConnection.getConnection();
        List<Sinonimo> lista = new ArrayList<Sinonimo>();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Sinonimo sinonimo = new Sinonimo();
                sinonimo.setId(rs.getInt("id"));
                sinonimo.setNome(rs.getString("nome"));
                sinonimo.add(rs.getString("sin1"));
                sinonimo.add(rs.getString("sin2"));
                //add na lsita
                lista.add(sinonimo);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return lista;
    }

    @Override
    public boolean verificarNome(String nome) {
        boolean validado = false;
        String sql = "select * from compras.sinonimo where sinonimo.nome = '" + nome + "'";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                validado = true;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return validado;
    }

    @Override
    public boolean cadastrar(Sinonimo sin) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean atualizar(Sinonimo sin) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deletar(Sinonimo sin) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
