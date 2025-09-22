package unidade_2._8_change_declaration_method.examples.example_2.client;

import unidade_2._8_change_declaration_method.examples.example_2.reports.Report;

public class ReportProcessor {
    public void processReport(Report report) {
        // metodo que invoca formatContent()
        System.out.println("Processing report: " + report.getTitle());
        System.out.println("Formatted content:\n" + report.formatContent());
        System.out.println("--- End of Report ---\n");
    }
}
