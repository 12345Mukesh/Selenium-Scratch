package CalendarTypes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarUtility {

	public static void main(String[] args) throws Throwable
	
	{
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		  driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
	
		
		  //clicking on first calendar
		//driver.findElement(By.id("first_date_picker")).click();
		  
		   //clicking on second calendar
			 driver.findElement(By.id("second_date_picker")).click();
		   selectdate(driver, "13/Mar/2013");
		  
		/*
		 * Error coming because selectdate method is not taking, but it should be selectDate method 
		 */
		
	}	
		

	public static void selectdate(WebDriver driver,String Date) throws Throwable
		{
			//validating the date creating in java class
			  
			  String targetdate = "13/Mar/2013";
			  Calendar calendar= Calendar.getInstance();
			    
			//Date format, if we provide wrong date also it will not print
			  try
			  {
			  SimpleDateFormat targetDateFormat= new SimpleDateFormat("dd/MMM/yyyy");
			  targetDateFormat.setLenient(false);
			  //Date  should also be date
			  Date formattedTargetDate= targetDateFormat.parse(Date);
			  calendar.setTime(formattedTargetDate);
			  }
			  catch (Exception e)
			  {
				throw new Exception("Invalid date is provided , please check the input date");
			}
			int targetmonth=  calendar.get(calendar.MONTH);
			 int targetyear= calendar.get(calendar.YEAR);  
			 int targetday=calendar.get(calendar.DAY_OF_MONTH);
			 
			  
			  //clicking on first calendar
			  driver.findElement(By.id("first_date_picker")).click();
			  
			  // October 2022
			  //selecting the title of calendar month and year
			String currentdate= driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			 SimpleDateFormat currentdateFormat= new SimpleDateFormat("MMM yyyy");
			 currentdateFormat.setLenient(false);
			  Date formattedTargetDates= currentdateFormat.parse(currentdate);
			  calendar.setTime(formattedTargetDates);
			int currentmonth=  calendar.get(calendar.MONTH);
			 int currentyear= calendar.get(calendar.YEAR);  
			
			 /*------------For future year clicking------------------*/
			 
			while(currentmonth<targetmonth || currentyear<targetyear)
			{
				//clicking on next button of the calendar
				driver.findElement(By.className("ui-datepicker-next")).click();
				 //selecting the title of calendar month and year
				currentdate= driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
				 currentdateFormat= new SimpleDateFormat("MMM yyyy");
				 currentdateFormat.setLenient(false);
				  formattedTargetDates= currentdateFormat.parse(currentdate);
				  calendar.setTime(formattedTargetDates);
				currentmonth=  calendar.get(calendar.MONTH);
				currentyear= calendar.get(calendar.YEAR);  
			}
			
			
			/*------------For previous year clicking------------------*/		
			while(currentmonth>targetmonth || currentyear>targetyear)
			{
			   	//clicking on previous button of the calendar
				driver.findElement(By.className("ui-datepicker-prev")).click();
				 //selecting the title of calendar month and year
				currentdate= driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
				 currentdateFormat= new SimpleDateFormat("MMM yyyy");
				 currentdateFormat.setLenient(false);
				  formattedTargetDates= currentdateFormat.parse(currentdate);
				  calendar.setTime(formattedTargetDates);
				currentmonth=  calendar.get(calendar.MONTH);
				currentyear= calendar.get(calendar.YEAR);  
			}
			
			
			//It will click on the particular target date which we gave
	
			 
			  driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td[not(contains(@class,' ui-datepicker-other-month '))]/a[text()="+targetday+"]")).click();
		  

			 
			  
			 
			
			
			driver.close();
			
			
		}

	
		
		
		

}
