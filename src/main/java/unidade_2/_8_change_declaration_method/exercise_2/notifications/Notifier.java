package unidade_2._8_change_declaration_method.exercise_2.notifications;

public abstract class Notifier {
    protected String recipient;

    public Notifier(String recipient) {
        this.recipient = recipient;
    }

    /**
     * Envia uma mensagem.
     *
     * @param message O conteúdo da mensagem a ser enviada.
     * @return Uma string confirmando o envio.
     */
    public abstract String send(String message);

    public String getRecipient() {
        return recipient;
    }
}
