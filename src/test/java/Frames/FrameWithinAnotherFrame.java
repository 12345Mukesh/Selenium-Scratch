package Frames;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameWithinAnotherFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		 
		  driver.get("https://demo.automationtesting.in/Frames.html");
		  
		//clicking on the iframe button
		  driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
		  
		   
		//In the previous script for the webpage directly the target has text so we directly added
		//in driver.switchto.frame()
		  //But in this script there is only that particular link so we are copying from the weblink
		  //1.First taking the outer frame
     WebElement outerframe=     driver.findElement(By.xpath(" //*[@id='Multiple']/iframe"));
      driver.switchTo().frame(outerframe);
      
      //2.Now going to inner frame
      //Here we are directly going because it is nested in outer frame
      WebElement innerframe=driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
      driver.switchTo().frame(innerframe);
      
      driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Frames.net");
      
      driver.close();
      
	
        
	
	
	
	
	}

}
