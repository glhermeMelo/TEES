package unidade_1._2_code_bad_smells.example_7;

public class Example7Estudante {
    //dados pessoais
    private String nomeCompleto;
    private String dataNascimento;
    private String endereco;

    //dados de matrícula
    private String numeroDeMatricula;
    private String curso;
    private double mediaGeral;

    public String getNomeCompleto() { return nomeCompleto; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public void matricularEmCurso(String curso) { this.curso = curso; }
    public void calcularMedia() {
        //omitido: lógica para calcular a média
    }
}
