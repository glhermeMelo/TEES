package unidade_1._2_code_bad_smells.example_7;

public class Example7EstudanteRefactored {
    //dados pessoais
    private String nomeCompleto;
    private String dataNascimento;
    private String endereco;

    //referência para a classe extraída
    private Example7MatriculaRefactored matricula;

    public String getNomeCompleto() { return nomeCompleto; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public Example7MatriculaRefactored getMatricula() { return matricula; }
}
