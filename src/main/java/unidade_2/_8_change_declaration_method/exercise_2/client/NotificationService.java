package unidade_2._8_change_declaration_method.exercise_2.client;

import unidade_2._8_change_declaration_method.exercise_2.notifications.Notifier;

public class NotificationService {
    public void notifyClient(Notifier notifier, String message) {
        System.out.println("Attempting to send notification to " + notifier.getRecipient());
        String confirmation = notifier.send(message); // Polimorfismo em ação
        System.out.println("Result: " + confirmation);
    }
}
