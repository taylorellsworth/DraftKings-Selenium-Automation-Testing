package tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;
import pageObjects.CreateNewLineupQuestionsPage;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import resources.TestBase;

public class CreateNewLineupQuestionsTests extends TestBase {


	/**
	 * Navigate to DraftKings.com, log in, and go to create new NFL lineup page
	 * @return createNewLineup object
	 * @throws IOException
	 */
	public CreateNewLineupQuestionsPage navigateToCreateNewLineupQuestionsPage() throws IOException {
		driver = initializeDriver();

		HomePage landingPage = new HomePage(driver);
		landingPage.getSignIn().click();
		
		LogInPage logInPage = new LogInPage(driver);
		logInPage.logIn(properties);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.urlContains(properties.getProperty("successfulLoginURL")));
		
		CreateNewLineupQuestionsPage createNewLineup = new CreateNewLineupQuestionsPage(driver);
		createNewLineup.getCreateNewLineupButton().click();
		
		return createNewLineup;
	}
	
	
	/**
	 * Closes browser after each test completes
	 */
	@AfterMethod
	public void closeBrowser() {
		driver.close();
		driver = null;
	}
	
	
	/**
	 * Verify screen correctly navigates to create lineup page
	 * @throws IOException
	 */
	@Test(priority=1)
	public void verifyNavtigateToCreateLineupPage() throws IOException {
		navigateToCreateNewLineupQuestionsPage();
		Assert.assertEquals(properties.getProperty("createNewLineupURL"), driver.getCurrentUrl());
	}
	
	
	/**
	 * Verify first question is correctly displayed on create lineup page
	 * @throws IOException
	 */
	@Test(priority=2)
	public void verifyFirstQuestionisDisplayed() throws IOException {
		CreateNewLineupQuestionsPage createNewLineup = navigateToCreateNewLineupQuestionsPage();
		Assert.assertTrue(createNewLineup.getFirstQuestion().isDisplayed());
	}
	
	
	/**
	 * Verify second question is not displayed since the sport has not been selected in first question
	 * @throws IOException
	 */
	@Test(priority=3)
	public void verifySecondQuestionisNotDisplayed() throws IOException, InterruptedException {
		navigateToCreateNewLineupQuestionsPage();
		Thread.sleep(5000L);
		secondQuestionDisplayed(false);
	}
	
	
	/**
	 * Verify user can select all the radio buttons for the first question asking for the sport
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test(priority=4)
	public void verifySelectionOfSportRadioButtons() throws InterruptedException, IOException {
		CreateNewLineupQuestionsPage createNewLineup = navigateToCreateNewLineupQuestionsPage();
		verifyRadioButtonsSelection(createNewLineup.getAllSportRadioButtons());
	}

	
	/**
	 * Verify second question is displayed since the user answered the first question
	 * @throws IOException
	 */
	@Test(priority=5)
	public void verifySecondQuestionisDisplayed() throws IOException {
		CreateNewLineupQuestionsPage createNewLineup = navigateToCreateNewLineupQuestionsPage();
		createNewLineup.getAllSportRadioButtons().get(0).click();
		secondQuestionDisplayed(true);
	}
	
	
	/**
	 * Verify third question is not displayed since the game variant has not been selected in second question
	 * @throws IOException
	 */
	@Test(priority=6)
	public void verifyThirdQuestionisNotDisplayed() throws IOException {
		CreateNewLineupQuestionsPage createNewLineup = navigateToCreateNewLineupQuestionsPage();
		createNewLineup.getAllSportRadioButtons().get(0).click();
		thirdQuestionDisplayed(false);
	}
	
	
	/**
	 * Verify user can select all the radio buttons for the second question asking for the game variant
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test(priority=7)
	public void verifySelectionOfGameVariantRadioButtons() throws InterruptedException, IOException {
		CreateNewLineupQuestionsPage createNewLineup = navigateToCreateNewLineupQuestionsPage();
		createNewLineup.getAllSportRadioButtons().get(0).click();		
		verifyRadioButtonsSelection(createNewLineup.getAllGameVariantRadioButtons());
	}

	
	/**
	 * Verify the third question is displayed since the user answered the second question
	 * @throws IOException
	 */
	@Test(priority=8)
	public void verifyThirdQuestionisDisplayed() throws IOException {
		CreateNewLineupQuestionsPage createNewLineup = navigateToCreateNewLineupQuestionsPage();
		createNewLineup.getAllSportRadioButtons().get(0).click();
		createNewLineup.getAllGameVariantRadioButtons().get(0).click();
		thirdQuestionDisplayed(true);
	}
	
	
	/**
	 * Verify the 'Continue' button is not displayed since the user has not answered all three questions
	 * @throws IOException
	 */
	@Test(priority=9)
	public void verifyContinueButtonIsNotDisplayed() throws IOException {
		CreateNewLineupQuestionsPage createNewLineup = navigateToCreateNewLineupQuestionsPage();
		createNewLineup.getAllSportRadioButtons().get(0).click();
		createNewLineup.getAllGameVariantRadioButtons().get(0).click();
		continueButtonDisplayed(false);
	}
	
	
	/**
	 * Verify user can select all the radio buttons for the third question asking for the contest start date
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test(priority=10)
	public void verifySelectionOfContestStartDateRadioButtons() throws InterruptedException, IOException {
		CreateNewLineupQuestionsPage createNewLineup = navigateToCreateNewLineupQuestionsPage();
		createNewLineup.getAllSportRadioButtons().get(0).click();
		createNewLineup.getAllGameVariantRadioButtons().get(0).click();		
		verifyRadioButtonsSelection(createNewLineup.getAllContestStartDateRadioButtons());
	}
	
	
	/**
	 * Verify continue button is not displayed since the user has answered all three 
	 * @throws IOException
	 */
	@Test(priority=11)
	public void verifyContinueButtonIsDisplayed() throws IOException {
		CreateNewLineupQuestionsPage createNewLineup = navigateToCreateNewLineupQuestionsPage();
		createNewLineup.getAllSportRadioButtons().get(0).click();
		createNewLineup.getAllGameVariantRadioButtons().get(0).click();
		createNewLineup.getAllContestStartDateRadioButtons().get(0).click();	
		continueButtonDisplayed(true);
	}
	
	
	/**
	 * Verify 'Cancel' button is displayed
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	public void verifyCancelButtonisDisplayed() throws IOException, InterruptedException {
		CreateNewLineupQuestionsPage createNewLineup = navigateToCreateNewLineupQuestionsPage();
		Thread.sleep(10000L);

		Assert.assertTrue(createNewLineup.getCancelButton().isDisplayed());
	}
	
	
	/**
	 * Method cycles through all the radio buttons shown and verifies that user can select all of them
	 * @param getAllRadioButtons
	 * @throws InterruptedException
	 */
	public void verifyRadioButtonsSelection(List<WebElement> getAllRadioButtons) throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();

		int numberRadioButtons = getAllRadioButtons.size();
		for(int i = 0; i < numberRadioButtons; i++) {
			getAllRadioButtons.get(i).click();
			Thread.sleep(5000L);
			softAssertion.assertTrue(getAllRadioButtons.get(i).isSelected());
		}
	}
	
	
	/**
	 * Helper method to determine if second question is disabled or not
	 * @param isDisplayed - whether testing for if second question is disabled or not
	 */
	public void secondQuestionDisplayed(boolean isDisplayed) {
		CreateNewLineupQuestionsPage createNewLineup = new CreateNewLineupQuestionsPage(driver);
		
		if(isDisplayed) {
			Assert.assertTrue(createNewLineup.getSecondQuestion().isDisplayed());
		}
		else {
			Assert.assertFalse(createNewLineup.getSecondQuestion().isDisplayed());
		}
	}
	
	
	/**
	 * Helper method to determine if third question is disabled or not
	 * @param isDisplayed - whether testing for if second question is disabled or not
	 */
	public void thirdQuestionDisplayed(boolean isDisplayed) {
		CreateNewLineupQuestionsPage createNewLineup = new CreateNewLineupQuestionsPage(driver);
		
		if(isDisplayed) {
			Assert.assertTrue(createNewLineup.getThirdQuestion().isDisplayed());
		}
		else {
			Assert.assertFalse(createNewLineup.getThirdQuestion().isDisplayed());
		}
	}
	
	
	/**
	 * Helper method to determine if 'Continue' button is disabled or not
	 * @param isDisplayed - whether testing for if second question is disabled or not
	 */
	public void continueButtonDisplayed(boolean isDisplayed) {
		CreateNewLineupQuestionsPage createNewLineup = new CreateNewLineupQuestionsPage(driver);

		if(isDisplayed) {
			Assert.assertTrue(createNewLineup.getContinueButton().isDisplayed());
		}
		else {
			Assert.assertFalse(createNewLineup.getContinueButton().isDisplayed());
		}
	}
	
}
