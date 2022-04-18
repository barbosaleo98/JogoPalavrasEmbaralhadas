package main;

public class FabricaMecanicaDoJogo {
    private MecanicaDoJogo mecanica;

    public MecanicaDoJogo selecionaMecanicaDoJogo(int escolhaJogador) throws NoSuchFieldException{
        
        switch (escolhaJogador) {
            case 1:
                this.mecanica = new MecanicaCincoRodadas();
                break;
            case 2:
                this.mecanica = new MecanicaMorteSubita();
                break;
            default:
                throw new NoSuchFieldException("Valor inválido");
        }

        return mecanica;
    }
}

