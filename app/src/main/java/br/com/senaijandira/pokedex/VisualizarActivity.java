package br.com.senaijandira.pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.com.senaijandira.pokedex.model.Pokemon;
import br.com.senaijandira.pokedex.model.PokemonFormSprites;
import br.com.senaijandira.pokedex.presenter.VisualizarPresenter;
import br.com.senaijandira.pokedex.service.ServiceFactory;
import br.com.senaijandira.pokedex.view.VisualizarView;

public class VisualizarActivity extends AppCompatActivity implements VisualizarView{

    VisualizarPresenter presenter;
    ImageView imgPokemon;
    TextView txtNome;
    TextView txtId;
    TextView txtTipo1;
    TextView txtTipo2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        imgPokemon = findViewById(R.id.imgPokemon);
        txtNome = findViewById(R.id.txtNome);
        txtId = findViewById(R.id.txtId);
        txtTipo1 = findViewById(R.id.txtTipo1);
        txtTipo2 = findViewById(R.id.txtTipo2);

        int idPokemon = getIntent().getIntExtra("idPoke", 0);
        Log.d("ID_POKEMON", idPokemon+"");

        presenter = new VisualizarPresenter(this, ServiceFactory.create());
        presenter.carregarPokemon(idPokemon);
    }

    @Override
    public void preencherPokemon(Pokemon pokemon){

    }


}
