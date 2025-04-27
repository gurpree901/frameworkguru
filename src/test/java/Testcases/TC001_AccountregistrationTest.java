package Testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobject.Homepage;
import pageobject.registration;

public class TC001_AccountregistrationTest extends Baseclass {

	@Test(groups= {"Regression","master"})
	public void verify_account_registration()
	{
		logger.info("****** starting TC001_Accountregsitration******");
		Homepage hp=new Homepage(driver);
		hp.clickMyaccount();
		logger.info("click on login my account");
		hp.clickregister();
		logger.info("click on register link");
		registration rg=new registration(driver);
		logger.info("providing coustmer details....");
		rg.setusername(randomestring().toUpperCase());
		rg.setlastname(randomestring().toUpperCase());
		rg.setmail(randomestring()+"@gmail.com");
		rg.settelephone(randomenumber());
		String password=aplhanumeric();
		rg.password(password);
		rg.confirmpwd(password);
		rg.agree();
		rg.clickbutton();
		
		logger.info("******finished TC001_Accountregistration********** ");
		
		/*String confmsg=rg.getconfirmationmsg();
		Assert.assertEquals(confmsg, "your account has been created succesfully");*/
	}
	
	

}
