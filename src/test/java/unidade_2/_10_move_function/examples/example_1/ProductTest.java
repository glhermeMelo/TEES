package unidade_2._10_move_function.examples.example_1;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    void calculateFinalPrice_shouldApplyTenPercentDiscount() {
        Product laptop = new Product("Laptop", new BigDecimal("1000.00"));
        BigDecimal expectedPrice = new BigDecimal("900.0000");
        assertEquals(expectedPrice, laptop.calculateFinalPrice());
    }

    @Test
    void calculateFinalPrice_shouldHandleDecimalPrices() {
        Product mouse = new Product("Mouse", new BigDecimal("49.90"));
        BigDecimal expectedPrice = new BigDecimal("44.9100");
        assertEquals(expectedPrice, mouse.calculateFinalPrice());
    }
}