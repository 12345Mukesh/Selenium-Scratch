package MouseAndKeyboardActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartmoveToElement {

	public static void main(String[] args) 
	{
	
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		  driver.get("https://www.flipkart.com");
		  String url=driver.getCurrentUrl();
		  System.out.println(url);
		  driver.findElement(By.xpath("//button[text()='✕']")).click();
		  
		  //1.0Inspecting the Fashion element
		  WebElement fashion=driver.findElement(By.xpath("//div[@class='_1psGvi SLyWEo']/descendant::div[text()='Fashion']"));
		  
		  //1.0.1 Moving the mouse on the mouse
		   Actions ac= new Actions(driver);
		   ac.moveToElement(fashion).perform();
		   
		 //1.1 Inspecting the Mens Bottom wear
		   //sorry second element is not inspecting correctly gave mens bottom wear but selecting mens top wear
		   WebElement mensbottomwear=driver.findElement(By.xpath("//div[@class='_3XS_gI _7qr1OC']/descendant::a[@class='_6WOcW9 _2-k99T' ]"));
		   
		   //1.1.1 moving the mouse to Mens Bottom wear
		   Actions ac1= new Actions(driver);
		   ac1.moveToElement(mensbottomwear).perform();
		   
		 // 1.2 clicking on mens cargos
		   
		  WebElement abc= driver.findElement(By.xpath("//div[@class='_3XS_gI']/descendant::a[@class='_6WOcW9 _3YpNQe'][6]"));
		  System.out.println(abc);
		 abc.click();

	}

}
