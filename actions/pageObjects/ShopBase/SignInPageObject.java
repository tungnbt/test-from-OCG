package pageObjects.ShopBase;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.ShopBase.SignInPageUI;

public class SignInPageObject extends BasePage{
	private WebDriver driver;
	
	public SignInPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public SelectShopPageObject clickToSignInBtn() {
		waitForElementClickable(driver, SignInPageUI.SIGN_IN_BTN);
		clickToElement(driver, SignInPageUI.SIGN_IN_BTN);
		return PageGeneratorManager.getSelectShopPage(driver);
	}

	public String getTxtErrorMessage() {
		waitForElementVisible(driver, SignInPageUI.ERROR_MESSAGE);
		return getElementText(driver, SignInPageUI.ERROR_MESSAGE);
	}

	public void inputToTxtboxByID(String inputValue, String locatorValue) {
		waitForElementVisible(driver,SignInPageUI.TXT_BOX_BY_ID ,locatorValue);
		sendKeyToElement(driver, SignInPageUI.TXT_BOX_BY_ID, inputValue, locatorValue);
	}
}
