package unidade_1._7_inline_variable.examples;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculadoraFreteTest {
    private final CalculadoraFrete calculadora = new CalculadoraFrete();

    @Test
    void deveCalcularFreteExpressoParaPesoPadrao() {
        BigDecimal frete = calculadora.calcularFreteExpresso(10.0, false);
        assertThat(frete).isEqualByComparingTo(new BigDecimal("25.00"));
    }

    @Test
    void deveCalcularFreteExpressoParaPesoEUrgente() {
        BigDecimal frete = calculadora.calcularFreteExpresso(5.0, true);
        assertThat(frete).isEqualByComparingTo(new BigDecimal("17.50"));
    }
}
