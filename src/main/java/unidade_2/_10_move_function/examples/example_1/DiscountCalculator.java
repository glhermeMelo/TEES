package unidade_2._10_move_function.examples.example_1;

import java.math.BigDecimal;

public class DiscountCalculator {

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
}
