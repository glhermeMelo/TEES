package unidade_2._13_rename_field.examples;

public class ProductRefactored {

    private String name;
    private double price;

    public ProductRefactored(String nm, double prc) {
        this.name = nm;
        this.price = prc;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    public void printDetails() {
        System.out.println("Nome: " + name + ", Preço: " + price);
    }
}