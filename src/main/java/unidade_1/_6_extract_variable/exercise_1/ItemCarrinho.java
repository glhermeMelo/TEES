package unidade_1._6_extract_variable.exercise_1;

public class ItemCarrinho {
    private String nome;
    private double precoUnitario;
    private int quantidade;

    public ItemCarrinho(String nome, double precoUnitario, int quantidade) {
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
}
