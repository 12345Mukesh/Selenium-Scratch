package MouseAndKeyboardActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoActiTimedoubleClick {

	public static void main(String[] args) 
	{
	
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		  driver.get("https://demo.actitime.com/login.do");
		  String url=driver.getCurrentUrl();
		  System.out.println(url);
		  String title=driver.getTitle();
		  System.out.println(title);
		
		  driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		  
		  // driver.findElement(By.name("pwd")).sendKeys("manager");
		  
		  //apart from xpath everytag 1.tagname 2.id 3.name 4.classname 5.linktext 6.partial linktext
		  //can given directly
		  driver.findElement(By.xpath("//input[@type='password'  and @name='pwd']")).sendKeys("manager");
		  
		  driver.findElement(By.xpath("//input[@type='checkbox']")).click();

	      WebElement login=  driver.findElement(By.xpath("//div[text()='Login ']"));
	      
	      Actions ac= new Actions(driver);
	      ac.doubleClick(login).perform();
	      
	      
	      
	      
	      
	      
	      driver.close();
	      
	      
	      
	      
	      
	      
	      
	      
	   
		
		
		
		
		
		
		
		
		
		
		

	}

}
