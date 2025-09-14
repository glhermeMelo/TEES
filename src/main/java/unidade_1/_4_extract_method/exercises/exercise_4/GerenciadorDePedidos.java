package unidade_1._4_extract_method.exercises.exercise_4;

/*
 * Analise esta classe e sua respectiva versão refatorada: Houve refatoração, de fato?
 * Se sim:
 *      (1) Identifique o tipo de refatoração aplicado.
 *      (2) Explique o porquê da refatoração (alguma vantagem?).
 */

import java.util.List;

public class GerenciadorDePedidos {

    public Pedido criarPedido(List<Item> itens) {
        Pedido novoPedido = criadorDePedido(itens);
        //omitido: lógica para processamento do pedido
        return novoPedido;
    }

    private Pedido criadorDePedido(List<Item> itens) {
        return new Pedido(itens);
    }
}
