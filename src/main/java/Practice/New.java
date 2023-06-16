package Practice;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class New {

	public static void main(String[] args) 
	{
		
		//Initializing the browser with the properties
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		//Launching the browser
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		//giving waiting time for the page to load
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//Giving the username and password to login
		
	WebElement username=	driver.findElement(By.id("user-name"));
		username.sendKeys("standard_user");
		
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
		
	WebElement button=	driver.findElement(By.xpath("//input[@class='submit-button btn_action']"));
		button.click();
		
		
		
		//Checking the Homepage title
		
	String Expectedtitle= "Swag Labs saucedemo.com"	;
	String Actualtitle=	driver.getTitle();
		
	
	if(Actualtitle.equals(Expectedtitle))
	{
		System.out.println("Home page is opened");
	}
	
	else
	{
		System.out.println("wrong title given");
	}
	
	//Selecting two items 
	 WebElement saucelabsbikelight= driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
	 saucelabsbikelight.click();
	 
	 driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	 
	 
	 WebElement cart=driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
	 
	 Actions ac= new Actions(driver);
	 ac.moveToElement(cart).click().perform();
	 
	 
	 WebElement cartbox=driver.findElement(By.xpath("//span[text()='Your Cart']"));
	String carttitle= cartbox.getText();
	 
//	 if(carttitle.equals("Your Cart"))
//	 {
//		 System.out.println("cart page is opened");
//	 }
//	 else
//	 {
//		 System.out.println("cart page is not displayed");
//	 }
	 
	 
	// driver.findElement(By.id("continue-shopping")).click();
	 
	 driver.findElement(By.xpath("//button[text()='Checkout']")).click();
	 
	 
	// driver.quit();	
	}

}
