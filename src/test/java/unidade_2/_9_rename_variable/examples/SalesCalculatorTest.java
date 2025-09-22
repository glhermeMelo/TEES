package unidade_2._9_rename_variable.examples;

import org.junit.jupiter.api.Test;
import unidade_2._9_rename_variable.examples.example_1.SalesCalculator;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalesCalculatorTest {
    private final SalesCalculator calculator = new SalesCalculator();

    @Test
    void calculateSalesTax_shouldReturnEightPercentOfValue() {
        BigDecimal value = new BigDecimal("100.00");
        BigDecimal expectedTax = new BigDecimal("8.0000");
        assertEquals(expectedTax, calculator.calculateSalesTax(value));
    }

    @Test
    void calculateSalesTax_shouldWorkForDecimalValues() {
        BigDecimal value = new BigDecimal("75.50");
        BigDecimal expectedTax = new BigDecimal("6.0400");
        assertEquals(expectedTax, calculator.calculateSalesTax(value));
    }

    @Test
    void calculateFinalPrice_shouldReturnPricePlusTax() {
        BigDecimal itemPrice = new BigDecimal("100.00");
        BigDecimal expectedFinalPrice = new BigDecimal("108.0000");
        assertEquals(expectedFinalPrice, calculator.calculateFinalPrice(itemPrice));
    }
}
