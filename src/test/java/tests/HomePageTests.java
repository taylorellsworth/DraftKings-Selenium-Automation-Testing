package tests;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import resources.TestBase;

public class HomePageTests extends TestBase{

	/**
	 * Opens DraftKings.com
	 * @throws IOException
	 */
	@BeforeMethod
	public void openWebPage() throws IOException {
		driver = initializeDriver();
	}
	
	
	/**
	 * Closes browser after each test completes.  Close all tabs if multiple are open
	 */
	@AfterMethod
	public void closeBrowser() {
		
		Set<String> tabs = driver.getWindowHandles();
		java.util.Iterator<String> iterator = tabs.iterator();
		
		while (iterator.hasNext()) {
			driver.switchTo().window(iterator.next());
			driver.close();
		}
		driver = null;
	}
	

	/**
	 * Test to verify if all the sports are displayed in the container on the home page
	 * @throws IOException
	 */
	@Test
	public void verifyAllSportsDisplayedInContainerTest() throws IOException {

		HomePage homePage = new HomePage(driver);
		
		//Cycle through all sports shown in container and compare those sports with the expected sports that are supposed to be displayed
		int numberOfSportsInContainer = homePage.getSportsInContainer().size();
		for(int i=0; i < numberOfSportsInContainer; i++) {
			String displayedSportsName = homePage.getSportsInContainer().get(i).getText();

			String expectedSportsName  = properties.getProperty("sports");
			String[] name = expectedSportsName.split(",");
			
			boolean isDisplayed = false;
			for (String string : name) {
				if(string.equals(displayedSportsName)) {
					isDisplayed = true;
				}
			}
			
			//Assert true if all the expected sports are actually displayed in the container
			Assert.assertTrue(isDisplayed, displayedSportsName + " is Displayed");
		}
	}

	
	/**
	 * Test to verify navigation header is displayed
	 */
	@Test
	public void verifyNavHeaderIsDisplayed() {
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.getNavigationHeader().isDisplayed());
	}
	
	
	/**
	 * Test to verify text for sign in link is displayed as "SIGN IN"
	 */
	@Test
	public void verifySignInText() {
		HomePage homePage = new HomePage(driver);
		Assert.assertEquals(homePage.getSignIn().getText(), "SIGN IN");
	}
	
	
	/**
	 * Test to verify text for FAQ link is displayed as "FAQ"
	 */
	@Test
	public void verifyFAQText() {
		HomePage homePage = new HomePage(driver);
		Assert.assertEquals(homePage.getFAQ().getText(), "FAQ");
	}
	
	
	/**
	 * Test to verify promo code link is displayed
	 */
	@Test
	public void verifyEnterPromoCodeLink() {
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.getEnterPromoCode().isDisplayed());
	}
	
	
	/**
	 * Test to verify text for enter a promo code link is displayed as "ENTER A PROMO CODE"
	 */
	@Test
	public void verifyEnterPromoCodeLinkText() {
		HomePage homePage = new HomePage(driver);
		Assert.assertEquals(homePage.getEnterPromoCode().getText(), "ENTER A PROMO CODE");
	}
	
	
	/**
	 * Test to verify that links in company directory footer all open correctly
	 * Assert that the number of tabs open equals the number of links in the company directory section in the footer
	 * @throws InterruptedException
	 */
	@Test
	public void verifyFooterCompanyDirectoryLinks() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		
		//Cycle through links present in the company directory section located in the footer
		int numberLinks = homePage.getFooterCompanyDirectory().findElements(By.tagName("a")).size();
		for(int i = 0; i < numberLinks; i++) {
			String clickonlinkTab = Keys.chord(Keys.COMMAND, Keys.ENTER);
			homePage.getFooterCompanyDirectory().findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000L);
		}
		
		Set<String> tabTitles = driver.getWindowHandles();
		java.util.Iterator<String> iterator = tabTitles.iterator();
		
		int numberTabs = 0;
		while (iterator.hasNext()) {
			driver.switchTo().window(iterator.next());
			numberTabs++;
		}
		
		//Assert that the number of tabs open equals the number of links in the company directory section in the footer
		Assert.assertEquals(numberLinks, numberTabs-1);
	}
	
}
