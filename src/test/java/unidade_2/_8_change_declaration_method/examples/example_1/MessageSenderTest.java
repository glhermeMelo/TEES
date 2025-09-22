package unidade_2._8_change_declaration_method.examples.example_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageSenderTest {

    @Test
    void shouldSendSmsMessageSuccessfully() { //Rename Method (para refletir o Rename Method em MessageSender)
        MessageSenderRefactored sender = new MessageSenderRefactored();
        String result = sender.sendSmsMessage("Admin", "Bob", "Hello there!");
        assertEquals("Message 'Hello there!' sent by Admin to Bob via SMS.", result);
    }

    @Test
    void shouldThrowExceptionForEmptySenderName() { // Novo teste para o novo parâmetro
        MessageSenderRefactored sender = new MessageSenderRefactored();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sender.sendSmsMessage("", "Bob", "Hello!");
        });
        assertEquals("Sender name cannot be empty.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForEmptyRecipient() {
        MessageSenderRefactored sender = new MessageSenderRefactored();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sender.sendSmsMessage("Admin", "", "Hello!");
        });
        assertEquals("Recipient cannot be empty.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForNullMessageContent() {
        MessageSenderRefactored sender = new MessageSenderRefactored();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sender.sendSmsMessage("Admin", "Alice", null);
        });
        assertEquals("Message content cannot be empty.", exception.getMessage());
    }
}
