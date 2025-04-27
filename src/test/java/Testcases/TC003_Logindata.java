package Testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobject.Homepage;
import pageobject.Myaccount;
import pageobject.loginpage;

public class TC003_Logindata extends Baseclass {
	@Test(dataProvider="logindata",dataProviderClass=DataProvider.class)
	public void verify_logindata(String email,String pwd,String exp)
	{
		logger.info("******startTC003_Logindata*******");
		//HOMEPAGE
		try
		{
		Homepage hp=new Homepage(driver);
		hp.clickMyaccount();
		hp.clicklogin();
		
		//Login
		
		loginpage lp=new loginpage(driver);
		lp.setusername(email);
		lp.setpassword(pwd);
		lp.clickbutton();
		
		Myaccount my=new Myaccount(driver);
		boolean targetpage=my.ismyaccountexist();
		if(exp.equalsIgnoreCase("valid"))
		{
			if(targetpage==true)
			{
				my.clicklogout();

				AssertJUnit.assertTrue(true);
			}
			else
			{
				AssertJUnit.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetpage==true)
			{
				my.clicklogout();
				AssertJUnit.assertTrue(false);
			}
			else
			{
				AssertJUnit.assertTrue(true); 
			}
		}
		}catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*****Finished TC003_LoginData******");

	

		
		
	}
	

}
