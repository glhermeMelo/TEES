package unidade_1._4_extract_method.exercises.exercise_2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculadoraImpostoTest {
    private final CalculadoraImposto calculadora = new CalculadoraImposto();

    @Test
    void calcularImpostoRenda_rendaBaixa_deveAplicar10PorCento() {
        assertThat(calculadora.calcularImpostoRenda(25000.0)).isEqualTo(2500.0);
    }

    @Test
    void calcularImpostoRenda_rendaAlta_deveAplicar20PorCento() {
        assertThat(calculadora.calcularImpostoRenda(50000.0)).isEqualTo(10000.0);
    }

    @Test
    void calcularImpostoRenda_rendaNegativa_deveLancarExcecao() {
        assertThatThrownBy(() -> calculadora.calcularImpostoRenda(-1000.0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void calcularImpostoSobreVendas_vendasBaixas_deveAplicar5PorCento() {
        assertThat(calculadora.calcularImpostoSobreVendas(8000.0)).isEqualTo(400.0);
    }

    @Test
    void calcularImpostoSobreVendas_vendasAltas_deveAplicar15PorCento() {
        assertThat(calculadora.calcularImpostoSobreVendas(15000.0)).isEqualTo(2250.0);
    }

    @Test
    void calcularImpostoSobreVendas_vendasNegativas_deveLancarExcecao() {
        assertThatThrownBy(() -> calculadora.calcularImpostoSobreVendas(-500.0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
