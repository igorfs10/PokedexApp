package br.com.senaijandira.pokedex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import br.com.senaijandira.pokedex.adapter.PokemonAdapter;
import br.com.senaijandira.pokedex.model.NamedApiResource;
import br.com.senaijandira.pokedex.presenter.MainPresenter;
import br.com.senaijandira.pokedex.service.ServiceFactory;
import br.com.senaijandira.pokedex.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView {

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

        presenter = new MainPresenter(this, ServiceFactory.create());

    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.carregarPokemons();
    }

    @Override
    public void preencherLista(List<NamedApiResource> lstPokemons) {
        adapter.clear();
        adapter.addAll(lstPokemons);
    }
<<<<<<< HEAD

=======
>>>>>>> origin/igor
}
