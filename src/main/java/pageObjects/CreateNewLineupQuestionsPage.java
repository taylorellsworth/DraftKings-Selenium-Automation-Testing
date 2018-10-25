package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateNewLineupQuestionsPage {

	public WebDriver driver;
	
	public CreateNewLineupQuestionsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By createNewLineupButton = By.cssSelector("a[href='/lineup/#create-lineup']"); 
	By firstQuestion = By.xpath("//*[@id='lineup-card-container']/div[1]/div[2]/div[2]/h1");
	By allSportRadioButtons = By.xpath("//input[@type='radio' and @name='sport']");
	By secondQuestion = By.cssSelector("div.step2-title");
	By allGameVariantRadioButtons = By.xpath("//input[@type='radio' and @name='game-variant']");
	By thirdQuestion = By.cssSelector("div.step3-title");
	By allContestStartDateRadioButtons = By.xpath("//input[@type='radio' and @name='contest-start-date']");
	By continueButton = By.xpath("//*[@id='lineup-card-container']/div[1]/div[2]/div[3]/a[2]");
	By cancelButton = By.xpath("//*[@id='lineup-card-container']/div[1]/div[2]/div[3]/a[1]");

	/**
	 * Gets create new lineup button
	 * @return WebElement
	 */
	public WebElement getCreateNewLineupButton() {
		return driver.findElement(createNewLineupButton);
	}
	
	/**
	 * Gets first question location
	 * @return WebElement
	 */
	public WebElement getFirstQuestion() {
		return driver.findElement(firstQuestion);
	}
	
	/**
	 * Gets radio buttons for first question
	 * @return List<WebElement>
	 */
	public List<WebElement> getAllSportRadioButtons() {
		return driver.findElements(allSportRadioButtons);
	}
	
	/**
	 * Gets second question location
	 * @return WebElement
	 */
	public WebElement getSecondQuestion() {
		return driver.findElement(secondQuestion);
	}
	
	/**
	 * Gets radio buttons for second question
	 * @return List<WebElement>
	 */
	public List<WebElement> getAllGameVariantRadioButtons() {
		return driver.findElements(allGameVariantRadioButtons);
	}
	
	/**
	 * Gets third question location
	 * @return WebElement
	 */
	public WebElement getThirdQuestion() {
		return driver.findElement(thirdQuestion);
	}

	/**
	 * Gets radio buttons for third question
	 * @return List<WebElement>
	 */
	public List<WebElement> getAllContestStartDateRadioButtons() {
		return driver.findElements(allContestStartDateRadioButtons);
	}
	
	/**
	 * Gets continue button location
	 * @return WebElement
	 */
	public WebElement getContinueButton() {
		return driver.findElement(continueButton);
	}
	
	/**
	 * Gets cancel button location
	 * @return WebElement
	 */
	public WebElement getCancelButton() {
		return driver.findElement(cancelButton);
	}
	
	/**
	 * Method to answer all three questions in order to access the draft players screen
	 */
	public void navigateToDraftingNFLPlayersPage() {
		getAllSportRadioButtons().get(0).click();
		getAllGameVariantRadioButtons().get(0).click();
		getAllContestStartDateRadioButtons().get(0).click();
		getContinueButton().click();
	}
	
}
