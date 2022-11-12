package TestNGDistributedBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParallelMethods 
{
	WebDriver driver;
   @Test()
   public void runtest1()
   {
	  driver=new ChromeDriver();
	  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
   }
	
   @Test()
   public void runtest2()
   {
	  driver=new ChromeDriver();
	  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
   }
	
   @Test()
   public void runtest3()
   {
	  driver=new ChromeDriver();
	  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
   }

}
