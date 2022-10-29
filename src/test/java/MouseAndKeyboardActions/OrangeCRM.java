package MouseAndKeyboardActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeCRM {

	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		  driver.get("https://opensource-demo.orangehrmlive.com/");
		  String url=driver.getCurrentUrl();
		  System.out.println(url);
		 
		   driver.findElement(By.name("username")).sendKeys("Admin");
		    driver.findElement(By.name("password")).sendKeys("admin123");
		   driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		   
		   //sorry the application has changed from mouse over to drop down
		   
		   driver.findElement(By.xpath("//button[@class='oxd-icon-button oxd-main-menu-button']")).click();
		   
		   driver.findElement(By.xpath("//span[@class='oxd-topbar-body-nav-tab-item']")).click();

	}

}
