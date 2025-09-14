package unidade_1._5_inline_method.exercise_2;

public class Pedido {
    private double valorTotal;
    private double taxaEnvio;

    public Pedido(double valorTotal, double taxaEnvio) {
        this.valorTotal = valorTotal;
        this.taxaEnvio = taxaEnvio;
    }

    public double getValorTotalComEnvio() {
        return this.valorTotal + this.taxaEnvio;
    }

    /*
    public double getValorTotalComEnvio() {
        return calcularValorTotalComEnvio();
    }

    private double calcularValorTotalComEnvio() {
        return this.valorTotal + this.taxaEnvio;
    }
    */

    public double getValorTotal() {
        return valorTotal;
    }

    public double getTaxaEnvio() {
        return taxaEnvio;
    }
}
