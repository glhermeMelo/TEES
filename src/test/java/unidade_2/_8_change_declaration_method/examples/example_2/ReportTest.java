package unidade_2._8_change_declaration_method.examples.example_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unidade_2._8_change_declaration_method.examples.example_2.client.ReportProcessor;
import unidade_2._8_change_declaration_method.examples.example_2.reports.CsvReport;
import unidade_2._8_change_declaration_method.examples.example_2.reports.PdfReport;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReportTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void pdfReportShouldFormatContentCorrectly() {
        PdfReport pdfReport = new PdfReport("Sales Summary", "Alice");
        String expected = "PDF Report: Sales Summary by Alice. Content in PDF format.";
        assertEquals(expected, pdfReport.formatContent());
    }

    @Test
    void csvReportShouldFormatContentCorrectly() {
        List<String> data = Arrays.asList("Header1,Header2", "Value1,Value2", "Value3,Value4");
        CsvReport csvReport = new CsvReport("User Data", data);
        String expected = "CSV Report: User Data\nHeader1,Header2\nValue1,Value2\nValue3,Value4";
        assertEquals(expected, csvReport.formatContent());
    }

    @Test
    void reportProcessorShouldHandlePdfReport() {
        ReportProcessor processor = new ReportProcessor();
        PdfReport pdfReport = new PdfReport("Project Status", "Bob");
        processor.processReport(pdfReport);
        assertTrue(outContent.toString().contains("Processing report: Project Status"));
        assertTrue(outContent.toString().contains("PDF Report: Project Status by Bob. Content in PDF format."));
    }

    @Test
    void reportProcessorShouldHandleCsvReport() {
        ReportProcessor processor = new ReportProcessor();
        List<String> data = Arrays.asList("Name,Age", "Charlie,30");
        CsvReport csvReport = new CsvReport("Contact List", data);
        processor.processReport(csvReport);
        assertTrue(outContent.toString().contains("Processing report: Contact List"));
        assertTrue(outContent.toString().contains("CSV Report: Contact List\nName,Age\nCharlie,30"));
    }
}
