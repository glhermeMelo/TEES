package unidade_2._10_move_function.exercise_2;

public class Account {

    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        System.out.println("Conta " + accountNumber + " criada com saldo: R$" + String.format("%.2f", balance));
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Valor de depósito deve ser positivo.");
        }
        this.balance += amount;
        System.out.println("Depósito de R$" + String.format("%.2f", amount) + " na conta " + accountNumber + ". Saldo atual: R$" + String.format("%.2f", balance));
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser positivo.");
        }
        if (this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Saque de R$" + String.format("%.2f", amount) + " da conta " + accountNumber + ". Saldo atual: R$" + String.format("%.2f", balance));
            return true;
        } else {
            System.out.println("Saldo insuficiente na conta " + accountNumber + " para saque de R$" + String.format("%.2f", amount) + ". Saldo: R$" + String.format("%.2f", balance));
            return false;
        }
    }
}