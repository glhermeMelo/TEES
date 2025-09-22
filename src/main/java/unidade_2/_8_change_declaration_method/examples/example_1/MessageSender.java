package unidade_2._8_change_declaration_method.examples.example_1;

public class MessageSender {
    public String sendMessage(String recipient, String messageContent) {

        if (recipient == null || recipient.isEmpty()) {
            throw new IllegalArgumentException("Recipient cannot be empty.");
        }
        if (messageContent == null || messageContent.isEmpty()) {
            throw new IllegalArgumentException("Message content cannot be empty.");
        }
        return "Message '" + messageContent + "' sent to " + recipient + " via SMS.";
    }
}
