package jigsaw.web;

import jigsaw.serviceModule.ReportService;
import jigsaw.loggerService.Logger;

import java.io.IOException;

public class clientApp {
    public static void main (String[] args) throws IOException {


        try {
            var logger = new Logger("log.txt");
            logger.updateLog("Started executing main client.");

            var reportService = new ReportService(logger);
            reportService.submitReport("Report title", "This is my first report!!");
            System.out.println("Printing report");
            System.out.println(reportService.getReport());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}