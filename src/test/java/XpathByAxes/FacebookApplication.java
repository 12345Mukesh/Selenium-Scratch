package XpathByAxes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookApplication {

	public static void main(String[] args) {
		
		
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		  driver.get("https://www.facebook.com/signup");
		  
		  
		  //1. Find the signup button in the Registration page of Facebook(child)
		  
		/*
		 *    Step 1: First need to find the ancestor or parent tag for the registration page.
		 *        Note: whole page can also become the ancestor so we need to take what we required
		 *              Registration page box is enough
		 *              
		 *              //div[@class='_58mf']
		 *              
		 *    Step 2: i) Now from that ancestor if we take child it will show the same registration field,
		 *               So we took the descendant(child and sub child).
		 *             ii) we should check by keeping it with * so that we can able to know whether we find the particular field
		 *                 Individually or not  
		 *                 
		 *                  /descendant::*
		 *                  
		 *    Step 3: i) From that we can able to Find signup button field. In that also first need to take the parent field
		 *                
		 *                 div[@class='_1lch']
		 *              
		 *             ii)Now we need to check how many childs are there - 2 childs
		 *                    
		 *                       /child::*            
		 * 
		 *             iii) Now we can take our required button field with text
		 *             
		 *                         button[text()='Sign Up']
		 */
		  
		  //main method : //div[@id='reg_form_box']/child::div[10]/button
		  
		  driver.findElement(By.xpath("//div[@class='_58mf']/descendant::div[@class='_1lch']/child::button[text()='Sign Up']")).click();
		  
		  
		  //2.Locate first name field from signup button(parent)
		  
driver.findElement(By.xpath("//button[text()='Sign Up']/parent::div[@class='_1lch']/parent::*/child::div[@id='fullname_field']/child::div[@class='clearfix _58mh']/child::div[@class='mbm _1iy_ _a4y _3-90 lfloat _ohe']"));
		  
		  
		  //3. Identify the password field from mobile number(following)
		  
         driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[3]/parent::*/following::div[text()='New password']\r\n"
         		+ "		  "));
		  
		  
		  //4. Locate mobile number from new password field(preceding)
		  
		  driver.findElement(By.xpath("//div[text()='New password']/preceding::div[text()='Mobile number or email address']"));
		  
		  
		  //5. Locate surname from female radio button(Ancestor)
		  
		  
		  
		  driver.close();
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  driver.close();
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		
	}

}
