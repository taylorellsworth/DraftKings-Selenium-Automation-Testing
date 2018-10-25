package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountDropDownAfterLogIn {

	public WebDriver driver;
	
	public AccountDropDownAfterLogIn(WebDriver driver) {
		this.driver = driver;
	}
	
	By dropDownLocation = By.xpath("//*[@id='dkjs-global-header']/div/header/div/div[3]/div[1]/div/div[2]"); 
	By accountInformation = By.xpath("//a[@href='https://www.draftkings.com/account']");
	By howToPlay = By.xpath("//a[@href='https://www.draftkings.com/how-to-play']");
	By rulesAndScoring = By.xpath("//a[@href='https://www.draftkings.com/help/rules/overview']");
	By FAQ = By.xpath("//a[@href='https://www.draftkings.com/help/faq']");
	By referAFriend = By.xpath("//a[@href='https://www.draftkings.com/refer-a-friend']");
	By mobileApps = By.xpath("//a[@href='https://www.draftkings.com/mobileapps']");
	By dkShop = By.xpath("//a[@href='https://shopdraftkings.com']");
	By dkTV = By.xpath("//a[@href='https://www.draftkings.com/video']");
	By playbook = By.xpath("//a[@href='https://www.draftkings.com/playbook']");
	By contactUs = By.xpath("//a[@href='https://www.draftkings.com/help/contact-us']");
	By verifyMe = By.xpath("//a[@href='https://www.draftkings.com/account/verification']");
	By signOut = By.xpath("//a[@href='https://www.draftkings.com/account/logout']");
	By logInPageText = By.xpath("//*[@id='react-mobile-home']/section/section[2]/div[1]/h4/span");
	
	/**
	 * Gets account drop down location
	 * @return WebElement
	 */
	public WebElement getDropDownLocation() {
		return driver.findElement(dropDownLocation);
	}
	
	/**
	 * Gets Account Information link
	 * @return WebElement
	 */
	public WebElement getAccountInformation() {
		return driver.findElement(accountInformation);
	}
	
	/**
	 * Gets How to Play link
	 * @return WebElement
	 */
	public WebElement getHowToPlay() {
		return driver.findElement(howToPlay);
	}
	
	/**
	 * Gets Rules and Scoring link
	 * @return WebElement
	 */
	public WebElement getRulesAndScoring() {
		return driver.findElement(rulesAndScoring);
	}
	
	/**
	 * Gets FAQ link
	 * @return WebElement
	 */
	public WebElement getFAQ() {
		return driver.findElement(FAQ);
	}
	
	/**
	 * Gets Refer a Friend link
	 * @return WebElement
	 */
	public WebElement getReferAFriend() {
		return driver.findElement(referAFriend);
	}
	
	/**
	 * Gets Mobile Apps link
	 * @return WebElement
	 */
	public WebElement getMobileApps() {
		return driver.findElement(mobileApps);
	}
	
	/**
	 * Gets DK Shop link
	 * @return WebElement
	 */
	public WebElement getDKShop() {
		return driver.findElement(dkShop);
	}
	
	/**
	 * Gets DK TV link
	 * @return WebElement
	 */
	public WebElement getDKTV() {
		return driver.findElement(dkTV);
	}
	
	/**
	 * Gets Playbook link
	 * @return WebElement
	 */
	public WebElement getPlaybook() {
		return driver.findElement(playbook);
	}
	
	/**
	 * Gets Contact Us link
	 * @return WebElement
	 */
	public WebElement getContactUs() {
		return driver.findElement(contactUs);
	}
	
	/**
	 * Gets Verify Me link
	 * @return WebElement
	 */
	public WebElement getVerifyMe() {
		return driver.findElement(playbook);
	}
	
	/**
	 * Gets Sign Out link
	 * @return WebElement
	 */
	public WebElement getSignOut() {
		return driver.findElement(signOut);
	}
	
	/**
	 * Gets log in page text
	 * @return WebElement
	 */
	public WebElement getLogInPageText() {
		return driver.findElement(logInPageText);
	}
	
}
