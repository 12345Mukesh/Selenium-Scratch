package PracticefromScratch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		  driver.get("https://www.facebook.com");
		  String url=driver.getCurrentUrl();
		  System.out.println(url);
		  String title=driver.getTitle();
		  System.out.println(title);
		  String actualtitle="Facebook – log in or sign up";
		  if(title.equals(actualtitle))
		  {
			  System.out.println("yes it is displayed correctly");
		  }
		  else
		  {
			  System.out.println("wrong url");
		  }
		
		
		  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("7702658809");
		  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("chanduM");
		  
		  driver.findElement(By.xpath("//button[@name='login']")).click();
		  
		  //Explicit wait used because our Homepage title was not matching normally
		  //and it will perform on only particular title
		  WebDriverWait wait= new WebDriverWait(driver, 30);
		  wait.until(ExpectedConditions.titleContains("Facebook"));
		  String actualtitle1=driver.getTitle();
		  System.out.println(actualtitle1);
		  String expectedtitle="Facebook";
		  if(actualtitle1.equals(expectedtitle))
		  {
			  System.out.println("yes home page is opened");
		  }
		  
		
		 driver.quit();
		
		
		

	}

}
