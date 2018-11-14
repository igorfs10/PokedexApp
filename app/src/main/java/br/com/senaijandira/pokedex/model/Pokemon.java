package br.com.senaijandira.pokedex.model;

import com.google.gson.annotations.SerializedName;

public class Pokemon {
//    private int id;
    @SerializedName("name")
    private String nome;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
