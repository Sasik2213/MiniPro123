package org.test.testPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeaderSection {
	/*
	 * Test the Header Section Functionalities Test the navigation to Home and
	 * Popular pages through elements in header section Test the navigation to
	 * account page through elements in header section Close the browser window.
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

	By userName = By.xpath("//input[@id='usernameInput']");
	By passWord = By.xpath("//input[@id='passwordInput']");
	By submitKey = By.xpath("//button[normalize-space()='Login']");
	

	public void performLoginOperation(String uName, String Passcode) {
		driver.findElement(userName).sendKeys(uName);
		driver.findElement(passWord).sendKeys(Passcode);
		driver.findElement(submitKey).click();
	}

	

	@Test
	public void HeaderSectionFunc() throws Exception {

		performLoginOperation("rahul", "rahul@2021");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		WebElement Home = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
		Home.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		WebElement popular = driver.findElement(By.xpath("//a[normalize-space()='Popular']"));
		popular.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		WebElement profile = driver.findElement(By.xpath("//img[@alt='profile']"));
		profile.click();
		
		

	}

}
