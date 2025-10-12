package unidade_2._10_move_function.examples.example_1;

import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Calcula o preço final do produto, aplicando um desconto fixo (10%).
     *
     * @return O preço final após o desconto.
     */
    public BigDecimal calculateFinalPrice() {
        BigDecimal discountPercentage = new BigDecimal("0.10");
        BigDecimal discountAmount = price.multiply(discountPercentage);
        return price.subtract(discountAmount);
    }

    public DiscountCalculator getDiscountCalculator() {
        return new DiscountCalculator();
    }
}