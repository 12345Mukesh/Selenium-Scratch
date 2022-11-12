package TestNGDistributedBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Parallel3
{
	WebDriver driver;
	@Test()
	public void Method3()
	{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");   
		driver=new ChromeDriver();

		driver.get("https://www.gmail.com");
		Reporter.log("Gmail Opened",true);

	}
}
