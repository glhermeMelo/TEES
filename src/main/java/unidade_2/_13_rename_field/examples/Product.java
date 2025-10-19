package unidade_2._13_rename_field.examples;

public class Product {
    private String nm; // Nome do produto
    private double prc; // Preço do produto

    public Product(String nm, double prc) {
        this.nm = nm;
        this.prc = prc;
    }

    public String getNm() { return nm; }
    public double getPrc() { return prc; }

    public void printDetails() {
        System.out.println("Nome: " + nm + ", Preço: " + prc);
    }
}
