package DynamicDropdown;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SpiceJet 
{

   public static void main(String args[]) throws InterruptedException	
   {
	   
	   //Everything is working fine just the return date is pending
	   
	 //1.To disable the notifications of browser one we cannot inspect or use 
	 		//Alert options so need to use browser notification popups
	 		
	 		ChromeOptions options= new ChromeOptions();
	 		options.addArguments("--disable--notifications");
	 		
	 		
	 		//created browser object need to send in particular driver
	 		WebDriver driver=new ChromeDriver(options);
	       System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		  driver.get("https://www.spicejet.com");
		  
		  
//		//		  
		  
		  //1. First Selecting from Field dropdown
        driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();
		//1. Then selecting required city
        driver.findElement(By.xpath("//div[@class='css-76zvg2 r-1srvcxg' and text()='Tirupati International Airport']")).click();
         
        Thread.sleep(5000);
     
        //2.Now Selecting To Field dropdown
        driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']")).click();
        
        //2. Now Selecting Destination city 
        driver.findElement(By.xpath("//div[@class='css-76zvg2 r-1srvcxg' and text()='Goa International Airport']")).click();
        
        //3.First click on  Departure calendar dropdown
        driver.findElement(By.xpath("//div[@data-testid='departure-date-dropdown-label-test-id']")).click();  
      
        
        /*
         * Return date need to click twice then only it is enabling(may be in code issue)
         */
        
        
        //3. Now selecting the Departure date
  //     driver.findElement(By.xpath("//div[@data-testid='undefined-calendar-day-15' and @class='css-1dbjc4n r-1awozwy r-16ru68a r-y47klf r-1loqt21 r-eu3ka r-1otgn73 r-1aockid']")).click();
        
        
//        
//        //4. Now selecting the Return calendar icon
//         driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']")).click();
//         
//         //4.Now selecting the Return date
//         driver.findElement(By.xpath("//div[@data-testid='undefined-calendar-day-5' and @class='css-1dbjc4n r-1awozwy r-16ru68a r-1loqt21 r-eu3ka r-1otgn73 r-1aockid']")).click();
//        
        
       //  5. First clicking on passenger dropdown
      
            driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();
            
            // i) Now selecting one adult and one infant
             
             driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
             
             driver.findElement(By.xpath("//div[@data-testid='Infant-testID-minus-one-cta']")).click();
             
       //6. Selecting the currency dropdown first      
   
            driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-5njf8e r-1otgn73'])[3]")).click();
            
            // i) selecting the type of currency 
            
            driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-ubezar' and text()='INR']")).click();
            
       //7. clicking on button
            
            driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
            
            Thread.sleep(2000);
   
   
        driver.close();
   
   
   
   
   }
	
}
