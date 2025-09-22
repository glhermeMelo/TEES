package unidade_1._6_extract_variable.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculadoraImpostoTest {
    private final CalculadoraImposto calculadora = new CalculadoraImposto();

    @Test
    void deveCalcularImpostoTotalParaItemSimples() {

        BigDecimal precoBase = new BigDecimal("100.00");
        int quantidade = 2;
        BigDecimal taxaFederal = new BigDecimal("0.05");
        BigDecimal taxaEstadual = new BigDecimal("0.07");
        BigDecimal imposto = calculadora.calcularImpostoTotalItem(precoBase, quantidade, taxaFederal, taxaEstadual);
        assertThat(imposto).isEqualByComparingTo(new BigDecimal("224.00"));
    }

    @Test
    void deveCalcularImpostoTotalParaQuantidadesDiferentes() {

        BigDecimal precoBase = new BigDecimal("50.00");
        int quantidade = 3;
        BigDecimal taxaFederal = new BigDecimal("0.10");
        BigDecimal taxaEstadual = new BigDecimal("0.02");
        BigDecimal imposto = calculadora.calcularImpostoTotalItem(precoBase, quantidade, taxaFederal, taxaEstadual);
        assertThat(imposto).isEqualByComparingTo(new BigDecimal("168.00"));
    }
}
