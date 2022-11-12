package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Enabled {

	  @Test(enabled=true)
	  public void abc()
	  {
		  Reporter.log("Enable successfully");
	  }

         //only enabled =true will execute here
	  
	  @Test(enabled=false)
	  public void xyz()
	  {
		  Reporter.log("Not Enabled successfully");
	  }

}
