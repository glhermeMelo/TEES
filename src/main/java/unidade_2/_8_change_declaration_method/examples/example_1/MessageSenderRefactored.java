package unidade_2._8_change_declaration_method.examples.example_1;

public class MessageSenderRefactored {
    //Change Method Declaration
    //1. Rename Method (sendMessage to sendSmsMessage)
    //2. Add parameter (senderName)
    public String sendSmsMessage(String senderName, String recipient, String messageContent) {
        //added (9-11)
        if (senderName == null || senderName.isEmpty()) {
            throw new IllegalArgumentException("Sender name cannot be empty.");
        }
        if (recipient == null || recipient.isEmpty()) {
            throw new IllegalArgumentException("Recipient cannot be empty.");
        }
        if (messageContent == null || messageContent.isEmpty()) {
            throw new IllegalArgumentException("Message content cannot be empty.");
        }
        //changed
        return "Message '" + messageContent + "' sent by " + senderName +  " to " + recipient + " via SMS.";
    }
}
