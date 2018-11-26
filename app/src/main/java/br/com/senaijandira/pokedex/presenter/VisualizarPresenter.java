package br.com.senaijandira.pokedex.presenter;

import android.util.Log;

import br.com.senaijandira.pokedex.model.Pokemon;
import br.com.senaijandira.pokedex.service.PokemonService;
import br.com.senaijandira.pokedex.view.VisualizarView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VisualizarPresenter {

    VisualizarView visualizarView;
    PokemonService service;

    public VisualizarPresenter(VisualizarView visualizarView, PokemonService service){
        this.visualizarView = visualizarView;
        this.service = service;
    }

    public void carregarPokemon(int id){
        Call<Pokemon> call = service.obterPokemonPorId(id);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Pokemon pokemon = response.body();
                visualizarView.preencherPokemon(pokemon);

            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Log.e("ERRO_API", t.getMessage());
            }
        });

    }


}
