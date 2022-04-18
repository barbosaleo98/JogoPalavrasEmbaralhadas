package main;

public abstract class MecanicaDoJogo {
    // setters nao utilizados pois deseja-se que o usuario nao possa alterar diretamente os atributos
    protected String palavraOriginal, palavraEmbaralhada, nomeModo, respostaJogador;
    protected BancoDePalavras bancoPalavras;
    protected boolean jogoEmAndamento = true, mudaRodada = false;

    abstract void processarTentativa(String respostaJogador);
    abstract String resultadosJogo();
    abstract int getPontuacao();
    abstract int getTentativas();
    abstract int getRodadas();
    abstract String getNomeModo();
    abstract String getRegras();

    public boolean isJogoEmAndamento() {
        return jogoEmAndamento;
    }

    public void carregaBancoDePalavras(BancoDePalavras bancoPalavras){
        this.bancoPalavras = bancoPalavras;
    }

    public String getPalavraOriginal() {
        return palavraOriginal;
    }

    public String getPalavraEmbaralhada() {
        return palavraEmbaralhada;
    }

    public void geraRodada(){
        mudaRodada = false;
        palavraOriginal = bancoPalavras.sorteiaPalavra();
        FabricaEmbaralhadores fabricaEmbaralhadores = new FabricaEmbaralhadores();
        Embaralhador embaralhador = fabricaEmbaralhadores.selecionaEmbaralhador();
        palavraEmbaralhada = embaralhador.embaralha(palavraOriginal);
    }

    public boolean isMudaRodada() {
        return mudaRodada;
    }

    public boolean isAcerto(String respostaJogador){
        return respostaJogador.equals(palavraOriginal);
    }

}

