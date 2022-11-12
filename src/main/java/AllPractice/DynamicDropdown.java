package AllPractice;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBys;

public class DynamicDropdown {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/webhp");
		driver.manage().window().maximize();
		
		String expecteddata="qspiders kphb";
		
	WebElement searchbox=	driver.findElement(By.name("q"));
	               searchbox.sendKeys("QSpiders");
	               
	           
		 
		List<WebElement> list= driver.findElements(By.xpath("(//ul[@class='G43f7e' and @role='listbox'])[1]/descendant::*"));
		
	
		  for(WebElement value:list)
		  {
			 String data=value.getText();
			 System.out.println(data);
			 if(data.equals(expecteddata))
			 {
				 System.out.println("Institute Name is:" + data);
				 value.click();
			 }
		 
		}
 
	
	}

}
