package Testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.Homepage;
import pageobject.Myaccount;
import pageobject.loginpage;

public class TC002_Logintest extends Baseclass{
	@Test(groups="Regression")
	public void verifylogin()
	{
	  
	  
			
		logger.info("****** starting TC002_Logintest******");
		try
		{
		Homepage hp=new Homepage(driver);
		hp.clickMyaccount();
		hp.clicklogin();
		//login
		loginpage lp=new loginpage(driver);
		lp.setusername(p.getProperty("Email"));
		lp.setpassword(p.getProperty("password"));
		lp.clickbutton();
		
		// Account page
		Myaccount my=new Myaccount(driver);
		boolean targetpage=my.ismyaccountexist();
		AssertJUnit.assertTrue(targetpage);
	     }
		 catch(Exception e)
		{
			 logger.info("catch block log " +e);
			 Assert.fail();
		}
		
		
		
		logger.info("******finishing TC002_**** TEST");
		}
	
	
}
	
		
	


