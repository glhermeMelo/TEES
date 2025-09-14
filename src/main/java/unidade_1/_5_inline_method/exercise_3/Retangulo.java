package unidade_1._5_inline_method.exercise_3;

public class Retangulo extends Forma {
    private double largura;
    private double altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    protected double calcularAreaEspecializada() {
        return largura * altura;
    }
}
