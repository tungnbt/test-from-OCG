package pageObjects.ShopBase;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.ShopBase.SelectShopPageUI;

public class SelectShopPageObject extends BasePage{
	private WebDriver driver;
	
	public SelectShopPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getTxtInfoUser() {
		waitForElementVisible(driver, SelectShopPageUI.EMAIL_INFO_USER);
		return getElementText(driver, SelectShopPageUI.EMAIL_INFO_USER);
	}

	public ShopBaseCreatorPageObject clickToShopLinkByText(String locatorValue) {
		waitForElementClickable(driver, SelectShopPageUI.SHOP_LINK_BY_TEXT, locatorValue);
		clickToElement(driver, SelectShopPageUI.SHOP_LINK_BY_TEXT, locatorValue);
		return PageGeneratorManager.getShopBaseCreatorPage(driver);
	}

	
}
