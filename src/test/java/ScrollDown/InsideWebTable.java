package ScrollDown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsideWebTable {

	public static void main(String[] args)
	{
		
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
		
		
		//clicking on language link at the bottom of page
		driver.findElement(By.xpath("//span[text()='‪English (United Kingdom)‬']")).click();
		
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		//inspecting the dropdown of the language link
	WebElement link=driver.findElement(By.xpath("//div[@class='OA0qNb ncFHed']"));
		
	
		//using document.queryselector to scroll directly
	 //It works for only RemoteWebDriver
	//   js.executeScript("window.scrollBy"+link);
	
      //when we try to add scroll by to this document in console it is not showing the list
		js.executeScript("document.querySelectorAll(\"OA0qNb ncFHed\").scrollBy(0,500) ");
		
		
		
		
		

	}

}
