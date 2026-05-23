public class ReportGenerator {
    public static void main(String[] args) {
        ReportService reportService = new ReportService(new PdfFormatter());
        reportService.generateReport("some data");
    }
}