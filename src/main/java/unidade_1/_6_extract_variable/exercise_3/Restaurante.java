package unidade_1._6_extract_variable.exercise_3;

import java.math.BigDecimal;
import java.util.Objects;

public class Restaurante {
    private String nome;
    private BigDecimal taxaEntregaBase;
    private boolean aberto;

    public Restaurante(String nome, BigDecimal taxaEntregaBase, boolean aberto) {
        this.nome = Objects.requireNonNull(nome);
        this.taxaEntregaBase = Objects.requireNonNull(taxaEntregaBase);
        this.aberto = aberto;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getTaxaEntregaBase() {
        return taxaEntregaBase;
    }

    public boolean isAberto() {
        return aberto;
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "nome='" + nome + '\'' +
                ", taxaEntregaBase=" + taxaEntregaBase +
                ", aberto=" + aberto +
                '}';
    }
}
