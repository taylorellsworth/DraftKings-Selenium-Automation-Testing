package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NFLLobbyPage {

	public WebDriver driver;
	
	public NFLLobbyPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By nflLobbyButton = By.xpath("//a[@href='#/NFL']"); 
	By entryFeeLowPriceDropDown = By.xpath("//*[@id='entry-fee-dropdown-from']/a");
	By entryFeeLowPriceOptions = By.xpath("//*[@id='entry-fee-dropdown-from']/ul/li");
	By entryFeeLowPriceText = By.xpath("//*[@id='entry-fee-dropdown-from']/a/text");
	By gameStyleSelection = By.xpath("//*[@id='dkjs-game-set-filter']/div/div[2]/div[1]/div/div[1]");
	By gameStyleSelectionDropDown = By.xpath("//*[@id='dkjs-game-set-filter']/div/div[2]/div[1]/div/div[2]/ul");
	By gameStyleSelectionRadioButtons = By.xpath("//*[@id='dkjs-game-set-filter']/div/div[2]/div[1]/div/div[2]/ul/li[1]/div[1]/input");
	By gameStyleDisplayedText = By.cssSelector("div[class='GameStyleSelector_tile-description']");
	By feesInDropDown = By.xpath("//*[@id='entry-fee-dropdown-from']/ul/li");
	By gameStyleOptions = By.xpath("//input[@name='controls']");
	By gameStyleChosen = By.xpath("//label[@for='controls']");
	
	/**
	 * Gets NFL Lobby button
	 * @return WebElement
	 */
	public WebElement getNflLobbyButton() {
		return driver.findElement(nflLobbyButton);
	}
	
	/**
	 * Gets entry fee low price drop down selector
	 * @return WebElement
	 */
	public WebElement getEntryFeeLowPriceDropDown() {
		return driver.findElement(entryFeeLowPriceDropDown);
	}

	/**
	 * Gets selected entry fee low price text 
	 * @return WebElement
	 */
	public WebElement getEntryFeeLowPriceText() {
		return driver.findElement(entryFeeLowPriceText);
	}
	
	/**
	 * Gets game style selection field
	 * @return WebElement
	 */
	public WebElement getGameStyleSelection() {
		return driver.findElement(gameStyleSelection);
	}
	
	/**
	 * Gets game style selection drop down
	 * @return WebElement
	 */
	public WebElement getGameStyleSelectionDropDown() {
		return driver.findElement(gameStyleSelectionDropDown);
	}
	
	/**
	 * Gets game style selection radio buttons
	 * @return List<WebElement>
	 */
	public List<WebElement> getGameStyleSelectionRadioButtons() {
		return driver.findElements(gameStyleSelectionRadioButtons);
	}
	
	/**
	 * Gets selected game style displayed text
	 * @return WebElement
	 */
	public WebElement getGameStyleDisplayedText() {
		return driver.findElement(gameStyleDisplayedText);
	}
	
	/**
	 * Gets fee in drop down window
	 * @return List<WebElement>
	 */
	public List<WebElement> getFeesInDropDown() {
		return driver.findElement(entryFeeLowPriceDropDown).findElements(feesInDropDown);
	}
	
	/**
	 * Gets game style option
	 * @return List<WebElement>
	 */
	public List<WebElement> getGameStyleOptions(){
		return driver.findElement(gameStyleSelectionDropDown).findElements(gameStyleOptions);
	}
	
	/**
	 * Get the chosen game style
	 * @return List<WebElement>
	 */
	public List<WebElement> getGameStyleChosen(){
		return driver.findElement(gameStyleSelectionDropDown).findElements(gameStyleChosen);
	}
}
