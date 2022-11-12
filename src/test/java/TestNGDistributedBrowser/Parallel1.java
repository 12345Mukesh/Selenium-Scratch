package TestNGDistributedBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Parallel1 
{

	WebDriver driver;
	@Test()
	public void Method1()
	{

		driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com");
		Reporter.log("Facebook Opened",true);

	}



}
