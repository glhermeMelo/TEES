package unidade_1._5_inline_method.example;

public class Funcionario {
    private String nome;
    private double salarioBase;
    private boolean isGerente;

    public Funcionario(String nome, double salarioBase, boolean isGerente) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.isGerente = isGerente;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public boolean isGerente() {
        return isGerente;
    }
}
