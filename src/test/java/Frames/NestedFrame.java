package Frames;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrame {

	public static void main(String[] args) {
	
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		 
		  driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		  
		  //1.Here directly it is having string so we are directly switching to outer frame
          driver.switchTo().frame("iframeResult");
		
          //Normal one
          //driver.findElement(By.xpath(iframe[@title='Iframe Example']));
          
		//2.For the inner frame no string is there but we can use index because only one frame is there inside
          driver.switchTo().frame(0);
          
          //3.Normal one
          /*
        WebElement text=  driver.findElement(By.xpath("//h1[text()='This page is displayed in an iframe']"));
		System.out.println(text);
		*/
		
		//Another method for printing text in inner frame
	   System.out.println("Text present in inner frame:" + driver.findElement(By.xpath("//h1")).getText());
	   
	   //4.switching to parent frame
		driver.switchTo().parentFrame();
		
		
	//5.printing text in outer frame	 	
	System.out.println("Text present in outer frame:" + driver.findElement(By.xpath("//p")).getText());
		
	driver.close();
	
	}

}
