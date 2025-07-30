package listenerlibrary;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerImplementation implements ITestListener {
	
	@Override
	public void onTestFailure(ITestResult result) {
				//TimeStamp
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
				
				String currentDate = sdf.format(new Date());
				
				System.out.println(currentDate);
				
				
				//Perform TypeCasting
				TakesScreenshot ts = (TakesScreenshot)genericlibrary.BaseConfig.staticdriver;
				
				//Call the Screenshot method and store the screenshot in Temp path
				File src = ts.getScreenshotAs(OutputType.FILE);
				
				//Create a permanent path for storing screenshot
				File dest = new File("./Screenshots/Listner "+ currentDate +".png");
				
				//Copy the screenshot from Temp to permanent
				try {
					FileHandler.copy(src, dest);
				} catch (IOException e) {
					e.printStackTrace();
				}
				Reporter.log("Screenshot Taken");
	}
	
	
	

}
