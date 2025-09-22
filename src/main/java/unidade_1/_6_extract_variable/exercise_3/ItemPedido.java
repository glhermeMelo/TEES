package unidade_1._6_extract_variable.exercise_3;

import java.math.BigDecimal;
import java.util.Objects;

public class ItemPedido {
    private String nome;
    private BigDecimal precoUnitario;
    private int quantidade;

    public ItemPedido(String nome, BigDecimal precoUnitario, int quantidade) {
        this.nome = Objects.requireNonNull(nome);
        this.precoUnitario = Objects.requireNonNull(precoUnitario);
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser positiva.");
        }
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPrecoTotal() {
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "nome='" + nome + '\'' +
                ", precoUnitario=" + precoUnitario +
                ", quantidade=" + quantidade +
                '}';
    }
}
