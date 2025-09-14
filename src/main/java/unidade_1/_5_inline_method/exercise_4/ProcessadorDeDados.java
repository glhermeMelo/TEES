package unidade_1._5_inline_method.exercise_4;

import java.util.List;

public class ProcessadorDeDados {
    public String processar(List<String> dados, int limite) {
        String dadosFiltrados = "";
        /*
        for (String dado : dados) {
            if (validarDados(dado)) {
                dadosFiltrados += dado + " ";
            }
        }
        */
        for (String dado : dados) {
            if (!dado.isEmpty() && dado.length() < 10) {
                dadosFiltrados += dado + " ";
            }
        }
        String resultado = formatarResultado(dadosFiltrados);

        return resultado.toUpperCase();
    }

    private boolean validarDados(String dado) {
        return !dado.isEmpty() && dado.length() < 10;
    }

    private String formatarResultado(String entrada) {
        return "Processado: " + entrada.trim();
    }
}
