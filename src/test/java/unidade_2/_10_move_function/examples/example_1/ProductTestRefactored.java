package unidade_2._10_move_function.examples.example_1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTestRefactored {

    private final DiscountCalculatorRefactored discountCalculator = new DiscountCalculatorRefactored();

    @Test
    void calculateFinalPrice_shouldApplyTenPercentDiscount() {
        ProductRefactored laptop = new ProductRefactored("Laptop", new BigDecimal("1000.00"));
        BigDecimal expectedPrice = new BigDecimal("900.0000");
        assertEquals(expectedPrice, discountCalculator.calculateFinalPrice(laptop.getPrice(),new BigDecimal("0.10")));
    }

    @Test
    void calculateFinalPrice_shouldHandleDecimalPrices() {
        ProductRefactored mouse = new ProductRefactored("Mouse", new BigDecimal("49.90"));
        BigDecimal expectedPrice = new BigDecimal("44.9100");
        assertEquals(expectedPrice, discountCalculator.calculateFinalPrice(mouse.getPrice(),new BigDecimal("0.10")));
    }
}