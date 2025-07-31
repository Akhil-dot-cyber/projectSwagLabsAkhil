package Demo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LearningAdvanceReport {
public static void main(String[] args) {
	
	//Create Spark Report
	
	ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports/report.html");
	
	spark.config().setDocumentTitle("Regression Testing for the Swag Labs");
	
	spark.config().setReportName("Regression Suite");
	
	spark.config().setTheme(Theme.STANDARD);
	
	//Create the Extent Report
	ExtentReports report = new ExtentReports();
	
	//Attach the spark report and Extent Report
	report.attachReporter(spark);
	
	//Configure  the system information 
	report.setSystemInfo("Device Name:", "Nihanth");
	report.setSystemInfo("Operating System", "Windows 11");
	report.setSystemInfo("Browser:", "Chrome");
	report.setSystemInfo("Browser Version:", "chrome-");
	
	//Create the test Information
	ExtentTest test= report.createTest("RegressionTest");
	
	//Steps Information 
	test.log(Status.INFO, "Step1: Launching the browser successful");
	test.log(Status.INFO, "Step2: Navigating to the Application via URL successful");
	test.log(Status.INFO, "Step3: Verifing the WebPage successful");
	
	if (true==true) {
		test.log(Status.PASS, "Step4: Verified the Web Elements, Displayed");
	} else {
		test.log(Status.PASS, "Step4: Verified the Web Elements, Not Displayed");
	}
	test.log(Status.SKIP, "Step5: Element is Hidden");
	
	//Flush the report
	report.flush();
	
	System.out.println("Execution done");
	
	
}
}