package unidade_2._12_extract_class.examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderRefactoredTest {

    @Test
    void constructor_shouldInitializeOrderAndPaymentDetailsObject() {
        OrderRefactored order = new OrderRefactored("TEST001", "Test Customer");
        assertEquals("TEST001", order.getOrderId());
        assertEquals("Test Customer", order.getCustomerName());
        assertNotNull(order.getOrderDate());
        assertTrue(order.getItems().isEmpty());

        // Verifica que o PaymentDetails foi criado e inicializado
        assertNotNull(order.getPaymentDetails());
        assertEquals("Não especificado", order.getPaymentDetails().getPaymentMethod());
        assertEquals("Pendente", order.getPaymentDetails().getPaymentStatus());
        assertEquals(0.0, order.getPaymentDetails().getAmountPaid(), 0.001);
        assertNull(order.getPaymentDetails().getPaymentDate());
    }

    @Test
    void addItem_shouldAddOneItemToOrder() {
        OrderRefactored order = new OrderRefactored("TEST002", "Item Customer");
        order.addItem("Monitor");
        assertEquals(1, order.getItems().size());
        assertTrue(order.getItems().contains("Monitor"));
    }

    @Test
    void displayOrderDetails_shouldNotThrowException() {
        OrderRefactored order = new OrderRefactored("TEST006", "Display Customer");
        order.addItem("Produto A");
        order.getPaymentDetails().processPayment("Cartão", 50.0, order.getOrderId());
        assertDoesNotThrow(() -> order.displayOrderDetails());
    }

}
