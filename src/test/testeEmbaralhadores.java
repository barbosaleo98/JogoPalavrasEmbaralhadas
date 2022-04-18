package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import main.Embaralhador;
import main.EmbaralhadorInversor;
import main.EmbaralhadorParesImpares;
import main.EmbaralhadorPermutador;

public class testeEmbaralhadores {
    Embaralhador embaralhador;

    @Test
    public void testeEmbaralhadorInversor(){
        embaralhador = new EmbaralhadorInversor();
        assertEquals("arvalap", embaralhador.embaralha("palavra"));
    }

    @Test
    public void testeEmbaralhadorPermutador(){
        embaralhador = new EmbaralhadorPermutador();
        List<String> possiveisPermutacoes = List.of("abc","acb","bac","bca","cab","cba");
        String palavraEmbaralhada = embaralhador.embaralha("abc");
        assertTrue(possiveisPermutacoes.contains(palavraEmbaralhada));
    }

    @Test
    public void testeEmbaralhadorParesImpares(){
        embaralhador = new EmbaralhadorParesImpares();
        assertEquals("214365", embaralhador.embaralha("123456"));
    }

}
