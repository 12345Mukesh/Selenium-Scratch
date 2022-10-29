package PracticefromScratch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InstagramLogin {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		  driver.get("https://www.instagram.com");
		  String url=driver.getCurrentUrl();
		  System.out.println(url);
		  String title=driver.getTitle();
		  System.out.println(title);
         
		  driver.findElement(By.name("username")).sendKeys("7702658809");
		  driver.findElement(By.name("password")).sendKeys("chanduM");
		  driver.findElement(By.xpath("//div[text()='Log In']")).click();
		  
		  //If login fails need to link on it
		  driver.findElement(By.xpath("//span[text()='Log in with Facebook']"));
		  
		  
	}

}
