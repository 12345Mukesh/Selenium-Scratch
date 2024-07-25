package DropdownsStatic;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DateSelection {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().clearDriverCache().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.redbus.in");
		
		String year="2022";
		String month="Oct";
		String date="25";
		
		//driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		
         // The selecting year and month should match with the input year and month
		//Month and Year
		while(true)
		{
			String monthyear=driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
		String arr[]=    monthyear.split(" ");
		String mon=arr[0];
		String yr=arr[1];
		
		 if(mon.equalsIgnoreCase(month) &&yr.equals(year))
		 {
		 break;
		 }
		 else
		 {
			 driver.findElement(By.xpath("//button[text()='>']")).click();
		 }
		
		}
		
		//Selecting date tag not exact date
		
	List<WebElement> alldates=	driver.findElements(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr/td"));
		
		for(WebElement ele:alldates)
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
