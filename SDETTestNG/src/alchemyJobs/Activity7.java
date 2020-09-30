package alchemyJobs;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity7 {
  
	WebDriver driver;
	
	@Test
  public void f() {
	  driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/post-a-job/']")).click();
	  driver.findElement(By.id("create_account_email")).sendKeys("vineeta@xyz.com");
	  driver.findElement(By.id("job_title")).sendKeys("SDETTesting");
	  driver.findElement(By.id("job_location")).sendKeys("Bangalore");
	  driver.switchTo().frame("job_description_ifr");
	  System.out.println("Putting values");
	  driver.findElement(By.xpath("//body/p")).sendKeys("This is for SDET Testing profile");
	  System.out.println("Moving to default content");
	  driver.switchTo().defaultContent();
	  driver.findElement(By.id("application")).sendKeys("https://alchemy.jobs.com");
	  driver.findElement(By.id("company_name")).sendKeys("Alchemy");
	  driver.findElement(By.name("submit_job")).click();
	  driver.findElement(By.id("job_preview_submit_button")).click();
	  driver.findElement(By.xpath("//a[text()='click here']")).click();
	  driver.findElement(By.xpath("//a[@href = 'https://alchemy.hguy.co/jobs/jobs/']")).click();
	  driver.findElement(By.id("search_keywords")).sendKeys("SDETTesting");
		driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  Assert.assertEquals(driver.findElement(By.xpath("//h3[text() = 'SDETTesting']")).getText().toString(), "SDETTesting");
	  
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
