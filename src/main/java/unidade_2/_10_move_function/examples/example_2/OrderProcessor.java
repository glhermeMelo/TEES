package unidade_2._10_move_function.examples.example_2;

import java.util.ArrayList;
import java.util.List;

public class OrderProcessor {

    private List<Order> ordersToProcess;

    public OrderProcessor() {
        this.ordersToProcess = new ArrayList<>();
    }

    public void addOrder(Order order) {
        this.ordersToProcess.add(order);
    }

    public void processAllOrders() {
        System.out.println("\n--- Processando todos os pedidos ---");
        for (Order order : ordersToProcess) {
            // Polimorfismo em ação
            double shippingCost = order.calculateShippingCost();
            double finalTotal = order.getItemTotal() + shippingCost;
            System.out.println("Pedido para " + order.getDestinationCountry() +
                    ": Total Itens R$" + String.format("%.2f", order.getItemTotal()) +
                    " + Frete R$" + String.format("%.2f", shippingCost) +
                    " = Total Final R$" + String.format("%.2f", finalTotal));
        }
    }

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        processor.addOrder(new StandardOrder(100.00, "Brasil"));
        processor.addOrder(new ExpressOrder(200.00, "Alemanha"));
        processor.addOrder(new InternationalOrder(50.00, "Argentina"));
        processor.addOrder(new InternationalOrder(150.00, "Brazil"));

        processor.processAllOrders();
    }
}
