package unidade_2._12_extract_class.examples;

import java.time.LocalDateTime;

public class Payment {
    private String paymentMethod;
    private String paymentStatus;
    private double amountPaid;
    private LocalDateTime paymentDate;

    public Payment() {
        this.paymentMethod = "Não especificado";
        this.paymentStatus = "Pendente";
        this.amountPaid = 0.0;
        this.paymentDate = null;
    }

    public String getPaymentMethod() { return paymentMethod; }
    public String getPaymentStatus() { return paymentStatus; }
    public double getAmountPaid() { return amountPaid; }
    public LocalDateTime getPaymentDate() { return paymentDate; }

    /**
     * Processa um pagamento para esta entidade.
     * Modifica os campos de detalhes do pagamento.
     * @param method Metodo de pagamento.
     * @param amount O valor pago.
     * @param orderId da transação.
     * @return true se o pagamento foi bem-sucedido, false caso contrário.
     */
    public boolean processPayment(String method, double amount, String orderId) { // orderId como contexto
        if (amount > 0 && !"Pendente".equals(this.paymentStatus)) {
            System.out.println("Pagamento já foi processado ou está em andamento. Status atual: " + this.paymentStatus);
            return false;
        }

        System.out.println("Processando pagamento para pedido " + orderId + "..."); // Usa orderId para contexto
        this.paymentMethod = method;
        this.amountPaid = amount;
        this.paymentDate = LocalDateTime.now();

        if (amount > 0) {
            this.paymentStatus = "Aprovado";
            System.out.println("Pagamento de R$" + amount + " via " + method + " APROVADO para pedido " + orderId);
            return true;
        } else {
            this.paymentStatus = "Recusado";
            this.amountPaid = 0.0;
            System.out.println("Pagamento RECUSADO para pedido " + orderId + ". Valor inválido.");
            return false;
        }
    }
}