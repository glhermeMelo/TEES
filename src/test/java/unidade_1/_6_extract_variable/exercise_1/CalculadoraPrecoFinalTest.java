package unidade_1._6_extract_variable.exercise_1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.within;

public class CalculadoraPrecoFinalTest {
    private final CalculadoraPrecoFinal calculadora = new CalculadoraPrecoFinal();

    @Test
    void deveCalcularPrecoTotalCorretamente() {
        List<ItemCarrinho> itens = Arrays.asList(
                new ItemCarrinho("Livro A", 20.0, 2),
                new ItemCarrinho("Livro B", 5.0, 3)
        );
        double preco = calculadora.calcularPrecoTotal(itens);
        assertThat(preco).isCloseTo(55.9075, within(0.0001));    }

    @Test
    void deveCalcularPrecoTotalComUmItem() {
        List<ItemCarrinho> itens = Arrays.asList(
                new ItemCarrinho("Livro", 50.0, 1)
        );
        double preco = calculadora.calcularPrecoTotal(itens);
        assertThat(preco).isEqualTo(50.825);
    }
}
