package br.com.senaijandira.pokedex.utils;

import br.com.senaijandira.pokedex.R;

public class corTipo {
    public int pegarCorTipo(String tipo){
        if(tipo.equals("bug")){
            return R.color.typeBug;
        }else if(tipo.equals("dark")){
            return R.color.typeDark;
        }else if(tipo.equals("dragon")){
            return R.color.typeDragon;
        }else if(tipo.equals("electric")){
            return R.color.typeElectric;
        }else if(tipo.equals("fairy")){
            return R.color.typeFairy;
        }else if(tipo.equals("fighting")){
            return R.color.typeFighting;
        }else if(tipo.equals("fire")){
            return R.color.typeFire;
        }else if(tipo.equals("flying")){
            return R.color.typeFlying;
        }else if(tipo.equals("ghost")){
            return R.color.typeGhost;
        }else if(tipo.equals("grass")){
            return R.color.typeGrass;
        }else if(tipo.equals("ground")){
            return R.color.typeGround;
        }else if(tipo.equals("ice")){
            return R.color.typeIce;
        }else if(tipo.equals("normal")){
            return R.color.typeNormal;
        }else if(tipo.equals("poison")){
            return R.color.typePoison;
        }else if(tipo.equals("psychic")){
            return R.color.typePsychic;
        }else if(tipo.equals("rock")){
            return R.color.typeRock;
        }else if(tipo.equals("steel")){
            return R.color.typeSteel;
        }else if(tipo.equals("water")){
            return R.color.typeWater;
        }else{
            return R.color.typeQuestion;
        }
    }
}
