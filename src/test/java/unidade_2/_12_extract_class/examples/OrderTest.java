package unidade_2._12_extract_class.examples;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void constructor_shouldInitializeOrderAndPendingPaymentDetails() {
        Order order = new Order("TEST001", "Test Customer");
        assertEquals("TEST001", order.getOrderId());
        assertEquals("Test Customer", order.getCustomerName());
        assertNotNull(order.getOrderDate());
        assertTrue(order.getItems().isEmpty());

        assertEquals("Não especificado", order.getPaymentMethod());
        assertEquals("Pendente", order.getPaymentStatus());
        assertEquals(0.0, order.getAmountPaid(), 0.001);
        assertNull(order.getPaymentDate());
    }

    @Test
    void addItem_shouldAddOneItemToOrder() {
        Order order = new Order("TEST002", "Item Customer");
        order.addItem("Monitor");
        assertEquals(1, order.getItems().size());
        assertTrue(order.getItems().contains("Monitor"));
    }

    @Test
    void processPayment_shouldUpdatePaymentDetailsOnSuccess() {
        Order order = new Order("TEST003", "Paid Customer");
        assertTrue(order.processPayment("Boleto", 250.75));

        assertEquals("Boleto", order.getPaymentMethod());
        assertEquals("Aprovado", order.getPaymentStatus());
        assertEquals(250.75, order.getAmountPaid(), 0.001);
        assertNotNull(order.getPaymentDate());
        assertTrue(order.getPaymentDate().isBefore(LocalDateTime.now().plusSeconds(1)));
    }

    @Test
    void processPayment_shouldFailForNegativeAmount() {
        Order order = new Order("TEST004", "Failed Customer");
        assertFalse(order.processPayment("Cartão", -50.00));
        assertEquals("Recusado", order.getPaymentStatus());
        assertEquals(0.0, order.getAmountPaid(), 0.001);
    }

    @Test
    void processPayment_shouldNotProcessIfAlreadyApproved() {
        Order order = new Order("TEST005", "Double Pay Customer");
        order.processPayment("Pix", 100.00);
        assertTrue(order.getPaymentStatus().equals("Aprovado"));

        assertFalse(order.processPayment("Cartão", 200.00));
        assertEquals("Pix", order.getPaymentMethod());
        assertEquals(100.00, order.getAmountPaid(), 0.001);
    }

    @Test
    void displayOrderDetails_shouldNotThrowException() {
        Order order = new Order("TEST006", "Display Customer");
        order.addItem("Produto A");
        order.processPayment("Cartão", 50.0);
        assertDoesNotThrow(() -> order.displayOrderDetails());
    }
}