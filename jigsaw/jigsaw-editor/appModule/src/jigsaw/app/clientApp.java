package jigsaw.app;

import jigsaw.loggerService.CommonLogger;
import jigsaw.loggerService.FileLogger;
import jigsaw.loggerService.NetworkLogger;
import jigsaw.rptService.ReportService;
import java.io.IOException;

public class clientApp {

    public static void main(String[] args) throws IOException {

        var logFileName = "file-log.txt";
        var logger = new CommonLogger(logFileName);
        var reportService = new ReportService(logger);
        reportService.submitLogReport("Report title", "This is my first report!!");
        System.out.println(logger.getLogs()); //able to call logger.getLogs directly.



    }
}
