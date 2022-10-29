package DropdownsStatic;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeperateDateandYear {

	public static void main(String[] args)
	{
		WebDriver driver= new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
   
		
		driver.findElement(By.xpath("(//input[@type='text' and @data-date-format='dd/mm/yy'])[1]")).click();
		
		Select month_drp= new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		
		month_drp.selectByVisibleText("May");
		
		Select year_drp= new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		
		year_drp.selectByVisibleText("1995");
		
		String date="08";
		
		//Everytime use // for good experience
		//Taking all dates and comparing each with harcoded value using for each loop
	List<WebElement> allDates=	driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		for(WebElement ele:allDates)
		{
			String dt=ele.getText();
			
			if(dt.equals(date))
			{
				ele.click();
				break;
			}
		}
	}

}
