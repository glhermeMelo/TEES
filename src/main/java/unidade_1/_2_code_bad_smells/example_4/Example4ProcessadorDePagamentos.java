package unidade_1._2_code_bad_smells.example_4;

public class Example4ProcessadorDePagamentos {
    public void processar() {

        //omitido: lógica do pagamento
        //notificação
        String mensagem = "Pagamento realizado com sucesso.";
        enviarEmail(mensagem);
    }

    private void enviarEmail(String mensagem) {
        //omitido: lógica para envio de e-mail
    }
}
