package unidade_2._8_change_declaration_method.examples.example_2.reports;

import java.util.List;
import java.util.StringJoiner;

public class CsvReport extends Report {
    private List<String> dataRows;

    public CsvReport(String title, List<String> dataRows) {
        super(title);
        this.dataRows = dataRows;
    }

    @Override
    public String formatContent() {
        StringJoiner sj = new StringJoiner("\n");
        sj.add("CSV Report: " + title);
        dataRows.forEach(sj::add);
        return sj.toString();
    }

    public List<String> getDataRows() {
        return dataRows;
    }
}
