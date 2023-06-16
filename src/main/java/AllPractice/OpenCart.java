package AllPractice;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenCart {

	public static void main(String[] args) throws InterruptedException
	{
	
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement laptop= driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
		
		Actions ac= new Actions(driver);
		ac.moveToElement(laptop).build().perform();
		
		WebElement showlaptop=driver.findElement(By.xpath("//a[text()='Show All Laptops & Notebooks']"));
		ac.moveToElement(showlaptop).click().build().perform();
		
		WebElement sony=driver.findElement(By.xpath("//a[text()='Sony VAIO']"));
		Point p= sony.getLocation();
       JavascriptExecutor jse= (JavascriptExecutor) driver;
       jse.executeScript("window.scrollBy"+p);
		
       jse.executeScript("arguments[0].click();",sony);
       
       Thread.sleep(3000);
       WebElement cartbtn=driver.findElement(By.xpath("//button[text()='Add to Cart']"));
       cartbtn.click();
       
       WebElement phone=driver.findElement(By.xpath("//a[text()='Phones & PDAs']"));
       phone.click();
       
       Thread.sleep(3000);
       WebElement iphone=driver.findElement(By.xpath("//a[text()='iPhone']"));
      jse.executeScript("arguments[0].click();", iphone);
      
      driver.findElement(By.id("button-cart")).click();
      
      driver.findElement(By.xpath("//a[text()='Cameras']")).click();
      
      Thread.sleep(3000);
      
     WebElement camera= driver.findElement(By.xpath("//a[text()='Nikon D300']"));
     jse.executeScript("arguments[0].click();", camera);
     
     Thread.sleep(2000);
     driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
     
     
     WebElement Mp3player=driver.findElement(By.xpath("//a[text()='MP3 Players']"));
     ac.moveToElement(Mp3player).build().perform();
     
     Thread.sleep(2000);
     driver.findElement(By.xpath("//a[text()='test 22 (0)']")).click();
       
       driver.quit();
       
	}

}
