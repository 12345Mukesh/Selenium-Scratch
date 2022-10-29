package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDriven1 {

	public static void main(String[] args) throws IOException 
	{
		//WebDriver driver=new ChromeDriver();
//		  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
//		  driver.manage().window().maximize();
//		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
//		
		  FileInputStream fis= new FileInputStream("C:\\Users\\Mukesh\\Documents\\SeleniumAutomationFromScratch\\src\\test\\resources\\Data\\InputData.xlsx");
		//  XSSFWorkbook wb= new XSSFWorkbook(fis);
		  //For workbookFactory instead of create method other methods are generating
	 Workbook wb= WorkbookFactory.create(fis);
		   
		  //1.Getting sheet number
		  Sheet sh=wb.getSheet("Sheet1");
		  
		  Row r= sh.getRow(5);
		  Cell c= r.getCell(1);
		  String cellvalue=c.getStringCellValue();
		  System.out.println(cellvalue);
		  
		  String value= wb.getSheet("Sheet1").getRow(4).getCell(2).getStringCellValue();
		  System.out.println(value);
		 
		  
		  //2.getting row count
		    int rowcount = sh.getLastRowNum();
		   System.out.println(rowcount);
		  
		   //3.getting column count
		   int columncount=sh.getRow(0).getLastCellNum();
		   System.out.println(columncount);
		   
		   /*
		    * 1. First getting row count and column count
		    * 2. Iterating using inner loops as normal java program
		    * 3. First going to row loop if it is true then will go to column loop
		    * 4. If columnn loop is true it will go inside inner loop and works
		    * 5. After again comes to outer row loop
		    * 6. Like this it will work untill row count fails
		    */
		   
		   for(int i=0;i<rowcount;i++)
		   {
			   //focuss on current row
			   Row currentrow = sh.getRow(i);  
			   
			   for(int j=0;j<columncount;j++)
			   {
				   //Read the value from the cell
				String value1=   currentrow.getCell(j).toString();
				
			    //The prints method simply print text on the console and does not add any new line
				System.out.print("  "  +value1);
			   }
		      //While println adds new line after print text on console
			   System.out.println();
		   }
		   
		
		 
		
	}

}
