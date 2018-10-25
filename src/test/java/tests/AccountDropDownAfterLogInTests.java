package tests;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;
import pageObjects.AccountDropDownAfterLogIn;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import resources.TestBase;

public class AccountDropDownAfterLogInTests extends TestBase {

	/**
	 * Navigate to DraftKings.com and log in before each test
	 * @throws IOException
	 */
	@BeforeMethod
	public void openWebPageAndLogin() throws IOException {
		driver = initializeDriver();

		HomePage landingPage = new HomePage(driver);
		landingPage.getSignIn().click();
		
		LogInPage logInPage = new LogInPage(driver);
		logInPage.logIn(properties);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.urlContains(properties.getProperty("successfulLoginURL")));	
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
	 * Verifies all links appear when user hovers over account 
	 * @throws InterruptedException
	 */
	@Test
	public void verifyAllLinksAppearInDropDown() throws InterruptedException {
		AccountDropDownAfterLogIn accountDropDown = new AccountDropDownAfterLogIn(driver);
	
		Actions action = new Actions(driver);
		action.moveToElement(accountDropDown.getDropDownLocation()).build().perform();
		
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(accountDropDown.getAccountInformation().isDisplayed());
		softAssertion.assertTrue(accountDropDown.getHowToPlay().isDisplayed());
		softAssertion.assertTrue(accountDropDown.getRulesAndScoring().isDisplayed());
		softAssertion.assertTrue(accountDropDown.getFAQ().isDisplayed());
		softAssertion.assertTrue(accountDropDown.getReferAFriend().isDisplayed());
		softAssertion.assertTrue(accountDropDown.getMobileApps().isDisplayed());
		softAssertion.assertTrue(accountDropDown.getDKShop().isDisplayed());
		softAssertion.assertTrue(accountDropDown.getDKTV().isDisplayed());
		softAssertion.assertTrue(accountDropDown.getPlaybook().isDisplayed());
		softAssertion.assertTrue(accountDropDown.getContactUs().isDisplayed());
		softAssertion.assertTrue(accountDropDown.getVerifyMe().isDisplayed());
		softAssertion.assertTrue(accountDropDown.getSignOut().isDisplayed());
		softAssertion.assertAll();
	}
	
	
	/**
	 * Verifies user signs out correctly when sign out button is clicked using Actions object.  
	 * Asserts screen transitions to Log In Page 
	 * @throws InterruptedException
	 */
	@Test
	public void verifySignOut() {
		AccountDropDownAfterLogIn accountDropDown = new AccountDropDownAfterLogIn(driver);
		
		//Hover over account drop down location and click the Sign Out button
		Actions action = new Actions(driver);
		action.moveToElement(accountDropDown.getDropDownLocation()).build().perform();
		accountDropDown.getSignOut().click();

		boolean onLogInPage = accountDropDown.getLogInPageText().isDisplayed();
		Assert.assertTrue(onLogInPage);
	}
	
}
