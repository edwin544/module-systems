package jigsaw.loggerService;

import java.io.*;
import jigsaw.fileAccess.FileIO;

public class NetworkLogger extends IOLogger implements ILogger {

    private String _networkFileName;

    public NetworkLogger(String networkFileName) {
        _networkFileName = networkFileName;
    }

    public void updateLog(String msg) throws IOException {
        File file = new File(_networkFileName);
        var fileIO = new FileIO(file);
        fileIO.updateFile(msg);
    }

    public String getLogs() throws IOException {
        File file = new File(_networkFileName);
        var fileIO = new FileIO(file);
        return fileIO.readFile();
    }
}
