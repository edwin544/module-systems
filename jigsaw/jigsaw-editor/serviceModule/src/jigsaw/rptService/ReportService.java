package jigsaw.rptService;

import jigsaw.loggerService.ILogger;
import jigsaw.loggerService.NetworkLogger;
import java.io.IOException;

public class ReportService {
    private NetworkLogger _logger;

    public ReportService(ILogger logger) {
        _logger =  (NetworkLogger) logger;
    }

    public void submitLogReport(String title, String description) throws IOException {
        _logger.updateLog(title + ", " + description);
    }

}
