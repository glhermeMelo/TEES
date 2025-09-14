package unidade_1._2_code_bad_smells.example_2;

public class Example2 {
    //calculando o imposto de um produto
    public double calcularImpostoProduto(double valor) {
        // omitido: código com a lógica específica para produto
        double impostoDevido = valor * 0.05;
        double total = valor + impostoDevido;
        return total;
    }

    //calculando o imposto de um serviço
    public double calcularImpostoServico(double valor) {
        // omitido: código com a lógica específica para serviço
        double impostoDevido = valor * 0.05;
        double total = valor + impostoDevido;
        return total;
    }
}
