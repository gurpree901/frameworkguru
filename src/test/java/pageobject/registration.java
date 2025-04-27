package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class registration extends Basepage{
    //Constructor
	public registration(WebDriver driver) {
		super(driver);
	}
	
	
	//locators
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement username;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement lastname;
	@FindBy(xpath="//input[@id='input-email']") WebElement email;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement telephone;
	@FindBy(xpath="//input[@id='input-password']")WebElement password;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement repassword;
	@FindBy(xpath="//input[@name='agree']") WebElement agree;
	@FindBy(xpath="//input[@value='Continue']") WebElement button;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgconfirmation;
	
	//Action methods
	
	public void setusername(String usr)
	{
		username.sendKeys(usr);
	}
	
	public void setlastname(String lname)
	{
		lastname.sendKeys(lname);
	}
	
	public void setmail(String mail)
	{
		email.sendKeys(mail);
	}
	
	public void settelephone(String tele)
	{
		telephone.sendKeys(tele);
	}
	
	public void password(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void confirmpwd(String confpwd)
	{
		repassword.sendKeys(confpwd);
	}
	
	public void agree()
	{
		agree.click();
	}
	
	public void clickbutton()
	{
		button.click();
	}
	
	public String getconfirmationmsg()
	{
		try
		{
			return(msgconfirmation.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
		
	}

}
