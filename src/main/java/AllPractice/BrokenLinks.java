package AllPractice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws Throwable
	{
		
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe" );
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://amazon.com/");
		
		Thread.sleep(5000);
		
	 /*	1. Capture the links
		    Most the links start with a tag  
		*/
            List<WebElement> links=   driver.findElements(By.tagName("a"));	
           System.out.println(links.size());
           
           //Adding all the url in array List
           List<String> urllist= new ArrayList<String>();
   
           for(WebElement element:links)
           {
        	   String url=	element.getAttribute("href"); 
        	  //Adding all the url in the Array List
        	 urllist.add(url);
           }
          
         long StartTime=System.currentTimeMillis();  
        //Doing for parallel stream    
       urllist.parallelStream().forEach(e -> CheckBrokenLink(e));
       long EndTime= System.currentTimeMillis();
       
       System.out.println("total time taken: " +(EndTime-StartTime));
       //For parallel stream time -  total time taken: 67658 = 67.6 sec
       //For normal stream need to remove parallelStream() and insert stream()
       //For Normal Stream time - total time taken: 149818=149.8 sec
       
       driver.quit();
	}
     public static void CheckBrokenLink(String linkurl)
     {
    	 
    	 try 
    	 {
		     URL url= new URL(linkurl);
    		 HttpURLConnection httpcon=(HttpURLConnection) url.openConnection();
    	        //Establish the connection
    	     httpcon.setConnectTimeout(5000);   
    		 httpcon.connect();
    	     
    		 if(httpcon.getResponseCode()>=400)
    		 {
    			 System.out.println(linkurl + "--------------->" + httpcon.getResponseMessage()+ " is a Broken Link");
    		 }
    		 
    		 else
    		 {
    			 System.out.println(linkurl+ "----------------->"+ httpcon.getResponseMessage()+ "working fine");
    		 }
    		 
		}
    	 catch (Exception e) 
    	 {
		
    		 
    	 }	
    	 
     }
   
   
   
   
	

}
