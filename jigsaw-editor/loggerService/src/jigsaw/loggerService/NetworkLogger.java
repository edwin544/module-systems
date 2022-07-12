package jigsaw.loggerService;

import java.io.*;
import jigsaw.fileAccess.FileIO;

public class NetworkLogger {

    private String _logName = "network-log.txt";

    public NetworkLogger() {

    }

    public void updateLog(String msg) throws IOException {
        File file = new File(_logName);
        var fileIO = new FileIO(file);
        fileIO.updateFile(msg);
    }
}
