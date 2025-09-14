package unidade_1._2_code_bad_smells.example_7;

public class Example7MatriculaRefactored {
    private String numeroDeMatricula;
    private String curso;
    private double mediaGeral;

    public void matricularEmCurso(String curso) { this.curso = curso; }
    public void calcularMedia() {
        //omitido: lógica para calcular a média
    }
}
