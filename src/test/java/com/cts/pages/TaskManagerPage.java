package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TaskManagerPage {

	private By addNewTaskLoc = By.linkText("Add New Task");
	private By assinedToLoc = By.name("assign_to");
	private By projectLoc = By.name("project_id");
	private By priorityLoc = By.name("priority_id");
	private By statusLoc = By.name("status_id");
	private By typeLoc = By.name("type_id");
	private By searchLoc = By.name("DoSearch");
	private By resultLoc = By.linkText("Code with one hand.");
	private By existingTaskLoc = By.linkText("Get armed");

	private WebDriver driver;

	public TaskManagerPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnaddNewTask() {

		driver.findElement(addNewTaskLoc).click();
	}

	public void clickOnTask() {

		driver.findElement(existingTaskLoc).click();
	}

	public void clickOnExistingTask() {

		driver.findElement(existingTaskLoc).click();
	}

	public void selectAssignedTo(String assinedTo) {

		Select select = new Select(driver.findElement(assinedToLoc));
		select.selectByVisibleText(assinedTo);
	}

	public void selectProject(String project) {

		Select select = new Select(driver.findElement(projectLoc));
		select.selectByVisibleText(project);
	}

	public void selectPriority(String priority) {

		Select select = new Select(driver.findElement(priorityLoc));
		select.selectByVisibleText(priority);
	}

	public void selectStatus(String status) {

		Select select = new Select(driver.findElement(statusLoc));
		select.selectByVisibleText(status);
	}

	public void selectType(String type) {

		Select select = new Select(driver.findElement(typeLoc));
		select.selectByVisibleText(type);
	}

	public void clickOnSearch() {

		driver.findElement(searchLoc).click();
	}

	public String getResults() {

		return driver.findElement(resultLoc).getText();
	}

}
