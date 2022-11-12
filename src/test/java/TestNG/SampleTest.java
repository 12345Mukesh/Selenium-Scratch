package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SampleTest 
{
   @Test
	public void Sample() throws InterruptedException
	{
		
	   WebDriver driver= new ChromeDriver();
	   System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	   driver.manage().window().maximize();
	   driver.get("https://www.google.com");
	   Thread.sleep(4500);
	//   driver.findElement(By.xpath("//button[text()='No thanks']")).click();
	   
	   driver.findElement(By.name("q")).sendKeys("Virat Kohli");
	 //  driver.findElement(By.xpath("//div[@class='pcTkSc']")).click();
	   
	   Reporter.log("King",true);
	   Reporter.log("GOAT",true);
	}
	
	
	
}
