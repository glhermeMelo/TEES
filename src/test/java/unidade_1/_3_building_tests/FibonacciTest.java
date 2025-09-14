package unidade_1._3_building_tests;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonacciTest {
    private final Fibonacci fibonacci = new Fibonacci();

    @Test
    void throwIllegalArgumentException() { //partição < 0
        assertThrows(IllegalArgumentException.class, () -> {
            fibonacci.calcularTermo(-1);
        });
    }

    @Test
    void testingFib0() { //partição = 0
        assertThat(fibonacci.calcularTermo(0)).isEqualTo(0); //teste de fronteiras
    }

    @Test
    void testingFib1And2() { //partição = 1,2
        assertThat(fibonacci.calcularTermo(1)).isEqualTo(1);
        assertThat(fibonacci.calcularTermo(2)).isEqualTo(1); //teste de fronteiras
    }

    @Test
    void testingFibGreaterThan2() { //partição > 2
        assertThat(fibonacci.calcularTermo(3)).isEqualTo(2);
        assertThat(fibonacci.calcularTermo(5)).isEqualTo(5);
        assertThat(fibonacci.calcularTermo(6)).isEqualTo(8);

    }

    @Test
    void testingUpper() { //partição > 2
        assertThat(fibonacci.calcularTermo(50)).isEqualTo(12586269025L);
    }

    @Test
    void throwArithmeticException() {
        assertThrows(ArithmeticException.class, () -> {
            fibonacci.calcularTermo(93);
        });
    }
}
