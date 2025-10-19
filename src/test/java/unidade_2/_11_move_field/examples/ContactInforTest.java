package unidade_2._11_move_field.examples;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ContactInfoTest {

    @Test
    void constructor_shouldSetAllFieldsCorrectly() {
        ContactInfo contact = new ContactInfo("test@example.com", "11-1234-5678");
        assertEquals("test@example.com", contact.getEmail());
        assertEquals("11-1234-5678", contact.getPhoneNumber());
    }

    @Test
    void setEmail_shouldUpdateEmail() {
        ContactInfo contact = new ContactInfo("old@example.com", "123");
        contact.setEmail("new@example.com");
        assertEquals("new@example.com", contact.getEmail());
    }

    @Test
    void setPhoneNumber_shouldUpdatePhoneNumber() {
        ContactInfo contact = new ContactInfo("abc@example.com", "old-phone");
        contact.setPhoneNumber("new-phone");
        assertEquals("new-phone", contact.getPhoneNumber());
    }

    @Test
    void toString_shouldReturnFormattedContactInfo() {
        ContactInfo contact = new ContactInfo("display@example.com", "00-1111-2222");
        assertEquals("Email: display@example.com, Phone: 00-1111-2222", contact.toString());
    }
}