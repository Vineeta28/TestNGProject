package alchemyJobs;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class Activity6 {
  
	WebDriver driver;
	
	@Test
  public void f() throws InterruptedException {
		driver.findElement(By.id("search_keywords")).sendKeys("Testing");
		driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
		Thread.sleep(1000);
	    WebElement element = driver.findElement(By.xpath("//h3[text() = 'Senior tester']"));
	    Actions actions = new Actions(driver);
	    actions.moveToElement(element);
	    actions.perform();
		element.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Apply for job']")).click();
		Thread.sleep(1000);
		String email = driver.findElement(By.xpath("//p/a")).getText();
		System.out.println("Printing the email at console : "+ email);
		Reporter.log("Printing the email at console : "+ email);
  }
  
  
  @BeforeClass
  public void openBrowser() {
	  System.out.println("Open Brower");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.get("https://alchemy.hguy.co/jobs/jobs/");
		driver.manage().window().maximize();
	  
  }

  @AfterClass
 
  public void closeBrowser() {
	  driver.close();
  }

}
