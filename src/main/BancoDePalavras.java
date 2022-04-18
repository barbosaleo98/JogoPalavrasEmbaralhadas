package main;

import java.util.ArrayList;
import java.util.Random;

public class BancoDePalavras {
    private ArrayList<String> listaPalavras = new ArrayList<String>();
    private Random randomizaPalavra = new Random();

    public BancoDePalavras(ArrayList<String> listaPalavras) {
        this.listaPalavras = listaPalavras;
    }
    
    public String sorteiaPalavra(){
        int indiceAleatorio = randomizaPalavra.nextInt(listaPalavras.size());
        return listaPalavras.get(indiceAleatorio);
    }
}

