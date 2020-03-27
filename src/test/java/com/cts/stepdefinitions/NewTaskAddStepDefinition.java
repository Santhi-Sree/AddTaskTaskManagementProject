package com.cts.stepdefinitions;

import java.io.IOException;

import org.junit.Assert;

import com.cts.base.LaunchWebDriver;
import com.cts.pages.AdministrationPage;
import com.cts.pages.LoginPage;
import com.cts.pages.TaskManagerPage;
import com.cts.pages.TaskRecordPage;
import com.cts.utils.ReadExcel;

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

	@When("Click on search button i should get the results")
	public void click_on_search_button_i_should_get_the_results() {

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

	@When("I click on task and enter login details from excel {string} with sheetname {string}")
	public void i_click_on_task_and_enter_login_details_from_excel_with_sheetname(String fileDetails, String sheetName)
			throws IOException {

		TaskManagerPage manage = new TaskManagerPage(LaunchWebDriver.driver);

		LoginPage login = new LoginPage(LaunchWebDriver.driver);

		// Reading from Excel
		String str[][] = ReadExcel.getSheetIntoStringArray("src/test/resources/Excel/TaskManagement.xlsx",
				"ValidLoginDetails");

		// Click on Existing task
		manage.clickOnTask();

		// Enter user name
		login.enterUserName(str[0][0]);

		// Enter Password
		login.enterPassWord(str[0][1]);

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

	@When("I click on Add Task Icon and enter login details from excel {string} with sheetname {string}")
	public void i_click_on_Add_Task_Icon_and_enter_login_details_from_excel_with_sheetname(String fileDetails,
			String sheetName) throws IOException {

		LoginPage login = new LoginPage(LaunchWebDriver.driver);

		AdministrationPage admin = new AdministrationPage(LaunchWebDriver.driver);

		// Reading from Excel
		String str[][] = ReadExcel.getSheetIntoStringArray("src/test/resources/Excel/TaskManagement.xlsx",
				"ValidLoginDetails");

		// Click on Add Task Icon
		admin.clickOnAddTaskIcon();

		// Enter user name
		login.enterUserName(str[0][0]);

		// Enter Password
		login.enterPassWord(str[0][1]);

		// Click on Login Button
		login.clickOnLogin();

	}

	@When("I enter data from excel {string} with sheetname {string}")
	public void i_enter_data_from_excel_with_sheetname(String fileDetails, String sheetName) throws IOException {

		TaskRecordPage record = new TaskRecordPage(LaunchWebDriver.driver);

		// Reading from Excel
		String str[][] = ReadExcel.getSheetIntoStringArray("src/test/resources/Excel/TaskManagement.xlsx",
				"ValidTaskDetails");

		// Enter Task name
		record.enterTaskName(str[0][0]);

		// Enter description of the task
		record.enterDescription(str[0][1]);

		// Select Project type
		record.selectProject(str[0][2]);

		// Select Priority of the task
		record.selectPriority(str[0][3]);

		// Select Status of the task
		record.selectStatus(str[0][4]);

		// Select the type of the task
		record.selectType(str[0][5]);

		// Select the Assigned To to assign the task
		record.selectAssignedTo(str[0][6]);

		// Enter Start date
		record.enterStartDate(str[0][7]);

		// Enter Finish date
		record.enterFinishDate(str[0][8]);
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

	@When("I click on existing task and enter login details from excel {string} with sheetname {string}")
	public void i_click_on_existing_task_and_enter_login_details_from_excel_with_sheetname(String string,
			String string2) throws IOException {

		LoginPage login = new LoginPage(LaunchWebDriver.driver);

		TaskManagerPage manage = new TaskManagerPage(LaunchWebDriver.driver);

		// Reading from Excel
		String str[][] = ReadExcel.getSheetIntoStringArray("src/test/resources/Excel/TaskManagement.xlsx",
				"ValidLoginDetails");

		// Click on existing task
		manage.clickOnExistingTask();

		// Enter user name
		login.enterUserName(str[0][0]);

		// Enter Password
		login.enterPassWord(str[0][1]);

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
