package TestNGDistributedBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Parallel2 
{

	WebDriver driver;
	@Test()
		public void Method2()
		{
		   
		driver=new ChromeDriver();
//		  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//		  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	      driver.get("https://www.whatsapp.com");
	      Reporter.log("Whatsapp Opened",true);
		
		}
	
	
	
	
}
