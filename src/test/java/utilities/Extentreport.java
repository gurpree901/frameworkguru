package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Testcases.Baseclass;

public class Extentreport implements ITestListener{
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;

	String repname;
	
	public void onstart(ITestContext testContext)
	{
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repname ="Test-Report-"+timestamp+".html";
		sparkreporter=new ExtentSparkReporter(".\\reports\\"+repname);
		sparkreporter.config().setDocumentTitle("automation report"); //title of the report
		sparkreporter.config().setReportName("functional testing");
		sparkreporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Application", "opencart");
		extent.setSystemInfo("module", "Admin");
		extent.setSystemInfo("submodule", "coustomers");
		extent.setSystemInfo("user name", System.getProperty("username"));
		extent.setSystemInfo("Environment", "QA");
		
		String os=testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("operating System", os);
		
		String browser=testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includeGroups=testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includeGroups.isEmpty())
		{
			extent.setSystemInfo("Groups", includeGroups.toString());
		}
	}
	
	public void ontestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS,result.getThrowable().getMessage());
	}
	
	public void ontestfailure(ITestResult result) throws IOException
	{
		extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName()+"got failed");
		test.log(Status.INFO,result.getThrowable().getMessage());
		try
		{
		String imgpath= new Baseclass().captureScreeen(result.getName());
		test.addScreenCaptureFromPath(imgpath);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public void ontestskipped(ITestResult result)
	{
		test =extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+"got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
	}
	
	public void ontestfinished(ITestResult result) throws IOException
	{
		//flushing the report
		extent.flush();
		//automatically
		String pathofExtentReport=System.getProperty("user.dir")+"\\reports\\"+repname;
		File extentreport=new File(pathofExtentReport);
		try
		{
		Desktop.getDesktop().browse(extentreport.toURI());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		/*{
			URL url=new URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repname);
			ImageHtmlEmail email=new ImageHtmlEmail();
			email.setDataSourceResolver(new DataSourceUrlResolver(url));
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("singgurpreet56481@gmail.com","password"));
			email.setSSLOnConnect(true);
			email.setFrom("singhgurpreet56481@gmail.com");
			email.setSubject("testresult");
			email.setMsg("please find attach report");
			email.addTo("gurpreet@gmail.com");
			email.attach(url,"ExtentReport","please check report");
			email.send();
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
	
		
		
		
			
				
	}
		
	}


