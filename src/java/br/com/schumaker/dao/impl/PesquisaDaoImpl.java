package br.com.schumaker.dao.impl;

import br.com.schumaker.bs.impl.LogBsImpl;
import br.com.schumaker.connection.HsConnection;
import br.com.schumaker.dao.PesquisaDao;
import br.com.schumaker.model.Pesquisa;
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
public class PesquisaDaoImpl implements PesquisaDao {

    @Override
    public Pesquisa obter(Integer id) {
        String sql = "select * from compras.pesquisados where pesquisados.id = " + id;
        Connection conn = HsConnection.getConnection();
        Pesquisa pesquisa = new Pesquisa();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pesquisa.setId(rs.getInt("id"));
                pesquisa.setNome(rs.getString("nome"));
                pesquisa.setVezes(rs.getInt("vezes"));
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
        return pesquisa;
    }

    @Override
    public List<Pesquisa> listar() {
        List<Pesquisa> pesquisas = new ArrayList<Pesquisa>();
        String sql = "select * from compras.pesquisados order by pesquisados.vezes desc";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Pesquisa pesquisa = new Pesquisa();
                pesquisa.setId(rs.getInt("id"));
                pesquisa.setNome(rs.getString("nome"));
                pesquisa.setVezes(rs.getInt("vezes"));
                //---add na lista
                pesquisas.add(pesquisa);
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
        return pesquisas;
    }

    @Override
    public List<Pesquisa> listarTopXX(int x) {
        List<Pesquisa> pesquisas = new ArrayList<Pesquisa>();
        String sql = "select * from compras.pesquisados order by pesquisados.vezes desc limit " + x;
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Pesquisa pesquisa = new Pesquisa();
                pesquisa.setId(rs.getInt("id"));
                pesquisa.setNome(rs.getString("nome"));
                pesquisa.setVezes(rs.getInt("vezes"));
                //---add na lista
                pesquisas.add(pesquisa);
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
        return pesquisas;
    }

    @Override
    public List<Pesquisa> like(String s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void inserir(String p) {
        Pesquisa pesquisa = obter(p);
        if (pesquisa.getId() > 0) {
            String sql = "update compras.pesquisados set pesquisados.vezes = ? where pesquisados.id = ?";
            Connection conn = HsConnection.getConnection();
            PreparedStatement pst = null;
            try {
                pst = conn.prepareStatement(sql);
                pst.setInt(1, (pesquisa.getVezes() + 1));
                pst.setInt(2, pesquisa.getId());

                pst.executeUpdate();
            } catch (SQLException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            } finally {
                try {
                    pst.close();
                    conn.close();
                } catch (SQLException ex) {
                    System.err.println(ex);
                    LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
                }
            }
        } else {
            String sql = "insert into compras.pesquisados "
                    + "(nome, vezes) "
                    + "values (?, ?)";
            pesquisa.setNome(p);//seta valor pesquisado para ser gravado
            Connection conn = HsConnection.getConnection();
            PreparedStatement pst = null;
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, pesquisa.getNome());
                pst.setInt(2, pesquisa.getVezes());

                pst.execute();
            } catch (SQLException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            } finally {
                try {
                    pst.close();
                    conn.close();
                } catch (SQLException ex) {
                    System.err.println(ex);
                    LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
                }
            }
        }
    }

    @Override
    public Pesquisa obter(String nome) {
        String sql = "select * from compras.pesquisados where pesquisados.nome = '" + nome + "'";
        Connection conn = HsConnection.getConnection();
        Pesquisa pesquisa = new Pesquisa();//inicializa objeto para ñ dar erros nas verificações
        pesquisa.setId(0);
        pesquisa.setVezes(1);
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pesquisa.setId(rs.getInt("id"));
                pesquisa.setNome(rs.getString("nome"));
                pesquisa.setVezes(rs.getInt("vezes"));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        } finally {
            try {
                pst.close();
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return pesquisa;
    }

    @Override
    public void atualizar(Pesquisa p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
