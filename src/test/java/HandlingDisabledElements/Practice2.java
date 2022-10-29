package HandlingDisabledElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice2 {

	public static void main(String[] args)
	{
	
		WebDriver driver= new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://courses.letskodeit.com/practice");

		//clicking on hide button
		driver.findElement(By.xpath("//input[@id='hide-textbox']")).click();
		
	//	driver.findElement(By.xpath("//input[@id='displayed-text']")).sendKeys("Mukesh");
		
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("document.getElementById(\'displayed-text\').value='Mukesh'");
		
		
	}

}
