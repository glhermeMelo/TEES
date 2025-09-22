package unidade_1._7_inline_variable.examples;

import java.math.BigDecimal;

public class CalculadoraFreteRefactored {
    private static final BigDecimal CUSTO_BASE_POR_KG = new BigDecimal("2.50");
    private static final BigDecimal TAXA_ADICIONAL_URGENTE = new BigDecimal("5.00");

    public BigDecimal calcularFreteExpresso(double pesoKg, boolean urgente) {

        BigDecimal custoAdicional = BigDecimal.ZERO;
        if (urgente) {
            custoAdicional = TAXA_ADICIONAL_URGENTE;
        }

        BigDecimal freteTotal = CUSTO_BASE_POR_KG.multiply(new BigDecimal(pesoKg))
                .add(custoAdicional);

        return freteTotal;
    }
}
