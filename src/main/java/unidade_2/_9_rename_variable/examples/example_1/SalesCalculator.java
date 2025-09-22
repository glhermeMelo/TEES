package unidade_2._9_rename_variable.examples.example_1;

import java.math.BigDecimal;

public class SalesCalculator {
    private static final BigDecimal DEFAULT_TAX_RATE = new BigDecimal("0.08"); // 8%

    /**
     * Calcula o imposto de vendas para um valor total.
     *
     * @param valor O valor total do item(ns) antes do imposto.
     * @return O valor do imposto de vendas.
     */
    public BigDecimal calculateSalesTax(BigDecimal valor) {
        BigDecimal calculatedTaxAmount = valor.multiply(DEFAULT_TAX_RATE);
        return calculatedTaxAmount;
    }

    /**
     * Calcula o preço final de um item(ns) após adicionar o imposto de vendas.
     *
     * @param itemPrice O preço do item(ns) antes do imposto.
     * @return O preço final incluindo o imposto.
     */
    public BigDecimal calculateFinalPrice(BigDecimal itemPrice) {
        BigDecimal tax = calculateSalesTax(itemPrice);
        return itemPrice.add(tax);
    }
}
