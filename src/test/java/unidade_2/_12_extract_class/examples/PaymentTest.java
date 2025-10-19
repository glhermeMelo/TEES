package unidade_2._12_extract_class.examples;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {

    @Test
    void constructor_shouldInitializePaymentDetailsToPending() {
        Payment payment = new Payment();
        assertEquals("Não especificado", payment.getPaymentMethod());
        assertEquals("Pendente", payment.getPaymentStatus());
        assertEquals(0.0, payment.getAmountPaid(), 0.001);
        assertNull(payment.getPaymentDate());
    }

    @Test
    void processPayment_shouldUpdatePaymentDetailsOnSuccess() {
        Payment payment = new Payment();
        assertTrue(payment.processPayment("Boleto", 250.75, "TEST_ORDER_ID"));

        assertEquals("Boleto", payment.getPaymentMethod());
        assertEquals("Aprovado", payment.getPaymentStatus());
        assertEquals(250.75, payment.getAmountPaid(), 0.001);
        assertNotNull(payment.getPaymentDate());
        assertTrue(payment.getPaymentDate().isBefore(LocalDateTime.now().plusSeconds(1)));
    }

    @Test
    void processPayment_shouldFailForNegativeAmount() {
        Payment payment = new Payment();
        assertFalse(payment.processPayment("Cartão", -50.00, "TEST_ORDER_ID"));
        assertEquals("Recusado", payment.getPaymentStatus());
        assertEquals(0.0, payment.getAmountPaid(), 0.001);
    }

    @Test
    void processPayment_shouldNotProcessIfAlreadyApproved() {
        Payment payment = new Payment();
        payment.processPayment("Pix", 100.00, "TEST_ORDER_ID");
        assertTrue(payment.getPaymentStatus().equals("Aprovado"));

        assertFalse(payment.processPayment("Cartão", 200.00, "TEST_ORDER_ID"));
        assertEquals("Pix", payment.getPaymentMethod());
        assertEquals(100.00, payment.getAmountPaid(), 0.001);
    }
}