package KeyWordDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class KeyValue {

	public static void main(String[] args) throws Throwable 
	{
	   FileInputStream fis= new FileInputStream("C:\\Users\\Mukesh\\Documents\\SeleniumAutomationFromScratch\\src\\test\\resources\\Data\\Config.properties.txt");
	   
	   Properties prop= new Properties();
	   prop.load(fis);
		
	   
	   //Retrieving data from the config.property file
	   //Just giving direct value
	   String value=prop.getProperty("url");
	   //We have to give like this for getting two possbiities
	   //1.If the key is correct we will get the value of the key(But it should be same as given in file - case sensitive)
	   //2.If the key is not correct we will get the beside key in value1 as Incorrect Key
	   String value1=prop.getProperty("username", "Incorrect Key");
	   System.out.println(value);
		System.out.println(value1);

	}

}
