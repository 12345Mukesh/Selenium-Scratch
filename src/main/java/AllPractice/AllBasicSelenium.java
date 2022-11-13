package AllPractice;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.inject.Key;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class AllBasicSelenium {

	public static void main(String[] args) throws Throwable {
		/*
		 * @Author="Mukesh"
		 * 
		 * @Type="Functional Testing"
		 * 
		 * @Description="Basic OverAll Selenium"
		 * 
		 */
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().window().maximize();

		/*
		 * 1. Basic Details Name, Phone, Email, Password, Address Clicking on Submit
		 * button
		 */
		driver.findElement(By.id("name")).sendKeys("Mukesh");
		driver.findElement(By.id("phone")).sendKeys("6281963899");
		driver.findElement(By.id("email")).sendKeys("cmukesh391@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Mukesh@12345#");
		driver.findElement(By.id("address")).sendKeys("1-158, Raja Street, Thondavada");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(3000);

		/*
		 * 2. Selecting the Gender Radio button
		 */
		driver.findElement(By.id("male")).click();

		/*
		 * 3.Which days of the week are best to start something new? Selecting the
		 * particular check box
		 */
		Thread.sleep(3000);
		WebElement loc = driver
				.findElement(By.xpath("//label[text()='Which days of the week are best to start something new?']"));
		Point p = loc.getLocation();

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy" + p);

		driver.findElement(By.id("monday")).click();

		/*
		 * 4. Selecting the dropdown of Static one
		 */

		WebElement dropdown = driver.findElement(By.xpath("//select[@class='custom-select']"));
		Select sel = new Select(dropdown);
		sel.selectByVisibleText("Finland");

		/*
		 * 5. Selecting the CheckBox & Radio Button practice Xpath
		 */
		// Check box
		Thread.sleep(3000);
		WebElement automation = driver
				.findElement(By.xpath("//label[text()='Years of experience in test automation']"));
		Point p1 = automation.getLocation();
		jse.executeScript("window.scrollBy" + p1);
		driver.findElement(By.xpath("//label[text()='3 years']")).click();

		// Radio button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[contains(text(),'Selenium Webdriver')]")).click();

		driver.findElement(By.xpath("//label[contains(text(),'Cucumber')]")).click();

		driver.findElement(By.xpath("//label[contains(text(),'TestNG')]")).click();

		/*
		 * 6. Uploading the File
		 */

		/*
		 * when performing the click action on the upload file Even though there is id
		 * as file we are getting
		 * 
		 * 
		 * Invalid Argument Exception(Element is not clicking), So need to perform using
		 * JavascriptExecutor to click on particular button
		 */

		WebElement button = driver.findElement(By.xpath("//input[@id='inputGroupFile02']"));

		jse.executeScript("arguments[0].click()", button);

		/*
		 * Now need to perform Three operations using Robot class 1. Copy the file to
		 * clipboard 2. Pasting the file(using Key Press and Key Release methods) 3.
		 * Pressing on Enter to submit(Same as Key Press and Key Release methods)
		 */

		Robot rb = new Robot();
		rb.delay(3000);

		// 1.copying the file to clipboard
		StringSelection ss = new StringSelection("C:\\Users\\Mukesh\\Desktop\\Offer - S Mukeshali.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// 2.pasting the file using press and Release methods
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		// 3. Pressing on Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		Date currentdate = new Date();
		String screenshot = currentdate.toString().replace(":", "-");
		System.out.println(screenshot);

		// 1.Full page screenshot

		Screenshot screen = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
				.takeScreenshot(driver);

		ImageIO.write(screen.getImage(), "PNG",
				new File("./screenshot/AllBasicFullPageScreenshot'" + screenshot + "'.png"));

		driver.quit();

	}

}
