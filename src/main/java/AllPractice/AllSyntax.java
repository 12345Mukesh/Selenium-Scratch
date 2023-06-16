package AllPractice;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class AllSyntax {

	public static void main(String[] args) throws Throwable {

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// 1.Initiation Methods
		driver.get("https://www.google.com");

		// 2.Page Verification Methods
		driver.getCurrentUrl();
		driver.getPageSource();
		driver.getTitle();

		// 3. Data Capture Methods
		driver.getWindowHandle();
		driver.getWindowHandles();

		// 4. Browser Window Handling Methods
		driver.manage().window();

		// Changing the Dimension of Window
		Dimension dim = new Dimension(100, 500);
		driver.manage().window().setSize(dim);

		// changing the position of window
		Point p = new Point(100, 300);
		driver.manage().window().setPosition(p);

		// 5.Navigation Methods
		driver.navigate().to("https://www.google.com");
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().refresh();

		// 6.Inspection Methods
		WebElement element = driver.findElement(By.id(""));
		driver.findElement(By.name(""));
		driver.findElement(By.className(""));
		driver.findElement(By.linkText(""));
		driver.findElement(By.partialLinkText(""));
		driver.findElement(By.cssSelector(""));
		driver.findElement(By.xpath(""));

		List<WebElement> allelements = driver.findElements(By.xpath(""));
		allelements.size();

		HashSet<String> hash = new HashSet<String>();
		LinkedHashSet<String> linkhash = new LinkedHashSet<String>();
		TreeSet<String> tree = new TreeSet<String>();

		for (int i = 0; i < allelements.size(); i++) {
			// storing all the allelements WebElements by converting into text function
			// String elements= allelements.get(i).getText();
			WebElement ele = allelements.get(i);
			String alltext = ele.getText();
			System.out.println(alltext);
			hash.add(alltext);
			linkhash.add(alltext);
			tree.add(alltext);
		}

		// Now seperating each and every element using for each loop
		// Here normal alltext String is throwing error so we using sets
		for (String text : hash) {

		}

		// 7.Control switching methods

		Alert al = driver.switchTo().alert();
		al.accept();
		al.dismiss();
		al.sendKeys("abcd");
		al.getText();

		// 8. Termination Methods
		driver.close();
		driver.quit();

		// 9.Waiting Methods
		// static wait
		Thread.sleep(5000);

		// Dynamic wait
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(null));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(null));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(null));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.elementToBeSelected(element));
		wait.until(ExpectedConditions.alertIsPresent());

		// 10.Dropdowns

		/*
		 * Static
		 * 
		 * //***selection Methods For static dropdown there should be select in the tag
		 * then only we can perform the operations For static multi dropdown there
		 * should be select tag and also multiple at the end of the select tag
		 */

		Select sel = new Select(element);
		sel.selectByVisibleText(null);
		sel.selectByValue(null);
		sel.selectByIndex(0);

		// ***Deselection Methods
		sel.deselectByVisibleText(null);
		sel.deselectByValue(null);
		sel.deselectByIndex(0);
		sel.deselectAll();

		// **operational Methods

		// ---isMultiple
		if (sel.isMultiple()) {
			System.out.println("Multi select dropdown");
		} else {
			System.out.println("single select dropdown");
		}

		// ---get options
		List<WebElement> options = sel.getOptions();
		for (int i = 0; i < options.size(); i++) {
			String op = options.get(i).getText();
			System.out.println(op);
		}

		// --get all selected options

		List<WebElement> alloptions = sel.getAllSelectedOptions();
		for (int i = 0; i < alloptions.size(); i++) {
			String op = options.get(i).getText();
			System.out.println(op);
		}

		// get First select options
		WebElement op = sel.getFirstSelectedOption();
		System.out.println(op.getText());

		// get wrapped elements
		WebElement wrap = sel.getWrappedElement();
		System.out.println(wrap.getText());

		List<WebElement> alldropdownoptions = sel.getOptions();

		HashSet<String> drophash = new HashSet<String>();
		LinkedHashSet<String> droplinkhash = new LinkedHashSet<String>();
		TreeSet<String> droptree = new TreeSet<String>();

		for (int i = 0; i < alldropdownoptions.size(); i++) {
			// storing all the allelements WebElements by converting into text function
			// String elements= allelements.get(i).getText();
			WebElement ele = allelements.get(i);
			String alltext = ele.getText();
			System.out.println(alltext);
			drophash.add(alltext);
			droplinkhash.add(alltext);
			droptree.add(alltext);
		}

		// Now seperating each and every element using for each loop
		// Here normal alltext String is throwing error so we using sets
		for (String text : hash) {

		}

		// For Dynamic dropdowns since there is no select tag we will use click,clear,
		// sendkeys...
		// div[contains(text(),'video')]
		// div[normalize-space()='video']
