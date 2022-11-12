package TestNGCrossBrowserParallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CrossBrowserTest2
{

	WebDriver driver;
	@Test()
		public void Method2()
		{
		   
		driver=new FirefoxDriver();
//		  System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
	      driver.get("https://www.whatsapp.com");
	      Reporter.log("Whatsapp Opened",true);
		
		}
	
	
	
	
}
