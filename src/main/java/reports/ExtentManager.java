package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;
    private static String reportFilePath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";

    public synchronized static ExtentReports getExtentReports() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportFilePath);
            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }

    public static String getReportPath() {
        return reportFilePath;
    }
}
