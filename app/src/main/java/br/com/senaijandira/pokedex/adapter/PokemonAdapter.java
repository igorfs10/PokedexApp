package br.com.senaijandira.pokedex.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.senaijandira.pokedex.R;
import br.com.senaijandira.pokedex.model.NamedApiResource;
import br.com.senaijandira.pokedex.utils.StringUtil;

public class PokemonAdapter extends ArrayAdapter<NamedApiResource>{
    StringUtil util = new StringUtil();
    public PokemonAdapter(Context ctx){
        super(ctx, 0, new ArrayList<NamedApiResource>());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View v = convertView;

        if(v == null){
            v = LayoutInflater.from(getContext())
                    .inflate(R.layout.adapter_pokemon, parent, false);
        }
        NamedApiResource pokemon = getItem(position);

        TextView txtId = v.findViewById(R.id.txtId);
        TextView txtNome = v.findViewById(R.id.txtNome);

        String url = pokemon.getUrl();
        String[] parts = url.split("/");
        int id = Integer.parseInt(parts[parts.length - 1]);
        txtId.setText(id + "");
        String name = pokemon.getName();
        txtNome.setText(util.primeiraMaiuscula(name));
        return v;
    }
}
