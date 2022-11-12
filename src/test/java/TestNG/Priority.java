package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Priority 
{
    @Test(priority=-35)
    public void run() 
    {
       	Reporter.log("Priority bigger negative", true);
    }
	
    
    @Test(priority=5)
    public void run1()
    {
    	Reporter.log("Standard positive", true);
    }
    
    @Test(priority=0)
    public void run2()
    {
    	Reporter.log("Standard zero", true);
    }
	

    @Test(priority=-5)
    public void run3()
    {
    	Reporter.log("Priority normal negative", true);
    }

  @Test(priority=35)
  public void run4()
  {
	  Reporter.log("Standard bigger positive", true);
  }
  
  
  /* Execution order
   * Priority bigger negative
Priority normal negative
Standard zero
Standard positive
Standard bigger positive
PASSED: run3
PASSED: run
PASSED: run2
PASSED: run4
PASSED: run1
   */



}
