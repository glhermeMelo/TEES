package unidade_2._8_change_declaration_method.exercise_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unidade_2._8_change_declaration_method.exercise_2.client.NotificationService;
import unidade_2._8_change_declaration_method.exercise_2.notifications.EmailNotifier;
import unidade_2._8_change_declaration_method.exercise_2.notifications.SmsNotifier;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NotifierTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void emailNotifierShouldSendMessageCorrectly() {
        EmailNotifier emailNotifier = new EmailNotifier("test@example.com", "Hello");
        String expected = "Email sent to test@example.com with subject 'Hello': Welcome!";
        assertEquals(expected, emailNotifier.send("Welcome!"));
    }

    @Test
    void smsNotifierShouldSendMessageCorrectly() {
        SmsNotifier smsNotifier = new SmsNotifier("123456789", "MyCompany");
        String expected = "SMS sent from MyCompany to 123456789: Your code is 123.";
        assertEquals(expected, smsNotifier.send("Your code is 123."));
    }

    @Test
    void notificationServiceShouldHandleEmailNotifier() {
        NotificationService service = new NotificationService();
        EmailNotifier emailNotifier = new EmailNotifier("service@example.com", "Important");
        service.notifyClient(emailNotifier, "Service update available.");
        assertTrue(outContent.toString().contains("Attempting to send notification to service@example.com"));
        assertTrue(outContent.toString().contains("Email sent to service@example.com with subject 'Important': Service update available."));
    }

    @Test
    void notificationServiceShouldHandleSmsNotifier() {
        NotificationService service = new NotificationService();
        SmsNotifier smsNotifier = new SmsNotifier("987654321", "Alerts");
        service.notifyClient(smsNotifier, "System critical alert!");
        assertTrue(outContent.toString().contains("Attempting to send notification to 987654321"));
        assertTrue(outContent.toString().contains("SMS sent from Alerts to 987654321: System critical alert!"));
    }
}