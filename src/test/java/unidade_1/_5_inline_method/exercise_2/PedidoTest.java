package unidade_1._5_inline_method.exercise_2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PedidoTest {
    @Test
    void deveCalcularValorTotalComEnvioCorretamente() {
        Pedido pedido = new Pedido(100.0, 10.0);
        double valorEsperado = 110.0;
        double valorCalculado = pedido.getValorTotalComEnvio();
        assertThat(valorCalculado).isEqualTo(valorEsperado);
    }

    @Test
    void deveCalcularValorTotalComEnvioQuandoValorOriginalZero() {
        Pedido pedido = new Pedido(0.0, 5.0);
        double valorEsperado = 5.0;
        double valorCalculado = pedido.getValorTotalComEnvio();
        assertThat(valorCalculado).isEqualTo(valorEsperado);
    }

    @Test
    void deveCalcularValorTotalComEnvioComValoresNegativos() {
        Pedido pedido = new Pedido(-50.0, 10.0);
        double valorEsperado = -40.0;
        double valorCalculado = pedido.getValorTotalComEnvio();
        assertThat(valorCalculado).isEqualTo(valorEsperado);
    }
}
