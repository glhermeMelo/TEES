package unidade_1._5_inline_method.exercise_3;

public class Circulo extends Forma {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    protected double calcularAreaEspecializada() {
        return Math.PI * raio * raio;
    }
}
