package AllPractice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleByMultipleTabsWindows {

	public static void main(String[] args) throws InterruptedException 
	{
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		
		WebElement button4=driver.findElement(By.xpath("//button[@onclick='newBrowserTabs()']"));
		JavascriptExecutor jse= (JavascriptExecutor)driver; 
		jse.executeScript("arguments[0].scrollIntoView()",button4);
		jse.executeScript("arguments[0].click()",button4);
		
		String parentwindow=driver.getWindowHandle();
		System.out.println(driver.getTitle());
		
		Set<String> windowhandles=driver.getWindowHandles();
		Iterator itr=windowhandles.iterator();
		
		for(String window:windowhandles)
		{
			if(!window.equals(parentwindow))
			{
				driver.switchTo().window(window);
				driver.manage().window().maximize();
				TimeUnit.SECONDS.sleep(3);
				String var=driver.getTitle();
				System.out.println(var); 
			   
				if(var.contentEquals("Basic Controls - H Y R Tutorials"))
				{
					
					System.out.println("Entering into Basic controls page");
					driver.findElement(By.xpath("//input[@name='fName']")).sendKeys("Chandu");
					
					driver.findElement(By.xpath("//input[@name='lName']")).sendKeys("Jollu");
					
					driver.findElement(By.xpath("//input[@id='femalerb']")).click();
					
					driver.findElement(By.xpath("//input[@id='englishchbx']")).click();
					
					driver.findElement(By.xpath("//input[@class='bcCheckBox']//following::input[@id='hindichbx']")).click();
					
					TimeUnit.SECONDS.sleep(3);
					
					driver.findElement(By.xpath("//button[@onclick='clearFeilds()']")).click();
					
					driver.close();
					
				}
				
				
				
				else if(var.contentEquals("AlertsDemo - H Y R Tutorials"))
				{
					System.out.println("Entering into AlertsDemo practice page");
					
					
					driver.findElement(By.id("alertBox")).click();
					
					Alert al= driver.switchTo().alert();
					
					TimeUnit.SECONDS.sleep(2);
					
					al.accept();
					
					driver.findElement(By.id("confirmBox")).click();
					
					TimeUnit.SECONDS.sleep(2);
					
					al.dismiss();
					
					driver.findElement(By.id("promptBox")).click();
					
					System.out.println(al.getText()); 
					
					
					
					al.sendKeys("Sample frame");
					
					TimeUnit.SECONDS.sleep(5);
					
					al.accept();
					
					driver.close();
					
				}
				
				else 
				{
					
					System.out.println("Title mismatching for switching windows");
				}
		
		
				
			}
			
		}		
		
		driver.switchTo().window(parentwindow);
		TimeUnit.SECONDS.sleep(3);
		System.out.println(driver.getTitle());
		driver.close();

		
		
	}

}
