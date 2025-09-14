package unidade_1._2_code_bad_smells.example_3;

public class Example3 {
    public void calcularPrecoFinal(double precoBase) {

        //adiciona 10% de imposto
        double imposto = precoBase * 0.10;
        double precoComImposto = precoBase + imposto;

        //adiciona uma taxa de serviço fixa de R$ 5,00
        double taxaServico = 5.0;
        double precoFinal = precoComImposto + taxaServico;

        System.out.println("O preço final é: " + precoFinal);
    }
}
