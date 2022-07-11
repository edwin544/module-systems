package jigsaw.loggerService;

import java.io.*;
// import java.io.FileWriter;
//import java.io.IOException;

public class Logger {

    private String _reportName;

    public Logger(String  reportName){
        _reportName = reportName;
    }

    public void updateLog(String msg) throws IOException {
        FileWriter fw = new FileWriter(_reportName, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(msg);
        bw.newLine();
        bw.close();
    }

}
