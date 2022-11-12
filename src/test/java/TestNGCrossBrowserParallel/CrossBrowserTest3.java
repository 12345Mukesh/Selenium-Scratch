package TestNGCrossBrowserParallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CrossBrowserTest3
{

	WebDriver driver;
	@Test()
		public void Method3()
		{
		   
		driver=new ChromeDriver();
//		  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	      driver.get("https://www.gmail.com");
	      Reporter.log("Gmail Opened",true);
		
		}
	
	
	
	
}
