package unidade_1._5_inline_method.exercise_3;

public abstract class Forma {
    public double calcularArea() {
        return calcularAreaEspecializada();
    }
    protected abstract double calcularAreaEspecializada();
}
