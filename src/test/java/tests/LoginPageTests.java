package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LogInPage;
import resources.TestBase;

public class LoginPageTests extends TestBase {

	/**
	 * Navigates to Log In page before each test is ran
	 * @throws IOException
	 */
	@BeforeMethod
	public void navigateToSignInPage() throws IOException {
		driver = initializeDriver();

		HomePage homePage = new HomePage(driver);
		homePage.getSignIn().click();
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
	 * Test to verify successful login
	 * Assert that the log in is successful and correctly navigated to the next page
	 * @throws IOException
	 * @throws InterruptedException
	 */
	//@Test
	public void verifySuccesfulLogin() throws IOException, InterruptedException {

		LogInPage loginPage = new LogInPage(driver);
		
		//Enter valid email and password, and click on log in button
		loginPage.getEmailField().sendKeys(properties.getProperty("email"));
		loginPage.getPasswordField().sendKeys(properties.getProperty("password"));
		loginPage.getLogInButton().click();

		//Explicit wait until log in is successful and navigates to the next page 
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.urlContains(properties.getProperty("successfulLoginURL")));
		
		//Assert that the log in is successful and correctly navigated to the next page
		Assert.assertEquals(driver.getTitle(), properties.getProperty("contestPage"));				
	}
	
	
	/**
	 * Test using dataProvider method to test invalid log in attempts.
	 * Assert that error message is displayed when attempting invalid log in
	 * @param email - email from getInvalidUsernameAndPassword data provider method
	 * @param password - password from getInvalidUsernameAndPassword data provider method
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "getInvalidEmailAndPassword")
	public void verifyInvalidLoginAttempts(String email, String password) throws IOException, InterruptedException {

		LogInPage loginPage = new LogInPage(driver);
		
		//Enter email and password 
		loginPage.getEmailField().clear();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		loginPage.getEmailField().sendKeys(email);
		
		loginPage.getPasswordField().clear();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		loginPage.getPasswordField().sendKeys(password);
		
		loginPage.getLogInButton().click();;
		//Thread.sleep(10000L);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Assert that error message is displayed when attempting invalid log in
		Assert.assertTrue(loginPage.getErrorContainer().isDisplayed());	
	}
	
	
	/**
	 * Sets the invalid email and password data that verifyInvalidLoginAttempts will use
	 * @throws IOException
	 */
	@DataProvider
	public Object[][] getInvalidEmailAndPassword() throws IOException{
		
		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream("/Users/tellsworth16/Documents/Career/Selenium/DraftKingsSeleniumAutomationTesting/src/main/java/resources/data.properties");
		properties.load(fileInputStream);
		
		String validEmail  = properties.getProperty("email");
		String validPassword = properties.getProperty("password");
		
		//Create data that verifyInvalidLoginAttempts will use to test invalid login attempts
		Object[][] data = new Object[3][2];
		
		data[0][0] = "InvalidEmail@gmail.com";
		data[0][1] = "InvalidPassword@gmail.com";
		
		data[1][0] = validEmail;
		data[1][1] = "InvalidPassword@gmail.com";
		
		data[2][0] = "InvalidEmail@gmail.com";
		data[2][1] = validPassword;
		
		return data;
	}
	
}
