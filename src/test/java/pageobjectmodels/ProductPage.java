package pageobjectmodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.CartEntryInfo;
import utils.DriverFactory;
import utils.World;

public class ProductPage {
    private final WebDriver driver;

    @FindBy(css = "[name=\"quantity\"]")
    static WebElement quantityDropdown;

    @FindBy(css = "#add-to-cart-button")
    static WebElement addToCartButton;

    @FindBy(css = "#twister-plus-price-data-price")
    static WebElement price;

    public ProductPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(this.driver, this);
    }

    public void addProductToCartWithQuantity(int quantity) {
        getQuantityDropdown().selectByValue(String.valueOf(quantity));
        World.saveCartEntryInfo(getCartEntryInfo());
        addToCartButton.click();
    }

    private CartEntryInfo getCartEntryInfo() {
        // With this operation of quantity * ammout we could get some rounding issues.
        // Maybe the logic in amazon prices is different.
        int quantity = getQuantity();
        return new CartEntryInfo(quantity, quantity * getAmount());
    }

    /**
     * Get the quantity dropdown.
     *
     * @return Select object.
     */
    private Select getQuantityDropdown() {
        return new Select(quantityDropdown);
    }

    private double getAmount() {
        return Double.parseDouble(price.getAttribute("value"));
    }

    private int getQuantity() {
        return Integer.parseInt(getQuantityDropdown().getFirstSelectedOption().getText());
    }
}
