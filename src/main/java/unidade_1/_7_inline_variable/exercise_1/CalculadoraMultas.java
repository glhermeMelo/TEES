package unidade_1._7_inline_variable.exercise_1;

import java.math.BigDecimal;

public class CalculadoraMultas {
    public BigDecimal calcularValorMulta(BigDecimal valorBase, int diasAtraso) {

        BigDecimal taxaDiaria = geradorDeValores(); // R$0,50

        BigDecimal taxaAtraso = taxaDiaria.multiply(new BigDecimal(diasAtraso));

        BigDecimal valorMulta = valorBase.add(taxaAtraso);

        return valorMulta;
    }

    private BigDecimal geradorDeValores() {
        return new BigDecimal("0.50");
    }
}
