class ReportService {
    private final ReportFormatter reportFormatter;

    public ReportService(ReportFormatter reportFormatter) {
        this.reportFormatter = reportFormatter;
    }

    public void generateReport(String data) {
        reportFormatter.format(data);
    }
}