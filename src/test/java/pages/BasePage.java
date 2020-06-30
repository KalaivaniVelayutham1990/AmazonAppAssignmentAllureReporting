
package pages;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}
	
	
	/**
	 * @Author: Kalaivani Velayutham
	 * @Date 28 jun 2020 
	 * This method will wait for the List of elements to load
	 * 
	 */
	@Step("Wait for the Webelements to Load")
	public void waitForList(List<WebElement> phoneList) {
		wait.until(ExpectedConditions.visibilityOfAllElements(phoneList));
	}

	/**
	 * @Author: Kalaivani Velayutham
	 * @Date 28 jun 2020 
	 * This method will check for the title
	 * 
	 */
	@Step("Check for Text is displayed")
	public void assertTextIsDisplayed(WebElement element) {
		System.out.println("Verifying " + element.getText());
		wait.until(ExpectedConditions.visibilityOf(element));
		Assert.assertTrue(element.isDisplayed(), "Text not present!");
	}

	/**
	 * @Author: Kalaivani Velayutham
	 * @Date 28 jun 2020 
	 * This method send value to a textbox
	 * 
	 */
	@Step("Check for a textBox, clear the field and enter {1}")
	public void sendText(WebElement element, String value) {
		System.out.println("Check for visibility of Textbox");
		wait.until(ExpectedConditions.visibilityOf(element));
		System.out.println("Clear textbox");
		element.clear();
		System.out.println("Enter " + value + " in the textbox");
		element.sendKeys(value);

	}

	/**
	 * @Author: Kalaivani Velayutham
	 * @Date 28 jun 2020 
	 * This method to click on element
	 * 
	 */
	@Step("Check for an element to click and perform click")
	public void click(WebElement element) {
		System.out.println("Check for visibility of click element");
		wait.until(ExpectedConditions.elementToBeClickable(element));
		System.out.println("Click :" + element.getText());
		element.click();

	}

	/**
	 * @Author: Kalaivani Velayutham
	 * @Date 28 jun 2020 
	 * This method to check for page title
	 * 
	 */
	@Step("Wait for Page Title to load")
	public void waitForPageTitle(String value) {
		System.out.println("Check for Page title");
		wait.until(ExpectedConditions.titleContains(value));

	}

	/**
	 * @Author: Kalaivani Velayutham
	 * @Date 28 jun 2020 
	 * This method will scroll to locate an element
	 * 
	 */
	@Step("Scroll down the page to find the element")
	public void scrollTillElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

	}

	/**
	 * @Author: Kalaivani Velayutham
	 * @Date 28 jun 2020 
	 * This method will check for an element displayed
	 * 
	 */
	@Step("Check for an element is Enabled")
	public void assertElementEnabled(WebElement element) {
		System.out.println("Verifying Add to cart is enabled? " + element.isEnabled());
		Assert.assertTrue(element.isEnabled(), "Button is enabled!");

	}
	
	

}