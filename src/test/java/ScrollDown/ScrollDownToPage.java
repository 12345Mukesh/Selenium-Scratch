package ScrollDown;

import java.awt.Window;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.internal.AbstractParallelWorker.Arguments;

public class ScrollDownToPage {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		  driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		  
		  
		  JavascriptExecutor js= (JavascriptExecutor)driver;
		  
		  //1.scrolling down using pixel
		 js.executeScript("window.scrollBy(0,1000)", "");
		  
		
		  //2.scrolling page till we find the element
		WebElement text=driver.findElement(By.xpath("//td[text()='India']"));
		js.executeScript("arguments[0].scrollIntoView()", text);
		
		//3.scroll down till bottom
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		
		

	}

}
