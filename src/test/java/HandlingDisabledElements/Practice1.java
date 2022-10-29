package HandlingDisabledElements;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practice1 {

	public static void main(String[] args) throws InterruptedException 
	{

		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		driver.get("https://selectorshub.com/xpath-practice-page");
		
		
		//driver.findElement(By.xpath("//*[name()='svg' and @style='enable-background:new 0 0 24 24;']")).click();
		//Because it is disabled need to click on  above the button
		
		Thread.sleep(3000);
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("document.querySelector(\"input[placeholder='First Enter name']\").disabled=false");
		driver.findElement(By.xpath("//input[@placeholder='First Enter name']")).sendKeys("Mukesh");
		
		
		
		//But for below last name there is no button so need to enable through javascript and should use disabled as false
		
	
		js.executeScript("document.querySelector(\"input[placeholder='Enter Last name']\").disabled=false");
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Last name']")).sendKeys("smart");
		
		Thread.sleep(2000);
		
		WebElement car=driver.findElement(By.id("cars"));
		
		Select sel= new Select(car);
		
		sel.selectByVisibleText("Audi");
		//Directly we cannot inspect element and scroll in webpage soshould use point location
		WebElement usertable=driver.findElement(By.xpath("//div[@class='elementor-element elementor-element-da25664 elementor-widget elementor-widget-html']"));
		Point loc=usertable.getLocation();
		js.executeScript("window.scrollBy"+loc);
		
		
		
		
	}

}
