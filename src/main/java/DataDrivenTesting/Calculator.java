package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Calculator {

	public static void main(String[] args) throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		
		  driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		
		  //clicking on the popup but it is insepectable now
		  Thread.sleep(5000);
		 driver.findElement(By.xpath("//button[text()='No thanks']")).click();
		
		  FileInputStream fis= new FileInputStream("C:\\\\Users\\\\Mukesh\\\\Documents\\\\SeleniumAutomationFromScratch\\\\src\\\\test\\\\resources\\\\Data\\\\RegistrationForm.xlsx");
		  Workbook wb=WorkbookFactory.create(fis);
		  Sheet sh=wb.getSheet("Sheet2");
		  
		  int noofRows=sh.getLastRowNum();
		  System.out.println("No of Rows is : " + noofRows);
		  
		  //Here we are starting rows from 1 because 0 will take headers
		  for(int i=1;i<noofRows;i++)
		  {
			  Row row= sh.getRow(i);
			  
			  //Directly also we can write
			  //Here it is Typecasting because of converting string to number to remove decimal value
			  int princip=(int) row.getCell(0).getNumericCellValue();
			  
			  //splitting into two statements
			  //Typecasting the string to integer to remove . decimal values
			  Cell principlecell=row.getCell(0);
			  int princ=(int) principlecell.getNumericCellValue();
			  
			 
			  Cell roi=row.getCell(1);
			  int rateofinterest=(int) roi.getNumericCellValue();
			  	  
			  Cell period= row.getCell(2);
			  int per=(int) period.getNumericCellValue();
			  
			  Cell Frequency=row.getCell(3);
			  String freq=Frequency.getStringCellValue();
			  
			  Cell Maturityvalue=row.getCell(4);
			  double Exp_mvalue=(double) Maturityvalue.getNumericCellValue();
			
			  //Here if we give directly pricip value it is int so throws error
			  //Need to convert it to string
			  	driver.findElement(By.id("principal")).sendKeys(String.valueOf(princip));
			    driver.findElement(By.id("interest")).sendKeys(String.valueOf(rateofinterest));
			    driver.findElement(By.id("tenure")).sendKeys(String.valueOf(per));
			     
			    //selecting dropdown for period
			    WebElement tenureperiod=driver.findElement(By.id("tenurePeriod"));
			    Select se= new Select(tenureperiod);
			    se.selectByVisibleText("year(s)");
			    
			    //selecting drop down for frequency
			    WebElement compound=driver.findElement(By.id("frequency"));
			    Select sel= new Select(compound);
			   sel.selectByVisibleText("Simple Interest");
			  //  sel.selectByValue(freq);
			    
			    
			driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();
			  
			//If we directly assign it will throw error
			//so need to convert to gettext method
		String Actual_mvalue= driver.findElement(By.xpath("//*[@id=\"resp_matval\"]")).getText();
		
			  
			  if((Double.parseDouble(Actual_mvalue))==Exp_mvalue)
			  {
				  
				  System.out.println("Test passed");
			  }
			  
			  else
			  {
				  System.out.println( "Test Failed");
			  }
		 
		  
			  //clearing all fields at a time
			  driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[2]/img")).click();
		  
		  
		  }
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		
		

	}

}
