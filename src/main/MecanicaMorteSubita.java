package main;

public class MecanicaMorteSubita extends MecanicaDoJogo {
    // setters nao utilizados pois deseja-se que o usuario nao possa alterar diretamente os atributos
    private int pontuacao = 0, tentativas = 1, rodadas = 1;
    private final String nomeModo = "Morte Súbita";

    @Override
    String getRegras() {
        return "- O jogo tem rodadas infinitas, mas acaba no primeiro erro; \n" 
        +"- Palavras embaralhadas de maneiras diferentes;\n"
        +"- A pontuação de cada rodada é igual ao número da rodada.";
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
            pontuacao += rodadas;
            rodadas += 1;
        }else{
            tentativas -= 1;
            super.jogoEmAndamento = false;
        }
        super.mudaRodada = true;
    }

    @Override
    String resultadosJogo() {
        return "Sua pontuação foi "+ pontuacao + " pts ao longo de "+ rodadas + " rodadas";
    }

}
