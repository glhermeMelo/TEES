package unidade_2._10_move_function.examples.example_1;

import java.math.BigDecimal;

public class ProductRefactored {
    private String name;
    private BigDecimal price;

    public ProductRefactored(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    // Após Move Method, delegando o cálculo do preço final para um DiscountCalculator
    public DiscountCalculator getDiscountCalculator() {
        return new DiscountCalculator();
    }
}