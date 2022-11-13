package AllPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SvgTags {

	public static void main(String[] args) 
	{
	
		System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		
		WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys("Admin");
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
		
		
		// All the images in the orangeHRM are svg tags only
		
		WebElement SvgTimeSheet=	driver.findElement(By.xpath("//button[@title='Timesheets']//*[local-name()='svg' and  @class='oxd-icon']"));
		
		
		
		
		
		
		
		
		
		
		
	}

}
