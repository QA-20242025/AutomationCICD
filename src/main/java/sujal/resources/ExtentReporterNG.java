package sujal.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

    public static ExtentReports getReportObject() {
        // Define the file path for the report
        String path = System.getProperty("user.dir") + "/reports/index.html";

        // Create ExtentSparkReporter instance
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Practice");
        reporter.config().setDocumentTitle("Test Results");

        // Create ExtentReports instance and attach the reporter
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Sujal");



return extent;
    }
}
