package unidade_1._2_code_bad_smells.example_6;

public class Example6CalculadoraDeSalario {
    //atributo utilizado apenas em calcularSalario()
    private double horasTrabalhadas;

    public double calcularSalario(double salarioPorHora, double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
        double salarioBruto = salarioPorHora * this.horasTrabalhadas;

        //omitido: lógica para calcular impostos, bônus, etc.

        return salarioBruto;
    }
    //omitido: demais atributos e métodos
}
