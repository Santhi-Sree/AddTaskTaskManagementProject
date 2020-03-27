Feature: Add Task in Task Management website 
	In order to login to website
	As a Task Manager
	I want to get access to the portal
	
Background: 
	Given I have browser 'ch' with Task Management website 
	
Scenario Outline: Search Task 

	When I enter data '<Assigned To>' '<Project>' '<Priority>' '<Status>' '<Type>' 
	And Click on search button i should get the results 
	Then I should access the portal with title as 'Task Manager' 
	Examples: 
		|Assigned To|Project|Priority|Status|Type|
		|Alexander Atkinson|CodeCharge|Highest|Open|Task|
		|Ken Price|Test Project|High|In progress|Task|
		
Scenario: Access Task 

	When I click on task and enter login details from excel 'src/test/resources/Excel/TaskManagement.xlsx' with sheetname 'ValidLoginDetails'
	Then I should get the text in Task field as 'Low on ammunition? Get armed. Get CodeCharge.' 
	
Scenario: Add Task with Valid Credentials 

	When I click on Add Task Icon and enter login details from excel 'src/test/resources/Excel/TaskManagement.xlsx' with sheetname 'ValidLoginDetails'
	And I enter data from excel 'src/test/resources/Excel/TaskManagement.xlsx' with sheetname 'ValidTaskDetails' 
	Then  I should return to 'Task Manager' page by clicking on add button 

 
Scenario Outline: Add Task with Invalid Credentials 

	When I click on Add Task Icon and enter login details from excel 'src/test/resources/Excel/TaskManagement.xlsx' with sheetname 'ValidLoginDetails' 
	And I enter data '<Description>' '<Project>' '<Priority>' '<Status>' '<Type>' '<Assigned To>' '<Start Date>' '<Finish Date>' and click on add button 
	Then  I should get error message as 'The value in field Task is required.' 
	Examples: 
		|Description|Project|Priority|Status|Type|Assigned To|Start Date|Finish Date|
		|I need to test the task|CodeCharge|High|In progress|Task|Stan Simon|03/14/20|03/18/20|
		|Need a break|CodeCharge|Lowest|Closed|Question|Ken Price|03/18/20|03/20/20|
		
Scenario: Edit Task 

	When  I click on existing task and enter login details from excel 'src/test/resources/Excel/TaskManagement.xlsx' with sheetname 'ValidLoginDetails' 
	And   click on task and enter data 'Enter code' 
	Then  I should redirect to 'Task Manager' page when i  click on submit button 
	
	
	