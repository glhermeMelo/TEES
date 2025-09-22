package unidade_1._6_extract_variable.exercise_3;

import java.math.BigDecimal;
import java.util.List;

public class CalculadoraTaxasDisponibilidade {
    private static final BigDecimal TAXA_SERVICO_PADRAO = new BigDecimal("0.05");
    private static final BigDecimal TAXA_SERVICO_PREMIUM = new BigDecimal("0.03");

    public BigDecimal calcularTaxaETotal(Restaurante restaurante, List<ItemPedido> itens, boolean usuarioPremium) {
        if (!restaurante.isAberto()) {
            throw new IllegalStateException("Restaurante fechado. Não é possível calcular taxas.");
        }

        BigDecimal subtotal = BigDecimal.ZERO;
        for (ItemPedido item : itens) {
            subtotal = subtotal.add(item.getPrecoTotal());
        }

        BigDecimal taxaEntrega = restaurante.getTaxaEntregaBase();

        if (subtotal.compareTo(new BigDecimal("100")) > 0) {
            taxaEntrega = BigDecimal.ZERO; // frete grátis se compra maior que R$100
        }

        BigDecimal taxaServico;
        if (usuarioPremium) {
            taxaServico = TAXA_SERVICO_PREMIUM;
        } else {
            taxaServico = TAXA_SERVICO_PADRAO;
        }

        BigDecimal valorTaxaServico = subtotal.multiply(taxaServico);

        BigDecimal total = subtotal.add(taxaEntrega).add(valorTaxaServico);

        return total;
    }
}
