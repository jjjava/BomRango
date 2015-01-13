package br.com.schumaker.dao.impl;

import br.com.schumaker.bs.PesquisaBs;
import br.com.schumaker.connection.HsConnection;
import br.com.schumaker.dao.ProdutoDao;
import br.com.schumaker.model.Setor;
import br.com.schumaker.model.Fabricante;
import br.com.schumaker.model.Mercado;
import br.com.schumaker.model.Produto;
import br.com.schumaker.model.Unidade;
import br.com.schumaker.util.HsCommons;
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
public class ProdutoDaoImpl implements ProdutoDao {

    @Override
    public Produto obter(Integer id) {
        String sql = "select * from compras.produto where produto.id = " + id;
        Connection conn = HsConnection.getConnection();
        Produto produto = new Produto();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                //---chaves estrangeiras
                produto.setIdcategoria(getMyCategoria(rs.getInt("idcategoria")));
                produto.setIdfabricante(getMyFabricante(rs.getInt("idfabricante")));
                produto.setIdmercado(getMyMercado(rs.getInt("idmercado")));
                produto.setUnidade(getMyUnidade(rs.getInt("unidade")));
                //---chaves estrangeiras
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getDouble("quantidade"));
                produto.setImagem(rs.getString("imagem"));
                produto.setAtivo(rs.getInt("ativo"));
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
        return produto;
    }

    @Override
    public List<Produto> listar() {
        List<Produto> produtos = new ArrayList<Produto>();
        String sql = "select * from compras.produto order by produto.preco";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                //---chaves estrangeiras
                produto.setIdcategoria(getMyCategoria(rs.getInt("idcategoria")));
                produto.setIdfabricante(getMyFabricante(rs.getInt("idfabricante")));
                produto.setIdmercado(getMyMercado(rs.getInt("idmercado")));
                produto.setUnidade(getMyUnidade(rs.getInt("unidade")));
                //---chaves estrangeiras
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getDouble("quantidade"));
                produto.setImagem(rs.getString("imagem"));
                produto.setAtivo(rs.getInt("ativo"));
                //---add na lista
                produtos.add(produto);
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
        return produtos;
    }

    @Override
    public List<Produto> listar(int limite) {
        List<Produto> produtos = new ArrayList<Produto>();
        String sql = "select * from compras.produto where produto.ativo=" + HsCommons.PRODATIV + " order by produto.preco limit " + limite;
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                //---chaves estrangeiras
                produto.setIdcategoria(getMyCategoria(rs.getInt("idcategoria")));
                produto.setIdfabricante(getMyFabricante(rs.getInt("idfabricante")));
                produto.setIdmercado(getMyMercado(rs.getInt("idmercado")));
                produto.setUnidade(getMyUnidade(rs.getInt("unidade")));
                //---chaves estrangeiras
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getDouble("quantidade"));
                produto.setImagem(rs.getString("imagem"));
                produto.setAtivo(rs.getInt("ativo"));
                //---add na lista
                produtos.add(produto);
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
        return produtos;
    }

    @Override
    public List<Produto> like(String s) {
        List<Produto> produtos = new ArrayList<Produto>();
        String sql = "select * from compras.produto where produto.nome like '%" + s + "%' and produto.ativo=" + HsCommons.PRODATIV + " order by produto.preco";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            int k = 0;
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                //---chaves estrangeiras
                produto.setIdcategoria(getMyCategoria(rs.getInt("idcategoria")));
                produto.setIdfabricante(getMyFabricante(rs.getInt("idfabricante")));
                produto.setIdmercado(getMyMercado(rs.getInt("idmercado")));
                produto.setUnidade(getMyUnidade(rs.getInt("unidade")));
                //---chaves estrangeiras
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getDouble("quantidade"));
                produto.setImagem(rs.getString("imagem"));
                produto.setAtivo(rs.getInt("ativo"));
                //---add na lista
                produtos.add(produto);
                k++;
            }
            if (k > 0) {//somente adiciona na tagcloud se o produto exisitir
                PesquisaBs pesquisaBS = new PesquisaBs(s);//fora do while para ser incrementado em 1x
                pesquisaBS.start();
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
        return produtos;
    }

    public List<Produto> listarByCategoria(int idCategoria, int limite) {
        List<Produto> produtos = new ArrayList<Produto>();
        String sql = "select * from compras.produto where produto.idcategoria=" + idCategoria + " and produto.ativo=" + HsCommons.PRODATIV + "  order by produto.preco limit " + limite;
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                //---chaves estrangeiras
                produto.setIdcategoria(getMyCategoria(rs.getInt("idcategoria")));
                produto.setIdfabricante(getMyFabricante(rs.getInt("idfabricante")));
                produto.setIdmercado(getMyMercado(rs.getInt("idmercado")));
                produto.setUnidade(getMyUnidade(rs.getInt("unidade")));
                //---chaves estrangeiras
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getDouble("quantidade"));
                produto.setImagem(rs.getString("imagem"));
                produto.setAtivo(rs.getInt("ativo"));
                //---add na lista
                produtos.add(produto);
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
        return produtos;
    }

    private Setor getMyCategoria(Integer id) {
        SetorDaoImpl categoriaDaoImpl = new SetorDaoImpl();
        return categoriaDaoImpl.obter(id);
    }

    private Fabricante getMyFabricante(Integer id) {
        FabricanteDaoImpl fabricanteDaoImpl = new FabricanteDaoImpl();
        return fabricanteDaoImpl.obter(id);
    }

    private Mercado getMyMercado(Integer id) {
        MercadoDaoImpl mercadoDaoImpl = new MercadoDaoImpl();
        return mercadoDaoImpl.obter(id);
    }

    private Unidade getMyUnidade(Integer id) {
        UnidadeDaoImpl unidadeDaoImpl = new UnidadeDaoImpl();
        return unidadeDaoImpl.obter(id);
    }
}
