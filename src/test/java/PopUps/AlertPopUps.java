package PopUps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopUps {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		  
       Thread.sleep(10000);
		  //First clicking on JS Alert button so that the Alert popup will open 
		  driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		
		  //1.Alert window with ok button
		Thread.sleep(3000);
		Alert al= driver.switchTo().alert();
		al.accept();
		
		//2.Alert window with ok and cancel buttons
		
		  driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		  Thread.sleep(3000);
		  Alert ale= driver.switchTo().alert();
			ale.accept();
			
		//3.Alert window with input box
			
			driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
			Thread.sleep(3000);
			
			 Alert aler= driver.switchTo().alert();
			System.out.println("Message displayed in Alert box is :  " + aler.getText());	
			
			//we can send text in alert pop up if text box is there
			aler.sendKeys("Only for Alert popups");
			aler.accept();
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
