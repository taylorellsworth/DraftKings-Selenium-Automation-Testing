# Page Object Model Selenium TestNG Maven Project for DraftKings.com
This repository contains a Page Object Model test automation framework using TestNg, Selenium and Java for DraftKings.com.  Developed as a Maven project.

## About the Project
Test automation framework contains the following:

### /src/test/java/tests
This package contains all the test classes.

	- AccountDropDownAfterLoginTests.java
		- Contains tests for the drop down window that appears when the user hovers over their account name.

	- ChooseNFLPlayersForLineupTests.java
		- Contains tests for the page where the user selects their daily NFL Lineup.

	- CreateNewLineupQuestionsTests.java
		- Contains tests for the initial question page that appears when the user clicks the ‘Create New Lineup’ button.  This page asks the user for what sport, what game variant, and what start date that they want to create a lineup for.

	- HomePageTests.java
		- Contains tests.java for the homepage that the user first accesses before they sign in
	
	- LogInPageTests.java
		- Contains tests.java for the page where the user enters their log in information

	- NFLLobbyTests.java
		- Contains tests for the NFL Lobby page where the user searches for contests to answers

	- Listeners.java
		- Implents iTestListener and contains methods such as onTestFailure and onTestSkipped

### /src/main/java/pageObjects
This package contains all the page classes for AccountDropDownAfterLoginTests, ChooseNFLPlayersForLineupTests CreateNewLineupQuestionsTests, HomePageTests, LogInPageTests, and NFLLobbyTests. All the 'Find By' methods that are defined in each page class can be used in test classes by importing the class to perform actions on web elements.

	- /resources
	- ExtentReporterNG.java
		- Produces HTML reports after test execution
	- TestBase.java
		- Contains common methods for initializing the driver, taking screenshots, and getting available players by position
	- data.properties
			- Property file containing data used in tests

### XML Files
 	- pom.xml 
    		- Contains all the plugins and dependencies that are required to run the test as maven project. TestNG.xml is configured in this pom.xml to trigger the test.
  	- TestNG.xml
    		- Contains the all class names that are to be triggered to run the complete suite of test cases.
  
### Test-Output Folder
	- ExtentReportsTestNG.html
		- Generated in this location

## Running the Tests:
To run as a Maven project: 
	1.	Install and set up Java
	2. 	Install and set up Maven plugin
	3. 	Install browser driver of choice (ChromeDriver, FirefoxDriver or InternetExplorerDriver)
	4. 	Clone the project and set the following:
		a. In /resources/data.properties, set the following:
			 - driver.path to path of installed web driver
			 - screenshotsPath to location you want screenshots saved when a test fails 
		b. In /resources/TestBase.java, set data_properties_path to the path of the project
	5.  Go to DraftKings.com and download the DKSalaries.csv for NFL players.  Convert the file to .xlsx.  In /resources/data.properties, change DraftKingsPlayersXLSX to the location of this file
	6.  cd to location of project and run:
		a. mvn clean
		b. mvn compile
		c. mvn test
	7. To view HTML file of results, go to Test-Output/ExtentReportsTestNG.html
