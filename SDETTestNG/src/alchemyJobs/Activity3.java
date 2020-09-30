package alchemyJobs;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Activity3 {
	
	WebDriver driver;
	
  @Test
  public void urlHeaderImage() {
	  
	  String urlHeader = driver.getCurrentUrl();
	  System.out.println(" Url Header of the Image : "+urlHeader);
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
