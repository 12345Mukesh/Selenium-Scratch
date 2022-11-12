package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardandSoftAssertions 
{

	@Test()
	public void verify()
	{
		WebDriver driver= new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver.get("https://demo.actitime.com/login.do");
	//	Assert.assertEquals(driver.getTitle(), "actiTIME - Log");
	//Hard assert should be given for mandatory fields like titles and other thing	
		
		SoftAssert sa= new SoftAssert();
		sa.assertEquals(driver.getTitle(), "actiTIME - Log");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		//Even if assertion fails it will enter username and password in the fields and will click on login button
		//For every soft assert must and should give sa.assertAll() at the end
		sa.assertAll();
		
		
		
	}
	
	
	
	
}
