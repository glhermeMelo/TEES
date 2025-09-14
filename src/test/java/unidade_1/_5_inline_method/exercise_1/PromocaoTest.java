package unidade_1._5_inline_method.exercise_1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PromocaoTest {
    @Test
    void deveCalcularPrecoComDescontoPromocionalCorretamente() {
        Promocao promocao = new Promocao();
        double precoOriginal = 100.0;
        double precoEsperado = 95.0;
        double precoCalculado = promocao.calcularPrecoComDesconto(precoOriginal);
        assertThat(precoCalculado).isEqualTo(precoEsperado);
    }

    @Test
    void deveCalcularPrecoComDescontoZero() {
        Promocao promocao = new Promocao();
        double precoOriginal = 0.0;
        double precoEsperado = 0.0;
        double precoCalculado = promocao.calcularPrecoComDesconto(precoOriginal);
        assertThat(precoCalculado).isEqualTo(precoEsperado);
    }
}
