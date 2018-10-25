package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChooseNFLPlayersForLineupPage {

	public WebDriver driver;
	
	public ChooseNFLPlayersForLineupPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By playerPickerContainer = By.cssSelector("div.PlayerPicker_player-picker"); 
	By playerSearchTextEntryBox = By.cssSelector("input.Search_search-field");
	By allSportRadioButtons = By.xpath("//input[@type='radio' and @name='sport']");
	By playerNameInContainer = By.xpath("//*[@id='dkjs-draft']/div/div/div/div[2]/div/div/div[3]/div[1]/div/div[3]/div[1]/div/div[2]/div/div/div[2]/div/span/span");
	By draftButton = By.cssSelector("span._dk-ui_icon-plus");
	By draftedPlayerNameInContainer = By.xpath("//*[@id='dkjs-draft']/div/div/div/div[2]/div/div/div[3]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div/div[1]/div[2]/div/span/span");
	By lineupDisplayContainer = By.xpath("//*[@id='dkjs-draft']/div/div/div/div[2]/div/div/div[3]/div[2]/div[1]/div[2]");
	By thirdQuestion = By.cssSelector("div.step3-title");
	By allContestStartDateRadioButtons = By.xpath("//input[@type='radio' and @name='contest-start-date']");
	By continueButton = By.xpath("//*[@id='lineup-card-container']/div[1]/div[2]/div[3]/a[2]");
	By cancelButton = By.xpath("//*[@id='lineup-card-container']/div[1]/div[2]/div[3]/a[1]");
	By removePlayerButton = By.cssSelector("span.DraftableActionCell_removable");
	By playerLineupPosition = By.cssSelector("span.PlayerNameCell_player-name-cell-text");
	
	/**
	 * Gets container where user picks players for lineup
	 * @return WebElement
	 */
	public WebElement getPlayerPickerContainer() {
		// TODO Auto-generated method stub
		return driver.findElement(playerPickerContainer);
	}
	
	/**
	 * Gets player search text box
	 * @return WebElement
	 */
	public WebElement getPlayerSearchTextEntryBox() {
		// TODO Auto-generated method stub
		return driver.findElement(playerSearchTextEntryBox);
	}
	
	/**
	 * Gets player name where user picks from 
	 * @return WebElement
	 */
	public WebElement getPlayerNameInContainer() {
		// TODO Auto-generated method stub
		return driver.findElement(playerNameInContainer);
	}
	
	/**
	 * Gets location of drafted player name
	 * @return WebElement
	 */
	public WebElement getDraftedPlayerNameInContainer() {
		// TODO Auto-generated method stub
		return driver.findElement(draftedPlayerNameInContainer);
	}
	
	/**
	 * Gets button that user clicks to select player
	 * @return WebElement
	 */
	public WebElement getDraftButton() {
		// TODO Auto-generated method stub
		return driver.findElement(draftButton);
	}
	
	/**
	 * Gets container where drafted lineup is located
	 * @return WebElement
	 */
	public WebElement getLineupDisplayContainer() {
		// TODO Auto-generated method stub
		return driver.findElement(lineupDisplayContainer);
	}
	
	/**
	 * Get remove player from lineup button
	 * @return WebElement
	 */
	public WebElement getRemovePlayerButton() {
		return driver.findElement(lineupDisplayContainer).findElement(removePlayerButton);
	}
	
	/**
	 * Get position of drafted player in lineup
	 * @return WebElement
	 */
	public WebElement getPlayerLineupPosition() {
		return driver.findElement(lineupDisplayContainer).findElement(playerLineupPosition);
	}
	
	/**
	 * Get positions of all spots in lineup
	 * @return List<WebElement>
	 */
	public List<WebElement> getPlayerLineupPositions() {
		return driver.findElement(lineupDisplayContainer).findElements(playerLineupPosition);
	}
		
}
