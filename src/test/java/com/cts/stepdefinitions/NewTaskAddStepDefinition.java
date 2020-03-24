package com.cts.stepdefinitions;

import org.junit.Assert;

import com.cts.base.LaunchWebDriver;
import com.cts.pages.AdministrationPage;
import com.cts.pages.LoginPage;
import com.cts.pages.TaskManagerPage;
import com.cts.pages.TaskRecordPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewTaskAddStepDefinition {

	@Given("I have browser {string} with Task Management website")
	public void i_have_browser_with_Task_Management_website(String browserName) {

		// Access Task Management web page
		LaunchWebDriver.setUp(browserName);
	}

	@When("I enter data {string} {string} {string} {string} {string}")
	public void i_enter_data(String assinedTo, String project, String priority, String status, String type) {
		
		TaskManagerPage manage = new TaskManagerPage(LaunchWebDriver.driver);
		
		// Select assigned to
		manage.selectAssignedTo(assinedTo);

		// Select Project
		manage.selectProject(project);

		// Select Priority
		manage.selectPriority(priority);

		// Select Status
		manage.selectStatus(status);

		// Select Type
		manage.selectType(type);
	}

	@When("Click on search button i shoud get the results")
	public void click_on_search_button_i_shoud_get_the_results() {
		
		TaskManagerPage manage = new TaskManagerPage(LaunchWebDriver.driver);
		
		// Click on Search
		manage.clickOnSearch();

		// Get results into string
		String result = manage.getResults();

		// Print result
		System.out.println(result);
	}

	@Then("I should access the portal with title as {string}")
	public void i_should_access_the_portal_with_title_as(String title) {
		// Get page title
		String actualTitle = LaunchWebDriver.driver.getTitle();

		// Assertion with expected title
		Assert.assertEquals(title, actualTitle);

		// Printing Actual title
		System.out.println(actualTitle);

		// Closing the browser
		LaunchWebDriver.tearDown();
	}

	@When("I click on task and enter username as {string} and password as {string}")
	public void i_click_on_task_and_enter_username_as_and_password_as(String username, String password) {
		
		TaskManagerPage manage = new TaskManagerPage(LaunchWebDriver.driver);
		
		LoginPage login = new LoginPage(LaunchWebDriver.driver);
		
		// Click on Existing task
		manage.clickOnTask();

		// Enter user name
		login.enterUserName(username);

		// Enter Password
		login.enterPassWord(password);

		// Click on Login Button
		login.clickOnLogin();
	}

	@Then("I should get the text in Task field as {string}")
	public void i_should_get_the_text_in_Task_field_as(String text) {
		
		TaskRecordPage record = new TaskRecordPage(LaunchWebDriver.driver);
		
		// Getting actual text from the task
		String actualText = record.getExistingText();

		// Assertion with Expected Text
		Assert.assertEquals(text, actualText);

		// Print the actual text
		System.out.println(actualText);

		// Closing the browser
		LaunchWebDriver.tearDown();
	}

	@When("I click on Add Task Icon and i enter username as {string} and password as {string}")
	public void i_click_on_Add_Task_Icon_and_i_enter_username_as_and_password_as(String username, String password) {
		
		LoginPage login = new LoginPage(LaunchWebDriver.driver);
		
		AdministrationPage admin = new AdministrationPage(LaunchWebDriver.driver);
		
		// Click on Add Task Icon
		admin.clickOnAddTaskIcon();

		// Enter user name
		login.enterUserName(username);

		// Enter Password
		login.enterPassWord(password);

		// Click on Login Button
		login.clickOnLogin();

	}

	@When("I enter data {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void i_enter_data(String task, String description, String project, String priority, String status,
			String type, String assignedTo, String startDate, String finishDate) {
		
		TaskRecordPage record = new TaskRecordPage(LaunchWebDriver.driver);

		// Enter Task name
		record.enterTaskName(task);

		// Enter description of the task
		record.enterDescription(description);

		// Select Project type
		record.selectProject(project);

		// Select Priority of the task
		record.selectPriority(priority);

		// Select Status of the task
		record.selectStatus(status);

		// Select the type of the task
		record.selectType(type);

		// Select the Assigned To to assign the task
		record.selectAssignedTo(assignedTo);

		// Enter Start date
		record.enterStartDate(startDate);

		// Enter Finish date
		record.enterFinishDate(finishDate);
	}

	@Then("I should return to {string} page by clicking on add button")
	public void i_should_return_to_page_by_clicking_on_add_button(String expectedtitle) {
		
		TaskRecordPage record = new TaskRecordPage(LaunchWebDriver.driver);
		
		// Click on Add button
		record.clickOnAddButton();

		// Get the title of the page
		String actualTitle = LaunchWebDriver.driver.getTitle();

		// Assertion with expected title
		Assert.assertEquals(expectedtitle, actualTitle);

		// Print the actual title
		System.out.println(expectedtitle);

		// Closing the browser
		LaunchWebDriver.tearDown();
	}

	@When("I enter data {string} {string} {string} {string} {string} {string} {string} {string} and click on add button")
	public void i_enter_data_and_click_on_add_button(String description, String project, String priority, String status,
			String type, String assignedTo, String startDate, String finishDate) {
		
		TaskRecordPage record = new TaskRecordPage(LaunchWebDriver.driver);

		// Enter description of the task
		record.enterDescription(description);

		// Select Project type
		record.selectProject(project);

		// Select Priority of the task
		record.selectPriority(priority);

		// Select Status of the task
		record.selectStatus(status);

		// Select the type of the task
		record.selectType(type);

		// Select the Assigned To to assign the task
		record.selectAssignedTo(assignedTo);

		// Enter Start date
		record.enterStartDate(startDate);

		// Enter Finish date
		record.enterFinishDate(finishDate);

		// Click on Add button
		record.clickOnAddButton();
	}

	@Then("I should get error message as {string}")
	public void i_should_get_error_message_as(String expectedErrorText) {
		
		TaskRecordPage record = new TaskRecordPage(LaunchWebDriver.driver);
		
		// Get the actual text of the error
		String actualError = record.getErrorText();

		// Assertion with expected error text
		Assert.assertEquals(expectedErrorText, actualError);

		// Print the actual error text
		System.out.println(actualError);

		// Closing the browser
		LaunchWebDriver.tearDown();
	}

	@When("I click on existing task and i enter username as {string} and password as {string}")
	public void i_click_on_existing_task_and_i_enter_username_as_and_password_as(String username, String password) {
		
		LoginPage login = new LoginPage(LaunchWebDriver.driver);
		
		TaskManagerPage manage = new TaskManagerPage(LaunchWebDriver.driver);
		
		// Click on existing task
		manage.clickOnExistingTask();

		// Enter user name
		login.enterUserName(username);

		// Enter Password
		login.enterPassWord(password);

		// Click on Login Button
		login.clickOnLogin();
	}

	@When("click on task and enter data {string}")
	public void click_on_task_and_enter_data(String text) {
		
		TaskRecordPage record = new TaskRecordPage(LaunchWebDriver.driver);
		
		// Click on description and enter data
		record.editTask(text);
	}

	@Then("I should redirect to {string} page when i  click on submit button")
	public void i_should_redirect_to_page_when_i_click_on_submit_button(String expectedtitle) {
		
		TaskRecordPage record = new TaskRecordPage(LaunchWebDriver.driver);
		
		// Click on Submit button
		record.clickOnSubmitButton();

		// Get the actual title of page after submit button is clicked
		String actualTitle = LaunchWebDriver.driver.getTitle();

		// Assertion with expected title
		Assert.assertEquals(expectedtitle, actualTitle);

		// Print the actual title
		System.out.println(actualTitle);

		// Closing the browser
		LaunchWebDriver.tearDown();
	}

}
