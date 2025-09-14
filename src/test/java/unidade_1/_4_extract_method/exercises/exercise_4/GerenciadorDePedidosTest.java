package unidade_1._4_extract_method.exercises.exercise_4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GerenciadorDePedidosTest {
    private final GerenciadorDePedidos gerenciador =  new GerenciadorDePedidos();

    @Test
    void criarPedido_comItens_deveRetornarUmObjetoPedido() {
        List<Item> itens = new ArrayList<>();
        itens.add(new Item("Caneta"));
        itens.add(new Item("Caderno"));

        Pedido pedido = gerenciador.criarPedido(itens);

        assertThat(pedido).isNotNull();
        assertThat(pedido.getItens()).hasSize(2);
        assertThat(pedido.getItens().get(0).getNome()).isEqualTo("Caneta");
    }

    @Test
    void criarPedido_comListaVazia_deveRetornarPedidoVazio() {
        List<Item> itens = new ArrayList<>();

        Pedido pedido = gerenciador.criarPedido(itens);

        assertThat(pedido).isNotNull();
        assertThat(pedido.getItens()).isEmpty();
    }
}
