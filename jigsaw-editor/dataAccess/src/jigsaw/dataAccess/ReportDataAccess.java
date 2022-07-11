package jigsaw.dataAccess;

import jigsaw.dataAccess.report.ReportWriter;
import jigsaw.loggerService.Logger;
import java.io.*;

public class ReportDataAccess {
    private Logger _logger;

    public ReportDataAccess(Logger logger){
        _logger = logger;
    }

    public void updateReport(String title, String description) throws IOException {

        _logger.updateLog("Data Access, updating report to file.");
        var reportWriter = new ReportWriter();
        var reportData = "Report Date: 12 July 2022 3:14 PM, Title:" + title + ", Description: " + description + "\n";
        reportWriter.updateReport(reportData);
    }

    public String getReport() throws IOException {

        _logger.updateLog("Data Access, reading report from file.");
        var reportReader = new ReportWriter();
        var reportData = reportReader.readReport();
        return reportData.toString();
    }
}
