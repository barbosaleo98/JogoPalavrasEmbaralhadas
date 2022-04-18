package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    private static FabricaMecanicaDoJogo fabricaMecanica = new FabricaMecanicaDoJogo();
    private static BancoDePalavras bancoPalavras;
    private static MecanicaDoJogo mecanica;
    private static Scanner scannerArquivoPalavras = null;
    private static Scanner scannerEntradas = new Scanner(System.in);
    private static String respostaJogador;
    private static boolean repetirEntrada;

    public static void main(String[] args) {

        try {
            inicializaBancoPalavras("src/main/resources/palavras.txt");
        } catch (Exception exception) {
            System.out.println("Erro: "+exception.getMessage());
        }

        repetirEntrada = true;

        while(repetirEntrada){

            inicializaJogo();

            while(mecanica.isJogoEmAndamento()){
                mecanica.geraRodada();
                while(!mecanica.isMudaRodada()){
                    System.out.println("-------------------------------------");
                    System.out.println("\nRodada: "+ mecanica.getRodadas() + " | Pontos: " + mecanica.getPontuacao());
                    System.out.println("Tentativas nesta rodada: "+ mecanica.getTentativas());
                    System.out.println("\n> Palavra em jogo: "+ mecanica.getPalavraEmbaralhada());
                    System.out.print("> Sua resposta: ");  
                    respostaJogador = scannerEntradas.next();
                    mecanica.processarTentativa(respostaJogador);
                    if(mecanica.getTentativas() == 0 || mecanica.isAcerto(respostaJogador))
                        System.out.println(">> Resposta correta: " + mecanica.getPalavraOriginal());
                }
            }
            
            System.out.println("\n======= Fim de jogo! =======");
            System.out.println("\n"+mecanica.resultadosJogo()+"\n");

            System.out.println("> Jogar novamente?");
            System.out.println("[s] Para jogar novamente");
            System.out.println("Ou digite qualquer coisa para sair");
            System.out.print("\nEscolha: ");
            respostaJogador = scannerEntradas.next();

            if(respostaJogador.equals("s")){
                repetirEntrada = true;
            }else{
                repetirEntrada = false;
                System.out.println("\nOk, até mais!");
            }
        }
    }

    // Imprime no console informacoes da inicializacao do jogo
    public static void inicializaJogo(){
        System.out.println("=====================================");
        System.out.println("   JOGO DAS PALAVRAS EMBARALHADAS    ");
        System.out.println("=====================================");

        repetirEntrada = true;

        while(repetirEntrada){
            try {
                System.out.println("\nEscolha o modo:");
                System.out.println("\n[1] Cinco Rodadas \n[2] Morte Súbita\n");
                System.out.print("Modo: ");
                mecanica = fabricaMecanica.selecionaMecanicaDoJogo(scannerEntradas.nextInt());
                repetirEntrada = false;
            } catch (NoSuchFieldException|InputMismatchException userInputException) {
                System.out.println("\n- ERRO: Favor selecionar um dos números entre [ ]");
                System.out.println("-------------------------------------");
                scannerEntradas.nextLine();
                repetirEntrada = true;
            }
        }
        
        mecanica.carregaBancoDePalavras(bancoPalavras);
        System.out.println("\n-----------------------------------");
        System.out.println("Selecionado: " + mecanica.getNomeModo().toUpperCase());
        System.out.println(mecanica.getRegras());

    }

    // Avaliacao pede que somente a Principal use scanner, por isso este metodo esta aqui
    // do contrario, pelo "tell don't ask" isso estaria na classe do BancoDePalavras
    public static void inicializaBancoPalavras(String nomeArquivoPalavras) throws Exception{
        ArrayList<String> listaPalavras = new ArrayList<String>();
        try {
            File arquivo = new File(nomeArquivoPalavras);
            scannerArquivoPalavras = new Scanner(arquivo);
            if(arquivo.length()==0){
                throw new Exception("Arquivo vazio");
            }
            while(scannerArquivoPalavras.hasNextLine()){
                String novaPalavra = scannerArquivoPalavras.nextLine();
                listaPalavras.add(novaPalavra);
            }
            bancoPalavras = new BancoDePalavras(listaPalavras);
        } catch (IOException ioException) {
            throw new Exception("Erro ao abrir arquivo: "+ioException.getMessage());
        }finally{
            if(scannerArquivoPalavras != null)
                scannerArquivoPalavras.close();
        }
        
    }
}

