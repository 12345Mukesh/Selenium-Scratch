package HandlingWebTables;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;
import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup.All;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableSimple {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		 
		  driver.get("https://seleniumpractise.blogspot.com/2021/08/");
		
		
		    
		   boolean status= false;
		   //1.printing the header of table
		  List<WebElement> a=driver.findElements(By.xpath("//table[@id=\"customers\"]//th")); 
		  System.out.println(a.size()); 
		  
		    for(WebElement all:a)
		    {
		    	//Directly printing element will give element address, 
		    	 //so first need to get the text by storing all values in one variable with one text
		    	
		    	String value=all.getText();
		    	Dimension size=all.getSize();
		    	System.out.println(size);
		    	System.out.println(value);
		    	
		    	
		    }   
		    
		   
		 
	   System.out.println("==============================="); 
	  
	  //2.printing from table with if else condition
	   
	   List<WebElement> sample=driver.findElements(By.xpath("//table[@id=\"customers\"]"));
	   for(WebElement simple:sample)
	   {
		   String simp=simple.getText();
		   System.out.println(simp);
		   
		   //converting all text to upper case
		   if(simp.contains("Selenium"))
		   {
			   System.out.println(simp.toUpperCase());
		   }
		   
	   }
	   
	   
	   System.out.println("===========================");
	   //3. printing the third  row of table  
	 List<WebElement> thirdrow=  driver.findElements(By.xpath("(//tr//preceding-sibling::tr)[3]"));
	  System.out.println(thirdrow.size());  
	 
	  //pick out group of elements and printing one by one
	  
	  for(WebElement third:thirdrow)
	  {
		  String th=third.getText();
		  System.out.println(th);
	  }
	  
	  System.out.println(" ===================================");
	   driver.findElement(By.xpath("//td[text()='Selenium']/preceding-sibling::td//input")).click();
	   Thread.sleep(3000);
	
	   
	 driver.findElement(By.xpath("//td[text()='Amazon']/following-sibling::td[a]")).click();
	   
	   
	 driver.close();
	   
	}

}
