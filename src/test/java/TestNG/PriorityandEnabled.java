package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PriorityandEnabled
{

	 @Test(priority=5,enabled=true,invocationCount=3)
	  public void abc()
	  {
		  Reporter.log("Enable successfully");
	  }

    //only enabled =true will execute here                
	/* PASSED: abc
	 PASSED: abc
	 PASSED: abc
    */   //even if we keep invocation count also it will not take
	                                                            
	  @Test(priority=-1,enabled=false,invocationCount=5)
	  public void xyz()
	  {
		  Reporter.log("Not Enabled successfully");
	  }

	
	
	
	
}
