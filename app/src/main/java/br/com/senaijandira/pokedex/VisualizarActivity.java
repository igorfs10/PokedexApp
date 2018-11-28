package br.com.senaijandira.pokedex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.senaijandira.pokedex.model.Pokemon;
import br.com.senaijandira.pokedex.model.Type;
import br.com.senaijandira.pokedex.presenter.VisualizarPresenter;
import br.com.senaijandira.pokedex.service.ServiceFactory;
import br.com.senaijandira.pokedex.utils.StringUtil;
import br.com.senaijandira.pokedex.view.VisualizarView;

public class VisualizarActivity extends AppCompatActivity implements VisualizarView{
    StringUtil util = new StringUtil();
    VisualizarPresenter presenter;
    ImageView imgPokemon;
    TextView txtNome, txtId, txtTipo1, txtTipo2;
    List<Type> tipos;
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
        Picasso.get().load(pokemon.getSprites().getFront_default()).into(imgPokemon);
        tipos = pokemon.getTypes();
        txtNome.setText(util.primeiraMaiuscula(pokemon.getSpecies().getName()));
        txtId.setText(pokemon.getId()+"");
        if(tipos.get(0).getSlot() == 2){
            txtTipo1.setText(util.primeiraMaiuscula(tipos.get(1).getType().getName()));
            txtTipo2.setText(util.primeiraMaiuscula(tipos.get(0).getType().getName()));
        }else{
            txtTipo1.setText(util.primeiraMaiuscula(tipos.get(0).getType().getName()));
            txtTipo2.setText("");
        }
    }


}
