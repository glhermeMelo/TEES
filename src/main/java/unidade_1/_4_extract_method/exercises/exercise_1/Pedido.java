package unidade_1._4_extract_method.exercises.exercise_1;

import java.util.List;

public class Pedido {
    private List<ItemVenda> itens;

    public Pedido(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public double calcularTotalComDesconto(double percentualDesconto) {
        double totalBruto = calcularValorTotalItens(itens);

        double valorDesconto = totalBruto * (percentualDesconto / 100.0);

        return totalBruto - valorDesconto;
    }

    private double calcularValorTotalItens(List<ItemVenda> itens) {
        double totalBruto = 0;

        for (ItemVenda item : itens) {
            totalBruto += item.getValorTotalBruto();
        }

        return totalBruto;
    }
}
