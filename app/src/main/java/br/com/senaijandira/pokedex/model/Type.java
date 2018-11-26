package br.com.senaijandira.pokedex.model;

/**
 * Created by 17259212 on 26/11/2018.
 */

public class Type {
    private int id;
    private int slot;
    private NamedApiResource type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public NamedApiResource getType() {
        return type;
    }

    public void setType(NamedApiResource type) {
        this.type = type;
    }
}
