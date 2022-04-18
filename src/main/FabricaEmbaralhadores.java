package main;

import java.util.Random;

public class FabricaEmbaralhadores {
    private Embaralhador embaralhador;
    private Random randomizaEmbaralhador = new Random();

    public Embaralhador selecionaEmbaralhador(){
        
        // Escolhe aleatoriamente um embaralhador
        switch (randomizaEmbaralhador.nextInt(3)) {
            case 0:
                this.embaralhador = new EmbaralhadorInversor();
                break;
            case 1:
                this.embaralhador = new EmbaralhadorPermutador();
                break;
            case 2:
                this.embaralhador = new EmbaralhadorParesImpares();
                break;
        }
        return embaralhador;
    }

}

