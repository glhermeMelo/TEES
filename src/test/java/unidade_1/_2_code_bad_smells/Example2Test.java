package unidade_1._2_code_bad_smells;

import org.junit.jupiter.api.Test;
import unidade_1._2_code_bad_smells.example_2.Example2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Example2Test {
    @Test
    void testCalcularImposto(){
        //valores de teste
        double valorTestProduto = 100, valorTestServico = 50;

        //instancia objeto da classe sob teste
        Example2 teste = new Example2();

        //teste
        assertThat(teste.calcularImpostoProduto(valorTestProduto)).isEqualTo(105);
        assertThat(teste.calcularImpostoServico(valorTestServico)).isEqualTo(52.5);
    }
}
