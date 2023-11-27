package org.test.testPages;
/*
Test the Home Page

Test the heading texts of each section
Test whether the play button is displayed or not
Test whether the Movies are displayed, in the corresponding movies sections
Test the Contact Us Section
Close the browser window.
*/

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage {
	
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
	public void testName() throws Exception {
		
		driver.findElement(By.xpath("//input[@id='usernameInput']")).sendKeys("rahul");
		driver.findElement(By.xpath("//input[@id='passwordInput']")).sendKeys("rahul@2021");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Trending Now']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//button[normalize-space()='Play']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Avatar']")).isDisplayed());
		WebElement footer = driver.findElement(By.xpath("//div[@class='footer-container']"));
		Assert.assertTrue(footer.findElement(By.xpath("//p[@class='contact-us-paragraph']")).isDisplayed());
		
		
	}
	

}
