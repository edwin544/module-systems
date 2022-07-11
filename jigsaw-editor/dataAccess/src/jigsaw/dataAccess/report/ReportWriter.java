package jigsaw.dataAccess.report;

import java.io.*;

public class ReportWriter {
    private String reportName = "report.txt";

    public void updateReport(String data) throws IOException {

        FileWriter fw = new FileWriter(reportName, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(data);
        bw.newLine();
        bw.close();
    }

    public String readReport() throws IOException {

        StringBuilder reportData = new StringBuilder();
        File myFile = new File(reportName);
        BufferedReader br = new BufferedReader(new FileReader(myFile));
        String strLine;
        while ((strLine = br.readLine()) != null) {
            reportData.append(strLine).append("\n");
        }
        return reportData.toString();
    }
}
