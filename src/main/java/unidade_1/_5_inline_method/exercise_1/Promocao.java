package unidade_1._5_inline_method.exercise_1;

public class Promocao {
    private static final double TAXA_PROMOCIONAL = 0.05;

    /*
    private double getTaxaPromocional() {
        return TAXA_PROMOCIONAL;
    }
    */

    public double calcularPrecoComDesconto(double precoOriginal) {
        double desconto = precoOriginal * TAXA_PROMOCIONAL;
        return precoOriginal - desconto;
    }
}
