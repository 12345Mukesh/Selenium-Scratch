package AllPractice;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class SWAGLabs {

	public static void main(String[] args) throws Throwable 
	{
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
       driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    
       WebElement jacket=  driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']"));
	  Point p=jacket.getLocation();	
     JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy"+p);
	
	driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket' and text()='Add to cart']")).click();	
	
	Thread.sleep(3000);
	WebElement menubtn=driver.findElement(By.xpath("//button[text()='Open Menu']"));
	Point p1= menubtn.getLocation();
	jse.executeScript("window.scrollBy"+p1);
	
	Actions ac= new Actions(driver);
	ac.moveToElement(menubtn).click().perform();
	Thread.sleep(2000);
	
    WebElement cartbtn=driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));	
    cartbtn.click();
    
    Thread.sleep(3000);
    WebElement checkoutbtn=driver.findElement(By.name("checkout"));
    checkoutbtn.click();
    
    driver.findElement(By.id("first-name")).sendKeys("Mukesh");
    driver.findElement(By.id("last-name")).sendKeys("Smart");
    driver.findElement(By.id("postal-code")).sendKeys("517502");
    Thread.sleep(3000);
    driver.findElement(By.id("continue")).click();
    
    WebElement checkouttitle=driver.findElement(By.xpath("//span[text()='Checkout: Overview']"));
    
    WebDriverWait wait= new WebDriverWait(driver,30);
    wait.until(ExpectedConditions.visibilityOf(checkouttitle));
    
    Date date= new Date();
	String screenshot = date.toString().replace(":", "-");
	System.out.println(screenshot);
	
	Screenshot screen= new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
	ImageIO.write(screen.getImage(), "PNG", new File("./screenshot/SWAGLabs'" + screenshot + "'.png"));
	
	
	
	driver.findElement(By.id("finish")).click();
		
	driver.findElement(By.id("back-to-products")).click();
	
	driver.close();
		
	}

}
