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

public class WindowHandleByMultipleTabsAndWindows {

	public static void main(String[] args) throws InterruptedException
	{
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		
		WebElement button5=driver.findElement(By.id("newTabsWindowsBtn"));
		JavascriptExecutor jse= (JavascriptExecutor)driver; 
		jse.executeScript("arguments[0].scrollIntoView()",button5);
		jse.executeScript("arguments[0].click()",button5);
		
		String parentwindow=driver.getWindowHandle();
		System.out.println(driver.getTitle());
		
		Set<String> windowhandles=driver.getWindowHandles();
		//Iterator itr=windowhandles.iterator();
		
		for(String window:windowhandles)
		{
			if(!window.equals(parentwindow))
			{
				driver.switchTo().window(window);
				System.out.println(window);
				driver.manage().window().maximize();
				TimeUnit.SECONDS.sleep(3);
				String var=driver.getTitle();
				System.out.println(var); 
			
			//navigating to basic controls tab and filling the details 
			driver.switchTo().window(window);
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
			
			else if(var.contentEquals("XPath Practice - H Y R Tutorials"))
			{
				System.out.println("Entering into Xpath practice page");
				
				driver.manage().window().maximize();
				
				driver.findElement(By.xpath("(//input[@name='name'])[1]")).sendKeys("Rahul");
				
				driver.findElement(By.xpath("(//input[@name='name'])[2]")).sendKeys("shetty");
				
				TimeUnit.SECONDS.sleep(3);
				
				driver.findElement(By.name("refreshbtn")).click();
				
				driver.close();
				
								
			}
			
			else if(var.contentEquals("Contact Me - H Y R Tutorials"))
			{
				System.out.println("Entering into contact me page");
				driver.findElement(By.xpath("(//input[@id='ContactForm1_contact-form-name'])[1]")).sendKeys("Sample");
				
				TimeUnit.SECONDS.sleep(3);
				driver.close();
				
			}
			
			else
			{
				System.out.println("Windows mismatched");
			}
			
			
			}
		
			
		
		}
		
		driver.switchTo().window(parentwindow);
		TimeUnit.SECONDS.sleep(3);
		System.out.println("All windows closed - switched to parent window");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		driver.close();
		
		
		
		
	}

}
