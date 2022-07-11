package jigsaw.app;

import jigsaw.rptService.ReportService;
import java.io.IOException;

public class clientApp {
    public static void main(String[] args) throws IOException {

        var reportService = new ReportService();
        reportService.submitReport("Report title", "This is my first report!!");
        System.out.println("Printing report");
        System.out.println(reportService.getReport());

    }
}
