package unidade_1._5_inline_method.exercise_4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProcessadorDeDadosTest {
    private final ProcessadorDeDados processador = new ProcessadorDeDados();

    @Test
    void deveProcessarDadosCorretamente() {
        List<String> dados = Arrays.asList("dado1", "exemplo-erro", "", "dado2");
        String resultado = processador.processar(dados, 10);
        assertThat(resultado).isEqualTo("PROCESSADO: DADO1 DADO2");
    }
}
