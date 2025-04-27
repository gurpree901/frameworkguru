package day1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenlinksk {

	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		for(WebElement li:links)
		{
			String ss=li.getAttribute("href");
			if(ss.isEmpty() || ss==null)
			{
				System.out.println("unable to find the links..");
				continue;
			}
			
			URL ul=new URL(ss);
			HttpURLConnection res=(HttpURLConnection) ul.openConnection();
			res.connect();
			if(res.getResponseCode()>=400)
			{
				System.out.println(ss+"broken links");
			}
			else
			{
				System.out.println("not  broke links");
			}
			
		}

	}

}
