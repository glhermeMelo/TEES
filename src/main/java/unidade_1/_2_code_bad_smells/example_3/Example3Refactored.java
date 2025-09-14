package unidade_1._2_code_bad_smells.example_3;

public class Example3Refactored {
    public void calcularPrecoFinal(double precoBase) {

        double precoComImposto = adicionarImposto(precoBase);
        double precoFinal = adicionarTaxaDeServico(precoComImposto);

        System.out.println("O preço final é: " + precoFinal);
    }

    private double adicionarImposto(double preco) {
        return preco * 1.10;
    }

    private double adicionarTaxaDeServico(double preco) {
        return preco + 5.0;
    }
}
