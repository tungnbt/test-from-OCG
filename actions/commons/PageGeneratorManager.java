package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.ShopBase.HomePageObject;
import pageObjects.ShopBase.SelectShopPageObject;
import pageObjects.ShopBase.ShopBaseCreatorPageObject;
import pageObjects.ShopBase.SignInPageObject;


public class PageGeneratorManager extends BasePage{
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static SignInPageObject getLoginPage(WebDriver driver) {
		return new SignInPageObject(driver);
	}
	
	public static SelectShopPageObject getSelectShopPage(WebDriver driver) {
		return new SelectShopPageObject(driver);
	}
	
	public static ShopBaseCreatorPageObject getShopBaseCreatorPage(WebDriver driver) {
		return new ShopBaseCreatorPageObject(driver);
	}
}
