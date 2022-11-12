package AllPractice;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlesAllWebsites {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		Thread.sleep(3000);

		//------------------------------------****************************--------------------------------------------
		
//		
//		// 1. First Type normal window switching
//		
//		String parentwindow = driver.getWindowHandle();
//	   System.out.println("parent window:" + parentwindow);
//		driver.findElement(By.id("newWindowBtn")).click();
//
//		Set<String> windows = driver.getWindowHandles();
//		System.out.println("All window Strings:" + windows);
//		/*
//		 * Parent window will come always at first
//		 * 
//		 */
//
//		for (String window : windows) {
//			System.out.println("First window :" + window);
//			/*
//			 * Because parent window always come first we need to write the if condition by
//			 * making it as false then will execue the loop condition
//			 */
//			if (!window.equals(parentwindow)) {
//				String newwindow = driver.switchTo().window(window).getTitle();
//				System.out.println("Changed window is:" + newwindow);
//				driver.manage().window().maximize();
//				Thread.sleep(5000);
//				driver.close();
//			}
//
//		}
//		driver.switchTo().window(parentwindow);
//		driver.findElement(By.id("name")).sendKeys("First window handle");
//
//		
		
		
		// 2. Now switching to other tab of window
		
		String parentwindow = driver.getWindowHandle();
	System.out.println("parent window:" + parentwindow);
		
		driver.findElement(By.id("newTabBtn")).click();
		Set<String> Allwindows = driver.getWindowHandles();
		System.out.println("All window Strings:" + Allwindows);
		/*
		 * Parent window will come always at first
		 * 
		 */
		 for(String window:Allwindows)
		 {
			 if(!window.equals(parentwindow))
			 {
				 String title=driver.switchTo().window(window).getTitle();
				 System.out.println("Child window Title is:" + title);
				 driver.manage().window().maximize();
				 
				 //Now clicking on popup box inside the child window
				  driver.findElement(By.id("alertBox")).click();
				  
				  Thread.sleep(5000);
				  Alert al= driver.switchTo().alert();
				  al.accept();
				  Thread.sleep(5000);
				 
				 driver.findElement(By.id("promptBox")).click();
				 al.sendKeys("Mukesh");
				 al.accept();
				 
				 driver.close();
			 }
			 
			 
		 }
		
		driver.switchTo().window(parentwindow);
		
		driver.findElement(By.id("name")).sendKeys("Second window handle");

	}

}
