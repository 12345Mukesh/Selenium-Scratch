package DropdownsStatic;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiDropDown {

	public static void main(String[] args) 
	{
	
		 WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		  driver.get("file:///E:/QSpiders/Selenium/Website%20projects/MultiDropdown.html");
	     WebElement addr=  driver.findElement(By.id("novotel"));
	    addr.click();
	   Select sel= new Select(addr);
	   List<WebElement> list=sel.getOptions();
	   
	   if(sel.isMultiple())
	   {
		   System.out.println("It is a multi select Dropdown");
	   }
	   
	   else
	   {
		   System.out.println("It is a single select Dropdown");
	   }
	   
	     for(int i=0;i<list.size()-1;i++)
	     {
	    	 String abc=list.get(i).getText();
	    	 System.out.println(abc);
	    			 
	     }
	     
	     /*
	      * Checking with Three sets- Hash, Linked Hash, Tree set
	      */
	     System.out.println("Starting the Hash Set");
	     HashSet<String> hash= new HashSet<String>();
	     for(int i=0;i<=list.size()-1;i++)
	     {
	    	String set1= list.get(i).getText();
	    	hash.add(set1);
          System.out.println(hash);
	     }
	      
	     for(String print:hash)
	     {
	    	 System.out.println(print);
	     }
	     
	     
	   System.out.println("Starting Linked Hash set");
	     LinkedHashSet<String> link= new LinkedHashSet();
	     for(int i=0;i<=list.size()-1;i++)
	     {
	    	 String set2=list.get(i).getText();
	         link.add(set2);
	         System.out.println(link);
	     }
	     
	     for(String test:link)
	     {
	    	 System.out.println(test);
	     }
  
  
  
     System.out.println("Starting the Tree set");
   TreeSet<String> tree= new TreeSet<String>();
   for(int i=0;i<=list.size()-1;i++)
   {
   	String a=list.get(i).getText();
   	tree.add(a);
   	System.out.println(tree);
   }
  
   for(String ts:tree)
   {
   	System.out.println(ts);
   }
  
  
  
  
  
  
  
  driver.close();
  
  
		
		
		

	}

}
