package unidade_1._6_extract_variable.exercise_3;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraTaxasDisponiblidadeTest {
    private final CalculadoraTaxasDisponibilidade calculador = new CalculadoraTaxasDisponibilidade();
    private final Restaurante restauranteNormal = new Restaurante("Restaurante A", new BigDecimal("10.00"), true);
    private final Restaurante restaurantePremium = new Restaurante("Restaurante B", new BigDecimal("5.00"), true);
    private final Restaurante restauranteFechado = new Restaurante("Restaurante C", new BigDecimal("12.00"), false);

    private final List<ItemPedido> itensPedidoValorBaixo = Arrays.asList(
            new ItemPedido("Hamburguer", new BigDecimal("25.00"), 1),
            new ItemPedido("Batata Frita", new BigDecimal("15.00"), 1)
    );

    private final List<ItemPedido> itensPedidoValorAlto = Arrays.asList(
            new ItemPedido("Pizza", new BigDecimal("60.00"), 1),
            new ItemPedido("Refrigerante", new BigDecimal("8.00"), 2),
            new ItemPedido("Sobremesa", new BigDecimal("20.00"), 1)
    );

    private final List<ItemPedido> itensPedidoFreteGratis = Arrays.asList(
            new ItemPedido("Prato Executivo", new BigDecimal("70.00"), 1),
            new ItemPedido("Salada", new BigDecimal("35.00"), 1)
    );


    @Test
    void deveCalcularTaxaTotalPadraoPedidoValorBaixo() {
        BigDecimal total = calculador.calcularTaxaETotal(restauranteNormal, itensPedidoValorBaixo, false);
        assertThat(total).isEqualByComparingTo(new BigDecimal("52.00"));
    }

    @Test
    void deveCalcularTaxaTotalPremiumPedidoValorBaixo() {
        BigDecimal total = calculador.calcularTaxaETotal(restauranteNormal, itensPedidoValorBaixo, true);
        assertThat(total).isEqualByComparingTo(new BigDecimal("51.20"));
    }

    @Test
    void deveCalcularTaxaTotalPadraoPedidoValorAlto() {
        BigDecimal total = calculador.calcularTaxaETotal(restauranteNormal, itensPedidoValorAlto, false);
        assertThat(total).isEqualByComparingTo(new BigDecimal("110.80"));
    }

    @Test
    void deveAplicarFreteGratisParaPedidoValorAlto() {
        BigDecimal total = calculador.calcularTaxaETotal(restauranteNormal, itensPedidoFreteGratis, false);
        assertThat(total).isEqualByComparingTo(new BigDecimal("110.25"));
    }

    @Test
    void deveLancarExcecaoSeRestauranteFechado() {
        assertThrows(IllegalStateException.class, () -> {
            calculador.calcularTaxaETotal(restauranteFechado, itensPedidoValorBaixo, false);
        }, "Restaurante fechado. Não é possível calcular taxas.");
    }
}
