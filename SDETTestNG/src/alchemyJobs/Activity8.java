package alchemyJobs;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity8 {
	
	WebDriver driver;
	
  @Test
  public void login() {
	  driver.findElement(By.id("user_login")).sendKeys("root");
	  driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
	  driver.findElement(By.id("wp-submit")).click();
	  try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  String title = driver.getTitle();
	  System.out.println(title);
	  Assert.assertEquals(title, "Dashboard ‹ Alchemy Jobs — WordPress");
  }
  

  
  @BeforeClass
  public void openBrowser() {
	  System.out.println("Open Brower");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
		driver.manage().window().maximize();
	  
  }

  @AfterClass
 
  public void closeBrowser() {
	  driver.close();
  }
  
}
