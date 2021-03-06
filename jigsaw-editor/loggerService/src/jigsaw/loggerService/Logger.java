package jigsaw.loggerService;

import java.io.*;
import jigsaw.fileAccess.FileIO;

public class Logger {

    private String _logName = "log.txt";

    public Logger() {
    }

    public void updateLog(String msg) throws IOException {
        File file = new File(_logName);
        var fileIO = new FileIO(file);
        fileIO.updateFile(msg);
    }
}
