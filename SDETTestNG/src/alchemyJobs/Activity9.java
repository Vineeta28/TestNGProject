package alchemyJobs;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity9 {
	
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
		  driver.findElement(By.xpath("//div[text()='Job Listings']")).click();
		  try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  driver.findElement(By.xpath("//a[@href = 'post-new.php?post_type=job_listing']")).click();
		  try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  driver.findElement(By.xpath("//button[@aria-label = 'Close dialog']")).click();
		  driver.findElement(By.id("post-title-0")).sendKeys("SDETTester");
		  driver.findElement(By.id("_company_website")).sendKeys("alchemy.xyz.com");
		  driver.findElement(By.id("_company_tagline")).sendKeys("Alchemy_jj");
		  driver.findElement(By.xpath("//button[@class='components-button editor-post-publish-panel__toggle editor-post-publish-button__button is-primary']")).click();
		  try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  driver.findElement(By.xpath("//button[text() = 'Publish']")).click();
		  
		  // to view the Job
		  driver.findElement(By.xpath("//a[text() = 'View Job']")).click();
		  
		  String jobListing = driver.findElement(By.xpath("//h1[text() = 'SDETTester']")).getText().toString();
		  Assert.assertEquals(jobListing, "SDETTester");
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
		//  driver.close();
	  }

}
