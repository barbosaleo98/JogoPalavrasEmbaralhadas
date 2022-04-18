package main;

import java.util.Random;

public class EmbaralhadorPermutador implements Embaralhador{

    private char[] caracteres;
    private Random randomizaCaracteres;

    @Override
    public String embaralha(String palavraOriginal) {
        caracteres = palavraOriginal.toCharArray();
        randomizaCaracteres = new Random();
         
        // Aplica embaralhamento de Fisher Yattes
        for (int i = caracteres.length-1; i > 0; i--) {
             
            // indice de 0 ate i
            int j = randomizaCaracteres.nextInt(i+1);

            // inverte caractere da posicao i pela j
            char temp = caracteres[i];
            caracteres[i] = caracteres[j];
            caracteres[j] = temp;
        }

        return String.valueOf(caracteres);
    }
    
}
