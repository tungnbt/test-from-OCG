package testcase;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.ShopBase.HomePageObject;
import pageObjects.ShopBase.SelectShopPageObject;
import pageObjects.ShopBase.ShopBaseCreatorPageObject;
import pageObjects.ShopBase.SignInPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Function_SignIn extends BaseTest {
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		existEmail = "tungnbt123@gmail.vn";
		password = "Admin@123";
		invalidEmail = "tungnbt123@gmail";
		log.info("Precondition: Open Sign In Page");
		homePage.clickToHeaderLink("Login");
		signInPage = PageGeneratorManager.getLoginPage(driver);
	}

	@Test
	public void TC_01_Empty_Data() {
		log.info("Empty_Data - Step 01: Click to Sign in btn");
		signInPage.clickToSignInBtn();

		log.info("Empty_Data - Step 02: Verify error message ");
		verifyEquals(signInPage.getTxtErrorMessage(), "Please enter your email and password");
	}

	@Test
	public void TC_02_Invalid_Email() {
		log.info("Invalid_Email - Step 01: refresh Sign in page");
		driver.navigate().refresh();
		
		log.info("Invalid_Email - Step 02: Input to Email Txtbox with value: " + invalidEmail);
		signInPage.inputToTxtboxByID(invalidEmail,"email");
		
		log.info("Invalid_Email - Step 03: Input to Password Txtbox with value: " + password);
		signInPage.inputToTxtboxByID(password,"password");
		
		log.info("Invalid_Email - Step 04: Click to Sign in Btn");
		signInPage.clickToSignInBtn();
		
		log.info("Invalid_Email - Step 05: Verify error message");
		verifyEquals(signInPage.getTxtErrorMessage(), "Email or password is not valid");
	}


	@Test
	public void TC_03_Existing_Email_Incorrect_Password() {
		log.info("Existing_Email_Incorrect_Password - Step 01: refresh Sign in page");
		driver.navigate().refresh();
		
		log.info("Existing_Email_Incorrect_Password - Step 02: Input to Email Txtbox with value: " + existEmail);
		signInPage.inputToTxtboxByID(existEmail,"email");
		
		log.info("Existing_Email_Incorrect_Password - Step 03: Input to Password Txtbox with value: Admin@123456");
		signInPage.inputToTxtboxByID("Admin@123456","password");
		
		log.info("Invalid_Email - Step 04: Click to Sign in Btn");
		signInPage.clickToSignInBtn();
		
		log.info("Existing_Email_Incorrect_Password - Step 05: Verify error message");
		verifyEquals(signInPage.getTxtErrorMessage(), "Email or password is not valid. 3 time(s) remaining.");
	}

	@Test
	public void TC_04_Valid_Email_Password() {
		log.info("Valid_Email_Password - Step 01: refresh Sign in page");
		driver.navigate().refresh();
		
		log.info("Valid_Email_Password - Step 02: Input to Email Txtbox with value: " + existEmail);
		signInPage.inputToTxtboxByID(existEmail,"email");
		
		log.info("Valid_Email_Password - Step 03: Input to Password Txtbox with value: "+password);
		signInPage.inputToTxtboxByID(password,"password");
		
		log.info("Valid_Email_Password - Step 04: Click to Sign in Btn");
		selectShopPage = signInPage.clickToSignInBtn();
		
		log.info("Valid_Email_Password - Step 05: Verify existemail");
		verifyEquals(selectShopPage.getTxtInfoUser(), existEmail);
		
		log.info("Valid_Email_Password - Step 06: click to tizi shop link");
		shopBaseCreatorPage = selectShopPage.clickToShopLinkByText("tizi"); 
		
		log.info("Valid_Email_Password - Step 07: Verify Sign in and select shop sucessful");
		verifyEquals(shopBaseCreatorPage.getWelcomeTxt(), "Welcome to ShopBase Creator, John");
		
		log.info("Valid_Email_Password - Step 08: Click to drop menu");
		shopBaseCreatorPage.clickToDropMenu("tizi");
		
		log.info("Valid_Email_Password - Step 09: Click to link by text at drop menu");
		signInPage = shopBaseCreatorPage.clickToLinkByTxtAtDropMenu("Logout");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private HomePageObject homePage;
	private SignInPageObject signInPage;
	private SelectShopPageObject selectShopPage;
	private ShopBaseCreatorPageObject shopBaseCreatorPage;

	private String existEmail, password, invalidEmail;
}
