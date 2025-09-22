package unidade_2._8_change_declaration_method.exercise_2.notifications;

public class EmailNotifier extends Notifier {
    private String subject;

    public EmailNotifier(String recipient, String subject) {
        super(recipient);
        this.subject = subject;
    }

    @Override
    public String send(String message) {
        return "Email sent to " + recipient + " with subject '" + subject + "': " + message;
    }

    public String getSubject() {
        return subject;
    }
}
