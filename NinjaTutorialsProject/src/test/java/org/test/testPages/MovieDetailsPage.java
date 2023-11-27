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

public class MovieDetailsPage {

	/*
	 * Create a MovieDetailsPageTest class and write the test cases for the below
	 * test scenarios,
	 * 
	 * Test the Movie Details Page In the Home Page click on any Movie and test all
	 * the UI elements present in it In the Popular Page click on any Movie and test
	 * all the UI elements present in it Close the browser window.
	 */
	
	public WebDriver driver;
	public WebDriverManager webDriverManager;
	public CommonUsage commonUsage;

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
	public void movieDetailsPage() throws Exception {
		commonUsage = new CommonUsage(driver);
		commonUsage.performLoginOperation("rahul","rahul@2021");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.findElement(By.xpath("//img[@alt='Shang-Chi and the Legend of the Ten Rings']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//button[normalize-space()='Play']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='movie-overview']")).isDisplayed());
		driver.findElement(By.xpath("//a[normalize-space()='Popular']")).click();
		driver.findElement(By.xpath("//img[@alt='The Amazing Spider-Man']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='The Amazing Spider-Man']")).getText().equalsIgnoreCase("The Amazing Spider-Man"));
	}
}
