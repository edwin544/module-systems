package jigsaw.serviceModule;

import jigsaw.dataAccess.ReportDataAccess;
import jigsaw.loggerService.Logger;

import java.io.IOException;

public class ReportService {

    private Logger _logger;
    public ReportService(Logger logger) {
        _logger = logger;
    }

    public void submitReport(String title, String description) throws IOException {
        _logger.updateLog("Report Service, submitting report.");
        var dataAccess = new ReportDataAccess(_logger);
        dataAccess.updateReport(title, description);
    }

    public String getReport() throws IOException {
        var dataAccess = new ReportDataAccess(_logger);
        return dataAccess.getReport();
    }

}
