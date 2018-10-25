package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By signIn = By.xpath("//a[@id='sign-in-link'] | //a[@href='/account/sitelogin/false?returnUrl=/lobby']");
	By faq = By.cssSelector("a[href='/help/faq']");
	By sportsContainer = By.xpath("//div[@class='sports-container']");
	By navigationHeader = By.xpath("//*[@id='template-body-wrapper']/main/section[1]/nav");
	By enterPromoCode = By.xpath("//*[@id='template-body-wrapper']/main/section[1]/div/header/a");
	By footerCompanyDirectory = By.cssSelector("div[data-test-id='dk-footer-company-directory']");
	By sportsInContainer = By.xpath("div[contains(@class,'sport _dk-ui_icon')]");
	
	/**
	 * Gets sign in button
	 * @return WebElement
	 */
	public WebElement getSignIn() {
		return driver.findElement(signIn);
	}
	
	/**
	 * Gets FAQ button
	 * @return WebElement
	 */
	public WebElement getFAQ() {
		return driver.findElement(faq);
	}
	
	/**
	 * Gets container containing sports available on home page
	 * @return
	 */
	public WebElement getSportsContainer() {
		return driver.findElement(sportsContainer);
	}
	
	/**
	 * Gets navigation header
	 * @return WebElement
	 */
	public WebElement getNavigationHeader() {
		return driver.findElement(navigationHeader);
	}
	
	/**
	 * Gets promo code text location
	 * @return WebElement
	 */
	public WebElement getEnterPromoCode() {
		return driver.findElement(enterPromoCode);
	}
	
	/**
	 * Gets footer containing company directory information
	 * @return WebElement
	 */
	public WebElement getFooterCompanyDirectory() {
		return driver.findElement(footerCompanyDirectory);
	}
	
	/**
	 * Gets sports in container
	 * @return List<WebElement
	 */
	public List<WebElement> getSportsInContainer() {
		return driver.findElement(sportsContainer).findElements(sportsInContainer);
	}
	
}
