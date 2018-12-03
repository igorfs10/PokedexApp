package br.com.senaijandira.pokedex.presenter;

import android.util.Log;

import br.com.senaijandira.pokedex.model.ApiResult;
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
        Call<ApiResult> call = service.obterPokemons();
        call.enqueue(new Callback<ApiResult>() {
            @Override
            public void onResponse(Call<ApiResult> call, Response<ApiResult> response) {
                ApiResult apiResult = response.body();
                mainView.preencherLista(apiResult.getResults());

            }

            @Override
            public void onFailure(Call<ApiResult> call, Throwable t) {
                Log.e("ERRO_API", t.getMessage());
            }
        });
    }
}
