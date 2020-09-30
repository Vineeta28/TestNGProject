package alchemyJobs;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class Activity1 {
	
	WebDriver driver;
	String title;
	
  @Test
  public void titleCheck() {
	  title = driver.getTitle();
	  Reporter.log("Title of the page : "+ title);
		
  }
  
  @BeforeClass
  public void openBrowser() {
	  System.out.println("Open Brower");
	  Reporter.log("Open Browser");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.get("https://alchemy.hguy.co/jobs");
		driver.manage().window().maximize();
	  
  }

  @AfterClass 
  public void closeBrowser() {
	  Assert.assertEquals(title, "Alchemy Jobs – Job Board Application");
	  driver.close();
  }

}
