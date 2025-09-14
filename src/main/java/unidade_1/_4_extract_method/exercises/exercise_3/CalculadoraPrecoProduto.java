package unidade_1._4_extract_method.exercises.exercise_3;

/*
 * Suponha que você precisa adicionar uma nova funcionalidade: calcular o preço
 * para clientes VIP (desconto de 5%).
 * Extrair a lógica base do cálculo de preço tornará mais fácil adicionar a nova
 * regra? Se sim, refatore.
 */

public class CalculadoraPrecoProduto {

    public double calcularPrecoComImpostosEPromocao(Produto produto, boolean ehPromocao) {
        double precoBase = produto.getPreco();
        double precoComImpostos = precoBase * 1.10;

        double precoFinal;

        if (ehPromocao) {
            precoFinal = calculadoraPrecoPromocao(precoComImpostos);
        } else {
            precoFinal = precoComImpostos;
        }
        return precoFinal;
    }

    private double calculadoraPrecoPromocao(double precoOriginal) {

        return precoOriginal - (precoOriginal * 0.15);
    }

    private double calculadoraPrecoVIP(double precoOriginal) {
        return precoOriginal - (precoOriginal * 0.05);
    }
}
