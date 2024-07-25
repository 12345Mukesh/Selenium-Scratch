package AllPractice;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBys;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicDropdown {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().clearDriverCache().setup();
		//System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/webhp");
		driver.manage().window().maximize();
		
		String expecteddata="qspiders gurugram reviews";
		
	WebElement searchbox=	driver.findElement(By.xpath("//textarea[@name='q']"));
	               searchbox.sendKeys(expecteddata);
	               
	           
		 
		List<WebElement> list= driver.findElements(By.xpath("(//ul[@class='G43f7e' and @role='listbox'])[1]"));
		WebElement selectedvalue = driver.findElement(By.xpath("(//ul[@class='G43f7e'])[1]//descendant::span[text()='"+expecteddata+"']"));
	
		  for(WebElement value:list)
		  {
			 String data=value.getText();
			 //System.out.println(data);
			 if(data.contains(expecteddata))
			 {
				 System.out.println("Institute Name is:" + data);
				 selectedvalue.click();
				 break;
			 }
		 
			 
		}
 
		
	
	}

}
