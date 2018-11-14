package br.com.senaijandira.pokedex.presenter;

import android.util.Log;

import java.util.List;

import br.com.senaijandira.pokedex.model.NamedApiResource;
import br.com.senaijandira.pokedex.service.PokemonService;
import br.com.senaijandira.pokedex.view.MainView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {

    MainView mainView;
    PokemonService service;

    public MainPresenter(MainView mainView, PokemonService service){
        this.mainView = mainView;
        this.service = service;
    }

    public void carregarPokemons(){
        Call<List<NamedApiResource>> call = service.obterPokemons();

        call.enqueue(new Callback<List<NamedApiResource>>() {
            @Override
            public void onResponse(Call<List<NamedApiResource>> call, Response<List<NamedApiResource>> response) {
                List<NamedApiResource> NamedApiResource = response.body();

                mainView.preencherLista(NamedApiResource);
            }

            @Override
            public void onFailure(Call<List<NamedApiResource>> call, Throwable t) {
                Log.e("ERRO_API", t.getMessage());
            }
        });
    }
}
