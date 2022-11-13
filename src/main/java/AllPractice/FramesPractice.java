package AllPractice;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

public class FramesPractice {

	public static void main(String[] args) throws Throwable 
	{
	
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		Thread.sleep(3000);
		
		/*
		 * 1. First Frame Entering
		 */
		
		WebElement frame1=driver.findElement(By.id("frm1"));
		
		 driver.switchTo().frame(frame1);
		 
		 // Inspecting elements inside the first frame
		 WebElement dropdown=driver.findElement(By.id("selectnav1"));
         Select sel= new Select(dropdown);
         sel.selectByVisibleText("-- Extent Reports");
         Thread.sleep(3000);
         
         driver.switchTo().parentFrame();
         //performing some operation on Main Frame to cross check it
         driver.findElement(By.id("name")).sendKeys("Frame 1 Completed");
//         
         //First Frame over
         
         /*
          * 2. Second Frame Entering
          * 
          */
         
		driver.switchTo().frame("frm2");
		//Inspecting Elements in Second Frame
		
		driver.findElement(By.id("firstName")).sendKeys("Mukesh");
		
		driver.findElement(By.id("lastName")).sendKeys("smart");
		
		driver.findElement(By.id("englishchbx")).click();
		
		driver.findElement(By.id("hindichbx")).click();
		
		driver.findElement(By.id("email")).sendKeys("cmukesh391@gmail.com");
		
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();
//		
	WebElement textbox=	 driver.findElement(By.id("name"));
         textbox.clear();
         textbox.sendKeys("Frame 2 Completed");

   //----------------**********************--------------------------------//      
		/*
		 * 3. Nested Nested Frame
		 * 
		 */
		
		
         driver.switchTo().frame("frm3");
         
         //-----------Normal Frame3 selecting the dropdown--------------//
         
         Select sel1= new Select(driver.findElement(By.id("selectnav1")));
		sel1.selectByVisibleText("- Testing");
		
		Thread.sleep(2000);
		
		
//		//*****************Now going into Frame 1************************//
//		
//		//First shift to Nested Frame 1
//		
//		driver.switchTo().frame("frm1");
//		
//		Select sel2= new Select(driver.findElement(By.id("selectnav1")));
//		sel2.selectByVisibleText("Tutorials");
//		Thread.sleep(3000);
//		
//		//******************Now coming out from Frame1**************************//
//		
//		driver.switchTo().parentFrame();
//		
//		driver.findElement(By.id("name")).sendKeys("Nested Frame1 Completed");
//		
//		//*********************Now going to Frame 2**************************//
//		
//		
//		driver.switchTo().frame("frm2");
//		
//		Select sel3= new Select(driver.findElement(By.id("selectnav1")));
//		sel2.selectByVisibleText("- Dropdowns");
//		Thread.sleep(3000);
//		
//		Select sel4= new Select(driver.findElement(By.id("course")));
//		sel4.selectByVisibleText("Java");
//		
//		Select sel5= new Select(driver.findElement(By.id("ide")));
//		sel5.selectByVisibleText("Eclipse");
//		Thread.sleep(3000);
//		
//       //*******************************Now coming out of Frame2 ********************//
//		
//driver.switchTo().parentFrame();
//		
//		driver.findElement(By.id("name")).sendKeys("Nested Frame2 Completed");
//		
//		
//		Thread.sleep(5000);
		
   //-------------------Now coming all out from it----------------
		
		driver.switchTo().defaultContent();
		
		
		WebElement nestedtextbox=	 driver.findElement(By.id("name"));
       nestedtextbox.clear();
        nestedtextbox.sendKeys("Frame 3 Completed");
		
     //Screenshot Printing
        
        Date currentdate= new Date();
		String screenshot= currentdate.toString().replace(":", "-");
		System.out.println(screenshot);
		
	   
		
	   //1.Full page screenshot 
		
	   Screenshot screen= new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
		
	   ImageIO.write(screen.getImage(), "PNG", new File("./screenshot/FramesScreenshot'"+screenshot+"'.png"));
	   
	   driver.quit();
        
        
		
		
	}

}
