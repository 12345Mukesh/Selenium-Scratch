package TestNG;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data
{

	//If we give class name as dataprovider it will not work
	@DataProvider
	public Object[][] databank1()
	{
		Object[][] obj= new Object[2][2];
		   
		obj[0][0]="admin1";
		obj[0][1]="manager";
		obj[1][0]="admin2";
		obj[1][1]="Employee";
		
		return obj;	
	}
	
	@DataProvider
	public Object[][] databank2()
	{
		Object[][] obj= new Object[2][3];
		   
		obj[0][0]="admin1";
		obj[0][1]="manager";
		obj[0][2]="Hyd";
		obj[1][0]="admin2";
		obj[1][1]="Employee";
		obj[1][2]="Goa";
		
		return obj;	
	}
	
	@Test(dataProvider="databank2")
	public void GetData(String un, String pwd, String city)
	{
		Reporter.log(un+"----"+pwd+"-----"+city);
	}
	
}
