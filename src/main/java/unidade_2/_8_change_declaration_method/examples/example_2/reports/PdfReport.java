package unidade_2._8_change_declaration_method.examples.example_2.reports;

public class PdfReport extends Report {
    private String author;

    public PdfReport(String title, String author) {
        super(title);
        this.author = author;
    }

    @Override
    public String formatContent() {
        return "PDF Report: " + title + " by " + author + ". Content in PDF format.";
    }

    public String getAuthor() {
        return author;
    }
}
