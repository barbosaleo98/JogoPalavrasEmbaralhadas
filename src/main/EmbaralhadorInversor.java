package main;

public class EmbaralhadorInversor implements Embaralhador{

    private String palavraEmbaralhada = "";

    @Override
    public String embaralha(String palavraOriginal) {
        
        for(int i = palavraOriginal.length()-1; i>=0; i-- ){
            palavraEmbaralhada += palavraOriginal.charAt(i);
        }
        return palavraEmbaralhada;
    }
    
}
