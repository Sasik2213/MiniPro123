package org.test.testPages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/*Create a HeaderSectionTest class and write the test cases for the below test scenarios,

Test the Header Section UI
Test whether the Website logo is displayed
Test the Navbar elements
Close the browser window.
*/
public class HeaderFunc {
	public WebDriver driver;
	public WebDriverManager webDriverManager;
	
	By userName = By.xpath("//input[@id='usernameInput']");
	By passWord = By.xpath("//input[@id='passwordInput']");
	By submitKey = By.xpath("//button[normalize-space()='Login']");
	
	private void performLoginOperation(String uName,String Passcode) {
		driver.findElement(userName).sendKeys(uName);
		driver.findElement(passWord).sendKeys(Passcode);
		driver.findElement(submitKey).click();
	}
	

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
	public void Header() throws Exception {
		performLoginOperation("rahul","rahul@2021");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		Assert.assertTrue(driver.findElement(By.xpath("//nav[@class='nav-header ']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='website logo']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Popular']")).isDisplayed());
	}
}
