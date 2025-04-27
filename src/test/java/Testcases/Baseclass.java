package Testcases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Baseclass {
	
	public WebDriver driver;
	public Properties p;
	public org.apache.logging.log4j.Logger logger;
	public org.apache.logging.log4j.Logger logger1;
	@BeforeClass(groups= {"sanity","Reggression","Master","Datadriven"})
	@Parameters({"Os" ,"browser"})
	public void setup(String os,String br)
	{
		//Loading config.properties file
		
		logger=LogManager.getLogger(this.getClass());
		switch(br.toLowerCase())
		{
		case "chrome" :driver=new ChromeDriver(); break;
		case "edge" :driver=new ChromeDriver(); break;
		case "firefox" :driver=new ChromeDriver(); break;
		default :System.out.println("invalid browser name..."); return;
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();



		
	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
		
		
	}
	public String randomenumber()
	{
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return generatednumber;
		
	}
	public String aplhanumeric()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return (generatedstring+"@"+generatednumber);


	}
	//Screenshot on failure
	
	public String captureScreeen(String tname)
	{
		String timestamp= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot) driver;
		File Source_file=ts.getScreenshotAs(OutputType.FILE);
		String target_file=System.getProperty(System.getProperty("user.dir")+"\\screenshot\\"+ tname+ "_"+timestamp+".png");
		File target_file1=new File(timestamp);
		Source_file.renameTo(target_file1);
		return target_file;
		
	}
	


}
