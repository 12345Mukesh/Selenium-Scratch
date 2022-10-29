package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingLoops {

	public static void main(String[] args) throws Throwable, IOException 
	{
	
		WebDriver driver=new ChromeDriver();
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		
		  driver.get("http://newtours.demoaut.com/");
		
		  FileInputStream fis= new FileInputStream("C:\\Users\\Mukesh\\Documents\\SeleniumAutomationFromScratch\\src\\test\\resources\\Data\\RegistrationForm.xlsx");
		  Workbook wb= WorkbookFactory.create(fis);
			
		  Sheet sh=wb.getSheet("Sheet1");
		   
		  //printing last row value 
		int noofRows= sh.getLastRowNum();
		System.out.println("Total no of Rows : " + noofRows);
		  
	
		//In first row how many columns are there we are taking the final value
		//For column there is no method as lastrownum so we taking lastcellnum
		
		  int columncount=sh.getRow(0).getLastCellNum();
		   System.out.println("Total no.of.Columns : " + columncount);
		
		for(int i=0;i<noofRows;i++)
		{
			Row current_row=sh.getRow(i);
			
			
			   
			   /*
			   //webpage is not loading so we didnt inserted these elements
			   String Firstname=current_row.getCell(0).getStringCellValue();
				String Lastname=current_row.getCell(1).getStringCellValue();
				String phone=current_row.getCell(2).getStringCellValue();
				String Email=current_row.getCell(3).getStringCellValue();
				String Address=current_row.getCell(4).getStringCellValue();
				String City=current_row.getCell(5).getStringCellValue();
				String State=current_row.getCell(6).getStringCellValue();
				String Pincode=current_row.getCell(7).getStringCellValue();
				String Country=current_row.getCell(8).getStringCellValue();
				String Username=current_row.getCell(9).getStringCellValue();
				String Password=current_row.getCell(10).getStringCellValue();
			  */
			   
			for(int j=0;j<columncount;j++)
			{
				//Going to that row first and then printing cell by cell
				  String cellvalue=current_row.getCell(j).toString();
				  System.out.print("  " + cellvalue);
			}
			
			 System.out.println();
		}
		
		
		
		
		
		
		
	}

}
