package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

public class HomePages extends BasePage {

	public HomePages(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}

	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchBox;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submit;

	/**
	 * @Author: Kalaivani Velayutham
	 * @Date 28 jun 2020 This method will Search for the value in search box
	 * 
	 */
	@Step("Search for {0} and click search icon")
	public void searchForProduct(String value) {
		sendText(searchBox, value);
		click(submit);
	}

	@Step("Wait HomePage Title Is Displayed")
	public void waitForHomePageTitleIsDisplayed(String value) {
		waitForPageTitle(value);

	}
}
