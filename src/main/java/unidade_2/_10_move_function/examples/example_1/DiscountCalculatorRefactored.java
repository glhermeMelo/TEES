package unidade_2._10_move_function.examples.example_1;

import java.math.BigDecimal;

public class DiscountCalculatorRefactored {

    /**
     * Calcula o valor do desconto para um preço base e uma porcentagem.
     *
     * @param basePrice O preço original.
     * @param percentage A porcentagem de desconto.
     *
     * @return O valor do desconto.
     */
    public BigDecimal calculateDiscountAmount(BigDecimal basePrice, BigDecimal percentage) {
        return basePrice.multiply(percentage);
    }

    /**
     * Calcula o preço final de um item aplicando um desconto percentual.
     *
     * @param basePrice O preço base do item.
     * @param discountPercentage A porcentagem de desconto a ser aplicada.
     *
     * @return O preço final após o desconto.
     */
    public BigDecimal calculateFinalPrice(BigDecimal basePrice, BigDecimal discountPercentage) {
        BigDecimal discountAmount = calculateDiscountAmount(basePrice, discountPercentage);
        return basePrice.subtract(discountAmount);
    }
}