package br.com.senaijandira.pokedex.model;

import java.util.List;

public class Pokemon {
    private int id;
    private NamedApiResource species;
    private PokemonFormSprites sprites;
    private List<Stat> stats;
    private List<Type> types;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NamedApiResource getSpecies() {
        return species;
    }

    public void setSpecies(NamedApiResource species) {
        this.species = species;
    }

    public PokemonFormSprites getSprites() {
        return sprites;
    }

    public void setSprites(PokemonFormSprites sprites) {
        this.sprites = sprites;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

}
