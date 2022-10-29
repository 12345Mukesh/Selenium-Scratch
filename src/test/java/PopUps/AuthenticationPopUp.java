package PopUps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPopUp {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		 
		  //syntax for basic auth
	//	driver.get("https://the-internet.herokuapp.com/basic_auth");
	
		//http://admin:admin@the-internet.herokuapp.com/basic_auth
		//http://username:password@URL
		
		 driver.get("https://admin:adminthe-internet.herokuapp.com/basic_auth");
		  
		//After giving this url the username and pwd will not ask here
		
		
		
		
		
		
		
		

	}

}
