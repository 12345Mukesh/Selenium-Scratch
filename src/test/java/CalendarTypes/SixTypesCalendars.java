package CalendarTypes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SixTypesCalendars {

	public static void main(String[] args) throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		  driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		  
		  
		  
		  /*
		   * 1. First calendar display only that particular month with month name and dates ,
		   * and navigation for month is there ->  previous month and next month
		   */
		
		   
//		//1.select calendar from current month and current year
		  int date=8;
//		  //clicking on calendar
		  driver.findElement(By.id("first_date_picker")).click();
//		  //To select the particular element we cannot directly inspect because it is table data so we need to go to parent 
//		  //tag 
		  driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/descendant::a[text()="+date+"]")).click();
//--------------------------------------------------------------------------------------****************-------------------------------------------------------------------------------------------------------//		  
		  
		
		/*
		 * 
		 * 2. Second calendar Dates -> display previous,current and next month dates but month name will be current only, 
		 * and navigation for month is there -> previous and next month
		 * 
		 * 
		 */
		  // 2. select calendar from current month and current year
		  //**Here if we take 30 it will select previous month not this month so need to change the code little bit
		  //Taking negative scenario by not
		  //*Here for normally descendant or ancestor or any axes we will use single / only
		  // but directly element is taking so need to take //
		  int date1=30;
		  
		 driver.findElement(By.id("second_date_picker")).click();
		 
		  driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td[not(contains(@class,' ui-datepicker-other-month '))]/a[text()="+date1+"]")).click();
	  

		  
		  
		  
		
		
		/*
		 * 
		 * 3. Third calendar display Dates -> only that particular month
		 *    navigation is there month -> previous and next month
		 *    Now extra feature is that for month and year -> dropdown is there so that changing the year will be easy
		 * 
		 * 
		 */
		
		
		
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  /*
		   * 4. Fourth calendar
		   * 
		   * Second calendar Dates -> display previous,current and next month dates but month name will be current only, 
		   * and navigation for month is there -> previous and next month
		   * 
		   *  Now extra feature is that for month and year -> dropdown is there so that changing the year will be easy
		   * 
		   * 
		   */
		  
		  
		  
		  
		  
		  
		  
		  
		  /* 5.   Fifth calendar display only that particular month with month name and dates ,
		   *      and navigation for month is there ->  previous month and next month
		   *      Here the main disadvantage is that past and future dates are disabled only few dates are enabled
		   *      
		   *      
		   */
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  /*
		   * 
		   * 6. Sixth calendar -> button outside is there,we need to click there and select( May be any one of combinations)
		   *                      (our zoho and VTiger used this type of calendar only)
		   * 
		   * 
		   * 
		   */
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  driver.close();
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  

	}

}
