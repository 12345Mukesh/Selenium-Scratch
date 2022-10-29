package MouseAndKeyboardActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		  driver.get("https://the-internet.herokuapp.com/key_presses");
		  String url=driver.getCurrentUrl();
		  System.out.println(url);
		
		  Actions act= new Actions(driver);
		  act.sendKeys(Keys.ENTER).perform();
		  
		   Thread.sleep(3000);
		  act.sendKeys(Keys.ARROW_DOWN).perform();
					
		    Thread.sleep(3000);
		    
		    act.sendKeys(Keys.BACK_SPACE).perform();
		    
		    Thread.sleep(3000);
		    
		    act.sendKeys(Keys.CLEAR).perform();
			
			
		    
		    
		
		

	}

}
