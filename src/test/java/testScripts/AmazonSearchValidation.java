package testScripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pages.HomePages;
import pages.ProductDescriptionPage;
import pages.ProductListingPage;
import utilities.Generics;

/**
 * @Author : Kalaivani Velaayutham
 *
 *         TC_Search_001:
 * 
 *         Test scenario: (You can complete this in Mobile app/Mobile browser)
 *         STEP 1: Open Amazon website in Chrome Browser, STEP 2: Search “Iphone
 *         11” STEP 3: Select “Apple iPhone 11(128gb) white” version from search
 *         results, if this version is not available consider any other) STEP 4:
 *         Verify that device is available. Validating In-stock, Add To cart
 *         button available.
 *
 */

public class AmazonSearchValidation extends BaseTest {

	private HomePages homePage;
	private ProductListingPage productListingPage;
	private ProductDescriptionPage productDescriptionPage;

	@Test(priority = 0)
	@Description("Search for Iphone 11 and check for availability")
	@Epic("EP01")
	@Feature("Feature 1: Search")
	@Story("Story: Search and check Product availability")
	public void tc_Search_001() {
		homePage.waitForHomePageTitleIsDisplayed(Generics.getValueFromConfigFile("title"));
		homePage.searchForProduct(Generics.getValueFromExcel(1));
		productListingPage.selectProduct(Generics.getValueFromExcel(2));
		productDescriptionPage.verifyStock();
		productDescriptionPage.verifyAddtoCartIsEnabled();

	}

	@BeforeMethod
	public void setUp() {
		driver.get(Generics.getValueFromConfigFile("url"));
		homePage = new HomePages(driver);
		productListingPage = new ProductListingPage(driver);
		productDescriptionPage = new ProductDescriptionPage(driver);
	}

}
