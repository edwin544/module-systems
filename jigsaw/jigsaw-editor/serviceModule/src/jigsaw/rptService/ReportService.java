package jigsaw.rptService;

import jigsaw.loggerService.IOLogger;


import java.io.IOException;

public class ReportService {
    private IOLogger _logger;

    public ReportService(IOLogger logger) {
        _logger =  logger;
        var data = _logger.getLogs();
        System.out.println(data);
    }

    public void submitReport(String title, String description) throws IOException {
        _logger.updateLog1("Report Service, submitting report.");
        //_logger.getLogs();
    }


}
