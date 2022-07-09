package jigsaw.dataAccess;

import jigsaw.loggerService.Logger;
import java.io.*;

public class ReportDataAccess {
    private String reportName = "report.txt";
    private Logger _logger;

    public ReportDataAccess(Logger logger){
        _logger = logger;
    }

    public void updateReport(String title, String description) throws IOException {
        _logger.updateLog("Data Access, updating report to file.");
        FileWriter fw = new FileWriter(reportName, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("Report Date: 11 July 2022 3:14 PM, Title:" + title + ", Description: " + description + "\n" );
        bw.newLine();
        bw.close();
    }

    public String getReport() throws IOException {
        _logger.updateLog("Data Access, reading report from file.");
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
