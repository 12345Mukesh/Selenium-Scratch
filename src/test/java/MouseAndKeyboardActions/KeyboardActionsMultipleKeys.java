package MouseAndKeyboardActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActionsMultipleKeys {

	public static void main(String[] args)
	{
	
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		  driver.get("https://text-compare.com/");
		  String url=driver.getCurrentUrl();
		  System.out.println(url);
		
		//Moving Text from one box to another box
		  
		  WebElement input1 = driver.findElement(By.id("inputText1"));
		  
		  WebElement input2 = driver.findElement(By.id("inputText1"));
		  
		  input1.sendKeys("welcome to selenium");
		  
		  Actions ac= new Actions(driver);
		  
		  //selecting the text(CTRL+A)
		  //for doing any action need to use both keys keydown and up
		  
		  ac.keyDown(Keys.CONTROL); //key press
		  ac.sendKeys("a");
		  ac.keyUp(Keys.CONTROL);  //key release
		  ac.perform();
		  
		  
		  //copying the text(CTRL+C)
		  ac.keyDown(Keys.CONTROL); //key press
		  ac.sendKeys("c");
		  ac.keyUp(Keys.CONTROL);  //key release
		  ac.perform();
		  
		  
		  
		  //shift to next tab by pressing tab key
		  ac.sendKeys(Keys.TAB);
		  ac.perform();
		  
		  
		  //pasting the text(CTRL+V)
		  ac.keyDown(Keys.CONTROL); //key press
		  ac.sendKeys("v");
		  ac.keyUp(Keys.CONTROL);  //key release
		  ac.perform();
		  
		  
		  //compare text
		  
		  if(input1.getAttribute("value").equals(input2.getAttribute("value")))
		  {
			  System.out.println("Text copied");
		  }
		  
		  else
		  {
			  System.out.println("Text not copied");
		  }
	}

}
