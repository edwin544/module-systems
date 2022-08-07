package jigsaw.loggerService;

import java.io.*;
import jigsaw.fileAccess.FileIO;

public class CommonLogger extends IOLogger implements ILogger{

    private String _logName;
    public CommonLogger(String logName) {
        _logName = logName;
    }

    public void updateLog(String msg) throws IOException {
        File file = new File(_logName);
        var fileIO = new FileIO(file);
        fileIO.updateFile(msg);
    }

    public String getLogs() throws IOException {
        File file = new File(_logName);
        var fileIO = new FileIO(file);
        return fileIO.readFile();
    }
}
