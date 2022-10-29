package DropdownsStatic;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SingleDropDown
{
	
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		  driver.get("file:///E:/QSpiders/Selenium/Website%20projects/SingleDropdown.html");
	     WebElement addr=  driver.findElement(By.id("novotel"));
	     
		Select sel=  new Select(addr);
		sel.selectByVisibleText("PUL ICE");
		sel.selectByValue("h");
		sel.selectByIndex(6);
		
		//we cannot get the size for sel option so need to change to list of webelement
		//from sel option we cannot print or list the elements in drop down so we added list of webelement
		
		List<WebElement>multi=sel.getOptions();
		for(int i=0;i<=multi.size()-1;i++)
		{
			sel.selectByIndex(i);
			Thread.sleep(5000);
			String abc=multi.get(i).getText();
			System.out.println(abc);
		}
		
		//This command will not work because it is used for multiselect dropdown
		  sel.deselectAll();
		
		
		
		if(sel.isMultiple())
		{
			System.out.println("It is multiple dropdown");
		}
		else
		{
			System.out.println("It is single dropdown");
		}
		
		  driver.close();
		  
	}

}
