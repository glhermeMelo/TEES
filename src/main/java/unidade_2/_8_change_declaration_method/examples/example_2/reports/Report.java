package unidade_2._8_change_declaration_method.examples.example_2.reports;

public abstract class Report {
    protected String title;

    public Report(String title) {
        this.title = title;
    }

    //metodo que será alterado
    public abstract String formatContent();

    public String getTitle() {
        return title;
    }
}
