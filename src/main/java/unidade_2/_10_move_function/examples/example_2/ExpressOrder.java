package unidade_2._10_move_function.examples.example_2;

public class ExpressOrder extends Order {
    public ExpressOrder(double itemTotal, String destinationCountry) {
        super(itemTotal, destinationCountry);
    }

    @Override
    public double calculateShippingCost() {
        // Frete expresso: taxa fixa + 10% do total dos itens
        System.out.println("Calculando frete expresso para " + destinationCountry);
        return 15.00 + (itemTotal * 0.10);
    }
}