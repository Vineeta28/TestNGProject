package alchemyJobs;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class Activity2 {
  
	WebDriver driver;
	
	
	@Test
  public void pageHeading() {
	  
		String pageHeader = driver.findElement(By.xpath("//header/h1[@class = 'entry-title']")).getText().toString();
		Reporter.log("Header of the page : "+pageHeader);
		}
	
  @BeforeClass
  public void openBrowser() {
	  System.out.println("Open Brower");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.get("https://alchemy.hguy.co/jobs");
		driver.manage().window().maximize();
	  
  }

  @AfterClass
 
  public void closeBrowser() {
	    driver.close();
  }

}
