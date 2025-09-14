package unidade_1._5_inline_method.example;

public class CalculadoraDeBonus {
    private double calcularBonus(Funcionario funcionario) {
        if (funcionario.isGerente()) {
            return funcionario.getSalarioBase() * 0.20;
        } else {
            return funcionario.getSalarioBase() * 0.10;
        }
    }

    public double calcularBonusAnualDoGerente(Funcionario funcionario) {
        return calcularBonus(funcionario);
    }
}
