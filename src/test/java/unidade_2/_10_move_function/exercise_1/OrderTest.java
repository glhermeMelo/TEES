package unidade_2._10_move_function.exercise_1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void calculateSubtotal_shouldReturnCorrectSumOfItems() {
        Customer customer = new Customer("Test", "T001", false);
        Order order = new Order("ORD-001", customer);
        order.addItem(10.00);
        order.addItem(20.00);
        assertEquals(30.00, order.calculateSubtotal(), 0.001);
    }

    @Test
    void calculatePremiumDiscount_shouldReturnZeroForRegularCustomer() {
        Customer regularCustomer = new Customer("Regular", "R001", false);
        Order order = new Order("ORD-002", regularCustomer);
        order.addItem(100.00);
        assertEquals(0.0, order.calculatePremiumDiscount(), 0.001);
        assertTrue(outContent.toString().contains("Cliente Regular não é Premium. Nenhum desconto aplicado."));
    }

    @Test
    void calculatePremiumDiscount_shouldReturnTenPercentForPremiumCustomer() {
        Customer premiumCustomer = new Customer("Premium", "P001", true);
        Order order = new Order("ORD-003", premiumCustomer);
        order.addItem(100.00);
        assertEquals(10.00, order.calculatePremiumDiscount(), 0.001); // 10% de 100
        assertTrue(outContent.toString().contains("Cliente Premium é Premium. Aplicando 10% de desconto."));
    }

    @Test
    void calculatePremiumDiscount_shouldHandleMultipleItems() {
        Customer premiumCustomer = new Customer("PremiumMulti", "PM01", true);
        Order order = new Order("ORD-004", premiumCustomer);
        order.addItem(50.00);
        order.addItem(150.00);
        assertEquals(20.00, order.calculatePremiumDiscount(), 0.001);
    }

    @Test
    void calculateTotal_shouldApplyDiscountForPremiumCustomer() {
        Customer premiumCustomer = new Customer("PremiumTotal", "PT01", true);
        Order order = new Order("ORD-005", premiumCustomer);
        order.addItem(100.00);
        assertEquals(90.00, order.calculateTotal(), 0.001);
    }

    @Test
    void calculateTotal_shouldNotApplyDiscountForRegularCustomer() {
        Customer regularCustomer = new Customer("RegularTotal", "RT01", false);
        Order order = new Order("ORD-006", regularCustomer);
        order.addItem(100.00);
        assertEquals(100.00, order.calculateTotal(), 0.001);
    }
}