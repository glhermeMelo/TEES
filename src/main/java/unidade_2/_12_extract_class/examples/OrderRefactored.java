package unidade_2._12_extract_class.examples;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderRefactored {

    private String orderId;
    private LocalDateTime orderDate;
    private String customerName;
    private List<String> items;

    private Payment paymentDetails;

    /**
     * Construtor para criar um novo pedido.
     * @param orderId ID único do pedido.
     * @param customerName Nome do cliente.
     */
    public OrderRefactored(String orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = LocalDateTime.now();
        this.items = new ArrayList<>();

        this.paymentDetails = new Payment();
    }

    // Getters para os detalhes do pedido
    public String getOrderId() { return orderId; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public String getCustomerName() { return customerName; }
    public List<String> getItems() { return items; }

    // Novo getter para o objeto Payment
    public Payment getPaymentDetails() { return paymentDetails; }

    public void addItem(String item) {
        this.items.add(item);
        System.out.println("Item '" + item + "' adicionado ao pedido " + orderId);
    }

    // Removidos todos os getters de pagamento e o metodo processPayment().

    /**
     * Exibe os detalhes completos do pedido, delegando os detalhes de pagamento.
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
        System.out.println("  Método: " + paymentDetails.getPaymentMethod());
        System.out.println("  Status: " + paymentDetails.getPaymentStatus());
        System.out.println("  Valor Pago: R$" + String.format("%.2f", paymentDetails.getAmountPaid()));
        System.out.println("  Data Pagamento: " + (paymentDetails.getPaymentDate() != null ? paymentDetails.getPaymentDate().toLocalDate() : "N/A"));
    }
}