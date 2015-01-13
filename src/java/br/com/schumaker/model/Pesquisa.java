package br.com.schumaker.model;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 07/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class Pesquisa {

    private Integer id;
    private String nome;
    private Integer vezes;

    public Pesquisa() {
    }

    public Pesquisa(Integer id, String nome, Integer vezes) {
        this.id = id;
        this.nome = nome;
        this.vezes = vezes;
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

    public Integer getVezes() {
        return vezes;
    }

    public void setVezes(Integer vezes) {
        this.vezes = vezes;
    }
}
