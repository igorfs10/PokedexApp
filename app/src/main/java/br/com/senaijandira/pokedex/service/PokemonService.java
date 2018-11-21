package br.com.senaijandira.pokedex.service;

import br.com.senaijandira.pokedex.model.ApiResult;
import br.com.senaijandira.pokedex.model.Pokemon;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonService {

    String URL_BASE = "http://pokeapi.co/";


    @GET("api/v2/pokemon/")
    Call<ApiResult> obterPokemons();

    @GET("api/v2/pokemon/{id}/")
    Call<Pokemon> obterPokemonPorId(@Path("id") int id);
}
