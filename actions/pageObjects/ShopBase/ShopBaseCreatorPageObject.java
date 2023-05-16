package pageObjects.ShopBase;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.ShopBase.ShopBaseCreatorPageUI;

public class ShopBaseCreatorPageObject extends BasePage{
	WebDriver driver;
	
	public ShopBaseCreatorPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getWelcomeTxt() {
		waitForElementVisible(driver, ShopBaseCreatorPageUI.WELCOME_TEXT);
		return getElementText(driver, ShopBaseCreatorPageUI.WELCOME_TEXT);
	}

	public void clickToDropMenu(String locatorValue) {
		waitForElementClickable(driver, ShopBaseCreatorPageUI.DROP_MENU_LINK, locatorValue);
		clickToElementByJS(driver, ShopBaseCreatorPageUI.DROP_MENU_LINK, locatorValue);
	}

	public SignInPageObject clickToLinkByTxtAtDropMenu(String valueLocator) {
		waitForElementClickable(driver, ShopBaseCreatorPageUI.LINK_BY_TXT_BOX_AT_DROP_DOWN_MENU, valueLocator);
		clickToElement(driver, ShopBaseCreatorPageUI.LINK_BY_TXT_BOX_AT_DROP_DOWN_MENU, valueLocator);
		return PageGeneratorManager.getLoginPage(driver);
	}
}
