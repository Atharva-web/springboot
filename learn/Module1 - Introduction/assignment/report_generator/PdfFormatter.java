class PdfFormatter implements ReportFormatter {
    @Override
    public void format(String data) {
        System.out.println
        ("Generating PDF report with data: " + data);
    }
}