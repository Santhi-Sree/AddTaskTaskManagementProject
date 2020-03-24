package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cts.base.LaunchWebDriver;

public class AdministrationPage {

	private By addTaskIconLoc = By.xpath("//img[@src='images/add-task-button.gif']");
	private By taskListLoc = By.xpath("//img[@src='images/task-list-button.gif']");
	private By prioritiesLoc = By.xpath("//a[text()='Priorities']");
	private By projectsLoc = By.xpath("//a[text()='Projects']");
	private By statusesLoc = By.xpath("//a[text()='Statuses']");
	private By typesLoc = By.xpath("//a[text()='Types']");
	private By errorTextLoc = By.xpath("//td[contains(text(),'Login or Password is incorrect.')]");

	private WebDriver driver;

	public AdministrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnAddTaskIcon() {

		driver.findElement(addTaskIconLoc).click();

	}

	public void clickOnTaskListIcon() {

		driver.findElement(taskListLoc).click();
	}

	public void clickingPriorities() {
		driver.findElement(prioritiesLoc).click();
	}

	public void clickingProjects() {
		driver.findElement(projectsLoc).click();
	}

	public void clickingStatuses() {
		driver.findElement(statusesLoc).click();
	}

	public void clickingTypes() {
		driver.findElement(typesLoc).click();
	}

	public String getErrorText() {

		return LaunchWebDriver.driver.findElement(errorTextLoc).getText();
	}

}
