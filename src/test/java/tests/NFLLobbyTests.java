package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.NFLLobbyPage;
import resources.TestBase;

public class NFLLobbyTests extends TestBase {

	/**
	 * Navigates to NFL lobby page after logging in
	 * @throws IOException
	 */
	public NFLLobbyPage navigateToNFLLobbyPage() throws IOException {
		driver = initializeDriver();

		HomePage landingPage = new HomePage(driver);
		landingPage.getSignIn().click();
		
		LogInPage logInPage = new LogInPage(driver);
		logInPage.logIn(properties);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.urlContains(properties.getProperty("successfulLoginURL")));
		
		NFLLobbyPage nflLobby = new NFLLobbyPage(driver);
		nflLobby.getNflLobbyButton().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return nflLobby;
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
	 * Test that verifies that fees in entry fee low price drop down are correctly displayed as the chosen fee when selected
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void verifyAllEntryFeeLowPricesCanBeSelectedFromDropDown() throws InterruptedException, IOException {
		
		SoftAssert softAssertion = new SoftAssert();
		NFLLobbyPage nflLobby = navigateToNFLLobbyPage();

		nflLobby.getEntryFeeLowPriceDropDown().click();
		
		int numberFeesShown = nflLobby.getFeesInDropDown().size();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//Iterate through number of fees in drop down and verify they appear as selected choice when selected
		for(int i=0; i < numberFeesShown; i++) {
			String fees = nflLobby.getFeesInDropDown().get(i).getText();
			
			nflLobby.getFeesInDropDown().get(i).click();
			 
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			nflLobby.getEntryFeeLowPriceDropDown().click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			String expectedFee = nflLobby.getEntryFeeLowPriceDropDown().getText();
			if (fees.contains("$.")){
				fees = fees.replace("$.", "$0.");
			}
			
			//Assert that fees in drop down are correctly displayed as the chosen fee when selected
			softAssertion.assertEquals(expectedFee, fees);
			
		}
		softAssertion.assertAll();
	}
	
		
	/**
	 * Test to verify the game style chosen appears as the selected game style and the radio button of the chosen game style is selected 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void verifyGameStyleSelectionRadioButtons() throws InterruptedException, IOException {
		
		SoftAssert softAssertion = new SoftAssert();
		NFLLobbyPage nflLobby = navigateToNFLLobbyPage();

		Thread.sleep(10000L);
		nflLobby.getGameStyleSelection().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		int numberGameStyleOption = nflLobby.getGameStyleOptions().size();
		//iterate through different game style options
		for(int i = numberGameStyleOption - 1; i >= 0; i--) {

			//Assert that game style chosen appears as the selected game style
			String gameStyleSelected = nflLobby.getGameStyleChosen().get(i).getText();
			nflLobby.getGameStyleChosen().get(i).click();
			String displayedSelectedName = nflLobby.getGameStyleDisplayedText().getText();
			softAssertion.assertTrue(gameStyleSelected.contains(displayedSelectedName));
			
			//Assert that the radio button of the chosen game style is selected 
			nflLobby.getGameStyleSelection().click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			boolean isSelected = nflLobby.getGameStyleOptions().get(i).isSelected();
			softAssertion.assertTrue(isSelected);
		}
		
		softAssertion.assertAll();
	}
	
}
