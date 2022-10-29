package ScrollDown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class UsingRemoteWebDriver {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		driver.get("https://www.selenium.dev/downloads");
		
	WebElement sponsors=driver.findElement(By.xpath("//h2[text()='Selenium Level Sponsors']"));
		
	  Point loc=sponsors.getLocation();
	  System.out.println(loc);
		
	  
	  //Thru Downcasting
	  RemoteWebDriver rwd = (RemoteWebDriver)driver;
	  rwd.executeScript("window.scrollBy"+loc);

	}

}
