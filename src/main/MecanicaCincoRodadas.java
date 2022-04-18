package main;

public class MecanicaCincoRodadas extends MecanicaDoJogo {
    // setters nao utilizados pois deseja-se que o usuario nao possa alterar diretamente os atributos
    private int pontuacao = 0, tentativas = 3, rodadas = 1;
    private final String nomeModo = "Cinco Rodadas";

    @Override
    String getRegras() {
        return "- O jogo tem 5 rodadas, com 3 tentativas cada; \n" 
        +"- Palavras embaralhadas de maneiras diferentes;\n"
        +"- A pontuação de cada rodada é igual ao número de tentivas restantes na hora do acerto.";
    }

    @Override
    public int getPontuacao() {
        return pontuacao;
    }

    @Override
    public String getNomeModo() {
        return nomeModo;
    }

    @Override
    public int getTentativas() {
        return tentativas;
    }

    @Override
    public int getRodadas() {
        return rodadas;
    }

    @Override
    public void processarTentativa(String respostaJogador) {
        if(super.isAcerto(respostaJogador)){
            pontuacao += tentativas;
            tentativas = 3;
            rodadas += 1;
            super.mudaRodada = true;
        }else{
            tentativas -= 1;
            super.mudaRodada = false;
        }

        if(tentativas <= 0 || rodadas > 5){
            super.jogoEmAndamento = false;
            super.mudaRodada = true;
        }
    }

    @Override
    String resultadosJogo() {
        return "Sua pontuação foi: "+ pontuacao + " pts";
    }
    
}
