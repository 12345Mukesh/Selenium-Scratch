package PracticefromScratch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartMobile 
{
   public static void main(String args[])
   {
	   WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		  driver.get("https://www.flipkart.com");
		  String url=driver.getCurrentUrl();
		  System.out.println(url);
		  driver.findElement(By.xpath("//button[text()='✕']")).click();
		 driver.findElement(By.xpath("//input[@class='_3704LK' and @name='q']")).sendKeys("Mobiles under 50,000");
		 driver.findElement(By.className("L0Z3Pu")).click();
		 
		 //Trying to select realme checkbox through descendant but not working
		 
		 
		 
		 
		    
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
		   }
	
	
	
}
