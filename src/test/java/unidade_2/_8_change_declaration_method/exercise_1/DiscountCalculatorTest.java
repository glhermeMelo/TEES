package unidade_2._8_change_declaration_method.exercise_1;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscountCalculatorTest {

    private final DiscountCalculator calculator = new DiscountCalculator();

    @Test
    void calculateDiscount_shouldReturnTenPercentOfPrice() {
        BigDecimal price = new BigDecimal("100.00");
        BigDecimal expectedDiscount = new BigDecimal("10.0000");
        assertEquals(expectedDiscount, calculator.calculateDiscount(price));
    }

    @Test
    void applyDiscount_shouldReturnPriceMinusTenPercentDiscount() {
        BigDecimal price = new BigDecimal("100.00");
        BigDecimal expectedFinalPrice = new BigDecimal("90.0000");
        assertEquals(expectedFinalPrice, calculator.applyDiscount(price));
    }

    @Test
    void calculateDiscount_shouldWorkForDecimalPrices() {
        BigDecimal price = new BigDecimal("75.50");
        BigDecimal expectedDiscount = new BigDecimal("7.5500");
        assertEquals(expectedDiscount, calculator.calculateDiscount(price));
    }
}
