package HandlingWebTables;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {

	public static void main(String[] args) throws InterruptedException
	{
	   
		WebDriver driver= new ChromeDriver();
		//System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://demo.opencart.com/admin/index.php");
		
      WebElement user=  driver.findElement(By.id("input-username"));
		user.clear();
      user.sendKeys("demo");
      
      
		WebElement pwd=driver.findElement(By.id("input-password"));
		pwd.clear();
		pwd.sendKeys("demo");
		
		driver.findElement(By.xpath("//button[text()=' Login']")).click();
		Thread.sleep(3000);
		
		//clicking on popup
		driver.findElement(By.xpath("//button[@type='button' and @class='btn-close']")).click();
		
		
		//click on sales
		driver.findElement(By.xpath("//a[text()=' Sales']")).click();
		
		//click on order
		driver.findElement(By.xpath("//a[text()='Orders']")).click();
		
		
		//1.Finding total no of pages
		String text=driver.findElement(By.xpath("//div[text()='Showing 1 to 10 of 121 (13 Pages)']")).getText();
	System.out.println(text);	
		
	
	 //we are taking as int because to use in for loop
		int total_pages=Integer.valueOf(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));
		System.out.println("Total no.of pages: " +total_pages);

	
	   //2.clicking on each and every page and find out how many rows are there
		//if the webpage is on current the element is showing as span text
		// but if we want to click on the next page it is showing as a link 
	
		for(int p=1;p<=total_pages;p++)
		{
			//All number parent tag was pagination->common tag is li-> Active tag is span 
		WebElement active_page=	driver.findElement(By.xpath("//ul[@class='pagination']/li/span"));
		
		System.out.println("Active Page :" + active_page.getText());
		Thread.sleep(2000);
  //	active_page.click();
		
	int rows=	driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr")).size();
		System.out.println("Number of rows : " + rows);
		
		//3.printing the text in the page
		 for(int r=1;r<rows;r++)
		 {
			 
		String orderId=	 driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+r+"]/td[2]")).getText();
		String customername=	 driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+r+"]/td[3]")).getText();     
		String status=	 driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+r+"]/td[4]")).getText();
		 
		 System.out.println(orderId+"  " + customername+"  "+ status);
		 
		 }
		
		Thread.sleep(3000);
		//Go to next element and clicking on that page	
		//Because it is not active we are taking'a'tag   
		//converting integer to string  
		
		//dont know why it is not clicking
		
		//4.clicking on next link
	String pageno=Integer.toString(p+1); 

		driver.findElement(By.xpath("//*[@id=\"form-order\"]/div[2]/div[1]/ul/li/a[@class='page-link']")).click();
	
		
		
		
		
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
