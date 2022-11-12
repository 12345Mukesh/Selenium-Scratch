package TestNGCrossBrowserTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cross3 
{
	WebDriver driver;
   @Parameters("browser")
	@Test()
	public void try3(String browsername)
	{
	   if(browsername.equals("firefox"))
	   {
		   driver=new FirefoxDriver();
		   System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		   driver.get("https://www.youtube.com");
		   
	   }
		
	
	   else
   
	   if(browsername.equals("chrome"))
	   {
		   driver=new ChromeDriver();
		   System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		   driver.get("https://www.whatsapp.com");
	   }
		
	}
	
}
