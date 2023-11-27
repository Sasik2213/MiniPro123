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

public class AccountPage {

	/*
	 * Create a AccountPageTest class and write the test cases for the below test
	 * scenarios,
	 * 
	 * Test the Account Page Test all the UI elements present on the web page. Test
	 * the Logout functionality Close the browser window.
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
	public void accountPageTesting() throws Exception {

		CommonUsage commonUsage = new CommonUsage(driver);
		commonUsage.performLoginOperation("rahul", "rahul@2021");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.findElement(By.xpath("//button[@class='avatar-button']")).click();
		System.out.println(driver.findElement(By.xpath("//p[@class='membership-username']")).getText());
		System.out.println(driver.findElement(By.xpath("//p[@class='membership-password']")).getText());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='membership-username']")).getText().equalsIgnoreCase("User name : rahul"));
		driver.findElement(By.xpath("//button[normalize-space()='Logout']")).click();
	}

}
