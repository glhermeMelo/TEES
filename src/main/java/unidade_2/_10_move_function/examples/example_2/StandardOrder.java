package unidade_2._10_move_function.examples.example_2;

public class StandardOrder extends Order {
    public StandardOrder(double itemTotal, String destinationCountry) {
        super(itemTotal, destinationCountry);
    }

    @Override
    public double calculateShippingCost() {
        // Frete padrão: taxa fixa + 5% do total dos itens
        System.out.println("Calculando frete padrão para " + destinationCountry);
        return 5.00 + (itemTotal * 0.05);
    }
}