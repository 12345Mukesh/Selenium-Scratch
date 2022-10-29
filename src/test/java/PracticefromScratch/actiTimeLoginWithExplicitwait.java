package PracticefromScratch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class actiTimeLoginWithExplicitwait {

	public static void main(String[] args) {
		
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

	      driver.findElement(By.xpath("//div[text()='Login ']")).click();
	   
	      WebDriverWait wait= new WebDriverWait(driver, 30);
	      wait.until(ExpectedConditions.titleContains("actiTIME - Enter Time-Track"));
	      
	     String hometitle= driver.getTitle();
	     System.out.println(hometitle);
	     
	     String actualtitle="actiTIME - Enter Time-Track";
	     
	     if(actualtitle.equals(hometitle))
	     {
	    	 System.out.println("yes actiTIME good application");
	     }
	     else
	     {
	    	 System.out.println("some mistake is there");
	     }

	   driver.close();
	
	}

}
