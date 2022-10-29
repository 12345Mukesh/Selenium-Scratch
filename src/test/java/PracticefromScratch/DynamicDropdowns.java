package PracticefromScratch;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdowns {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		  driver.get("https://www.flipkart.com");
		  String url=driver.getCurrentUrl();
		  System.out.println(url);
		  driver.findElement(By.xpath("//button[text()='✕']")).click();
		  //Selecting list in drop down
		  
		  driver.findElement(By.xpath("//input[@class='_3704LK' and @name='q']")).sendKeys("poco");
			Thread.sleep(5000);
		  List<WebElement> al=driver.findElements(By.xpath("//span[text()='poco x3']"))	;	
		System.out.println(al.size());
		
		Thread.sleep(5000);
		int a=0;
		 for(int i=0;i<al.size()-1;i++)
		 {
			 if(al.get(i).getText().equals("poco x3"))
			 {
				 a=i;
				 System.out.println(a);
			 }
		 
		 }
    al.get(a).click();
	}

}
