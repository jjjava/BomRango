package br.com.schumaker.model;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 07/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class Mercado {

    private Integer id;
    private Integer idDensidade;
    private String nome;
    private String endereco;
    private String cidade;
    private String bairro;
    private String estado;
    private String telefone;
    private String site;
    private String cartoes;
    private String cnpj;
    private String horarioFunc;
    private String fundacao;
    private String sobre;

    public Mercado() {
    }

    public Mercado(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Integer getIdDensidade() {
        return idDensidade;
    }

    public void setIdDensidade(Integer idDensidade) {
        this.idDensidade = idDensidade;
    }

    public String getCartoes() {
        return cartoes;
    }

    public void setCartoes(String cartoes) {
        this.cartoes = cartoes;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getHorarioFunc() {
        return horarioFunc;
    }

    public void setHorarioFunc(String horarioFunc) {
        this.horarioFunc = horarioFunc;
    }

    public String getFundacao() {
        return fundacao;
    }

    public void setFundacao(String fundacao) {
        this.fundacao = fundacao;
    }

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
