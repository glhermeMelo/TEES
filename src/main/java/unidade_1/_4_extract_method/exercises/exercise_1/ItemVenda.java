package unidade_1._4_extract_method.exercises.exercise_1;

public class ItemVenda {
    private String nome;
    private double precoUnitario;
    private int quantidade;

    public ItemVenda(String nome, double precoUnitario, int quantidade) {
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorTotalBruto() {
        return precoUnitario * quantidade;
    }

    public double calcularPrecoComDesconto(double percentualDesconto) {
        double valorBruto = getValorTotalBruto();
        double valorDesconto = valorBruto * (percentualDesconto / 100.0);
        return valorBruto - valorDesconto;
    }
}
