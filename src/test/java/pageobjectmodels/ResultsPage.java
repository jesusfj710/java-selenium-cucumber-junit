package pageobjectmodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

import java.util.List;

public class ResultsPage {
    private final WebDriver driver;

    @FindBy(css = ".s-search-results [data-index] .sg-col-inner .s-product-image-container")
    static List<WebElement> productImages;

    public ResultsPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(this.driver, this);
    }

    public void clickFirstElement() {
        productImages.get(0).click();
    }
}