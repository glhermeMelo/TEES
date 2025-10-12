package unidade_2._10_move_function.exercise_1;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String orderId;
    private Customer customer;
    private List<Double> itemPrices; // Preços individuais dos itens no pedido

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.itemPrices = new ArrayList<>();
    }

    public String getOrderId() { return orderId; }
    public Customer getCustomer() { return customer; }

    public void addItem(double price) {
        itemPrices.add(price);
    }

    public double calculateSubtotal() {
        return itemPrices.stream().mapToDouble(Double::doubleValue).sum();
    }

    /**
     * Calcula o desconto premium para este pedido.
     * Se o cliente for premium, ele recebe 10% de desconto no subtotal.
     *
     * @return O valor do desconto a ser aplicado (0.0 se não for premium).
     */
    public double calculatePremiumDiscount() {
        if (customer.isPremium()) { // Acessa o atributo de Customer
            double subtotal = calculateSubtotal();
            System.out.println("Cliente " + customer.getName() + " é Premium. Aplicando 10% de desconto.");
            return subtotal * 0.10;
        }
        System.out.println("Cliente " + customer.getName() + " não é Premium. Nenhum desconto aplicado.");
        return 0.0;
    }

    public double calculateTotal() {
        double subtotal = calculateSubtotal();
        double discount = calculatePremiumDiscount();
        return subtotal - discount;
    }
}