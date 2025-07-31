package genericlibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pagerepository.LoginPage;
import pagerepository.LogoutPage;

public class BaseConfig {

	public WebDriver driver;
	
    public ExtentSparkReporter spark;
    
	public ExtentReports report;
    
	public ExtentTest test;
	
	@BeforeTest
	public void ReportSetup() {
		
		//Create Spark Report
		
		 spark = new ExtentSparkReporter("./AdvanceReports/report.html");
				
	    spark.config().setDocumentTitle("Regression Testing for the Swag Labs");
				
	    spark.config().setReportName("Regression Suite");
				
		spark.config().setTheme(Theme.STANDARD);
				
		//Create the Extent Report
		
		   report = new ExtentReports();
				
				//Attach the spark report and Extent Report
				report.attachReporter(spark);
				
				//Configure  the system information 
				report.setSystemInfo("Device Name:", "Akhil");
				report.setSystemInfo("Operating System", "Windows 11");
				report.setSystemInfo("Browser:", "Chrome");
				report.setSystemInfo("Browser Version:", "chrome- 138.0.7204.169");
	}
	
	@AfterTest
	public void RepoertTerminate() {
      
		report.flush();
	}

	public static WebDriver staticdriver;

	// @Parameters("BrowserName");

	@BeforeClass

	public void BrowserSetup() throws IOException {

		String browser = "edge";
		// 1.open the browser

		driver = WebDriverLibrary.openBrowser(browser);

		staticdriver = driver;

		// Maximize the browser

		WebDriverLibrary.maximizeBrowser();

		// Wait statement
		WebDriverLibrary.waitStatement();
		;

		// 2.navigate to the application via url

		WebDriverLibrary.navigateToApp(PropertiesLibrary.fetchData("url"));

		// 3.verify the page using Title

		Assert.assertEquals(driver.getTitle(), "Swag Labs");

	}

	@BeforeMethod
	public void Login() throws IOException {

		// wait statement
		WebDriverLibrary.waitStatement();
		;

		// create an object for LoginPage
		LoginPage loginobj = new LoginPage(driver);

		// 4.verify the username textfield

		Assert.assertTrue(loginobj.getUsernameText().isDisplayed());

		WebDriverLibrary.enterTheData(loginobj.getUsernameText(), PropertiesLibrary.fetchData("username"));

		// 5.verify the password text field

		Assert.assertTrue(loginobj.getPasswordText().isDisplayed());

		WebDriverLibrary.enterTheData(loginobj.getPasswordText(), PropertiesLibrary.fetchData("password"));

		// 6.verify the login button

		WebDriverLibrary.elementClick(loginobj.getLoginButton());

		// Verify the page

		System.out.println(driver.getTitle());

	}

	@AfterMethod
	public void logOut() {

		// 32.Verify the Logout button is displayed and click on logout button

		LogoutPage logoutobj = new LogoutPage(driver);

		// validate menu
		Assert.assertTrue(logoutobj.getMenu().isEnabled());

		// click the menu
		WebDriverLibrary.elementClick(logoutobj.getMenu());

		WebDriverLibrary.waitStatement(logoutobj.getlogoutbutton());

		// validate logout
		Assert.assertTrue(logoutobj.getlogoutbutton().isDisplayed());

		// click logout
		WebDriverLibrary.elementClick(logoutobj.getlogoutbutton());

	}

	@AfterClass
	public void BrowserTerminate() {

		// 34.Close the browser

		driver.quit();

		Reporter.log("browser terminate done", true);
	}

	@DataProvider

	public Object[][] checkOutInfo() {

		Object[][] data = new Object[1][3];

		data[0][0] = ExcelLibrary.readData("Readdetails", 0, 0);
		data[0][1] = ExcelLibrary.readData("Readdetails", 0, 1);

		data[0][2] = ExcelLibrary.readData("Readdetails", 0, 2);

		return data;

	}
}
