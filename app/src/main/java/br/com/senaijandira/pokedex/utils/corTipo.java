package br.com.senaijandira.pokedex.utils;

import android.graphics.Color;
public class corTipo {
    public int pegarCorTipo(String tipo){
        if(tipo.equals("bug")){
            return Color.parseColor("#A8B820");
        }else if(tipo.equals("dark")){
            return Color.parseColor("#705848");
        }else if(tipo.equals("dragon")){
            return Color.parseColor("#7038F8");
        }else if(tipo.equals("electric")){
            return Color.parseColor("#F8D030");
        }else if(tipo.equals("fairy")){
            return Color.parseColor("#EE99AC");
        }else if(tipo.equals("fighting")){
            return Color.parseColor("#C03028");
        }else if(tipo.equals("fire")){
            return Color.parseColor("#F08030");
        }else if(tipo.equals("flying")){
            return Color.parseColor("#A890F0");
        }else if(tipo.equals("ghost")){
            return Color.parseColor("#705898");
        }else if(tipo.equals("grass")){
            return Color.parseColor("#78C850");
        }else if(tipo.equals("ground")){
            return Color.parseColor("#E0C068");
        }else if(tipo.equals("ice")){
            return Color.parseColor("#98D8D8");
        }else if(tipo.equals("normal")){
            return Color.parseColor("#A8A878");
        }else if(tipo.equals("poison")){
            return Color.parseColor("#A040A0");
        }else if(tipo.equals("psychic")){
            return Color.parseColor("#F85888");
        }else if(tipo.equals("rock")){
            return Color.parseColor("#B8A038");
        }else if(tipo.equals("steel")){
            return Color.parseColor("#B8B8D0");
        }else if(tipo.equals("water")){
            return Color.parseColor("#6890F0");
        }else{
            return Color.parseColor("#68A090");
        }
    }
}
