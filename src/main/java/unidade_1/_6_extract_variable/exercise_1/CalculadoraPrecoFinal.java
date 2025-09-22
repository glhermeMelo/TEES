package unidade_1._6_extract_variable.exercise_1;

import java.util.List;

public class CalculadoraPrecoFinal {
    private static final Double DESCONTO_CINCO_PORCENTO = 0.05;
    private static final Double DESCONTO_SETE_PORCENTO = 0.07;

    public double calcularPrecoTotal(List<ItemCarrinho> itens) {

        double subtotal = calcularPreco(itens);

        double precoComDesconto = subtotal * (1 - DESCONTO_CINCO_PORCENTO); // -5%
        double precoFinal = precoComDesconto * (1 + DESCONTO_SETE_PORCENTO); // +7%

        return precoFinal;
    }

    private double calcularPreco(List<ItemCarrinho> itens) {
        double subtotal = 0;
        for (ItemCarrinho item : itens) {
            subtotal += item.getPrecoUnitario() * item.getQuantidade();
        }

        return subtotal;
    }
}
