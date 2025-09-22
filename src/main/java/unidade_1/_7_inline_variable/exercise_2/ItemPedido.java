package unidade_1._7_inline_variable.exercise_2;

import java.math.BigDecimal;

public class ItemPedido {
    private String nome;
    private BigDecimal precoUnitario;
    private int quantidade;

    public ItemPedido(String nome, BigDecimal precoUnitario, int quantidade) {
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoTotal() {
        return precoUnitario.multiply(new BigDecimal(quantidade));
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
}
