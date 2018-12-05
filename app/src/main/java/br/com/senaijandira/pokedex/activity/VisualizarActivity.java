package br.com.senaijandira.pokedex.activity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.senaijandira.pokedex.R;
import br.com.senaijandira.pokedex.model.Pokemon;
import br.com.senaijandira.pokedex.model.Stat;
import br.com.senaijandira.pokedex.model.Type;
import br.com.senaijandira.pokedex.presenter.VisualizarPresenter;
import br.com.senaijandira.pokedex.service.ServiceFactory;
import br.com.senaijandira.pokedex.utils.StringUtil;
import br.com.senaijandira.pokedex.utils.corTipo;
import br.com.senaijandira.pokedex.view.VisualizarView;

public class VisualizarActivity extends Activity implements VisualizarView{
    StringUtil util = new StringUtil();
    corTipo cor = new corTipo();
    VisualizarPresenter presenter;
    ImageView imgPokemon, imgShiny;
    TextView txtNome, txtId, txtTipo1, txtTipo2, txtHp, txtSpeed, txtAtk, txtDef, txtSpAtk, txtSpDef;
    List<Type> tipos;
    List<Stat> stats;
    LinearLayout cor1, cor2, principal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        imgPokemon = findViewById(R.id.imgPokemon);
        imgShiny = findViewById(R.id.imgShiny);
        txtNome = findViewById(R.id.txtNome);
        txtId = findViewById(R.id.txtId);
        txtTipo1 = findViewById(R.id.txtTipo1);
        txtTipo2 = findViewById(R.id.txtTipo2);
        txtHp = findViewById(R.id.txtHp);
        txtSpeed = findViewById(R.id.txtSpeed);
        txtAtk = findViewById(R.id.txtAtk);
        txtDef = findViewById(R.id.txtDef);
        txtSpAtk = findViewById(R.id.txtSpAtk);
        txtSpDef = findViewById(R.id.txtSpDef);
        cor1 = findViewById(R.id.cor1);
        cor2 = findViewById(R.id.cor2);
        principal = findViewById(R.id.principal);



        int idPokemon = getIntent().getIntExtra("idPoke", 0);
        Log.d("ID_POKEMON", idPokemon+"");

        presenter = new VisualizarPresenter(this, ServiceFactory.create());
        presenter.carregarPokemon(idPokemon);
    }
    private Drawable getDrawableWithRadius(int Slot) {

        GradientDrawable gradientDrawable   =   new GradientDrawable();
        gradientDrawable.setCornerRadii(new float[]{15, 15, 15, 15, 15, 15, 15, 15});
        gradientDrawable.setStroke(2, Color.BLACK);
        if(Slot == 1){
            gradientDrawable.setColor(cor.pegarCorTipo(tipos.get(1).getType().getName()));
        }else if(Slot == 2){
            gradientDrawable.setColor(cor.pegarCorTipo(tipos.get(0).getType().getName()));
        }
        return gradientDrawable;
    }

    @Override
    public void preencherPokemon(Pokemon pokemon){
        Picasso.get().load(pokemon.getSprites().getFront_default()).into(imgPokemon);
        Picasso.get().load(pokemon.getSprites().getFront_shiny()).into(imgShiny);
        tipos = pokemon.getTypes();
        stats = pokemon.getStats();
        txtNome.setText(util.primeiraMaiuscula(pokemon.getSpecies().getName()));
        txtId.setText(pokemon.getId()+"");
        int colors[] = new int[2];

        if(tipos.get(0).getSlot() == 2){
            colors[0] = cor.pegarCorTipo(tipos.get(1).getType().getName());
            colors[1] = cor.pegarCorTipo(tipos.get(0).getType().getName());
            txtTipo1.setText(util.primeiraMaiuscula(tipos.get(1).getType().getName()));
            cor1.setBackground(getDrawableWithRadius(1));
            txtTipo2.setText(util.primeiraMaiuscula(tipos.get(0).getType().getName()));
            cor2.setBackground(getDrawableWithRadius(2));
        }else{
            txtTipo1.setText(util.primeiraMaiuscula(tipos.get(0).getType().getName()));
            cor1.setBackground(getDrawableWithRadius(2));
            colors[0] = cor.pegarCorTipo(tipos.get(0).getType().getName());
            colors[1] = cor.pegarCorTipo(tipos.get(0).getType().getName());
            txtTipo2.setText("");
        }

        Window window = this.getWindow();
        window.setStatusBarColor(colors[0]);
        window.setNavigationBarColor(colors[1]);
        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM, colors);

        principal.setBackgroundDrawable(gradientDrawable);

        txtHp.setText(stats.get(5).getBase_stat()+"");
        txtSpeed.setText(stats.get(0).getBase_stat()+"");
        txtAtk.setText(stats.get(4).getBase_stat()+"");
        txtDef.setText(stats.get(3).getBase_stat()+"");
        txtSpAtk.setText(stats.get(2).getBase_stat()+"");
        txtSpDef.setText(stats.get(1).getBase_stat()+"");


    }


}
