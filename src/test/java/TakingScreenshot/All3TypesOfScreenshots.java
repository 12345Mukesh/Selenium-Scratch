package TakingScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class All3TypesOfScreenshots {

	public static void main(String[] args) throws IOException 
	{
	  WebDriver driver= new ChromeDriver();
	//	System.getProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
	   driver.get("https://demo.nopcommerce.com/");
	   driver.manage().window().maximize();
		
	   Date currentdate= new Date();
		String screenshot= currentdate.toString().replace(":", "-");
		System.out.println(screenshot);
		
	   
	   //1.Full page screenshot but not coming
		
	   Screenshot screen= new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
		
	   ImageIO.write(screen.getImage(), "PNG", new File("./screenshot/FullPageScreenshot1.png"));
	   
	   
	   
		//2.screenshot of section/portion of File
		/*
	        WebElement section=	driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
			File src=section.getScreenshotAs(OutputType.FILE);
			File dest=new File(".//screenshot//featuredproducts.png");
			FileUtils.copyFile(src, dest);
		*/
		
		//3. screenshot of section/portion of File
//		     WebElement commerce=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
//		     File src1=commerce.getScreenshotAs(OutputType.FILE);
//				File dest1=new File(".//screenshot//logo.png");
//				FileUtils.copyFile(src1, dest1);
//		
//		
//				
//		

	   driver.quit();
	   
	   
	}

}
