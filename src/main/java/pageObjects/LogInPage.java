package pageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {

	public WebDriver driver;
	
	public LogInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By emailField = By.xpath("//input[@name='username']"); 
	By passwordField = By.cssSelector("input[name='password']");
	By logInButton = By.xpath("/html/body/div[9]/div/div/section/section/div[3]/button/span | //*[@id='react-mobile-home']/section/section[2]/div[3]/button");
	By errorContainer = By.xpath("/html/body/div[9]/div/div/section/section/div[2]/div[1]");

	/**
	 * Gets email field
	 * @return WebElement
	 */
	public WebElement getEmailField() {
		return driver.findElement(emailField);
	}
	
	/**
	 * Gets password field
	 * @return WebElement
	 */
	public WebElement getPasswordField() {
		return driver.findElement(passwordField);
	}

	/**
	 * Gets log in button
	 * @return WebElement
	 */
	public WebElement getLogInButton() {
		return driver.findElement(logInButton);
	}
	
	/**
	 * Gets error message field
	 * @return WebElement
	 */
	public WebElement getErrorContainer() {
		return driver.findElement(errorContainer);
	}
	
	/**
	 * Method to successfully log in
	 * @param properties
	 */
	public void logIn(Properties properties) {
		getEmailField().sendKeys(properties.getProperty("email"));
		getPasswordField().sendKeys(properties.getProperty("password"));
		getLogInButton().click();
	}
	
}
