package unidade_2._8_change_declaration_method.exercise_2.notifications;

public class SmsNotifier extends Notifier {
    private String senderId;

    public SmsNotifier(String recipient, String senderId) {
        super(recipient);
        this.senderId = senderId;
    }

    @Override
    public String send(String message) {
        return "SMS sent from " + senderId + " to " + recipient + ": " + message;
    }

    public String getSenderId() {
        return senderId;
    }
}
