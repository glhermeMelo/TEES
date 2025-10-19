package unidade_2._12_extract_class.examples;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private LocalDateTime orderDate;
    private String customerName;
    private List<String> items;

    private String paymentMethod;
    private String paymentStatus;
    private double amountPaid;
    private LocalDateTime paymentDate;

    /**
     * Construtor para criar um novo pedido.
     * @param orderId ID único do pedido.
     * @param customerName Nome do cliente.
     */
    public Order(String orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = LocalDateTime.now();
        this.items = new ArrayList<>();

        this.paymentMethod = "Não especificado";
        this.paymentStatus = "Pendente";
        this.amountPaid = 0.0;
        this.paymentDate = null;
    }

    // Getters para os detalhes do pedido
    public String getOrderId() { return orderId; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public String getCustomerName() { return customerName; }
    public List<String> getItems() { return items; }

    public void addItem(String item) {
        this.items.add(item);
        System.out.println("Item '" + item + "' adicionado ao pedido " + orderId);
    }

    // Getters para os detalhes do pagamento (Candidatos para Extract Class)
    public String getPaymentMethod() { return paymentMethod; }
    public String getPaymentStatus() { return paymentStatus; }
    public double getAmountPaid() { return amountPaid; }
    public LocalDateTime getPaymentDate() { return paymentDate; }

    /**
     * Processa um pagamento para este pedido.
     * Modifica os campos relacionados ao pagamento.
     * @param method Metodo de pagamento.
     * @param amount O valor pago.
     * @return true se o pagamento foi bem-sucedido, false caso contrário.
     */
    public boolean processPayment(String method, double amount) {
        if (amount > 0 && !"Pendente".equals(this.paymentStatus)) {
            System.out.println("Pedido " + orderId + " já foi pago ou está em processamento.");
            return false;
        }

        System.out.println("Processando pagamento para pedido " + orderId + "...");
        this.paymentMethod = method;
        this.amountPaid = amount;
        this.paymentDate = LocalDateTime.now();

        // Simulação da lógica de pagamento (poderia ser mais complexa)
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

    /**
     * Exibe os detalhes completos do pedido, incluindo itens e pagamento.
     */
    public void displayOrderDetails() {
        System.out.println("\n--- Detalhes do Pedido #" + orderId + " ---");
        System.out.println("Cliente: " + customerName);
        System.out.println("Data do Pedido: " + orderDate.toLocalDate());
        System.out.println("Itens:");
        if (items.isEmpty()) {
            System.out.println("  Nenhum item.");
        } else {
            for (String item : items) {
                System.out.println("  - " + item);
            }
        }
        System.out.println("Detalhes do Pagamento:");
        System.out.println("  Método: " + paymentMethod);
        System.out.println("  Status: " + paymentStatus);
        System.out.println("  Valor Pago: R$" + String.format("%.2f", amountPaid));
        System.out.println("  Data Pagamento: " + (paymentDate != null ? paymentDate.toLocalDate() : "N/A"));
    }
}