package stepdefinitions;

import io.cucumber.java.en.Given;
import pageobjectmodels.ProductPage;
import pageobjectmodels.ResultsPage;

public class ResultsPageSteps {
    private ResultsPage resultsPage;
    private ProductPage productPage;

    public ResultsPageSteps() {
        this.resultsPage = new ResultsPage();
        this.productPage = new ProductPage();
    }

    @Given("the user adds the first product appearing to Cart with quantity {int}")
    public void the_user_adds_the_first_product_appearing_to_Cart_with_quantity(Integer quantity) {
        resultsPage.clickFirstElement();
        productPage.addProductToCartWithQuantity(quantity);
    }

}
