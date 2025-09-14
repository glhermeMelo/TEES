package unidade_1._2_code_bad_smells.example_4;

public class Example4NotificadorDePagamentosRefactored {
    public void enviarNotificacao(String mensagem) {
        enviarEmail(mensagem);
    }

    private void enviarEmail(String mensagem) {
        //omitido: lógica para envio de e-mail
    }
}
