package org.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonUsage {
	public static WebDriver driver;
	public CommonUsage(WebDriver driver) {
		this.driver=driver;
	}
	By userName = By.xpath("//input[@id='usernameInput']");
	By passWord = By.xpath("//input[@id='passwordInput']");
	By submitKey = By.xpath("//button[normalize-space()='Login']");

	public  void performLoginOperation(String uName, String Passcode) {
		driver.findElement(userName).sendKeys(uName);
		driver.findElement(passWord).sendKeys(Passcode);
		driver.findElement(submitKey).click();
	}
}
