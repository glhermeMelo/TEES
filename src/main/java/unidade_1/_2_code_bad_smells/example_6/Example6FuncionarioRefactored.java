package unidade_1._2_code_bad_smells.example_6;

public class Example6FuncionarioRefactored {
    private double salarioPorHora;

    public Example6FuncionarioRefactored(double salarioPorHora) {
        this.salarioPorHora = salarioPorHora;
    }

    public double calcularSalario(double horasTrabalhadas) {
        return this.salarioPorHora * horasTrabalhadas;
    }
}
