package main;

public class EmbaralhadorParesImpares implements Embaralhador {

    @Override
    public String embaralha(String palavraOriginal) {
        char[] caracteres = palavraOriginal.toCharArray();
         
        for (int i = 1; i < caracteres.length; i++) {
            char temp = ' ';

            // Quando i eh impar, inverte seu caractere com o do indice anterior
            if(i%2 != 0){
                temp = caracteres[i-1];
                caracteres[i-1] = caracteres[i];
                caracteres[i] = temp;
            }

        }

        return String.valueOf(caracteres);
    }
}
