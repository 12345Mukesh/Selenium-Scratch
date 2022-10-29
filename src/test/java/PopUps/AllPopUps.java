package PopUps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllPopUps {

	public static void main(String[] args) throws InterruptedException 
	{
	
		
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		 
		  driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		
		driver.findElement(By.id("alertBox")).click();
		
		Thread.sleep(3000);
		Alert al= driver.switchTo().alert();
		al.accept();
		
		driver.findElement(By.id("confirmBox")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.id("confirmBox")).getText());
		Alert ale= driver.switchTo().alert();
		ale.dismiss();
		
		driver.findElement(By.id("promptBox")).click();
		Alert aler=driver.switchTo().alert();
		System.out.println(driver.findElement(By.id("promptBox")).getText());
		System.out.println("The text in the popup is : " + aler.getText());
		aler.sendKeys("Mukesh Smart");
		Thread.sleep(2000);
		aler.accept();
		
		
		
		
		
		
		
		

	}

}
