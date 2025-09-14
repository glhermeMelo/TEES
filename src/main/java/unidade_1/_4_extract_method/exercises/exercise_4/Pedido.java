package unidade_1._4_extract_method.exercises.exercise_4;

import java.util.List;

public class Pedido {
    private List<Item> itens;

    public Pedido(List<Item> itens) { this.itens = itens; }
    public List<Item> getItens() { return itens; }
}
