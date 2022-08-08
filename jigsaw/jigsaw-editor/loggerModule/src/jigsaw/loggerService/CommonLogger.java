package jigsaw.loggerService;

import java.io.*;
import jigsaw.fileAccess.FileIO;

public class CommonLogger implements ILogger{

    protected String _logFileName;
    public CommonLogger(String logFileName) {
        _logFileName = logFileName;
    }

    public void updateLog(String msg) throws IOException {
        //do nothing
    }

    public String getLogs() throws IOException {
        return "getting dummy logs.";
    }
}
