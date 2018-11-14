package br.com.senaijandira.pokedex.service;

import java.util.List;

import br.com.senaijandira.pokedex.model.NamedApiResource;
import br.com.senaijandira.pokedex.model.Pokemon;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonService {

    String URL_BASE = "http://pokeapi.co/api/v2/";


    @GET("/pokemon/")
    Call<List<NamedApiResource>> obterPokemons();

    @GET("/pokemon/{id}/")
    Call<Pokemon> obterPokemonPorId(@Path("id") int id);
}
