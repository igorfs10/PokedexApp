package br.com.senaijandira.pokedex.model;

/**
 * Created by 17259212 on 26/11/2018.
 */

public class Stat {
    private int id;
    private String base_stat;
    private NamedApiResource stat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBase_stat() {
        return base_stat;
    }

    public void setBase_stat(String base_stat) {
        this.base_stat = base_stat;
    }


    public NamedApiResource getStat() {
        return stat;
    }

    public void setStat(NamedApiResource stat) {
        this.stat = stat;
    }
}
