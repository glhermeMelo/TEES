package unidade_1._6_extract_variable.exercise_3;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class GerenciadorDePromocoesTest {
    private final GerenciadorDePromocoes gerenciador = new GerenciadorDePromocoes();

    @Test
    void deveAplicarDescontoFixoQuandoValorSuficiente() {
        BigDecimal valor = new BigDecimal("50.00");
        BigDecimal resultado = gerenciador.aplicarDescontoFixo(valor);
        assertThat(resultado).isEqualByComparingTo(new BigDecimal("45.00"));
    }

    @Test
    void naoDeveAplicarDescontoFixoQuandoValorInsuficiente() {
        BigDecimal valor = new BigDecimal("3.00");
        BigDecimal resultado = gerenciador.aplicarDescontoFixo(valor);
        assertThat(resultado).isEqualByComparingTo(new BigDecimal("3.00"));
    }
}
