package br.com.senaijandira.pokedex.view;

import java.util.List;

import br.com.senaijandira.pokedex.model.NamedApiResource;

public interface MainView {
    void preencherLista(List<NamedApiResource> lstPokemons);
}
