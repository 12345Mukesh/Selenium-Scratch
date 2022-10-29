package MouseAndKeyboardActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {

	public static void main(String[] args) throws Throwable {
	

		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		  driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		  String url=driver.getCurrentUrl();
		  System.out.println(url);
		  String title=driver.getTitle();
		  System.out.println(title);
		
		  WebElement oslo=driver.findElement(By.id("box1"));
			WebElement norway=driver.findElement(By.id("box101"));
				Actions ac3= new Actions(driver);
				ac3.dragAndDrop(oslo,norway).perform();
				
				Thread.sleep(2000);
				
		  
		  WebElement stockholm=driver.findElement(By.id("box2"));
			WebElement sweden=driver.findElement(By.id("box102"));
				Actions ac5= new Actions(driver);
				ac5.dragAndDrop(stockholm, sweden ).perform();
				
				Thread.sleep(2000);
		  
		WebElement wash=driver.findElement(By.id("box3"));
		WebElement us= driver.findElement(By.id("box103"));
		Actions ac= new Actions(driver);
		ac.dragAndDrop(wash, us).perform();
		
		Thread.sleep(2000);
		
		WebElement 	copenhagen=driver.findElement(By.id("box4"));
		WebElement Denmark=	driver.findElement(By.id("box104"));
			Actions ac4= new Actions(driver);
			ac4.dragAndDrop(copenhagen, Denmark).perform();
			
			Thread.sleep(2000);
			
			WebElement rome=driver.findElement(By.id("box6"));
	    WebElement italy=driver.findElement(By.id("box106"));
		Actions ac1= new Actions(driver);
		ac1.dragAndDrop(rome,italy).perform();
		
		Thread.sleep(2000);
		
		
		
		
	  WebElement madrid=driver.findElement(By.id("box7"));
	   WebElement spain=driver.findElement(By.id("box107"));
		Actions ac2= new Actions(driver);
		ac2.dragAndDrop(madrid,spain).perform();
		Thread.sleep(2000);
		
		
		
			WebElement seoul =driver.findElement(By.id("box5"));
			WebElement southkorea =driver.findElement(By.id("box105"));
				Actions ac6= new Actions(driver);
				ac6.dragAndDrop(southkorea,seoul ).perform();
				
				
			
		
	
		
	
		
	
	
	
		
	
			
				
	
	
	
	
	}

}
