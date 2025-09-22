package unidade_1._7_inline_variable.exercise_2;

import java.util.List;

public class Pedido {
    private List<ItemPedido> itens;
    private TipoCliente tipoCliente;

    public Pedido(List<ItemPedido> itens, TipoCliente tipoCliente) {
        this.itens = itens;
        this.tipoCliente = tipoCliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }
}
