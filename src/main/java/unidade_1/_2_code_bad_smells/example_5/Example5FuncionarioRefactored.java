package unidade_1._2_code_bad_smells.example_5;

public class Example5FuncionarioRefactored {
    private String nome;
    private double salario;

    public double getSalario() {
        return salario;
    }

    public double calcularBonus() {
        return this.salario * 0.10;
    }
}
