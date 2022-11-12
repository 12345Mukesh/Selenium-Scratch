package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class GroupingExecution
{

	/*
	 * Groups will execute according to alphabetic order irrespective of which order we try to execute
	 * 
//Directly running
Functional test1
Functional test2
Functional test3
IT test1
IT test2
It test3
Smoke test1
Smoke test2
Smoke test3

//we will add run then only we can include or exclude
//If we exclude Smoke Group we will get this output
Functional test1
Functional test2
Functional test3
IT test1
IT test2
It test3


*/
	
	
	
	@Test(groups="Smoke Group")
	public void smoke1()
	{
		Reporter.log("Smoke test1", true);
	}
	
	@Test(groups="Functional Group")
	public void ft1()
	{
		Reporter.log("Functional test1", true);
	}
	
	@Test(groups="Smoke Group")
	public void smoke2()
	{
		Reporter.log("Smoke test2", true);
	}
	
	@Test(groups="Functional Group")
	public void ft2()
	{
		Reporter.log("Functional test2", true);
	}
	
	@Test(groups="Smoke Group")
	public void smoke3()
	{
		Reporter.log("Smoke test3", true);
	}
	
	
	@Test(groups="IT Group")
	public void itgrp1()
	{
		Reporter.log("IT test1", true);
	}
	

	@Test(groups="Functional Group")
	public void ft3()
	{
		Reporter.log("Functional test3", true);
	}


	@Test(groups="IT Group")
	public void itgrp2()
	{
		Reporter.log("IT test2", true);
	}

	@Test(groups="IT Group")
	public void itgrp3()
	{
		Reporter.log("It test3", true);
	}





}
