package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;
import pageObjects.ChooseNFLPlayersForLineupPage;
import pageObjects.CreateNewLineupQuestionsPage;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import resources.TestBase;

public class ChooseNFLPlayersForLineupTests extends TestBase {

	/**
	 * Navigate to DraftKings.com, log in, and go to page where user drafts NFL play
	 * @throws IOException
	 */
	@BeforeMethod
	public void openWebPage() throws IOException {
		driver = initializeDriver();

		HomePage landingPage = new HomePage(driver);
		landingPage.getSignIn().click();
		
		LogInPage logInPage = new LogInPage(driver);
		logInPage.logIn(properties);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.urlContains(properties.getProperty("successfulLoginURL")));
		
		CreateNewLineupQuestionsPage createNewLineup = new CreateNewLineupQuestionsPage(driver);
		createNewLineup.getCreateNewLineupButton().click();
		
		createNewLineup.navigateToDraftingNFLPlayersPage();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
	 * Test to verify successful navigation to Draft NFL players page
	 * @throws IOException
	 */
	@Test
	public void verifyNavtigateToDraftPlayersPage() throws IOException {
		ChooseNFLPlayersForLineupPage choosePlayersForLineup = new ChooseNFLPlayersForLineupPage(driver);
		Assert.assertTrue(choosePlayersForLineup.getPlayerPickerContainer().isDisplayed());
	}
	
	
	/**
	 * 
	 * Test to verify all QBs available to draft appear in player picker container when their name is searched
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	public void verifySearchedQBsCorrectlyAppearInPlayerPickerContainer() throws IOException, InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		ChooseNFLPlayersForLineupPage choosePlayersForLineup = new ChooseNFLPlayersForLineupPage(driver);

		verifySearchedNameCorrectlyAppearInPlayerPickerContainer("quarterBack", choosePlayersForLineup, softAssertion);
		
		softAssertion.assertAll();	
	}
	
	
	/**
	 * Test to verify all RBs available to draft appear in player picker container when their name is searched
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	public void verifySearchedRBsCorrectlyAppearInPlayerPickerContainer() throws IOException, InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		ChooseNFLPlayersForLineupPage choosePlayersForLineup = new ChooseNFLPlayersForLineupPage(driver);

		verifySearchedNameCorrectlyAppearInPlayerPickerContainer("runningBack", choosePlayersForLineup, softAssertion);
		
		softAssertion.assertAll();	
	}
	
	
	/**
	 * Test to verify all WRs available to draft appear in player picker container when their name is searched
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	public void verifySearchedWRsCorrectlyAppearInPlayerPickerContainer() throws IOException, InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		ChooseNFLPlayersForLineupPage choosePlayersForLineup = new ChooseNFLPlayersForLineupPage(driver);

		verifySearchedNameCorrectlyAppearInPlayerPickerContainer("wideReceiver", choosePlayersForLineup, softAssertion);
		
		softAssertion.assertAll();	
	}
	
	
	/**
	 * Test to verify all TEs available to draft appear in player picker container when their name is searched
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	public void verifySearchedTEsCorrectlyAppearInPlayerPickerContainer() throws IOException, InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		ChooseNFLPlayersForLineupPage choosePlayersForLineup = new ChooseNFLPlayersForLineupPage(driver);

		verifySearchedNameCorrectlyAppearInPlayerPickerContainer("tightEnds", choosePlayersForLineup, softAssertion);
		
		softAssertion.assertAll();	
	}
	
	
	/**
	 * Test to verify all DSTs available to draft appear in player picker container when their name is searched
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	public void verifySearchedDSTsCorrectlyAppearInPlayerPickerContainer() throws IOException, InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		ChooseNFLPlayersForLineupPage choosePlayersForLineup = new ChooseNFLPlayersForLineupPage(driver);

		verifySearchedNameCorrectlyAppearInPlayerPickerContainer("defense", choosePlayersForLineup, softAssertion);
		
		softAssertion.assertAll();	
	}
	
	
	/**
	 * Test to verify Drafted QBs appear in lineup
	 * Test to verify players are removed from lineup when remove button is pressed
	 * @throws InterruptedException
	 * @throws IOException
	 */
	//@Test
	public void verifyDraftedQBsAppearInLineup() throws InterruptedException, IOException {
		SoftAssert softAssertion = new SoftAssert();
		ChooseNFLPlayersForLineupPage choosePlayersForLineup = new ChooseNFLPlayersForLineupPage(driver);

		verifyDraftedPlayerAppearsInLineup("quarterBack", choosePlayersForLineup, softAssertion);
		
		softAssertion.assertAll();	
	}
	
	
	/**
	 * Test to verify Drafted RBs appear in lineup
	 * Test to verify players are removed from lineup when remove button is pressed
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void verifyDraftedRBsAppearInLineup() throws InterruptedException, IOException {
		SoftAssert softAssertion = new SoftAssert();
		ChooseNFLPlayersForLineupPage choosePlayersForLineup = new ChooseNFLPlayersForLineupPage(driver);

		verifyDraftedPlayerAppearsInLineup("runningBack", choosePlayersForLineup, softAssertion);
		
		softAssertion.assertAll();	
	}
	
	
	/**
	 * Test to verify Drafted WRs appear in lineup
	 * Test to verify players are removed from lineup when remove button is pressed
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void verifyDraftedWRsAppearInLineup() throws InterruptedException, IOException {
		SoftAssert softAssertion = new SoftAssert();
		ChooseNFLPlayersForLineupPage choosePlayersForLineup = new ChooseNFLPlayersForLineupPage(driver);

		verifyDraftedPlayerAppearsInLineup("wideReceiver", choosePlayersForLineup, softAssertion);
		
		softAssertion.assertAll();	
	}
	
	
	/**
	 * Test to verify Drafted TEs appear in lineup
	 * Test to verify players are removed from lineup when remove button is pressed
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void verifyDraftedTEsAppearInLineup() throws InterruptedException, IOException {
		SoftAssert softAssertion = new SoftAssert();
		ChooseNFLPlayersForLineupPage choosePlayersForLineup = new ChooseNFLPlayersForLineupPage(driver);

		verifyDraftedPlayerAppearsInLineup("tightEnd", choosePlayersForLineup, softAssertion);
		
		softAssertion.assertAll();	
	}
	
	
	/**
	 * Test to verify Drafted DSTs appear in lineup
	 * Test to verify players are removed from lineup when remove button is pressed
	 * @throws InterruptedException
	 * @throws IOException
	 */
	//@Test
	public void verifyDraftedDTSsAppearInLineup() throws InterruptedException, IOException {
		SoftAssert softAssertion = new SoftAssert();
		ChooseNFLPlayersForLineupPage choosePlayersForLineup = new ChooseNFLPlayersForLineupPage(driver);

		verifyDraftedPlayerAppearsInLineup("defense", choosePlayersForLineup, softAssertion);
		
		softAssertion.assertAll();	
	}
	
	
	/**
	 * Function to verify searched name appears in player picker container
	 * Assert that name of player that was searched appears in player picker container
	 * @param position from data.properties
	 * @param choosePlayersForLineup
	 * @param softAssertion
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void verifySearchedNameCorrectlyAppearInPlayerPickerContainer(String position, ChooseNFLPlayersForLineupPage choosePlayersForLineup, SoftAssert softAssertion) throws IOException, InterruptedException {
		
		ArrayList<String> listOfPlayers = getListOfPlayersByPostion(position);

		//Iterate through list of players based on position selected
		for(String searchedPlayersName : listOfPlayers) {
			choosePlayersForLineup.getPlayerSearchTextEntryBox().sendKeys(searchedPlayersName);
			Thread.sleep(10000L);

			String playersNameDisplayedInPlayerPickerContainer = choosePlayersForLineup.getPlayerNameInContainer().getText();

			//remove period from in order to see if name of player that is searched contains name that appears
			if(playersNameDisplayedInPlayerPickerContainer.contains(".")){
				playersNameDisplayedInPlayerPickerContainer = playersNameDisplayedInPlayerPickerContainer.substring(playersNameDisplayedInPlayerPickerContainer.indexOf(".") + 2);
			}

			//Assert that name of player that was searched appears in player picker container
			softAssertion.assertTrue(searchedPlayersName.contains(playersNameDisplayedInPlayerPickerContainer));
			choosePlayersForLineup.getPlayerSearchTextEntryBox().clear();
		}
	}
	
	
	/**
	 * Function to assert that drafted player appears in lineup
	 * Assert that player is removed from lineup when remove button is pressed
	 * @param position
	 * @param choosePlayersForLineup
	 * @param softAssertion
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void verifyDraftedPlayerAppearsInLineup(String position, ChooseNFLPlayersForLineupPage choosePlayersForLineup, SoftAssert softAssertion) throws InterruptedException, IOException {
		
		ArrayList<String> listOfPlayers = getListOfPlayersByPostion(position);

		//Iterate through list of players based on postion selected
		for(String playerName : listOfPlayers) {
			choosePlayersForLineup.getPlayerSearchTextEntryBox().sendKeys(playerName);
			Thread.sleep(10000L);
			
			//Draft player that user searched for
			String playerNameDisplayed = choosePlayersForLineup.getPlayerNameInContainer().getText();
			choosePlayersForLineup.getDraftButton().click();

			//Iterate through roster spots to find selected player
			int totalLineupSpots = choosePlayersForLineup.getPlayerLineupPositions().size();
			for(int i = 0; i<totalLineupSpots; i++) {
				
				String draftedNameDisplayed = choosePlayersForLineup.getPlayerLineupPositions().get(i).getText();
				
				if(!draftedNameDisplayed.isEmpty()) {
					
					//Assert that the player drafted appears in lineup
					boolean draftedPlayerAppearsInLineup = playerNameDisplayed.equals(draftedNameDisplayed);
					softAssertion.assertTrue(draftedPlayerAppearsInLineup);
					Thread.sleep(10000L);

					//Remove player from lineup
					removeDraftedPlayer(choosePlayersForLineup, playerNameDisplayed, softAssertion);	
				}
			}
		}
	}
	
	
	/**
	 * Get list of players based on position
	 * @return list of players 
	 * @throws IOException
	 */
	public ArrayList<String> getListOfPlayersByPostion(String position) throws IOException {
		ArrayList<String> listOfPlayers = getAllAvailablePlayersByPostition(properties.getProperty(position));
		return listOfPlayers;
	}
	
	
	/**
	 * Helper function to remove player from drafted team
	 * Assert that the player is no longer in the lineup
	 * @param choosePlayersForLineup
	 * @param playerNameDisplayed
	 * @param softAssertion
	 */
	public void removeDraftedPlayer(ChooseNFLPlayersForLineupPage choosePlayersForLineup, String playerNameDisplayed, SoftAssert softAssertion) {

		choosePlayersForLineup.getRemovePlayerButton().click();
		String draftedPlayerNameRemoved = choosePlayersForLineup.getPlayerLineupPosition().getText();

		//Assert that the drafted player is no longer in lineup
		boolean isRemoved = playerNameDisplayed.equals(draftedPlayerNameRemoved);
		softAssertion.assertFalse(isRemoved);
	
	}

}
