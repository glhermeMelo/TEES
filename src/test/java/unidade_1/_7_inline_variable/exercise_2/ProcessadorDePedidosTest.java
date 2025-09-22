package unidade_1._7_inline_variable.exercise_2;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProcessadorDePedidosTest {
    private final ProcessadorDePedidos processador = new ProcessadorDePedidos();

    private ItemPedido criarItem(String nome, String preco, int quantidade) {
        return new ItemPedido(nome, new BigDecimal(preco), quantidade);
    }

    @Test
    void calcularPrecoFinal_ClientePadrao_SubtotalAbaixoDoLimiteFreteGratis() {
        List<ItemPedido> itens = Arrays.asList(
                criarItem("Livro", "30.00", 1),
                criarItem("Caneta", "5.00", 2)
        );
        Pedido pedido = new Pedido(itens, TipoCliente.PADRAO);
        BigDecimal precoFinal = processador.calcularPrecoFinal(pedido);
        assertThat(precoFinal).isEqualByComparingTo(new BigDecimal("57.75"));
    }

    @Test
    void calcularPrecoFinal_ClientePadrao_SubtotalAcimaDoLimiteFreteGratis() {
        List<ItemPedido> itens = Arrays.asList(
                criarItem("Notebook", "1200.00", 1)
        );
        Pedido pedido = new Pedido(itens, TipoCliente.PADRAO);
        BigDecimal precoFinal = processador.calcularPrecoFinal(pedido);
        assertThat(precoFinal).isEqualByComparingTo(new BigDecimal("1260.00"));
    }

    @Test
    void calcularPrecoFinal_ClienteVIP_SubtotalAcimaDoLimiteFreteGratis() {
        List<ItemPedido> itens = Arrays.asList(
                criarItem("Celular", "1500.00", 1)
        );
        Pedido pedido = new Pedido(itens, TipoCliente.VIP);
        BigDecimal precoFinal = processador.calcularPrecoFinal(pedido);
        assertThat(precoFinal).isEqualByComparingTo(new BigDecimal("1545.00"));
    }

    @Test
    void calcularPrecoFinal_ClienteGOLD_SubtotalAbaixoDoLimiteFreteGratis_BUG_TESTE() {
        List<ItemPedido> itens = Arrays.asList(
                criarItem("Mouse", "50.00", 1),
                criarItem("Teclado", "60.00", 1)
        );
        Pedido pedido = new Pedido(itens, TipoCliente.GOLD);
        BigDecimal precoFinal = processador.calcularPrecoFinal(pedido);
        assertThat(precoFinal).isEqualByComparingTo(new BigDecimal("99.00"));
    }

    @Test
    void calcularPrecoFinal_ClienteGOLD_SubtotalAcimaDoLimiteFreteGratis() {
        List<ItemPedido> itens = Arrays.asList(
                criarItem("Monitor", "300.00", 1),
                criarItem("Webcam", "100.00", 2)
        );
        Pedido pedido = new Pedido(itens, TipoCliente.GOLD);
        BigDecimal precoFinal = processador.calcularPrecoFinal(pedido);
        assertThat(precoFinal).isEqualByComparingTo(new BigDecimal("475.00"));
    }
}
