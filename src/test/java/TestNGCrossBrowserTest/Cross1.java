package TestNGCrossBrowserTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cross1
{

	WebDriver driver;
	   @Parameters("browser")
		@Test()
		public void try1(String browsername)
		{
		   if(browsername.equals("firefox"))
		   {
			   driver=new ChromeDriver();
			   System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			   driver.get("https://www.facebook.com");
		   }
			
		}
		
	
	
}
