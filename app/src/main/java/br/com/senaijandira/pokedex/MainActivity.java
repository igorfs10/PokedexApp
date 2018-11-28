package br.com.senaijandira.pokedex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.senaijandira.pokedex.adapter.PokemonAdapter;
import br.com.senaijandira.pokedex.model.NamedApiResource;
import br.com.senaijandira.pokedex.presenter.MainPresenter;
import br.com.senaijandira.pokedex.service.ServiceFactory;
import br.com.senaijandira.pokedex.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView, AdapterView.OnItemClickListener {

    ListView lstPokemon;
    PokemonAdapter adapter;
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstPokemon = findViewById(R.id.lstPokemon);

        adapter = new PokemonAdapter(this);

        lstPokemon.setAdapter(adapter);
        lstPokemon.setOnItemClickListener(this);

        presenter = new MainPresenter(this, ServiceFactory.create());
    }

    @Override
    protected void onResume(){
        super.onResume();

        presenter.carregarPokemons();
    }
    @Override
    public void preencherLista(List<NamedApiResource> lstPokemons) {
        adapter.clear();
        adapter.addAll(lstPokemons);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        NamedApiResource pokemon = adapter.getItem(position);
        String url = pokemon.getUrl();
        String[] parts = url.split("/");
        int idPoke = Integer.parseInt(parts[parts.length - 1]);

        Intent intent = new Intent(this, VisualizarActivity.class);
        intent.putExtra("idPoke", idPoke);
        startActivity(intent);
    }
}
