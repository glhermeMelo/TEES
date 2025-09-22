package unidade_1._6_extract_variable.exercise_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ServicoDeDadosTest {
    private ServicoDeDados servico;

    @BeforeEach
    void setUp() {
        servico = new ServicoDeDados();
    }

    @Test
    void deveRetornarDadosQuandoBuscaForBemSucedida() {
        List<String> dados = servico.buscarDados("usuario1");
        assertThat(dados).hasSize(2);
        assertThat(dados).containsExactly("Dado_usuario1_1", "Dado_usuario1_2");
        assertThat(servico.getTentativasBusca()).isEqualTo(1);
    }

    @Test
    void deveRetornarListaVaziaQuandoBuscaFalharPorExcessoDeTentativas() {
        servico.buscarDados("chave1");
        servico.buscarDados("chave2");
        servico.buscarDados("chave3");
        List<String> dados = servico.buscarDados("chave4");
        assertThat(dados).isEmpty();
        assertThat(servico.getTentativasBusca()).isEqualTo(4);
    }
}
