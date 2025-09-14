package unidade_1._4_extract_method.exercises.exercise_1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ItemVendaTest {
    @Test
    void deveCalcularPrecoComDesconto() {
        ItemVenda item = new ItemVenda("Produto A", 100.0, 2);
        double percentualDesconto = 10.0;
        double precoComDesconto = item.calcularPrecoComDesconto(percentualDesconto);
        assertThat(precoComDesconto).isEqualTo(180.0);
    }

    @Test
    void deveCalcularPrecoSemDesconto() {
        ItemVenda item = new ItemVenda("Produto B", 50.0, 3);
        double percentualDesconto = 0.0;
        double precoComDesconto = item.calcularPrecoComDesconto(percentualDesconto);
        assertThat(precoComDesconto).isEqualTo(150.0);
    }
}
