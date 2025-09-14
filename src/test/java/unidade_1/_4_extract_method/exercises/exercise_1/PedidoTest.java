package unidade_1._4_extract_method.exercises.exercise_1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PedidoTest {
    @Test
    void deveCalcularTotalComDesconto() {
        List<ItemVenda> itens = new ArrayList<>();
        itens.add(new ItemVenda("Item X", 50.0, 2));
        itens.add(new ItemVenda("Item Y", 75.0, 1));
        Pedido pedido = new Pedido(itens);
        double percentualDesconto = 20.0;
        double totalComDesconto = pedido.calcularTotalComDesconto(percentualDesconto);
        assertThat(totalComDesconto).isEqualTo(140.0);
    }

    @Test
    void deveCalcularTotalSemDesconto() {
        List<ItemVenda> itens = new ArrayList<>();
        itens.add(new ItemVenda("Item Z", 30.0, 5));
        Pedido pedido = new Pedido(itens);
        double percentualDesconto = 0.0;
        double totalComDesconto = pedido.calcularTotalComDesconto(percentualDesconto);
        assertThat(totalComDesconto).isEqualTo(150.0);
    }
}
