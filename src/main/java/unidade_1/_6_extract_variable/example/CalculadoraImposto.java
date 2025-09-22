package unidade_1._6_extract_variable.example;

import java.math.BigDecimal;

public class CalculadoraImposto {
    public BigDecimal calcularImpostoTotalItem(BigDecimal precoBase,
                                               int quantidade,
                                               BigDecimal taxaFederal,
                                               BigDecimal taxaEstadual) {

        BigDecimal impostoTotal = (precoBase.multiply(new BigDecimal(quantidade)))
                .add((precoBase.multiply(new BigDecimal(quantidade))).multiply(taxaFederal))
                .add((precoBase.multiply(new BigDecimal(quantidade))).multiply(taxaEstadual));
        return impostoTotal;
    }
}
