package unidade_1._5_inline_method.exercise_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraAreaTest {
    @Test
    void deveCalcularAreaCorretamenteParaCirculo() {
        Circulo circulo = new Circulo(5.0);
        CalculadoraArea calculadora = new CalculadoraArea();
        assertEquals(Math.PI * 5.0 * 5.0, calculadora.obterAreaTotal(circulo), 0.001);
    }

    @Test
    void deveCalcularAreaCorretamenteParaRetangulo() {
        Retangulo retangulo = new Retangulo(4.0, 6.0);
        CalculadoraArea calculadora = new CalculadoraArea();
        assertEquals(24.0, calculadora.obterAreaTotal(retangulo), 0.001);
    }
}
