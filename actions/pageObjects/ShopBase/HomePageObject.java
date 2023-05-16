package pageObjects.ShopBase;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.ShopBase.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToHeaderLink(String locatorValue) {
		waitForElementClickable(driver, HomePageUI.DYNAMIC_LINK_BY_TEXT_AT_HEADER_MENU, locatorValue);
		clickToElement(driver, HomePageUI.DYNAMIC_LINK_BY_TEXT_AT_HEADER_MENU, locatorValue);
	}
}
