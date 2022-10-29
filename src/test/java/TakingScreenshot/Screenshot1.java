package TakingScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class Screenshot1 {

	public static void main(String[] args) 
	{
	
		Date currentdate= new Date();
		String screenshotfilename= currentdate.toString().replace(":", "-");
		System.out.println(screenshotfilename);
		
		
		WebDriver driver=new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver.get("https://www.ebay.com.au/");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(".//screenshot//"+screenshotfilename+".png");
		try {
			Files.copy(src, dest);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		

	}

}
