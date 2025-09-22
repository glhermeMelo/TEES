package unidade_1._6_extract_variable.exercise_2;

import java.util.ArrayList;
import java.util.List;

public class ServicoDeDados {
    private int tentativasBusca = 0;

    public List<String> buscarDados(String chave) {
        tentativasBusca++;

        boolean tentativasFalhas = tentativasBusca > 3;

        if (chave == null || chave.isEmpty() || tentativasFalhas) {
            System.out.println("Busca falhou após " + tentativasBusca + " tentativa(s).");
            return new ArrayList<>();
        }

        System.out.println("Busca realizada com sucesso na tentativa " + tentativasBusca + ".");
        List<String> resultados = new ArrayList<>();
        resultados.add("Dado_" + chave + "_1");
        resultados.add("Dado_" + chave + "_2");
        return resultados;
    }

    public int getTentativasBusca() {
        return tentativasBusca;
    }
}
