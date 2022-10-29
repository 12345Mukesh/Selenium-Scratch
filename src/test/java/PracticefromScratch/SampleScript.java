package PracticefromScratch;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SampleScript {

	public static void main(String[] args) throws InterruptedException 
	{
		
	   //1. Upcasting browser driver with webdriver to load all the 13 abstract methods
             //   WebDriver driver= new FirefoxDriver();
             //   System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
		 WebDriver driver= new ChromeDriver();
		 System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
                
       //2. Giving the url to open  
                driver.get("https://www.google.com");
            
       //3. Getting the url and printing 
                String url=driver.getCurrentUrl();
                System.out.println(url);
           
       //4. Getting the page source code  
                String src= driver.getPageSource();
		        if(src.contains("india"))
		         {
			       System.out.println("India is great");
		         }
		       else
		        {
			      System.out.println("Dabba Fellow it is not proper browser");
		        }
            
       //5. Getting the title
		        String abc=driver.getTitle();
		        System.out.println(abc);
		        if(abc.equals("golgole"))
		         {
			       System.out.println("Ok Google died");
		         }
		        else
		         {
			       System.out.println("Dabba Fellow give correct spelling");
		         }
	      
	  //6. Using manage() method
		        driver.manage().window().fullscreen();
		      //Directly size changing in browser is not possible so need to use Dimension object  
		        Dimension dim= new Dimension(500,500);
		        driver.manage().window().setSize(dim);
	         //Directly moving the position of browser is not possible so need to add point object
		        Point p=new Point(800,800);
		        driver.manage().window().setPosition(p);
	
	            Thread.sleep(5000);
	            
	  //7.  Directly we cannot enter url in Navigate because it has forward,backward,refresh so need 
	  //      to give in another method
	            driver.navigate().to("https://www.udemy.com");
	            Thread.sleep(5000);
	            
	            driver.navigate().back();
	            Thread.sleep(5000);
	            
	            driver.navigate().forward();
	            Thread.sleep(5000);
	            
	            driver.navigate().refresh();
	            
	       driver.quit();
	}

}
