package unidade_1._4_extract_method.examples;

public class Example1ItemVenda {
    private String nome;
    private double valor;

    public Example1ItemVenda(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }
}
