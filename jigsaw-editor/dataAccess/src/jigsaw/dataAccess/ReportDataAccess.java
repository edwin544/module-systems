package jigsaw.dataAccess;

import jigsaw.loggerService.Logger;
import jigsaw.fileAccess.FileIO;
import java.io.*;

public class ReportDataAccess {
    private Logger _logger;
    private String reportName = "report.txt";

    public ReportDataAccess(Logger logger){
        _logger = logger;
    }

    public void updateReport(String title, String description) throws IOException {
        _logger.updateLog("Data Access log, updating report to file.");
        File file = new File(reportName);
        var fileIO = new FileIO(file);
        var reportData = "Report Date: 13 July 2022 3:14 PM, Title:" + title + ", Description: " + description + "\n";
        fileIO.updateFile(reportData);
        _logger.updateLog("Data Access log, report written to file.\n");
    }

    public String getReport() throws IOException {
        _logger.updateLog("Data Access log, reading report from file.");
        File file = new File(reportName);
        var fileIO = new FileIO(file);
        var reportData = fileIO.readFile();
        return reportData.toString();
    }
}
