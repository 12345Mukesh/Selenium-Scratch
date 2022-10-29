package WindowHandle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		 
		  driver.get("https://opensource-demo.orangehrmlive.com/");
		  Thread.sleep(3000);
		  /*
		  //get single window id
     String window=driver.getWindowHandle();
		System.out.println(window);
		//CDwindow-88056D9929C52202F62483D8A3BD3669
		//CDwindow-CBB057435189139B7A15C62BC405A180
		*/
		
		  
		//opens another browser window
	driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		
	   //Return IDs of multiple browser windows
	// In set  duplicates are not allowed
		Set<String>windows= driver.getWindowHandles();
		
		//1. First method by using iterator()
	/*	
	Iterator<String> it=	windows.iterator();
	//Gives first parent window id
	String parentid=	it.next();
	//Gives child window id	
		String childid=it.next();
		
		System.out.println("Parent Window ID is :" + parentid);
		
		System.out.println("Child Window ID is :" + childid);
		
	*/
		
		//2. Using List/ArrayList
		// In list duplicates are allowed
		List<String> windowid= new ArrayList(windows);
		
		/*
		//Stores parent window id 
		String parentid=windowid.get(0);
		System.out.println(parentid);
		//Stores child window id
		String childid=windowid.get(1);
		System.out.println(childid);
		
		
		//switching between windows using windowid
		
		driver.switchTo().window(parentid);
		System.out.println("Parent window Title is : " + driver.getTitle());
		
		driver.switchTo().window(childid);
		System.out.println("Child window Title is : "+ driver.getTitle());
		
		*/
		
		
		// Instead of writing for each and every codeGetting all windows at at time by using foreach loop
		
		for(String winId:windowid)
		{
			//printing the window id
		//	System.out.println(winId);
		String title=driver.switchTo().window(winId).getTitle();
		if(title.equals("HR Software | Free & Open Source HR Software |"))
		{
			Thread.sleep(3000);
			System.out.println(title);
			driver.close();
		}
		
		else
		{
			System.out.println(title);
			driver.close();
		}
		}
		
		//close single browser window
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
