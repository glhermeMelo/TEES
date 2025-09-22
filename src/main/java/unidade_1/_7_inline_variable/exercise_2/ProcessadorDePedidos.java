package unidade_1._7_inline_variable.exercise_2;

import java.math.BigDecimal;
import java.util.List;

public class ProcessadorDePedidos {
    private static final BigDecimal TAXA_FRETE_PADRAO = new BigDecimal("15.00");
    private static final BigDecimal LIMITE_FRETE_GRATIS = new BigDecimal("100.00");
    private static final BigDecimal IMPOSTO_VIP = new BigDecimal("0.03"); //3%
    private static final BigDecimal IMPOSTO_PADRAO = new BigDecimal("0.05"); //5%
    private static final BigDecimal DESCONTO_GOLD_PERCENTUAL = new BigDecimal("0.10"); //10%

    public BigDecimal calcularPrecoFinal(Pedido pedido) {

        BigDecimal subtotal = calcularSubtotal(pedido.getItens());
        BigDecimal frete = calcularFrete(subtotal);
        BigDecimal valorComFrete = subtotal.add(frete);

        BigDecimal valorFinal;
        if (pedido.getTipoCliente() == TipoCliente.VIP) {
            valorFinal = valorComFrete.add(valorComFrete.multiply(IMPOSTO_VIP));
        } else {
            valorFinal = valorComFrete.add(valorComFrete.multiply(IMPOSTO_PADRAO));
        }

        if (pedido.getTipoCliente() == TipoCliente.GOLD) {
            BigDecimal desconto = calcularDescontoGold(subtotal);
            valorFinal = valorFinal.subtract(desconto);
        }

        return valorFinal;
    }

    private BigDecimal calcularSubtotal(List<ItemPedido> itens) {

        BigDecimal sub = BigDecimal.ZERO;
        for (ItemPedido item : itens) {
            sub = sub.add(item.getPrecoTotal());
        }
        return sub;
    }

    private BigDecimal calcularFrete(BigDecimal subtotal) {

        if (subtotal.compareTo(LIMITE_FRETE_GRATIS) > 0) {
            return BigDecimal.ZERO;
        }
        return TAXA_FRETE_PADRAO;
    }

    private BigDecimal calcularDescontoGold(BigDecimal subtotal) {

        return subtotal.multiply(DESCONTO_GOLD_PERCENTUAL);
    }
}
