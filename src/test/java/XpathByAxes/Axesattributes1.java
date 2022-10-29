package XpathByAxes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Axesattributes1 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		  driver.get("https://www.hyrtutorials.com/");
		 
		/*  
		    1.Following Sibling from Email -> Entering text of Email field
		  */
		 //Here using Mouse Action because after moving to the particular element only we can 
		  //select the element
		  WebElement move= driver.findElement(By.xpath("//a[text()='Selenium Practice']"));
		    
		  Actions ac=new Actions(driver);
		  ac.moveToElement(move).perform();
		  
		  driver.findElement(By.xpath("//a[text()='XPath Practice']")).click();

		  
		  driver.findElement(By.xpath("//label[text()='Email']/following-sibling::input[1]")).
		  sendKeys("abcd@gmail.com");
		  
		  /*
		   * 2. Parent of all the fields
		   * 
		   *   Two methods we can write for parent
		   *   i) Hard coded by giving *
		   *   ii)By giving the tag name
		   *         1. From the end element we can give  (or)
		   *         2. From the back element also we can give
		   * 
		   */
		 
	  driver.findElement(By.xpath("//label[text()='Email']/following-sibling::input[1]/parent::*"));
	/*
	   1. driver.findElement(By.xpath("//label[text()='Email']/following-sibling::input[1]/parent::div"));
	
	   2. driver.findElement(By.xpath("//label[text()='Email']/parent::div));
	
	*/
	
	
	/*
	 * 3. From Parent to Child(Finding all elements which is having text) 
	 * 
	 *    i)Normal one which is having all childs for the parent
	 *    ii) with child having tag name as input
	 *    iii) particular child with fields having text
	 * 
	 */
	
	  /* 1. driver.findElement(By.xpath("//div[@class='container']/child::*"));
	   
	     2. driver.findElement(By.xpath("//div[@class='container']/child::input"));
	   
	   */
	   
	     driver.findElement(By.xpath("//div[@class='container']/child::input[@type='text']"));
	
	
	     /* 
	      *  
	      *  4. Preceding-sibling  salary -> check box 
	      *                   (or)  check box <- salary
	      *     It is selecting two check boxes even after indexing because of same tag name and attributes
	      * 
	      */
	     
	     driver.findElement(By.xpath("//td[text()='5000']/preceding-sibling::td/child::input[1]"));
	     
	     
	     /*
	      * 5. Descendant 
	      * 
	      *         @container is grand father and inside buttons are grand child to it
	      *       i)  only three buttons are having button tag
	      *       ii) For Refresh button it is having seperate input tag so taking separtely
	      * 
	      */
	     
	     driver.findElement(By.xpath("//div[@class='container']/descendant::button[text()='Reset']")).click();
	     
	     driver.findElement(By.xpath("//div[@class='container']/descendant::input[@name='refreshbtn']")).click();
	     
	     
	     
	     /*
	      *  6. Ancestor
	      *  
	      *     i) Taking from button tag to grand parent so that parent will also be included
	      *     ii) If we use ancestor-or-self tag the current element from we are inspecting
	      *     it will also be added
	      * 
	      * 
	      * 
	      */
	     
	     driver.findElement(By.xpath("//div[@class='buttons']/ancestor::div"));
	     
	     
	  //2.   driver.findElement(By.xpath("//div[@class='buttons']/ancestor-or-self::div"));
	     
	     
	     /*
	      * 
	      * 7. Following - Just it will show from the next element but common is parent
	      * 
	      */
	     
	     driver.findElement(By.xpath("//label[text()='Password']/following::input[@type='password'][2]"));
	     
	     
	     /*
	      * 
	      * 8. Preceding - Just it will show from the previous element
	      * 
	      */
	     
	     
	     
	     
	
	}

}
