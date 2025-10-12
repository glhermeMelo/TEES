package unidade_2._10_move_function.exercise_2;

public class TransactionProcessor {

    /**
     * Transfere fundos de uma conta para outra.
     *
     * @param fromAccount A conta de origem.
     * @param toAccount A conta de destino.
     * @param amount O valor a ser transferido.
     *
     * @return true se a transferência foi bem-sucedida, false caso contrário.
     */
    public boolean transferFunds(Account fromAccount, Account toAccount, double amount) {
        System.out.println("\n--- Tentando transferir R$" + String.format("%.2f", amount) +
                " de " + fromAccount.getAccountNumber() + " para " + toAccount.getAccountNumber() + " ---");

        if (amount <= 0) {
            System.out.println("Erro: Valor da transferência deve ser positivo.");
            return false;
        }

        // 1. Verificar saldo e retirar da conta de origem
        if (fromAccount.withdraw(amount)) { // Delega ao 'fromAccount' para sacar
            // 2. Depositar na conta de destino
            toAccount.deposit(amount); // Delega ao 'toAccount' para depositar
            System.out.println("Transferência de R$" + String.format("%.2f", amount) + " realizada com sucesso.");
            return true;
        } else {
            System.out.println("Transferência falhou: Saldo insuficiente na conta de origem.");
            return false;
        }
    }
}