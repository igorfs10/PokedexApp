package br.com.senaijandira.pokedex.utils;

public class StringUtil {
    public String primeiraMaiuscula(String name){
        char primeiraLetraMaiuscula =  Character.toUpperCase(name.charAt(0));
        name = primeiraLetraMaiuscula + name.substring(1, name.length());
        return name;
    }
}
