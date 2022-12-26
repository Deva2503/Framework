package generic;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

abstract public class BaseTest implements IAutoConstants
{
	public WebDriver driver;
	static
	{
		System.setProperty(CHROME_KEY , CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	
	@BeforeMethod(alwaysRun=true)
	public void openApp()
	{
		String appURL=AutoUtils.getProperty(CONFIG_PATH, "URL");
		String strITO=AutoUtils.getProperty(CONFIG_PATH, "ITO");
		long ITO= Long.parseLong(strITO);
		driver.get(appURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ITO));
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeApp(ITestResult testresult)
	{
		String testName=testresult.getName();
		int status=testresult.getStatus();
		if(status==1)
		{
			Reporter.log(testName+"is PASSED", true);
		}
		else
		{
			Reporter.log(testName+"is FAILED", false);
			AutoUtils.getPhoto(driver, IMAGE_PATH,testName);
		}
		
		driver.quit();
	}
}
