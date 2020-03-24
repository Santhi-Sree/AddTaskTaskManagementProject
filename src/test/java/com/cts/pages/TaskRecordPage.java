package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaskRecordPage {

	private By taskNameLoc = By.name("task_name");
	private By DescriptionLoc = By.name("task_desc");
	private By projectIdLoc = By.name("project_id");
	private By priorityLoc = By.name("priority_id");
	private By statusLoc = By.name("status_id");
	private By typeLoc = By.name("type_id");
	private By assignedToLoc = By.name("user_id_assign_to");
	private By startDateLoc = By.name("task_start_date");
	private By finishDateLoc = By.name("task_finish_date");
	private By addButtonLoc = By.name("Insert");
	private By errorMessageLoc = By.xpath("//tr[@class='Error']");
	private By submitLoc = By.name("Update");
	private By actualTextLoc = By.xpath("//textarea[@name='task_desc']");

	private WebDriver driver;
	
	public TaskRecordPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterTaskName(String task) {

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(typeLoc));
		driver.findElement(taskNameLoc).sendKeys(task);
	}

	public void enterDescription(String description) {

		driver.findElement(DescriptionLoc).sendKeys(description);
	}

	public void selectProject(String project) {

		Select select = new Select(driver.findElement(projectIdLoc));
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

	public void selectAssignedTo(String assignedTo) {

		Select select = new Select(driver.findElement(assignedToLoc));
		select.selectByVisibleText(assignedTo);
	}

	public void enterStartDate(String startDate) {

		driver.findElement(startDateLoc).sendKeys(startDate);
	}

	public void enterFinishDate(String finishDate) {

		driver.findElement(finishDateLoc).sendKeys(finishDate);
	}

	public void clickOnAddButton() {

		driver.findElement(addButtonLoc).click();
	}

	public String getErrorText() {

		return driver.findElement(errorMessageLoc).getText();
	}

	public  String getExistingText() {

		return driver.findElement(actualTextLoc).getText();
	}

	public  void editTask(String text) {

		driver.findElement(taskNameLoc).clear();
		driver.findElement(taskNameLoc).sendKeys(text);
	}

	public  void clickOnSubmitButton() {

		driver.findElement(submitLoc).click();
	}

}
