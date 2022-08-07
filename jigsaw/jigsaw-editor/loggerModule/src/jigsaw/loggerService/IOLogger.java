package jigsaw.loggerService;

import jigsaw.fileAccess.FileIO;
import java.io.File;
import java.io.IOException;

public class IOLogger {

    public String getLogs() throws IOException {
        return "get IO logs";
    }
    private String _logName = "io-log.txt";

    public void updateLog1(String msg) throws IOException  {
        File file = new File(_logName);
        var fileIO = new FileIO(file);
        fileIO.updateFile(msg);
    }
}
