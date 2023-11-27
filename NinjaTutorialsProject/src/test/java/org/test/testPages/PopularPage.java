package org.test.testPages;

import java.time.Duration;

import org.common.CommonUsage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PopularPage {
	/*
	 * Create a PopularPageTest class and write the test cases for the below test
	 * scenarios,
	 * 
	 * Test the Popular Page UI Test whether the movies are displayed
	 */
	public WebDriver driver;
	public WebDriverManager webDriverManager;

	@BeforeTest
	public void StartBrowser() {
		/* Setup Chrome Browser Driver */
		webDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://qamoviesapp.ccbp.tech/");
	}

	@AfterTest
	public void closeBrowser() {
		/* Close the Browser */
		driver.quit();
	}
	
	@Test
	public void PopularPage() throws Exception {
		CommonUsage commonUsage = new CommonUsage(driver);
		commonUsage.performLoginOperation("rahul", "rahul@2021");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.findElement(By.xpath("//a[normalize-space()='Popular']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='PAW Patrol: The Movie']")).isDisplayed());
		
		
	}

}
