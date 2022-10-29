package HandlingWebTables;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable2 {

	public static void main(String[] args)
	{
		
		WebDriver driver;
		driver= new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/mens/player-rankings/test");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	List<WebElement> list=	driver.findElements(By.xpath("//div[@class='rankings-block__container ' and @data-title='Test All-Rounder Rankings']"));
	for(int i=0;i<list.size();i++)
	{
		System.out.println(list.get(i).getText());
	}
	
	
	List<WebElement> title=driver.findElements(By.xpath("//h4[text()='Test All-Rounder Rankings']"));
	for(int i=0;i<title.size();i++)
	{
		System.out.println(title.get(i).getText());
	}
		
	//1.Getting third rank of Test Allrounder
	
	List<WebElement>name=driver.findElements(By.xpath("//div[@data-title='Test All-Rounder Rankings']/descendant::table/tbody/tr[@class='table-body'][2]"));
	
	for(int i=0;i<name.size();i++)
	{
		System.out.println(name.get(i).getText());
	}
	
	
	
	//2. 10th position name
	  
	List<WebElement> position= driver.findElements(By.xpath("//div[@data-title='Test Batting Rankings']/table/tbody/tr[9]"));
	
	for(int i=0;i<position.size();i++)
	{
		System.out.println(position.get(i).getText());
	}
	
	
	//3. Moving from 10th position to 5th position in Test Batting Rankings
	
List<WebElement>fifth=driver.findElements(By.xpath("//div[@data-title='Test Batting Rankings']/table/tbody/tr[9]/ancestor::div[@class='col-4 col-12-desk touch-scroll-list__element']/div/table/tbody/tr[4]"));
	for(int i=0;i<fifth.size();i++)
	{
		System.out.println(fifth.get(i).getText());
	}
	
	
	//4. 2nd position name
	
	List<WebElement>second=driver.findElements(By.xpath("//div[@data-title='Test Bowling Rankings']/table/tbody/tr/td/a[text()='Ravichandran Ashwin']"));
	for(int i=0;i<second.size();i++)
	  {
		 System.out.println(second.get(i).getText());
	  }

	//5. Moving from 2nd position name to 7th position name in Test Bowling Rankings
	
   List<WebElement> index=driver.findElements(By.xpath("//div[@data-title='Test Bowling Rankings']/table/tbody/tr[1]/ancestor::tbody/tr/td/a[text()='Mitchell Starc']"));
	
    for(int i=0;i<index.size();i++)
   {
	 System.out.println(index.get(i).getText());

   }
		
	
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("window.ScrollBy(0,500)");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
