package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

public class ProductListingPage extends BasePage {

	public ProductListingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}

	@FindAll({ @FindBy(css = ".a-size-base.a-color-base.a-text-normal") })
	private List<WebElement> phones;

	/**
	 * @Author: Kalaivani Velayutham
	 * @Date 28 jun 2020 This method will check for the phone if not available
	 *       it will select another option provided
	 * 
	 */
	@Step("In Product List Page, select {0}")
	public void selectProduct(String value) {
		waitForList(phones);
		System.out.println("Total no products:  " + phones.size());
		System.out.println("Check for " + value);
		for (WebElement element : phones) {
			try {
				String ph = element.getText();
				System.out.println("Available phones: " + ph);
				if (element.getText().contains(value)) {
					System.out.println("Selected: " + ph);
					click(element);
					break;
				} else {
					System.out.println(value + " is not available!");

				}
			} catch (Exception e) {
				// e.printStackTrace();
			}
		}

	}
}