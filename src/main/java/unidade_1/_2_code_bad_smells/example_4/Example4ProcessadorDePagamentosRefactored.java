package unidade_1._2_code_bad_smells.example_4;

public class Example4ProcessadorDePagamentosRefactored {
    private Example4NotificadorDePagamentosRefactored notificador =
            new Example4NotificadorDePagamentosRefactored();

    public void processar() {

        //omitido: lógica do pagamento
        //notificação
        String mensagem = "Pagamento realizado com sucesso.";
        notificador.enviarNotificacao(mensagem);
    }
}
