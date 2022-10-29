package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingData {

	public static void main(String[] args) throws Throwable
	{
		//writing data in excel sheet - For single value
	   FileInputStream fis= new FileInputStream("C:\\Users\\Mukesh\\Documents\\SeleniumAutomationFromScratch\\src\\test\\resources\\Data\\InputData.xlsx");
	   Workbook wb= WorkbookFactory.create(fis);
	   Sheet sh=wb.getSheet("Sheet2");
//	   Row r=sh.getRow(0);
//		Cell c=r.createCell(3);
//		c.setCellValue("India is great");

		//Reading the data from excel sheet
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Mukesh\\Documents\\SeleniumAutomationFromScratch\\src\\test\\resources\\Data\\InputData.xlsx");
		
		System.out.println("Started writing");
		
	
		//sometimesRow should always start from 0-> if we give another value it will throw null pointer exception
		//Now it is working fine
		//we can give what row we want
		for(int i=5;i<9;i++)
		{
			
			Row row=sh.createRow(i);
			
			//going into the column and cell value
			for(int j=0;j<3;j++)
			{
				row.createCell(j).setCellValue("abc");
			}
			
		}
		wb.write(fos);
		fos.close();
		System.out.println("completed data ito Excel sheet");
		
	}

}
