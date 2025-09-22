package unidade_1._7_inline_variable.exercise_1;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculadoraMultasTest {
    private final CalculadoraMultas calculadora = new CalculadoraMultas();

    @Test
    void deveCalcularValorMultaComDiasAtraso() {
        BigDecimal valorBase = new BigDecimal("100.00");
        int diasAtraso = 5;
        BigDecimal valorMulta = calculadora.calcularValorMulta(valorBase, diasAtraso);
        assertThat(valorMulta).isEqualByComparingTo(new BigDecimal("102.50"));
    }

    @Test
    void deveCalcularValorMultaComZeroDiasAtraso() {
        BigDecimal valorBase = new BigDecimal("50.00");
        int diasAtraso = 0;
        BigDecimal valorMulta = calculadora.calcularValorMulta(valorBase, diasAtraso);
        assertThat(valorMulta).isEqualByComparingTo(new BigDecimal("50.00"));
    }
}
