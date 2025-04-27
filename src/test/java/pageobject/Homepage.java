package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage {
	
	//constructor

	public Homepage(WebDriver driver) {
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement lnkaccount;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']") WebElement linkregister;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']") WebElement login;
	//Action methods
	
	public void clickMyaccount()
	{
		lnkaccount.click();
	}
	
	public void clickregister()
	{
		linkregister.click();
	}
	
	public void clicklogin()
	{
		login.click();
	}
	

}
