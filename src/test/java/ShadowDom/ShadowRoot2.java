package ShadowDom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowRoot2 {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://shop.polymer-project.org");
		driver.manage().window().maximize();
		
		
		//1.Root node/shadow host
    WebElement root= driver.findElement(By.tagName("shop-app"));
   WebElement shadowDom1= getShadowDOM(root, driver);
   
   //2. Normal Element 
    WebElement ironpages=shadowDom1.findElement(By.tagName("iron-pages"));
		
  WebElement shophome=ironpages.findElement(By.name("home"));
    
  WebElement shadowdom2=getShadowDOM(shophome, driver);
  
  shadowdom2.findElement(By.cssSelector("div:nth-child(2) > shop-button > a"));
    
	
	
	}

	
	 static WebElement getShadowDOM(WebElement element, WebDriver driver)
	{
		 JavascriptExecutor js= (JavascriptExecutor)driver;
		 WebElement shadowDom1=(WebElement) js.executeScript("return arguments[0].shadowRoot", element);
		 
		return shadowDom1;
		
		
	}
	
	
	
	
	
	
	
	
	
}
