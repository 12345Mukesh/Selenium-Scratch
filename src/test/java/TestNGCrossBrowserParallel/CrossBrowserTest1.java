package TestNGCrossBrowserParallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CrossBrowserTest1
{

	WebDriver driver;
	@Test()
		public void Method1()
		{
		   //Driver should be initialized then only it will work
    	driver=new ChromeDriver();
//		  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	      driver.get("https://www.facebook.com");
	      Reporter.log("Facebook Opened",true);
		
		}
	
	
	
	
}
