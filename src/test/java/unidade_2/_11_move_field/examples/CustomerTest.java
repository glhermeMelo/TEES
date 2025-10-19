package unidade_2._11_move_field.examples;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

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
    void constructor_shouldSetAllFieldsCorrectly() {
        Customer customer = new Customer("C001", "Alice", "Smith",
                "alice.s@example.com", "11-98765-4321");
        assertEquals("C001", customer.getId());
        assertEquals("Alice", customer.getFirstName());
        assertEquals("Smith", customer.getLastName());
        assertEquals(LocalDate.now(), customer.getRegistrationDate());
        assertEquals("alice.s@example.com", customer.getEmail());
        assertEquals("11-98765-4321", customer.getPhoneNumber());
    }

    @Test
    void getFullName_shouldReturnConcatenatedName() {
        Customer customer = new Customer("C001", "Alice", "Smith", "a@e.com", "123");
        assertEquals("Alice Smith", customer.getFullName());
    }

    @Test
    void setEmail_shouldUpdateEmail() {
        Customer customer = new Customer("C001", "Alice", "Smith", "old@e.com", "123");
        customer.setEmail("new@e.com");
        assertEquals("new@e.com", customer.getEmail());
    }

    @Test
    void setPhoneNumber_shouldUpdatePhoneNumber() {
        Customer customer = new Customer("C001", "Alice", "Smith", "a@e.com", "old-phone");
        customer.setPhoneNumber("new-phone");
        assertEquals("new-phone", customer.getPhoneNumber());
    }

    @Test
    void displayCustomerInfo_shouldOutputAllInformation() {
        Customer customer = new Customer("C003", "Charlie", "Brown",
                "charlie.b@example.com", "31-95555-4444");
        customer.displayCustomerInfo();
        String output = outContent.toString();
        assertTrue(output.contains("ID: C003"));
        assertTrue(output.contains("Name: Charlie Brown"));
        assertTrue(output.contains("Email: charlie.b@example.com"));
        assertTrue(output.contains("Phone: 31-95555-4444"));
        assertTrue(output.contains("Registered: " + LocalDate.now()));
    }
}