package unidade_2._10_move_function.examples.example_2;

public class InternationalOrder extends Order {
    public InternationalOrder(double itemTotal, String destinationCountry) {
        super(itemTotal, destinationCountry);
    }

    @Override
    public double calculateShippingCost() {
        // Frete internacional: taxa fixa + 20% do total dos itens + custo por país
        System.out.println("Calculando frete internacional para " + destinationCountry);
        double baseCost = 25.00 + (itemTotal * 0.20);

        if ("Brazil".equals(destinationCountry)) {
            baseCost += 10.00;
        }
        return baseCost;
    }
}