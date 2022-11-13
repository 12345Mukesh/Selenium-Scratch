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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class OrangeHRMPractice {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

		/*
		 * Buttons are not clicking and sending text when going to third page of Scripting
		 * Throwing Element Click Intercepted Exception
		 * 
		 */
		
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys("Admin");
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("admin123");

		driver.findElement(
				By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"))
				.click();

		WebElement cursor = driver.findElement(By.xpath("//button[@class='oxd-icon-button oxd-main-menu-button']"));

		Actions ac = new Actions(driver);
		ac.moveToElement(cursor).build().perform();
		// For just normal click method
		cursor.click();

		// using svg tags rather than hardcoding going from parent to chid
		//clicking on TimeSheets
		WebElement SvgTimeSheet = driver
				.findElement(By.xpath("//button[@title='Timesheets']//*[local-name()='svg' and  @class='oxd-icon']"));
		SvgTimeSheet.click();
        Thread.sleep(3000);
	//	cursor.click();
		
		
		//Clicking on Project Info on Header
		WebElement projects=driver.findElement(By.xpath("//span[text()='Project Info ']"));
		projects.click();
		//***---------- Now clicking on projects in the dropdown(Its dynamic so need of select class)---*****//
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		
		
		//Scrolling down to already present project Global Corp and Co
		WebElement Global=driver.findElement(By.xpath("//div[text()='Global Corp and Co']/following::div[text()='Global Software phase - 1']"));
		Point p= Global.getLocation();
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy"+p);
		Thread.sleep(2000);
		
		//******--- Going xpath from parent to child with this one-------******//
		driver.findElement(By.xpath("//div[text()='Global Corp and Co']/following::div[text()='Global Software phase - 1']/following::button[@class='oxd-icon-button oxd-table-cell-action-space']/following::i[@class='oxd-icon bi-pencil-fill']")).click();
		
		
		//----****  Now inside the Global corp giving some details****-------//
		//Giving some description
		driver.findElement(By.xpath("//textarea[@class=\"oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical\"]")).sendKeys("Never Ever Give UP, Dont think about Others, That will make you weak, Live In your Own World");
		//Giving the project
		//Some elements getting Element Not Interactable Exception
	   driver.findElement(By.xpath("(//div[@class='oxd-autocomplete-wrapper'])[2]//input[@placeholder='Type for hints...']")).sendKeys("Mukesh Smart");
		
		
		//scroll down to QA Testing
		WebElement QATest=driver.findElement(By.xpath("//div[text()='QA Testing']/following::div[@class='oxd-table-cell-actions']/button[@class='oxd-icon-button oxd-table-cell-action-space'][2]"));
       Point p1= QATest.getLocation();
       jse.executeScript("window.scrollBy"+p1);
		
		//Now modifying on QA Testing (selecting the pencil button)
		driver.findElement(By.xpath("//div[text()='QA Testing']/following::div[@class='oxd-table-cell-actions']/button[@class='oxd-icon-button oxd-table-cell-action-space'][2]")).click();
		//changing the name
		driver.findElement(By.xpath("//div[@class='oxd-form-row']/descendant::input[@class='oxd-input oxd-input--active']")).sendKeys("AQA Testing");
		//clicking on save btn
		WebElement QAsave=driver.findElement(By.xpath("//div[@class='oxd-form-actions']/following::button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
        
		jse.executeScript("arguments[0].click();", QAsave);
		
		//clicking on check box of project management
	WebElement projectman=	driver.findElement(By.xpath("(//i[@class='oxd-icon bi-check oxd-checkbox-input-icon'])[7]"));
	jse.executeScript("arguments[0].click();", projectman);
	
		
		//------------***** Now going again to top save button*******--------------
		
		WebElement SAVE=driver.findElement(By.xpath("//button[text()=' Save ']"));
		Point p2=SAVE.getLocation();
		jse.executeScript("window.scrollBy"+p2);
		Thread.sleep(3000);
		
		
		Date date= new Date();
		String screenshot = date.toString().replace(":", "-");
		System.out.println(screenshot);
		
		Screenshot screen= new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(screen.getImage(), "PNG", new File("./screenshot/OrangeHRM'" + screenshot + "'.png") );
		
		jse.executeScript("arguments[0].click();", SAVE);
		
		
		
		driver.quit();
		
		
		
		
		
	}

}
