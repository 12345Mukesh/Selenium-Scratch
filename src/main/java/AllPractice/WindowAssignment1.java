package AllPractice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowAssignment1 
{

	public static void main(String args[]) throws InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		
		TimeUnit.SECONDS.sleep(3);

		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		TimeUnit.SECONDS.sleep(3);
		
		Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]

		Iterator<String>it = windows.iterator();

		String parentId = it.next();

		String childId = it.next();

		driver.switchTo().window(childId);

		String childtitle=driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
		System.out.println(childtitle);
		
		driver.close();
		
		driver.switchTo().window(parentId);
		
		String parenttitle=driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText();
		System.out.println(parenttitle);
		
		driver.quit();
		
		

		
		
	}
	
}
