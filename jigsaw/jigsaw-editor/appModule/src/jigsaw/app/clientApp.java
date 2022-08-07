package jigsaw.app;

import jigsaw.loggerService.CommonLogger;
import jigsaw.rptService.ReportService;
import java.io.IOException;

public class clientApp {

    public static void main(String[] args) throws IOException {

        var logger = new CommonLogger();
        var reportService = new ReportService(logger);
        reportService.submitReport("Report title", "This is my first report!!");
        System.out.println("Printing report");

    }
}
