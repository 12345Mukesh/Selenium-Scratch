package AllPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowRoot1 {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://books-pwakit.appspot.com");
		driver.manage().window().maximize();
		
		//checking by using css selector
		                         //  tagname and id
	//	driver.findElement(By.cssSelector("input#input")).sendKeys("testing");
		
		//Giving no such element exception because of Shadow DOM
		// Nested shadow dom is there so need to start from parent dom
		// so using JavascriptExecutor need to get shadow dom

  //1.First getting the normal one 		
WebElement root=driver.findElement(By.tagName("book-app")); // Shadow Host / Root Element
		
  //2.First Shadow element
   //starting the inspecting using JavascriptExecutor
  JavascriptExecutor js= (JavascriptExecutor)driver;
  // For Nested shadow dom we taking the output as variable again
  WebElement shadowDom1=(WebElement) js.executeScript("return arguments[0].shadowRoot", root);
  
//3. Inspecting the normal element   
  WebElement appheader=shadowDom1.findElement(By.tagName("app-header"));
  
  //4. Second shadow root element started
  WebElement apptoolbar=appheader.findElement(By.cssSelector("app-toolbar.toolbar-bottom"));
  
  //5. Inspecting the normal element
 WebElement bookinputdecorator= apptoolbar.findElement(By.tagName("book-input-decorator"));
  
  bookinputdecorator.findElement(By.cssSelector("input#input")).sendKeys("Testing");
  
  
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
