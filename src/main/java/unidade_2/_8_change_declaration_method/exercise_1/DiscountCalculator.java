package unidade_2._8_change_declaration_method.exercise_1;

import java.math.BigDecimal;

public class DiscountCalculator {

    /**
     * Calcula o valor de desconto para um determinado preço.
     * Atualmente aplica uma taxa de 10%.
     *
     * @param price O preço base.
     * @return O valor do desconto.
     */
    public BigDecimal calculateDiscount(BigDecimal price) {
        return price.multiply(new BigDecimal("0.10"));
    }

    /**
     * Aplica o desconto ao preço original.
     *
     * @param price O preço original.
     * @return O preço final após o desconto.
     */
    public BigDecimal applyDiscount(BigDecimal price) {
        BigDecimal discount = calculateDiscount(price);
        return price.subtract(discount);
    }
}
