package jigsaw.loggerService;

import java.io.*;
import jigsaw.fileAccess.FileIO;

public class Logger {

    private String _reportName = "log.txt";

    public Logger() {
    }

    public void updateLog(String msg) throws IOException {
        File file = new File(_reportName);
        var fileIO = new FileIO(file);
        fileIO.updateFile(msg);
    }
}
