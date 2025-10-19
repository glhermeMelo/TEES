package unidade_2._11_move_field.examples;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRefactoredTest {

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
        ContactInfo testContact = new ContactInfo("alice.s@example.com", "11-98765-4321");
        CustomerRefactored customer = new CustomerRefactored("C001", "Alice", "Smith", testContact); // Passa ContactInfo
        assertEquals("C001", customer.getId());
        assertEquals("Alice", customer.getFirstName());
        assertEquals("Smith", customer.getLastName());
        assertEquals(LocalDate.now(), customer.getRegistrationDate());
        assertNotNull(customer.getContactInfo()); // Verifica se o objeto ContactInfo foi atribuído
        assertEquals("alice.s@example.com", customer.getContactInfo().getEmail()); // Acessa via ContactInfo
        assertEquals("11-98765-4321", customer.getContactInfo().getPhoneNumber()); // Acessa via ContactInfo
    }

    @Test
    void getFullName_shouldReturnConcatenatedName() {
        ContactInfo testContact = new ContactInfo("a@e.com", "123");
        CustomerRefactored customer = new CustomerRefactored("C001", "Alice", "Smith", testContact);
        assertEquals("Alice Smith", customer.getFullName());
    }

    // Os antigos testes setEmail e setPhoneNumber agora testam o ContactInfo diretamente
    @Test
    void updateContactInfoDetails_shouldWorkViaGetContactInfo() {
        ContactInfo testContact = new ContactInfo("old@e.com", "old-phone");
        CustomerRefactored customer = new CustomerRefactored("C001", "Alice", "Smith", testContact);

        customer.getContactInfo().setEmail("new@e.com");
        assertEquals("new@e.com", customer.getContactInfo().getEmail());

        customer.getContactInfo().setPhoneNumber("new-phone");
        assertEquals("new-phone", customer.getContactInfo().getPhoneNumber());
    }

    @Test
    void displayCustomerInfo_shouldOutputAllInformation() {
        ContactInfo testContact = new ContactInfo("charlie.b@example.com", "31-95555-4444");
        CustomerRefactored customer = new CustomerRefactored("C003", "Charlie", "Brown", testContact);
        customer.displayCustomerInfo();
        String output = outContent.toString();
        assertTrue(output.contains("ID: C003"));
        assertTrue(output.contains("Name: Charlie Brown"));
        assertTrue(output.contains("Email: charlie.b@example.com, Phone: 31-95555-4444"));
        assertTrue(output.contains("Registered: " + LocalDate.now()));
    }
}