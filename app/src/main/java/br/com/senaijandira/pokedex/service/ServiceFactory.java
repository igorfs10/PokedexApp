package br.com.senaijandira.pokedex.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

Gson gson

public class ServiceFactory {

    public static PokemonService create(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PokemonService.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(PokemonService.class);
    }
}
