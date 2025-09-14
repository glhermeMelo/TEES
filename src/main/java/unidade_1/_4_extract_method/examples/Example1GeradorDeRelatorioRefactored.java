package unidade_1._4_extract_method.examples;

import java.time.LocalDate;
import java.util.List;

public class Example1GeradorDeRelatorioRefactored {
    public void gerarRelatorioDeVendas(List<Example1ItemVenda> itens) {
        // Exibir cabeçalho do relatorio
        System.out.println("--- Relatorio de Vendas ---");
        System.out.println("Data: " + LocalDate.now());
        System.out.println("--------------------------");

        // Calcular o total dos itens e exibir cada um
        double total = processarItens(itens);

        // Exibir o rodapé e o total
        System.out.println("--------------------------");
        System.out.println("Total de Vendas: R$ " + total);
        System.out.println("--------------------------");
    }

    private double processarItens(List<Example1ItemVenda> itens) {
        double total = 0;
        for (Example1ItemVenda item : itens) {
            System.out.println("Item: " + item.getNome() +
                    " | Valor: " + item.getValor());
            total += item.getValor();
        }
        return total;
    }
}
