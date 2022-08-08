package jigsaw.fileAccess;

import java.io.*;

public class NetworkIO {
    private File _file;

    public NetworkIO(File file){
        _file = file;
    }

    public void updateFile(String data) throws IOException {
        FileWriter fw = new FileWriter(_file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(data);
        bw.newLine();
        bw.close();
    }

    public String readFile() throws IOException {
        StringBuilder reportData = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(_file));
        String strLine;
        while ((strLine = br.readLine()) != null) {
            reportData.append(strLine).append("\n");
        }
        return reportData.toString();
    }
}
