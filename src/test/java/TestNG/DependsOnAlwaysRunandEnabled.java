package TestNG;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependsOnAlwaysRunandEnabled 
{
	
	/*
	 *1. For enabled=true 
	 *
	 *Successfully Run1
	 *will run even assertion gets fail
	 *Enabled true now
	 *
	 *PASSED: run3
	 *PASSED: run1
	 *PASSED: run4
	 *
	 * FAILED: run
	 * SKIPPED: run2
	 * 
	 *Total tests run: 5, Passes: 3, Failures: 1, Skips: 1
	 * 
	 * 
	 * 
	 * 2. For enabled=false
	 * 
	 * Successfully Run1
	 * will run even assertion gets fail
	 * 
	 * PASSED: run1
	 * PASSED: run3
	 * 
	 * FAILED: run
	 * SKIPPED: run2
	 * 
	 * run4 method is not even in the list also and whether it is failed or skipped dont know also
	 * 
	 * Total tests run: 4, Passes: 2, Failures: 1, Skips: 1
	 */
	
	
	
	//It will fail because we made assert fail
	 @Test()
	    public void run() 
	    {
		    Assert.fail();
	       	Reporter.log("Successfully Run", true);
	    }
		
	    
	    @Test()
	    public void run1()
	    {
	    	Reporter.log("Successfully Run1", true);
	    }
	    
	    //This method will get skipped because run method we intentionally made failed so it depends on that method
	    @Test(dependsOnMethods = {"run","run1"})
	    public void run2()
	    {
	    	Reporter.log("Successfully Run+Run1", true);
	    }
		
   
	    //This method will pass because even run2 methods fails also we gave always run= true
	    //alwaysRun is powerful than depends on methods
	    @Test(dependsOnMethods = {"run2"},alwaysRun = true)
	    public void run3()
	    {
	    	Reporter.log("will run even assertion gets fail", true);
	    }

	    //If we keep enabled= true , it will show the success result in the console
	    //If we keep enabled=false , it will not show even skipped also in console
	    
	  @Test(dependsOnMethods = {"run3"},alwaysRun=true,enabled = false)
	  public void run4()
	  {
		  Reporter.log("Enabled true now", true);
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
