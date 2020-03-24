package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private  By userNameLoc = By.xpath("//input[@name='login']");
	private  By passWordLoc = By.xpath("//input[@name='password']");
	private  By loginButtonLoc = By.xpath("//input[@name='DoLogin']");
	private  By AdminIcon = By.xpath("//img[@src='images/administration-button.gif']");
	private  By logOut = By.xpath("//a[contains(text(),'Logout')]");
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public  void enterUserName(String username) {

		driver.findElement(userNameLoc).sendKeys(username);
	}

	public  void enterPassWord(String password) {

		driver.findElement(passWordLoc).sendKeys(password);
	}

	public  void clickOnLogin() {

		driver.findElement(loginButtonLoc).click();
	}

	public  void ClickOnAdminIcon() {
		driver.findElement(AdminIcon).click();
	}

	public  void ClickOnLogOut() {
		driver.findElement(logOut).click();
	}

}
