package br.com.schumaker.model;

import java.util.ArrayList;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 21/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class Sinonimo {

    private int id;
    private String nome;
    private ArrayList<Sinonimo> lista;

    public Sinonimo() {
    }

    public void add(Sinonimo sin) {
        lista.add(sin);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Sinonimo> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Sinonimo> lista) {
        this.lista = lista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
