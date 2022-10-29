package PopUps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PermissionPopUpsLikeAskingNotificationsinApplications {

	public static void main(String[] args) {
		
		//To disable the notifications of browser one we cannot inspect or use 
		//Alert options so need to use browser notification popups
		
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable--notifications");
		
		
		//created browser object need to send in particular driver
		WebDriver driver=new ChromeDriver(options);
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		 
		  driver.get("https://www.redbus.in/");
		
		

	}

}
