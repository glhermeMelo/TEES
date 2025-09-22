package unidade_1._7_inline_variable.examples;

import java.math.BigDecimal;

public class CalculadoraFrete {
    private static final BigDecimal CUSTO_BASE_POR_KG = new BigDecimal("2.50");
    private static final BigDecimal TAXA_ADICIONAL_URGENTE = new BigDecimal("5.00");

    public BigDecimal calcularFreteExpresso(double pesoKg, boolean urgente) {

        BigDecimal custoPorPeso = CUSTO_BASE_POR_KG.multiply(new BigDecimal(pesoKg));

        BigDecimal custoAdicional = BigDecimal.ZERO;
        if (urgente) {
            custoAdicional = TAXA_ADICIONAL_URGENTE;
        }

        BigDecimal freteTotal = custoPorPeso.add(custoAdicional);

        return freteTotal;
    }
}
