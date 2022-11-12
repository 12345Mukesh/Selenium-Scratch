package DynamicDropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Googlesearch {

	public static void main(String[] args) throws InterruptedException 
	{

		WebDriver driver=new ChromeDriver();
		//  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(1000);
		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		driver.findElement(By.xpath("//a[@id='webklipper-publisher-widget-container-notification-close-div']")).click();
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//a[@class='mmtLogo makeFlex']")), 10, 15).click();

		String OptionToSelect="BOM";

		int count=0;

		WebElement check=	driver.findElement(By.id("fromCity"));

		check.sendKeys(OptionToSelect);

		
			

//		WebDriverWait wait= new WebDriverWait(driver,10);
//		wait.until(ExpectedConditions.visibilityOf(check));

		//id="webklipper-publisher-widget-container-notification-frame"

		//selecting the mumbai city from the given list storing in one variable
		//List<WebElement> Cities=    driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]"));
		List<WebElement> Cities=    driver.findElements(By.xpath("//div[@id='react-autowhatever-1']"));
		
		for(WebElement element:Cities)
		{
			String City=element.getText();
			System.out.println(City);
			
							if(City.contains(OptionToSelect))
							{
								Thread.sleep(1000);
								driver.findElement(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/descendant::div[@class='makeFlex hrtlCenter']/div[text()='BOM']")).click();
								
								// <div data-cy="outsideModal" class="loginModal displayBlock modalLogin dynHeight personal"
							}
		}

//		if(count!=0)
//
//		{
//			System.out.println(OptionToSelect+" Has been selected in Dropdown");
//		}
//
//		else
//		{
//			System.out.println("Not given current format");
//		}

		//	   driver.findElement(By.xpath("//a[@class='close']")).click();

		//disabling the pop up
		//          WebElement alert=driver.findElement(By.xpath("//i[@class='wewidgeticon we_close']")); 
		//          JavascriptExecutor jse= (JavascriptExecutor)driver;
		//          jse.executeScript("arguments[0].click", alert);
		//             

	}	

}
