package MouseAndKeyboardActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SpiceJetDropdown {

	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		  driver.get("https://www.spicejet.com");
		  
		  WebElement about=driver.findElement(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-ubezar r-16dba41 r-1pzd9i8' and text()='Add-ons']"));
		  
		  Actions ac= new Actions(driver);
		   ac.moveToElement(about).perform();
		   
		   WebElement army=driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-ubezar' and text()='Indian Armed Forces Personnel']"));
		
		   Actions ac1= new Actions(driver);
		   ac1.moveToElement(army).perform();
		   Thread.sleep(3000);
		   ac1.contextClick(army).perform();
		   Thread.sleep(5000);
		   ac1.doubleClick(army).perform();
		   driver.close();

	}

}
