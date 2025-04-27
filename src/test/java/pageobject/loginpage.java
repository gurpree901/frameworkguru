package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginpage extends Basepage{
       //constructor
	public loginpage(WebDriver driver) {
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//input[@id='input-email']") WebElement username;
	@FindBy(xpath="//input[@id='input-password']") WebElement password;
	@FindBy(xpath="//input[@id='input-password']") WebElement button;
	
	//Action methods
	public void setusername(String usr)
	{
		username.sendKeys(usr);
	}
	
	public void setpassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickbutton()
	{
		button.click();
	}

}
