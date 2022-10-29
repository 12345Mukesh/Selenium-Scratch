package Frames;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstDefaultSecondDefaultThirdFrame {

	public static void main(String[] args) throws InterruptedException
	{
	
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		 
		  driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		
		
		
		//This element will not locate in webpage due to it is in another frame
		//so need to use frame method
		
		/*  
		Every frame will have iframe tag
		1.First find the frame element
		For first frame there is unique frame and directly it is having  target as text so we directly taking it
		 * 
		 */
   driver.switchTo().frame("packageListFrame");
   driver.findElement(By.xpath("//a[text()='org.openqa.selenium']")).click();
	
   
   /*
    when we try to switch to second frame, from first frame it will not work, it will throw error
    so after going to first frame we need to come again to main page frame
    defaultContent means all the parent means ancestor - Based on the webpage we need to go whether it is parentFrame or defaultContent
     * 
     */
    driver.switchTo().defaultContent();
   Thread.sleep(3000);
   
   
      //2. Going to second frame and clicking on it
		
      driver.switchTo().frame("packageFrame");
      driver.findElement(By.xpath("//span[text()='JavascriptExecutor']")).click();
      
      /*when we try to switch to third frame, from second frame it will not work, it will throw error
      so after going to first frame we need to come again to main page then we can
      switch to second frame there is unique frame and directly it is having target as text so we directly taking it
       defaultContent means all the parent means ancestor - Based on the webpage we need to go whether it is parentFrame or defaultContent
     * 
       * 
       */
    
      driver.switchTo().defaultContent();
      Thread.sleep(3000);
      
      //3. Going to third frame
      driver.switchTo().frame("classFrame");
      driver.findElement(By.xpath("//a[text()='Default Methods']")).click();
      Thread.sleep(3000);
      
      WebElement pin=driver.findElement(By.xpath("//h4[text()='pin']"));
      
      Point p=pin.getLocation(); 
      
      JavascriptExecutor jse= (JavascriptExecutor)driver;
      jse.executeScript("window.scrollBy"+p);
      Thread.sleep(3000);
      
      driver.close();
   
   
		
	}

}
