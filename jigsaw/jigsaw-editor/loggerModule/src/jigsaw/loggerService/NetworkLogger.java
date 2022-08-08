package jigsaw.loggerService;

import jigsaw.fileAccess.NetworkIO;

import java.io.File;
import java.io.IOException;

public class NetworkLogger extends CommonLogger implements ILogger {

    public NetworkLogger(String networkFileName) {
        super(networkFileName);
    }

    public void updateLog(String msg) throws IOException {
        File file = new File(_logFileName);
        var networkIO = new NetworkIO(file);
        networkIO.updateFile("Network: " + msg);
    }

    public String getLogs() throws IOException {
        File file = new File(_logFileName);
        var networkIO = new NetworkIO(file);
        return networkIO.readFile();
    }
}
