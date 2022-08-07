package jigsaw.loggerService;

import java.io.IOException;

public interface ILogger {
    void updateLog(String msg) throws IOException;
}
