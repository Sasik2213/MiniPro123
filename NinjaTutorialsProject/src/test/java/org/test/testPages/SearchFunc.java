package org.test.testPages;

import java.time.Duration;
import java.util.List;

import org.common.CommonUsage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchFunc {
	/*
	 * Test the Search Functionality Test the Search functionality by searching with
	 * some movie names and the count of movies displayed Close the browser window.
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
	public void SearchTesting() throws Exception {
		commonUsage = new CommonUsage(driver);
		commonUsage.performLoginOperation("rahul","rahul@2021");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.findElement(By.xpath("//button[@class='search-empty-button']")).click();
		driver.findElement(By.xpath("(//input[@id='search'])[1]")).sendKeys("");
		driver.findElement(By.xpath("//button[@class='search-button']")).click();
		List<WebElement> movieContainer = driver.findElements(By.xpath("//div[@class='home-search-container']"));
		System.out.println("No of Movies Displayed:"+movieContainer.size());
		
		
	}
	
	

}
