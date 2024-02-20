package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class Search {

	WebDriver driver;
	
	By sdata=By.xpath("//*[@id=\"SearchContent\"]/form/input[1]");
	By link=By.xpath("//*[@id=\"BackLink\"]/a");
//creating constructor  to initialize the WebDriver object, which is the main entry point for interacting with the web browser using Selenium.
	public Search(WebDriver driver) {
		this.driver=driver;
	}
	
	public void setvalues(String sval)
	  {
		  driver.findElement(sdata).sendKeys(sval,Keys.ENTER);
		  driver.findElement(link).click();
		  
	  }
}