package unidade_1._4_extract_method.exercises.exercise_2;

public class CalculadoraImposto {
    public double calcularImpostoRenda(double rendaAnual) {
        /*
        if (rendaAnual < 0) {
            throw new IllegalArgumentException("Renda anual não pode ser negativa.");
        }
        */

        checadorDeValorNegativo(rendaAnual, "Renda anual não pode ser negativa.");

        if (rendaAnual <= 30000.0) {
            return rendaAnual * 0.10;
        } else {
            return rendaAnual * 0.20;
        }
    }

    public double calcularImpostoSobreVendas(double valorVendas) {
        /*
        if (valorVendas < 0) {
            throw new IllegalArgumentException("Valor de vendas não pode ser negativo.");
        }
        */

        checadorDeValorNegativo(valorVendas, "Valor de vendas não pode ser negativo.");

        if (valorVendas <= 10000.0) {
            return valorVendas * 0.05;
        } else {
            return valorVendas * 0.15;
        }
    }

    private void checadorDeValorNegativo(double valor, String mensagemErro) {
        if (valor < 0)
            throw new IllegalArgumentException(mensagemErro);

    }
}
