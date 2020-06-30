package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

public class ProductDescriptionPage extends BasePage {

	public ProductDescriptionPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}

	@FindBy(xpath = "(//span[contains(text(),'in stock.') or contains(text(),'In Stock')] [1])")
	private WebElement inStock;

	@FindBy(css = "#add-to-cart-button")
	private WebElement addToCartButton;

	/**
	 * @Author: Kalaivani Velayutham
	 * @Date 28 jun 2020 This method will check for the In Stock of Product
	 * 
	 */
	@Step("In Product Page check for In stock")
	public void verifyStock() {
		System.out.println("Verify in Stock");
		assertTextIsDisplayed(inStock);
	}

	/**
	 * @Author: Kalaivani Velayutham
	 * @Date 28 jun 2020 This method will check for Add to cart button displayed
	 *       and enabled
	 * 
	 */
	@Step("In Product Page check for Add To Cart")
	public void verifyAddtoCartIsEnabled() {
		System.out.println("Scroll to find Add to Cart Button");
		scrollTillElement(addToCartButton);
		System.out.println("Check Add to Cart Button Is Enabled");
		assertElementEnabled(addToCartButton);

	}

}
