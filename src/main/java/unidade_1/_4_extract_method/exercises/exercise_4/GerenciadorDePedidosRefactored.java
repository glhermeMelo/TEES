package unidade_1._4_extract_method.exercises.exercise_4;

import java.util.List;
import java.util.ArrayList; // para testes

public class GerenciadorDePedidosRefactored {

    private Pedido criarNovoPedido(List<Item> itens) {
        return new Pedido(itens);
    }

    public Pedido criarPedido(List<Item> itens) {
        Pedido novoPedido = criarNovoPedido(itens);
        //omitido: lógica para processamento do pedido
        return novoPedido;
    }
}
