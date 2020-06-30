
package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
	
	public void takeScreenShot() {
		try {

			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File desFile = new File(System.getProperty("user.dir") + File.separator + "failScreenShot.png");
			FileUtils.copyFile(srcFile, desFile);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getScreenshot(String screenshotName) {
		String destination = "";
		try {
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return destination;
	}

}