//  	[//div[contains(text(),'abcd')]][1]	

		// 11. Mouse Events and Keyboard Events

		WebElement mouseact = driver.findElement(By.xpath(null));

		Actions ac = new Actions(driver);
		// moving the mouse
		ac.moveToElement(mouseact).click().build().perform();
		// Right click on the element
		ac.contextClick().build().perform();
		// Double click on the element
		ac.doubleClick().build().perform();
		// drag and drop
		ac.dragAndDrop(wrap, mouseact).build().perform();

		// selecting all the data // copying the data
		ac.keyDown(Keys.CONTROL);
		ac.keyDown(Keys.CONTROL);
		ac.sendKeys("a");
		ac.sendKeys("c");
		ac.keyUp(Keys.CONTROL);
		ac.keyDown(Keys.CONTROL);
		ac.perform();
		ac.perform();

		// moving to another page or another cell //pasting the data
		ac.sendKeys(Keys.TAB);
		ac.keyDown(Keys.CONTROL);
		ac.perform();
		ac.sendKeys("v");
		ac.keyUp(Keys.CONTROL);
		ac.perform();

		// ****----------------------some operation for uploading the file using robot
		// class

		// copying the data using toolkit and string selection method
		StringSelection ss = new StringSelection("some path of our local system ----c://programfiles//abc.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		Robot rb = new Robot();
		// delaying time
		rb.delay(2000);

		// selecting the data
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_A);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_A);

		// copying the data
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_C);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_C);

		// pasting the data //pressing on enter
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_V);

		// 12.JavascriptExecutor

		// Scroll down
		WebElement link = driver.findElement(By.xpath(null));
		Point po = link.getLocation();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1000)");
		jse.executeScript("window.scrollBy" + po);
		jse.executeScript("document.querySelectorAll(link).scrollBy(0,500)");
		jse.executeScript("document.querySelector(link).scrollBy(0,500)");
		jse.executeScript("arguments[0].scrollIntoview();", link);

		// For click method
		WebElement click = driver.findElement(By.xpath(null));
		// This logic is for hidden element
		jse.executeScript("arguments[0].click();", click);
		jse.executeScript("document.getElementById('some id').value='somevalue'");

		// For send keys method
		WebElement username = driver.findElement(By.id("username"));
		jse.executeScript("document.getElementById('firstname').value='testuser'");
		jse.executeScript("arguments[0].value='testuser'", username);
		
		// To handle disabled elements
				jse.executeScript("document.querySelector(\"input[placeholder='First Enter name']\").disabled=False");
				jse.executeScript("document.getElementByid('displayed-text').value='abc'");

		// To handle checkbox
		jse.executeScript("document.getElementById('enter element id').checked=false");

		// To generate Alert popup
		jse.executeScript("alert('welcome to New Practice');");

		// To refresh the browser window
		jse.executeScript("history.go(0)");

		// To get title of webpage
		String text = jse.executeScript("return document.title;").toString();
		System.out.println(text);

		// To get the domain
		String domain = jse.executeScript("return document.domain;").toString();
		System.out.println(domain);

		// To get the title
		String url = jse.executeScript("return document.URL;").toString();
		System.out.println(url);

		// To navigate to different page
		jse.executeScript("window.location='https://www.softwaretesting.com'");

		// using Remote WebDriver
		RemoteWebDriver rwd = (RemoteWebDriver) driver;
		rwd.executeScript("window.scrollBy" + link);

		// 13. Taking Screenshot(Full page and particular Element)
		Date currentdate = new Date();
		String screenshot = currentdate.toString().replace(":", "-");
		System.out.println(screenshot);

		Screenshot screen = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
				.takeScreenshot(driver);
		ImageIO.write(screen.getImage(), "PNG",
				new File("./screenshot/AllSyntaxFullPageScreenshot'" + screenshot + "'.png"));

		WebElement file = driver.findElement(By.xpath("//abc[text()='123']"));

		File src = file.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/AllSyntaxParticularElementScreenshot");
		Files.copy(src, dest);

		// 14. Handling Popups

		// 1.web based
		/*
		 * i).Java Script - It is not movable It is not inspectable It is not selected
		 * 
		 */

		Alert a = driver.switchTo().alert();
		a.accept();
		a.dismiss();
		a.sendKeys("abcd");
		a.getText();

		/*
		 * ii) Browser based popup Need to add some script before initialising webdriver
		 * with driver
		 */

		ChromeOptions co = new ChromeOptions();
		co.addArguments("------disable notifications");
		co.addArguments("----starts maximised-----");

		/*
		 * iii) Hidden division popup
		 */
		// we can handle hidden division popup using click, clear and send keys method

		/*
		 * 2. window based popup
		 * 
		 * window based popups can be handled by using window handles just for switching
		 * and If we want to perform any operation on it we should use Robot Class
		 */

		// copying the data using toolkit and string selection method
		StringSelection s = new StringSelection("some path of our local system ----c://programfiles//abc.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);

		Robot rob = new Robot();
		// delaying time
		rob.delay(2000);

		// selecting the data
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_A);
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_A);

		// copying the data
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_C);
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_C);

		// pasting the data //pressing on enter
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyPress(KeyEvent.VK_V);
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_V);

		/*
		 * 15. Handling Frames
		 * 
		 * First thing is that we need to check whether the tag is iframe or not then
		 * only we can handle using frames
		 */
		/*
		 * frame(int index) frame(String text or id) frame(WebElement frameelement)
		 */

		driver.switchTo().frame(0);
		driver.switchTo().frame(screenshot);
		driver.switchTo().frame(element);

		// coming back to parent frame
		driver.switchTo().parentFrame();

		// coming back from all
		driver.switchTo().defaultContent();

		/*
		 * 16. Web Tables table -> thead -> tbody -> trow -> tdata
		 */

		List<WebElement> second = driver.findElements(By
				.xpath("//div[@data-title='Test Bowling Rankings']/table/tbody/tr/td/a[text()='Ravichandran Ashwin']"));
		for (int i = 0; i < second.size(); i++) {
			System.out.println(second.get(i).getText());
		}

		// 17. window handles

		String parentwindow = driver.getWindowHandle();
		System.out.println(parentwindow);

		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {
			System.out.println(window);
			if (!window.equals(parentwindow)) {
				String title = driver.switchTo().window(window).getTitle();
				System.out.println(title);
				driver.manage().window().maximize();
				driver.getCurrentUrl();
				driver.getTitle();

			}
		}

		driver.switchTo().window(parentwindow);

		// 18. Data driven
		/*
		 * public String readdatafromExcel(String path, String sheetname, int row, int
		 * cell)throws throwable { FileInputStream fis= new
		 * FileInputStream(IAutoConstant.path); Workbook wb=
		 * WorkbookFactory.create(fis); String data=
		 * wb.getSheetName(sheetname).getRow(row).getcell().toString(); return data; }
		 * 
		 * public void writedatafromeExcel(String path, String sheetname, int row, int
		 * cell, String data) throws throwable { FileInputStream fis= new
		 * FileInputStream(IAutoConstant.path) Workbook wb= WorkbookFactory.create(fis);
		 * wb.getSheetName(sheetname).getRow(row).createCell(cell).setCellvalue(data);
		 * 
		 * FileOutputStream fos= new FileOutputStream(parentwindow) wb.write(fos); }
		 * 
		 * 
		 * public int getRowCount(String path, String sheet) throws throwable {
		 * FileInputStream fis= new FileInputStream(IAutoConstant.path) Workbook wb=
		 * WorkbookFactory.create(fis); int rowcount=
		 * wb.getSheet(Sheetname).getLastrowNum(); return rowcount;
		 * 
		 * }
		 */

		// 19. keyword driven

		/*
		 * public string readDataFromPropFile(String path, String key) { FileInputStream
		 * fis= new FileInputStream(IAutoConstant.path); Properties prop= new
		 * Properties(); prop.load(fis); return prop.getProperty(key, "Incorrect Key");
		 */

	}

}
