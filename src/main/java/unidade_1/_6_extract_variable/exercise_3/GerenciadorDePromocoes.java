package unidade_1._6_extract_variable.exercise_3;

import java.math.BigDecimal;

public class GerenciadorDePromocoes {
    private BigDecimal obterValorDescontoFixo() {
        return new BigDecimal("5.00");
    }

    public BigDecimal aplicarDescontoFixo(BigDecimal valorTotal) {
        BigDecimal desconto = obterValorDescontoFixo();
        if (valorTotal.compareTo(desconto) > 0) {
            return valorTotal.subtract(desconto);
        }
        return valorTotal;
    }
}
