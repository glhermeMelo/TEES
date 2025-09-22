package unidade_1._6_extract_variable.example;

import java.math.BigDecimal;

public class CalculadoraImpostoRefactored {
    public BigDecimal calcularImpostoTotalItem(BigDecimal precoBase,
                                               int quantidade,
                                               BigDecimal taxaFederal,
                                               BigDecimal taxaEstadual) {

        BigDecimal subtotal = precoBase.multiply(new BigDecimal(quantidade));
        BigDecimal impostoFederal = subtotal.multiply(taxaFederal);
        BigDecimal impostoEstadual = subtotal.multiply(taxaEstadual);

        BigDecimal impostoTotal = subtotal.add(impostoFederal).add(impostoEstadual);

        return impostoTotal;
    }
}
