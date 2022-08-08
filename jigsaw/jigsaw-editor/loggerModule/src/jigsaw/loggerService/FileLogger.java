package jigsaw.loggerService;

import jigsaw.fileAccess.FileIO;

import java.io.File;
import java.io.IOException;

public class FileLogger extends CommonLogger implements ILogger {

    public FileLogger(String fileName) {
        super(fileName);
    }

    public void updateLog(String msg) throws IOException {
        File file = new File(_logFileName);
        var fileIO = new FileIO(file);
        fileIO.updateFile("File: " + msg);
    }

    public String getLogs() throws IOException {
        File file = new File(_logFileName);
        var fileIO = new FileIO(file);
        return fileIO.readFile();
    }
}
