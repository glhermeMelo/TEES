package unidade_1._4_extract_method.exercises.exercise_3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculadoraPrecoProdutoTest {
    private final CalculadoraPrecoProduto calculadora = new CalculadoraPrecoProduto();
    private final Produto produto = new Produto("Laptop", 1000.0);

    @Test
    void calcularPrecoComImpostosEPromocao_comPromocao_deveAplicarImpostoEDescontoPromocional() {
        double precoFinal = calculadora.calcularPrecoComImpostosEPromocao(produto, true);
        assertThat(precoFinal).isEqualTo(935.0);
    }

    @Test
    void calcularPrecoComImpostosEPromocao_semPromocao_deveAplicarApenasImposto() {
        double precoFinal = calculadora.calcularPrecoComImpostosEPromocao(produto, false);
        assertThat(precoFinal).isEqualTo(1100.0);
    }
}
