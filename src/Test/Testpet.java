package Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.Cart;
import page.Login;
import page.Search;
import page.Signup;

public class Testpet {
WebDriver driver;
	@BeforeTest
	public void testbefore() throws Exception
	{
		
		 driver=new ChromeDriver();//driver will accessChromeDriver on the local machine, directly.
		 
		 driver.get("https://petstore.octoperf.com/actions/Catalog.action");//Fetching a web page 
		 driver.manage().window().maximize();//Maximize the window
			Thread.sleep(3000);//wait time
	 
	}
	
	@Test
	public void testt() throws IOException
	 {
		
		Search ob=new Search(driver);//create object of search object
		ob.setvalues("parrot");//passing value
		Signup sp = new Signup(driver);
		sp.setvalues();
		sp.userinfo("Swe2","123","123");
		sp.accinfo("Swetha", "Johnson", "swethajohn@gmail.com", "8139765253","Alapatt", "potta", "Kochi", "Kerala", "xyz", "India");
		sp.proinfo("english", "DOGS");
		
		String actual=driver.getCurrentUrl();
		URL n=new URL(actual);
		HttpURLConnection con=(HttpURLConnection)n.openConnection();
		con.connect();
		System.out.println("Response code:"+con.getResponseCode());
	 
		Cart cb=new Cart(driver);
		cb.setvalues("4");
	    Login Lb=new Login(driver);
		Lb.setvalues("123");
		String actual1=driver.getCurrentUrl();
		List<WebElement> links=driver.findElements(By.tagName("img"));//locates all elements with  tag name, “img.”
		System.out.println("total no of links="+links.size());//Fetch the number of links and displays it.
		for(WebElement u:links){
			 String link=u.getAttribute("src");
			 System.out.println(link);
		}		
}
}