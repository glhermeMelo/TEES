package unidade_2._10_move_function.examples.example_2;

public abstract class Order {
    protected double itemTotal;
    protected String destinationCountry;

    public Order(double itemTotal, String destinationCountry) {
        this.itemTotal = itemTotal;
        this.destinationCountry = destinationCountry;
    }

    public double getItemTotal() { return itemTotal; }
    public String getDestinationCountry() { return destinationCountry; }

    // Metodo polimórfico: cada tipo de pedido calcula o frete de forma específica
    public abstract double calculateShippingCost();
}

